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
 * 结果与博客完全相反
 * <a href="http://coolshell.cn/articles/10249.html">7个示例科普CPU Cache#内存访问和运行#指令级别并发</a>
 * 
 * @author spccold
 * @version $Id: InstructionConcurrency.java, v 0.1 2016年12月9日 下午3:22:03 spccold Exp $
 */
public class InstructionConcurrency {
	private static final int STEPS = 256 * 1024 * 1024;
	public static void main(String[] args) {
		int[] arr = new int[2];
		case1(arr);
//		case2(arr);
	}

	public static void case1(int[] arr) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < STEPS; i++) {
			arr[0]++;
			arr[0]++;
		}
		long end = System.currentTimeMillis();
		System.out.println("case1 consume: " + (end - start));
	}

	public static void case2(int[] arr) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < STEPS; i++) {
			arr[0]++;
			arr[1]++;
		}
		long end = System.currentTimeMillis();
		System.out.println("case2 consume: " + (end - start));
	}
}
