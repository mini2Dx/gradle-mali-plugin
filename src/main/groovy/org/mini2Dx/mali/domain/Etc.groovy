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
package org.mini2Dx.mali.domain

/**
 *
 */
class Etc {
	/**
	 * Set to false for slower more thorough optimal quality search
	 */
	boolean fastCompression = true;
	/**
	 * Set to false to use non-perceptual (highest PSNR)
	 */
	boolean perceptual = true;
	/**
	 * Set to true to use ETC2 compression. ETC1 is most compatible, ETC2 has highest quality.
	 */
	boolean etc2 = false;
	/**
	 * The compressed format. Can be- R, R_signed, RG, RG_signed, RGB, RGBA1, RGBA8 or RGBA.
	 * Defaults to RGB.
	 */
	String format = "RGB";
	/**
	 * Set to true to enable mipmaps
	 */
	boolean mipmaps = false;
	/**
	 * Set to true to ouput KTX format instead of PKM
	 */
	boolean ktx = false;
	/**
	 * Set to true for verbose output
	 */
	boolean verbose = false;
	/**
	 * Set to true to output progress
	 */
	boolean progress = false;
}
