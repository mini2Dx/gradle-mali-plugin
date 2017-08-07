/**
 * MIT License
 * 
 * Copyright (c) 2017 Thomas Cashman
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.mini2Dx.mali.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 *
 */
class CompressTexturesTask extends DefaultTask {

	@TaskAction
	def compressTextures() {
		File inputDirectory = new File(project.getExtensions().findByName('mali').inputPath);
		File outputDirectory = new File(project.getExtensions().findByName('mali').outputPath);
		
		String binFolder = null;
		if(project.getExtensions().findByName('mali').maliBinFolderPath == null) {
			if (Os.isFamily(Os.FAMILY_WINDOWS)) {
				binFolder = project.getExtensions().findByName('mali').maliWindowsBinFolderPath;
			} else if (Os.isFamily(Os.FAMILY_MAC)) {
				binFolder = project.getExtensions().findByName('mali').maliWindowsBinFolderPath;
			} else if (Os.isFamily(Os.FAMILY_UNIX)) {
				binFolder = project.getExtensions().findByName('mali').maliWindowsBinFolderPath;
			}
		} else {
			binFolder = project.getExtensions().findByName('mali').maliBinFolderPath;
		}

		if(project.getExtensions().findByName('mali').etc != null) {
			compressTexturesUsingEtc(binFolder, outputDirectory.getAbsolutePath(), inputDirectory.listFiles());
		}
		if(project.getExtensions().findByName('mali').astc != null) {
			compressTexturesUsingAstc(binFolder, outputDirectory.getAbsolutePath(), inputDirectory.listFiles());
		}
	}

	def compressTexturesUsingAstc(String binFolder, String outputDirectory, File [] files) {
		for(File file : files) {
			if(!isSupportedInputFormat(file)) {
				println "Skipping " + file.getAbsolutePath();
				continue;
			}
			List<String> args = new ArrayList<String>();
			args.add(getBinPath(binFolder, "astcenc"));
			args.add("-c");
			args.add(file.getAbsolutePath());
			args.add(new File(outputDirectory, getFilenameWithoutExtension(file) + ".astc").getAbsolutePath());

			if(project.getExtensions().findByName('mali').astc.alphablend) {
				args.add("-alphablend");
			}
			if(project.getExtensions().findByName('mali').astc.hdr) {
				args.add("-hdr");
			}

			runMali(args)
		}
	}

	def compressTexturesUsingEtc(String binFolder, String outputDirectory, File [] files) {
		for(File file : files) {
			if(!isSupportedInputFormat(file)) {
				println "Skipping " + file.getAbsolutePath();
				continue;
			}
			List<String> args = new ArrayList<String>();
			args.add(getBinPath(binFolder, "etcpack"));

			runMali(args);
		}
	}

	def runMali(List<String> processArgs) {
		project.exec { 
			commandLine processArgs 
		}
	}

	def getBinPath(String binFolder, String toolName) {
		return new File(binFolder, toolName).getAbsoluteFile();
	}
	
	def getFilenameWithoutExtension(File file) {
		return file.getName().substring(0, file.getName().lastIndexOf('.'));
	}
	
	def isSupportedInputFormat(File file) {
		if(file.getName().toLowerCase().endsWith(".png")) {
			return true;
		} else if(file.getName().toLowerCase().endsWith(".tga")) {
			return true;
		} else if(file.getName().toLowerCase().endsWith(".jpg")) {
			return true;
		} else if(file.getName().toLowerCase().endsWith(".bmp")) {
			return true;
		} else if(file.getName().toLowerCase().endsWith(".hdr")) {
			return true;
		}
		return false;
	}
}