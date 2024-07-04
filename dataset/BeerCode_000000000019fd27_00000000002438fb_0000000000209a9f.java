import java.util.*;
class App {
	public static void main(String[] commands) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		in.nextLine();
		for (int t = 1; t <= T; t++) {
			String input = in.nextLine();
			String result = process(input, 0);
			System.out.printf("Case #%d: %s\n", t, result);
		}
	}
	static String process(String s, int level) {
		char[] a = s.toCharArray();
		if (a.length == 0) { return ""; }
		ArrayList<String> all = new ArrayList();
		int start = 0;
		char expected = (char)('0' + level);
		for (int i = 1; i < a.length; i++) {
			if (a[start] == expected && a[i] == expected) {

			}
			if (a[start] == expected && a[i] != expected) {
				String t = "";
				for (int j = start; j < i; j++) {
					t += a[j];
				}
				all.add(t);
				start = i;
			}
			if (a[start] != expected && a[i] == expected) {
				String t = "";
				for (int j = start; j < i; j++) {
					t += a[j];
				}
				all.add(t);
				start = i;
			}
			if (a[start] != expected && a[i] != expected) {

			}
		}

		String t = "";
		for (int j = start; j < a.length; j++) {
			t += a[j];
		}
		all.add(t);

		String result = "";
		for (String w : all) {
			if (w.startsWith("" + expected)) {
				result += w;
			} else {
				result += "(" + process(w, level+1) + ")";
			}
		}
		return result;
	}
}