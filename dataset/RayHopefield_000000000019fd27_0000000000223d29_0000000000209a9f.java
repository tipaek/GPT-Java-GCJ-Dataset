package CodeJam.y2020;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int i = 1; i <= T; i++) {
			String s = sc.nextLine();
			StringBuilder sb = new StringBuilder();
			int curr = 0;
			for (char c : s.toCharArray()) {
				int num = c - '0';
				if (num > curr)
					for (int j = 0; j < num - curr; j++)
						sb.append('(');
				else if (num < curr)
					for (int j = 0; j < curr - num; j++)
						sb.append(')');
				curr = num;
				sb.append(num);
			}
			for (int j = 0; j < curr; j++)
				sb.append(')');

			System.out.printf("Case #%s: %s%n", i, sb.toString());
		}
		sc.close();
	}

}
