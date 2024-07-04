import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Solution {
	static Scanner sc;

	public static void main(String args[]) {
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		int B = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			// System.err.println("case " + i);
			resolv(B);
		}
	}

	static String readFirst() {
		StringBuffer sb = new StringBuffer();
		String s;
		for (int n = 1; n <= 10; n++) {
			System.out.println(n);
			System.out.flush();
			s = sc.next();
			if (s.equals("0") || s.equals("1"))
				sb.append(s);
			else
				System.exit(1);
		}
// System.err.println(sb.toString());
		return sb.toString();
	}

	static String reverse(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++)
			sb.append(s.charAt(s.length() - i - 1));
		return sb.toString();
	}

	static String exor(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++)
			if (s.charAt(i) == '0')
				sb.append('1');
			else
				sb.append('0');
		return sb.toString();
	}

	static String reexor(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++)
			if (s.charAt(s.length() - i - 1) == '0')
				sb.append('1');
			else
				sb.append('0');
		return sb.toString();
	}

	private static void resolv(int B) {
		if (B == 10) {
			String s = readFirst();
			System.out.println(s);
			System.out.flush();
			s = sc.next();
			if (s.equals("Y"))
				;
				// System.err.println("YES");
			else
				System.exit(1);
		} else if (B == 20) {
			String ps = null, rs = null, s = null;

			ps = readFirst();
			for (int i = 0; i < 10; i++) {
				rs = exor(ps);
				s = readFirst();
				if (ps.equals(s) || rs.equals(s))
					ps = s;
				else
					break;
			}
			if (ps.equals(s) || rs.equals(s)) {
				if (s.equals("0000000000") || s.equals("1111111111")) {
					StringBuffer sb = new StringBuffer();
					System.out.println(1);
					System.out.flush();
					if (sc.next().equals("0"))
						sb.append("0000000000");
					else
						sb.append("1111111111");
					System.out.println(11);
					System.out.flush();
					if (sc.next().equals("0"))
						sb.append("0000000000");
					else
						sb.append("1111111111");
					s = sb.toString();
// System.err.println(s);
System.out.println(s);
System.out.flush();
					s = sc.next();
// System.err.println(s);
					return;
				}
			}
			ArrayList<String> list = new ArrayList<String>();
			String k1 = s + reverse(ps);
			String k2 = s + reexor(ps);
// System.err.println(k1);
// System.err.println(k2);
			list.add(k1);
			list.add(reverse(k1));
			list.add(exor(k1));
			list.add(reexor(k1));
			list.add(k2);
			list.add(reverse(k2));
			list.add(exor(k2));
			list.add(reexor(k2));
// System.err.println(list);

			while (true) {
				String s0 = list.get(0);
				String s1 = list.get(1);
				int idx = 0;
				for (; idx < s0.length(); idx++) {
					if (s0.charAt(idx) != s1.charAt(idx))
						break;
				}
				System.out.println(idx + 1);
				System.out.flush();
				s = sc.next();
				if (s.charAt(0) == s0.charAt(idx))
					list.remove(1);
				else
					list.remove(0);
				if (list.size() == 1)
					break;
			}
			s = list.get(0);
// System.err.println(s);
System.out.println(s);
System.out.flush();
				s = sc.next();
// System.err.println(s);
			// System.exit(1);
		}
	}
}
