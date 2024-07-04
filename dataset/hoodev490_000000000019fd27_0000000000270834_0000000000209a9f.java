import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;


public class Solution {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
			int t = in.nextInt();

			for (int i = 0; i < t; i++) {
				String str = in.next();
				solve(str, i + 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.exit(0);
	}

	private static void solve(String str, int testcase) {
		Stack<Character> stack = new Stack<Character>();
		String output = solve(0, 0, str, stack);
		while (!stack.isEmpty()) {
			output += stack.pop();
		}
		System.out.println(String.format("Case #%d: %s", testcase, output));
	}

	private static String solve(int i, int last, String str, Stack<Character> stack) {
		if (i >= str.length()) {
			return "";
		}
		
		String output = "";
		
		Integer depth = str.charAt(i) - '0';
		
		if (depth < last) {
			for (int x = depth; x < last; x++) {
				output += stack.pop();
			}
		}
		
		if (depth > last) {
			for (int x = last; x < depth; x++) {
				stack.push(')');
				output += '(';
			}
		}
		
		output += depth;
		
		return output + solve(i + 1, depth, str, stack);
	}

}