import java.util.Scanner;

public class Solution {

	private static String process(String s) {
		String r = "";
		for (int i = 0; i < s.length(); i++) {
			int prev = i - 1;
			if (s.charAt(i) == '1') {
				if (prev == -1 || (prev > -1 && s.charAt(prev) == '0')) {
					r += "(";
				}
			} else if (s.charAt(i) == '0') {
				if (prev > -1 && s.charAt(prev) == '1') {
					r += ")";
				}
			}
			r += String.valueOf(s.charAt(i));
		}
		if (s.charAt(s.length() - 1) == '1') {
			r += ")";
		}
		return r;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String y = in.nextLine();
		int T = Integer.parseInt(y);
		for (int t = 0; t < T; t++) {
			String s = in.nextLine();
			System.out.println(process(s));
		}
		in.close();
	}
}
