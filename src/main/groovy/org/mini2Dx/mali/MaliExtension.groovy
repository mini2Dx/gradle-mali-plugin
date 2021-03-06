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
package org.mini2Dx.mali

import java.util.List

/**
 *
 */
class MaliExtension {
	/**
	 * The path of the input directories containing all textures to compress
	 */
	String [] inputPaths;
	/**
	 * The path of the output directories to output compressed textures to (paired to the input paths)
	 */
	String [] outputPaths;
	
	/**
	 * The path to the 'bin' folder for mali
	 */
	String maliBinFolderPath;
	/**
	 * The path to the 'bin' folder for mali on Windows machines
	 */
	String maliWindowsBinFolderPath;
	/**
	 * The path to the 'bin' folder for mali on Mac machines
	 */
	String maliMacBinFolderPath;
	/**
	 * The path to the 'bin' folder for mali on Linux machines
	 */
	String maliLinuxBinFolderPath;
}
