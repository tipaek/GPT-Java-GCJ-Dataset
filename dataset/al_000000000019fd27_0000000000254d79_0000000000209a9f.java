import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCount = scanner.nextInt();

		for (int i = 0; i < testCount; i++) {
			String str = scanner.next();
			String result = solve(str);
			System.out.println("Case #" + (i + 1) + ": " + result);
		}

	}

	private static String solve(String str) {
		StringBuilder sb = new StringBuilder();
		char previous = '-';
		int openCount = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c != previous) {
				int value = c - '0';
				if (openCount < value) {
					while (openCount != value) {
						sb.append('(');
						openCount++;
					}
				} else if (openCount > value) {
					while (openCount != value) {
						sb.append(')');
						openCount--;
					}
				}
			}
			sb.append(c);
			previous = c;
		}
		if (openCount != 0) {
			while (openCount != 0) {
				sb.append(')');
				openCount--;
			}
		}
		return sb.toString();
	}

}
