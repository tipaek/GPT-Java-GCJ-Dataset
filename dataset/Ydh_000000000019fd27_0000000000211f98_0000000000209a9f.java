
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();

		int tc = scan.nextInt();

		for (int test_Case = 1; test_Case <= tc; test_Case++) {
			char[] input = scan.next().toCharArray();
			sb.append("Case #");
			sb.append(test_Case);
			sb.append(": ");

			int state = 0;

			for (int i = 0; i < input.length; i++) {
				int cur = input[i] - '0';

				if (cur < state) {
					for (int j = cur; j < state; j++) {
						sb.append(')');
					}
					sb.append(cur);
					state = cur;
				} else if (cur > state) {
					for (int j = state; j < cur; j++) {
						sb.append('(');
					}
					sb.append(cur);
					state = cur;
				} else {
					sb.append(cur);
				}

			}

			for (int i = 0; i < state; i++) {
				sb.append(')');
			}

			sb.append('\n');
		}
		System.out.println(sb.toString());
	}

}
