import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static String solution(String s) {
		String ans = "";
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
			if (curr == '0') {
				while (!stack.isEmpty()) {
					stack.pop();
					ans += ')';
				}

				ans += curr;
			} else {
				int num = Integer.parseInt(String.valueOf(curr));

				for (int j = 0; j < num && num > stack.size(); j++) {
					ans += '(';
					stack.push('(');
				}
				for (int j = stack.size(); j > num && num < stack.size(); j--) {
					ans += ')';
					stack.pop();
				}

				ans += curr;
			}
		}

		while (!stack.isEmpty()) {
			stack.pop();
			ans += ')';
		}

		return ans;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int tests = in.nextInt();
		in.nextLine();

		int caaa = 1;

		while (tests > 0) {
			tests--;

			String line = in.nextLine();
			System.out.println("Case #" + caaa++ + ": " + solution(line));
		}

		// System.out.println(solution("221"));
	}
}
