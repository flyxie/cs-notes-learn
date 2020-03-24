package leecode;

import java.util.Arrays;

/*
 * 有序数组的 Two Sum
 * 题目描述：在有序数组中找出两个数，使它们的和为 target。
 * https://cyc2018.github.io/CS-Notes/#/notes/Leetcode%20%E9%A2%98%E8%A7%A3%20-%20%E5%8F%8C%E6%8C%87%E9%92%88?id=_1-%e6%9c%89%e5%ba%8f%e6%95%b0%e7%bb%84%e7%9a%84-two-sum
 * 
 * 使用双指针，一个指针指向值较小的元素，一个指针指向值较大的元素。
 * 指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。
 * 
 */

class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		if (numbers == null)
			return null;
		int i = 0, j = numbers.length - 1;
		while (i < j) {
			int sum = numbers[i] + numbers[j];
			if (sum == target) {
				break;
			} else if (sum < target) {
				i++;
			} else {
				j--;
			}
		}
		return new int[] { i + 1, j + 1 };
	}
}

/*
 * 2. 两数平方和
 * 
 * 题目描述：判断一个非负整数是否为两个整数的平方和。 设右指针为 x，左指针固定为 0， 为了使 02 + x2 的值尽可能接近 target，我们可以将
 * x 取为 sqrt(target)。
 * 
 */

class JudgeSquareSum {
	public boolean judgeSquareSum(int c) {
		int low = 0, high = (int) Math.sqrt(c);
		while (low <= high) {
			int sum = low * low + high * high;
			if (sum == c) {
				return true;
			} else if (sum < c) {
				low++;
			} else {
				high--;
			}
		}
		return false;

	}
}

public class Main {
	public static void main(String[] args) {
		int[] num = { 2, 7, 11, 15 };
		int target = 9;
		TwoSum i = new TwoSum();
		int[] temp = i.twoSum(num, target);
		System.out.println(Arrays.toString(temp));
	}
}
