import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int te = 0; te < T; te++) {

			String s = sc.next();
			StringBuilder sb = new StringBuilder();
			int left = 0;
			int right = 0;
			int initial = Integer.parseInt(String.valueOf(s.charAt(0)));

			for (int i = 0; i < initial; i++) {
				sb.append('(');
				left++;
			}
			sb.append(s.charAt(0));

			for (int i = 0; i < s.length() - 1; i++) {

				int value = Integer.parseInt(String.valueOf(s.charAt(i)))
						- Integer.parseInt(String.valueOf(s.charAt(i + 1)));

				if (value > 0) {

					for (int j = 0; j < value; j++) {
						sb.append(')');
						right++;
					}
				} else if (value < 0) {
					for (int j = 0; j < Math.abs(value); j++) {
						sb.append('(');
						left++;
					}
				}
				sb.append(s.charAt(i + 1));

			}

			if ((left - right) > 0) {
				for (int i = 0; i < (left - right); i++) {
					sb.append(')');
				}
			}

			System.out.println("Case #" + (te + 1) + ": " + sb.toString());

		}

		sc.close();

	}

}