import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for(int tc = 1; tc <= n; tc++) {
			String x = scanner.next();
			StringBuilder sb = new StringBuilder();
			boolean hasOne = false;
			String ones = "";
			for(char c : x.toCharArray()) {
				if (c == '0') {
					if (hasOne) {
						sb.append("(" + ones + ")");
						hasOne = false;
						ones = "";
					}
					sb.append(c);
				} else {
					hasOne = true;
					ones += '1';
				}
			}
			if (ones.length() > 0) {
				sb.append("(" + ones + ")");
			}

			System.out.printf("Case #%d: %s", tc, sb.toString()).println();
		}

	}

}
