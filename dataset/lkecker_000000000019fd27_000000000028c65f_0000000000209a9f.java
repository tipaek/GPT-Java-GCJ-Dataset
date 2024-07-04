import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			String s = sc.next();
			solve(i + 1, s);
		}
	}

	private static void solve(int i, String s) {
		int currentNesting = 0;
		StringBuilder erg = new StringBuilder();
		int index = 0;
		while (index < s.length()) {
			if (s.charAt(index) - 48 > currentNesting) {
				erg.append("(");
				currentNesting++;
			} else if (s.charAt(index) - 48 < currentNesting) {
				erg.append(")");
				currentNesting--;
			} else {
				erg.append(s.charAt(index));
				index++;
			}
		}
		while (currentNesting > 0) {
			erg.append(")");
			currentNesting--;
		}

		System.out.println("Case #" + i + ": " + erg.toString());

	}

}
