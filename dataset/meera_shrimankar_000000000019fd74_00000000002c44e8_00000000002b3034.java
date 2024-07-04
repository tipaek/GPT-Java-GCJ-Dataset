import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static String match(String input, String pattern) {
		int n = input.length();
		int m = pattern.length();
		boolean[][] lookup = new boolean[n + 1][m + 1];
		for (int i = 0; i < n + 1; i++) {
			Arrays.fill(lookup[i], false);
		}
		lookup[0][0] = true;
		for (int j = 1; j <= m; j++) {
			if (pattern.charAt(j - 1) == '*')
				lookup[0][j] = lookup[0][j - 1];
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (pattern.charAt(j - 1) == '*') {
					lookup[i][j] = lookup[i][j - 1] || lookup[i - 1][j];
				} else if (input.charAt(i - 1) == '*') {
					lookup[i][j] = lookup[i][j - 1] || lookup[i - 1][j];
				} else if (input.charAt(i - 1) == pattern.charAt(j - 1)) {
					lookup[i][j] = lookup[i - 1][j - 1];
				} else {
					lookup[i][j] = false;
				}
			//	System.out.println(i + " " + j + " " + lookup[i][j]);
			}
		}
		StringBuilder sb = new StringBuilder();
		if (lookup[n][m]) {
			int i = 0;
			int j = 0;
			while (i < n && j < m) {
				if (input.charAt(i) == '*') {
					while (pattern.charAt(j) != '*') {
						sb.append(pattern.charAt(j));
						j++;
					}
					sb.append(input.charAt(i));
				} else if (pattern.charAt(j) == '*') {
					while (input.charAt(i) != '*') {
						sb.append(input.charAt(i));
						i++;
					}
					sb.append(pattern.charAt(j));
				} else {
					sb.append(pattern.charAt(i));
				}
				i++;
				j++;
				
			}
			while (i < n) {
				sb.append(input.charAt(i));
				i++;
			}
			while (j < m) {
				sb.append(pattern.charAt(j));
				j++;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		List<List<String>> dataList = new ArrayList<>();
		for (int i = 0; i < T; i++) {
			List<String> testcase = new ArrayList<String>();
			int N = sc.nextInt();
			for (int j = 0; j < N; j++) {
				String input = sc.next();
				testcase.add(input);
			}
			dataList.add(testcase);
		}
		for (int i = 0; i < dataList.size(); i++) {
			String pattern = dataList.get(i).get(0);
			for (int j = 1; j < dataList.get(i).size(); j++) {
				pattern = match(dataList.get(i).get(j), pattern);
				if (pattern == null) {
					break;
				}
			}
			StringBuilder sb = new StringBuilder();
			if (pattern != null) {
				for (int j = 0; j < pattern.length(); j++) {
					if (pattern.charAt(j) == '*') {
						sb.append('A');
					} else {
						sb.append(pattern.charAt(j));
					}
				}
				System.out.println(sb.toString());
			} else {
				System.out.println('*');
			}
		}
	}
}
