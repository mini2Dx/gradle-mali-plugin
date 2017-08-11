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
class Astc {
	/**
	 * Enables ASTC compression
	 */
	boolean enabled = false;
	/**
	 * Set the speed/quality tradeoff. Can be veryfast, fast, medium, thorough or exhaustive. 
	 * Defaults to medium.
	 */
	String compressionSpeed = "medium";
	/**
	 * Sets the bits per texel
	 */
	String bitsPerTexel = "8.0";
	/**
	 * Set to true to treat textures as RGBA
	 */
	boolean alphablend = false;
	/**
	 * Set to true to treat textures as HDR
	 */
	boolean hdr = false;
}
