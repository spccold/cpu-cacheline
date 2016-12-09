/**
 *
 *	Copyright 2016-2016 spccold
 *
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *
 *   	http://www.apache.org/licenses/LICENSE-2.0
 *
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 *
 */
package org.spccold;

/**
 * @author spccold
 * @version $Id: ArrayAccessSpeed.java, v 0.1 2016年12月9日 下午2:12:08 spccold Exp $
 */
public class ArrayAccessSpeed {
	public static void main(String[] args) {
		int[] arr = new int[64 * 1024 * 1024];
		access1(arr);
//		access2(arr);
	}
	
	public static void access1(int[] arr){
		long start = System.currentTimeMillis();
		for(int i = 0 ; i< arr.length; i++){
			arr[i] = arr[i] * 3;
		}
		long end = System.currentTimeMillis();
		System.out.println("access1 consume: "+(end-start));
	}

	//16 * 4(btis) = 64bits(单个cacheline的大小)
	public static void access2(int[] arr){
		long start = System.currentTimeMillis();
		for(int i = 0 ; i< arr.length; i+=16){
			arr[i] = arr[i] * 3;
		}
		long end = System.currentTimeMillis();
		System.out.println("access1 consume: "+(end-start));
	}
}
