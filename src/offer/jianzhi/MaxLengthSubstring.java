/**
 * 输出最长公共子串
 * 动态规划
 * 		整型数组
		   　  b　　a　　b
		
		c　　0　　0　　0
		
		a　　0　　1　　0
		
		b　　1　　0　　1
		
		a　　0　　1　　0
	
		b	 1	  0    1
		
		或者字符串数组
 * 　　             b　　a　　b   

		c　　0　　0　　0
		
		a　　0　　a　　0
		
		b　　b　　0　　ab
		
		a　　0　　ba　  0
		
		b	 b    0   bab
 */
package offer.jianzhi;

public class MaxLengthSubstring {

	// 暴力解法
	public static String maxSubstring(String strOne, String strTwo) {
		if (strOne.equals("") || strOne.equals(""))
			return null;
		String str1;
		String str2;
		if (strOne.length() > strTwo.length()) {
			str1 = strOne;
			str2 = strTwo;
		} else {
			str2 = strOne;
			str1 = strTwo;
		}
		// 遍历较短的字符串，并依次减少短字符串的字符数量，判断长字符是否包含该子串
		for (int i = 0; i < str1.length(); i++) {
			for (int start = 0, end = str2.length() - i; end <= str2
					.length(); start++, end++) {
				if (str1.contains(str2.substring(start, end)))
					return str2.substring(start, end);
			}
		}

		return null;
	}

	// 动态规划
	public static String maxSubstring2(String strOne, String strTwo) {
		if (strOne.equals("") || strOne.equals(""))
			return null;

		String str1;
		String str2;
		if (strOne.length() > strTwo.length()) {
			str1 = strOne;
			str2 = strTwo;
		} else {
			str2 = strOne;
			str1 = strTwo;
		}

		// 将数组初始化
		String[][] dp = new String[str1.length() + 1][str2.length() + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				dp[i][j] = "";

			}
		}

		String max = "";
		// 若str1的第i-1位与str2的第j-1位相等（从0开始算），则将这个字符加上dp[i-1][j-1]，存储在dp[i][j]中
		// 多存一行一列，是为了避免需要对第0位的字符和字符串数组进行单独处理
		// （因为dp[0][j]和dp[i][0]不存在dp[i - 1][j - 1]）
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + str1.charAt(i - 1);
				}
				if (dp[i][j].length() > max.length())
					max = dp[i][j];
			}
		}

		return max;
	}

	public static void main(String[] args) {
		String str1 = "abcdefg";
		String str2 = "adefgwgeweg";
		System.out.println(maxSubstring(str1, str2));
		System.out.println(maxSubstring2(str1, str2));
	}

}
