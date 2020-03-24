package offer.jianzhi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

// 找出数组中重复的数字

// 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
// 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。
public class DuplicateNum {
	public boolean duplicate(int numbers[], int length, int[] duplication) {
		int[] temp = new int[length];
		Arrays.fill(temp, length);
		for (int i = 0; i < length; i++) {
			if (numbers[i] == temp[numbers[i]]) {
				duplication[0] = numbers[i];
				return true;
			} else
				temp[numbers[i]] = numbers[i];

		}
		return false;
	}
}

// 或者不使用 int[] 数组，用boolean数组，boolean只占一位，更省空间
// 也不用再给数组赋值为 length 了
class DuplicateNum1 {
	public boolean duplicate(int numbers[], int length, int[] duplication) {
		boolean[] temp = new boolean[length];
		for (int i = 0; i < temp.length; i++) {
			if (temp[numbers[i]] == true) {
				duplication[0] = numbers[i];
				return true;
			}
			temp[numbers[i]] = true;
		}
		return false;
	}
}

//  或者不使用新数组
//  将值为 i 的元素调整到第 i 个位置上。
//  在调整过程中，如果第 i 位置上已经有一个值为 i 的元素，就可以知道 i 值重复。

class DuplicateNum2 {
	public boolean duplicate(int numbers[], int length, int[] duplication) {
		int temp;
		for (int i = 0; i < length; i++) {
			// 当第 i 位置上的元素不是 i 时，循环，直到第 i 位置上的元素等于i
			while (numbers[i] != i) {
				// 判断第 i 位置上的元素是否已经有一个值为 i 的元素
				if (numbers[i] == numbers[numbers[i]]) {
					duplication[0] = numbers[i];
					return true;

				}
				// 将值为 i 的元素调整到第 i 个位置上
				temp = numbers[numbers[i]];
				numbers[numbers[i]] = numbers[i];
				numbers[i] = temp;
			}
		}
		return false;

	}
}

// 二维数组/矩阵中的查找
// 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。
// 给定一个数，判断这个数是否在该二维数组中。

class Matrix {
	public boolean Find(int target, int[][] array) {
		int rows = 0, columns = array[0].length - 1;
		while (rows <= array.length - 1 & columns >= 0) {
			if (target == array[rows][columns]) {
				return true;
			} else if (target < array[rows][columns]) {
				columns--;
			} else {
				rows++;
			}
		}

		"Hello".substring(2, 5);

		return false;
	}
}

// 将一个字符串中的空格替换成 "%20"
// 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
// 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
class ReplaceSpace {
	public String replaceSpace(StringBuffer str) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				str.replace(i, i + 1, "%20");
			}
		}
		return str.toString();

	}
}

// 当遍历到一个空格时，在尾部填充两个任意字符，如"  "
// 令 P1 指向字符串原来的末尾位置，P2 指向字符串现在的末尾位置。P1 和 P2 从后向前遍历
// 当 P1 遍历到一个空格时，就需要令 P2 指向的位置依次填充 02%（注意是逆序的），
// 否则就填充上 P1 指向的字符的值。
class ReplaceSpace2 {
	public String replaceSpace(StringBuffer str) {
		int p1 = str.length() - 1;
		for (int i = 0; i <= p1; i++) {// 遍历到原字符串长度就停止
			if (str.charAt(i) == ' ') {
				str.append("11");
			}
		}

		int p2 = str.length() - 1;
		while (p1 >= 0) {
			if (str.charAt(p1) != ' ') {
				str.setCharAt(p2--, str.charAt(p1--));
			} else {
				str.setCharAt(p2--, '0');
				str.setCharAt(p2--, '2');
				str.setCharAt(p2--, '%');
				p1--;
			}
		}
		return str.toString();

	}
}

// 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。

/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/

// import java.util.ArrayList;

// 1.使用递归
class reverseList {
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (listNode != null) {
			list.addAll(printListFromTailToHead(listNode.next));
			list.add(listNode.val);
		}
		return list;

	}
}

// 2.使用头插法
class reverseList1 {
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		// 头插法构建逆序链表
		ListNode head = new ListNode(0);
		ListNode temp = new ListNode(0);
		while (listNode != null) {
			temp = listNode.next;
			listNode.next = head.next;
			head.next = listNode;
			listNode = temp;
		}

		// 把逆序链表传入 ArrayList
		head = head.next;
		ArrayList<Integer> list = new ArrayList<>();
		while (head != null) {
			list.add(head.val);
			head = head.next;
		}
		return list;
	}
}

// 3.使用栈

// import java.util.Stack;
class reverseList2 {
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		Stack<Integer> stack = new Stack<>();
		while (listNode != null) {
			stack.push(listNode.val);
			listNode = listNode.next;
		}
		ArrayList<Integer> list = new ArrayList<>();
		while (!stack.isEmpty()) {
			list.add(stack.pop());
		}
		return list;
	}
}

// 重建二叉树

// 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//	1. 根据前序序列第一个结点确定根结点
//	2. 根据根结点在中序序列中的位置分割出左右两个子序列
//	3. 对左子树和右子树分别递归使用同样的方法继续分解
//	例如：
//	前序序列{1,2,4,7,3,5,6,8} = pre
//	中序序列{4,7,2,1,5,3,8,6} = in
//	
//	根据当前前序序列的第一个结点确定根结点，为 1
//	找到 1 在中序遍历序列中的位置，为 in[3]
//	切割左右子树，则 in[3] 前面的为左子树， in[3] 后面的为右子树
//	则切割后的左子树前序序列为：{2,4,7}，切割后的左子树中序序列为：{4,7,2}；
//	切割后的右子树前序序列为：{3,5,6,8}，切割后的右子树中序序列为：{5,3,8,6}
//	对子树分别使用同样的方法分解 

// import java.util.Arrays;

class BinaryTree {
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		if (pre.length == 0 || in.length == 0) {
			return null;
		}
		TreeNode root = new TreeNode(pre[0]);

		for (int i = 0; i < in.length; i++) {
			if (in[i] == pre[0]) {
				root.left = reConstructBinaryTree(
						Arrays.copyOfRange(pre, 1, i + 1),
						Arrays.copyOfRange(in, 0, i));
				root.right = reConstructBinaryTree(
						Arrays.copyOfRange(pre, i + 1, in.length),
						Arrays.copyOfRange(in, i + 1, in.length));

			}
		}
		return root;
	}
}

/*
 * 8.二叉树的下一个结点
 */

// ① 如果一个节点的右子树不为空，那么该节点的下一个节点是右子树的最左节点；
// ② 否则，向上找第一个左链接指向的树包含该节点的祖先节点。

class GetNextNode {
	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		TreeLinkNode parent = pNode.next;

		// ① 如果一个节点的右子树不为空，那么该节点的下一个节点是右子树的最左节点；
		if (pNode.right != null) {
			TreeLinkNode child = pNode.right;
			while (child.left != null) {
				child = child.left;

			}
			return child;
		} else { // ② 否则，向上找第一个左链接指向的树包含该节点的祖先节点。
			while (parent != null) {
				if (parent.left == pNode) {
					return parent;
				}
				pNode = pNode.next;
				parent = pNode.next;
			}
			return null;
		}

	}
}

/*
 * 用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。
 */

// 当元素要出栈时，需要先进入 out 栈，此时元素出栈顺序被反转，
// 因此出栈顺序就和最开始入栈顺序是相同的，先进入的元素先退出。

// import java.util.Stack;

class creatQueue {
	Stack<Integer> inStack = new Stack<Integer>();
	Stack<Integer> outStack = new Stack<Integer>();

	public void push(int node) {
		inStack.push(node);
	}

	public int pop() {
		if (outStack.isEmpty()) { // 若 out栈为空，则
			while (!inStack.isEmpty()) { // 取 in栈中的全部数据入 out栈
				outStack.push(inStack.pop());
			}
		}

		return outStack.pop();
	}
}

/*
 * 求斐波那契数列的第 n 项，从第 0 项开始，n <= 39
 * f(0) = 0, f(1) = 1
 * f(n) = f(n-1) - f(n-2) , n>=2
 */

// 如果使用递归求解，会重复计算一些子问题。
// 递归是将一个问题划分成多个子问题求解，动态规划也是如此，
// 但是动态规划会把子问题的解缓存起来，从而避免重复求解子问题。
class Fibonacci {
	public int Fibonacci(int n) {
		int[] fib = new int[n + 1];
		if (n < 2) {
			return n;
		}
		fib[0] = 0;
		fib[1] = 1;
		for (int i = 2; i < fib.length; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		return fib[n];
	}
}

// 由于待求解的 n 小于 40，
// 因此可以将前 40 项的结果先进行计算，之后就能以 O(1) 时间复杂度得到第 n 项的值。
class Fibonacci1 {
	private int[] fib = new int[40];

	public Fibonacci1() {
		fib[0] = 0;
		fib[1] = 1;
		for (int i = 2; i < 40; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
	}

	public int Fibonacci(int n) {
		return fib[n];
	}
}

/**
 * 矩形覆盖
 * 用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，总共有多少种方法？
 */

// 要覆盖 2*n 的大矩形，可以先覆盖 2*1 的矩形，再覆盖 2*(n-1) 的矩形；
// 或者先覆盖 2*2 的矩形，再覆盖 2*(n-2) 的矩形。
// 而覆盖 2*(n-1) 和 2*(n-2) 的矩形可以看成子问题。
class RectCover {
	public int cover(int target) {
		if (target < 3) {
			return target;
		}
		int[] cov = new int[target + 1];

		cov[1] = 1;
		cov[2] = 2;
		for (int i = 3; i < cov.length; i++) {
			cov[i] = cov[i - 1] + cov[i - 2];

		}
		return cov[target];
	}
}

/*
 * 青蛙跳台阶
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。
 * 求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 */

// 跳 n 阶台阶，可以先跳 1 阶台阶，再跳 n-1 阶台阶；
// 或者先跳 2 阶台阶，再跳 n-2 阶台阶。
// 而 n-1 和 n-2 阶台阶的跳法可以看成子问题，
class FrogJump {
	public int JumpFloor(int target) {
		if (target < 3) {
			return target;
		}
		int temp1 = 1;
		int temp2 = 2;
		int result = 0;
		for (int i = 3; i < target + 1; i++) {
			result = temp1 + temp2;
			temp1 = temp2;
			temp2 = result;
		}
		return result;
	}
}

/*
 * 变态跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */

class SuperFrogJump {
	public int JumpFloor(int target) {
		int[] jump = new int[target + 1];
		jump[1] = 1;
		jump[2] = 2;
		for (int i = 2; i <= target; i++) {
			jump[i] = 2 * jump[i - 1];
		}
		return jump[target];
	}

	// f(n) = 2*f(n-1), 所以 f(n) 是一个等比数列
	public int JumpFloorII(int target) {
		return (int) Math.pow(2, target - 1);
	}

}

/*
 * 找出旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */

// 非递减排序：指不是单调递增（可能存在重复数字）的递增序列。如：1,2,2,3,4；
// import java.util.ArrayList;
class RotateArray {
	public int minNumberInRotateArray(int[] array) {
		if (array.length == 0) {
			return 0;
		} else {
			int low = 0, high = array.length - 1, mid;
			while (low < high) { // 注意不能写 low <= high，会死循环
				mid = low + (high - low) / 2;
				if (array[mid] > array[high]) {
					low = mid + 1;
				} else {
					high = mid;
				}
			}
			return array[high]; // return array[low] 也可以

		}
	}
}

// CS-Notes解法 考虑了一个特殊的情况：nums[l] == nums[m] == nums[h]
// 如： {1,1,1,0,1}

class RotateArrayCS {
	public int minNumberInRotateArray(int[] nums) {
		if (nums.length == 0)
			return 0;
		int l = 0, h = nums.length - 1;
		while (l < h) {
			int m = l + (h - l) / 2;
			if (nums[l] == nums[m] && nums[m] == nums[h])
				return minNumber(nums, l, h);
			else if (nums[m] <= nums[h])
				h = m;
			else
				l = m + 1;
		}
		return nums[l];
	}

	private int minNumber(int[] nums, int l, int h) {
		for (int i = l; i < h; i++)
			if (nums[i] > nums[i + 1])
				return nums[i + 1];
		return nums[l];
	}
}

/* 
 * 矩阵中的路径
 * 判断在一个矩阵中是否存在一条包含某字符串所有字符的路径？
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向上下左右移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 */

// 使用回溯法（backtracking）进行求解，它是一种暴力搜索方法，通过搜索所有可能的结果来求解问题。
// 回溯法在一次搜索结束时需要进行回溯（回退），将这一次搜索过程中设置的状态进行清除，从而开始一次新的搜索过程。
// 回溯是深度优先搜索的一种特例，它在一次搜索过程中需要设置一些本次搜索过程的局部状态，并在本次搜索结束之后清除状态。
class MatrixPath {
	private int rows;
	private int cols;

	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		if (rows == 0 || cols == 0)
			return false;
		this.rows = rows;
		this.cols = cols;
		char[][] charMatrix = buildMatrix(matrix);

		boolean[][] flag = new boolean[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (backPath(charMatrix, str, flag, 0, i, j))
					return true;
			}
		}
		return false;
	}

	private char[][] buildMatrix(char[] matrix) {
		char[][] charMatrix = new char[rows][cols];
		int index = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				charMatrix[i][j] = matrix[index];
				index++;
			}
		}
		return charMatrix;
	}

	private boolean backPath(char[][] matrix, char[] str, boolean[][] flag,
			int strIndex, int i, int j) {
		// TODO Auto-generated method stub
		if (strIndex == str.length)
			return true;
		if (i >= 0 & i < rows && j >= 0 && j < cols
				&& matrix[i][j] == str[strIndex] && flag[i][j] == false) {
			flag[i][j] = true;
			System.out.print(matrix[i][j] + "  ");
			if (backPath(matrix, str, flag, strIndex + 1, i + 1, j)) {
				return true;
			}
			if (backPath(matrix, str, flag, strIndex + 1, i - 1, j)) {
				return true;
			}
			if (backPath(matrix, str, flag, strIndex + 1, i, j + 1)) {
				return true;
			}
			if (backPath(matrix, str, flag, strIndex + 1, i, j - 1)) {
				return true;
			}
		}
		if (i >= 0 & i < rows && j >= 0 && j < cols)
			flag[i][j] = false;
		return false;
	}

}

/**机器人的运动范围
 * 地上有一个 m 行和 n 列的方格。
 * 一个机器人从坐标 (0, 0) 的格子开始移动，每一次只能向左右上下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于 k 的格子。
 * 例如，当 k 为 18 时，机器人能够进入方格 (35,37)，因为 3+5+3+7=18。
 * 但是，它不能进入方格 (35,38)，因为 3+5+3+8=19。
 * 
 * 请问该机器人能够达到多少个格子？
 */

// 使用深度优先搜索（Depth First Search，DFS）方法进行求解。
// 普通的深度优先搜索并不需要使用这些局部状态，虽然还是有可能设置一些全局状态。
// 回溯是深度优先搜索的一种特例，它在一次搜索过程中需要设置一些本次搜索过程的局部状态，并在本次搜索结束之后清除状态。
class RobotMove {
	private int rows, cols, threshold;
	private int count;
	private int[][] next = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 },
			{ -1, 0 } };

	public int movingCount(int threshold, int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		this.threshold = threshold;
		boolean[][] marked = new boolean[rows][cols];
		dfs(marked, 0, 0);
		return count;
	}

	private void dfs(boolean[][] marked, int r, int c) {
		if (r < 0 || r >= rows || c < 0 || c >= cols || marked[r][c])
			return;
		marked[r][c] = true;
		if (countSum(r, c) <= threshold) {
			count++;

			for (int[] n : next) {
				dfs(marked, r + n[0], c + n[1]);
			}
		}
		return;
	}

	private int countSum(int r, int c) {
		return r % 10 + r / 10 % 10 + c % 10 + c / 10 % 10;
	}
}