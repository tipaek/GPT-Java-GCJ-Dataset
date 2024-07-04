import java.util.*;

public class Solution {

	private static class MyString {
		int pos;
		int len;
		String str;

		public MyString(int pos, int len, String str) {
			this.pos = pos; this.len = len; this.str = str;
		}
	}

	private static boolean check(boolean pre, StringBuffer sb, String s) {
		if (s.equals("*") || s.equals("")) {
			return true;
		}

		int sl = s.length();

//		System.err.println(pre + " " + sb + " " + s);

		if (pre) {
			for (int i = 0; (i < sb.length() && i < sl); i++) {
				if (sb.charAt(i) != s.charAt(i)) {
					return false;
				}
			}

			if (sl > sb.length()) {
				sb.append(s.substring(sb.length()));
			}
		} else {
			for (int i = sb.length() - 1, j = sl - 1; (i >= 0 && j >= 0); i--, j--) {
				if (sb.charAt(i) != s.charAt(j)) {
					return false;
				}
			}

			if (sl > sb.length()) {
				sb.insert(0, s.substring(0, sl - sb.length()));
			}
		}

		return true;
	}

	private static List<String> split(String str) {
		List<String> res = new ArrayList();
		StringBuffer cur = new StringBuffer();

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '*') {
				if (cur.length() > 0) {
					res.add(cur.toString());
					cur = new StringBuffer();
				}
				res.add("*");
			} else {
				cur.append(str.charAt(i));
			}
		}

		if (cur.length() > 0) {
			res.add(cur.toString());
		}

		return res;
	}

	private static String solve(String[] p) {
		StringBuffer bb = new StringBuffer();
		StringBuffer eb = new StringBuffer();
		List<MyString> set = new ArrayList();

		for (String s : p) {
			int sl = s.length();	
			List<String> strs = split(s);
//			System.err.println(s + " -> " + strs.size());
				if (!check(true, bb, strs.get(0))) {
					return "*";
				}

				if (!check(false, eb, strs.get(strs.size() - 1))) {
					return "*";
				}

				for (int i = 1; i < (strs.size() - 1); i++) {
					if (!strs.get(i).equals("*")) {
						set.add(new MyString(i, strs.size(), strs.get(i)));
					}
				}
		}
		
		for (MyString str : set) {
			bb.append(str.str);
		}

		bb.append(eb);

		String res = bb.toString();
		if (res.equals("")) {
			res = "A";
		}

		return res;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int T = s.nextInt();
		for(int i = 1; i <= T; i++) {
			int N = s.nextInt();
			String[] strs = new String[N];
			for (int j = 0; j < N; j++) {
				strs[j] = s.next();
			}

			System.out.println("Case #" + i + ": " + solve(strs));
		}

		s.close();
	}
}