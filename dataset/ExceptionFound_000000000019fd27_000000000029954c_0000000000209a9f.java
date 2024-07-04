import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String args[]) {
		String openBracket = "(";
		String closeBracket = ")";
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; i++) {
			String str = in.next() + in.nextLine();
			String s[] = str.split("");
			StringBuilder sb = new StringBuilder();
			int prevNum = 0;
			for (int j = 0; j < s.length; j++) {
				int num = Integer.parseInt(s[j]);
				if (num < prevNum) {
					sb.insert(sb.length() - num, num);
					prevNum = num;
					continue;
				} else if (j != 0) {
					if (sb.charAt(sb.length() - 1) == '0') {
						for (int g = 0; g < num; g++) {
							sb.insert(sb.length(), openBracket);
						}
						sb.insert(sb.length(), num);
						for (int g = 0; g < num; g++) {
							sb.insert(sb.length(), closeBracket);
						}
					} else {
						for (int g = 0; g < num - 1; g++) {
							sb.insert(sb.length() - 1, openBracket);
						}
						sb.insert(sb.length() - 1, num);
						for (int g = 0; g < num - 1; g++) {

							sb.insert(sb.length() - 1, closeBracket);
						}
					}
					prevNum = num;
					continue;
				}
				for (int k = 0; k < num; k++) {
					sb.append(openBracket);
				}
				sb.append(num);
				for (int k = 0; k < num; k++) {
					sb.append(closeBracket);
				}

				prevNum = num;
			}
			System.out.println("Case #" + i + ": " +  sb.toString());
		}
		in.close();
	}
}
