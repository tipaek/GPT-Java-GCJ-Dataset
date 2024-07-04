import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String[] array = new String[T];
		for (int i = 0; i < T; i++) {
			array[i] = sc.next();
		}
		for (int i = 1; i <= T; i++) {
			String output = getStringWithParenthesis(array[i - 1]);
			System.out.println("Case #" + i + ": " + output);
		}

	}

	public static String getStringWithParenthesis(String input) {
		StringBuffer sb = new StringBuffer();
		Stack<Character> st = new Stack<>();
		char[] chars = input.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (i - 1 >= 0) {
				int diff = chars[i - 1] - chars[i];
				while (diff > 0) {
					sb.append(')');
					st.pop();
					diff--;
				}
			}
			int depth = st.size();
			for (int j = depth; j < Integer.parseInt(String.valueOf(chars[i])); j++) {
				st.push('(');
				sb.append('(');
			}
			sb.append(chars[i]);
		}
		for (int i = 0; i < st.size(); i++) {
			sb.append(')');
		}
		return sb.toString();
	}
}