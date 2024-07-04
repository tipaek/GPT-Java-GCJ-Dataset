
import java.util.Scanner;

public class Solution {
	static Scanner s = new Scanner(System.in);
	static int t = s.nextInt();
	static String[] out = new String[t];
	static int l = 0;

	public static void main(String[] args) {
		String[] b = new String[100];
		for (int i = 0; i < t; i++) {
			b[i] = s.next();
			check(b[i]);
		}
		for (int i = 0; i < t; i++) {
			System.out.println("Case #" + (i + 1) + ": " + out[i]);
		}
	}

	private static void check(String string) {
		String dummy = "";
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) > 0) {
				int time = string.charAt(i) - 48;
				for (int j = 0; j < time; j++) {
					dummy += "(";
				}
				dummy += string.charAt(i);
				for (int j = 0; j < time; j++) {
					dummy += ")";
				}
			} else {
				dummy += string.charAt(i);
			}
		}
		checkDummy(dummy);
	}

	private static void checkDummy(String dummy) {
		StringBuilder build = new StringBuilder(dummy);
		for (int i = 0; i < build.length() - 1; i++) {
			if (build.charAt(i) == ')' && build.charAt(i + 1) == '(') {
				build = build.deleteCharAt(i);
				build = build.deleteCharAt(i);
				i -= 2;
			}
		}
		out[l++] = build.toString();
	}
}
