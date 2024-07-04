import java.util.*;
import java.io.*;

class Solution {

	public static void main(String[] args) {
		//input:
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numOfTestCase = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc. //# of Test cases
		in.nextLine();
		for (int t = 1; t <= numOfTestCase; t++) {
			String str = in.nextLine();
			String result = addParentheses(str);
			System.out.println("Case #" + t + ": " + result);
		}		
	}

	public static String addParentheses(String str) {
		int[] nums = new int[str.length()];
		for (int i = 0; i < str.length(); i++){
			nums[i] = str.charAt(i) - '0';
		}
		// for (int num : nums) {
		// 	System.out.print(num);
		// }

		StringBuilder result = new StringBuilder();
		//initial
		int counter = nums[0];
		appendParentheses(result, nums[0], "(");
		result.append(nums[0]);
		//processing
		for(int i = 1; i < nums.length; i++) {
			if (counter < nums[i]) {
				appendParentheses(result, nums[i] - counter, "(");
			} 
			if (counter > nums[i]) {
				appendParentheses(result, counter - nums[i], ")");
			} 
			result.append(nums[i]);
			counter = nums[i];
		}
		//Close
		if (counter > 0) {
			appendParentheses(result, counter, ")");
		}
		return result.toString();
	}

	private static StringBuilder appendParentheses(StringBuilder result, int repeatTimes, String openOrCloseParentheses) {
		while(repeatTimes > 0) {
			result.append(openOrCloseParentheses);
			repeatTimes--;
		}
		return result;
	}
}