import java.util.*;

public class Solution {

	private static String solve(List<String> pats) {
		int n = pats.size();
		String[] prefix = new String[n], suffix = new String[n], mid = new String[n];
		for (int i = 0; i < n; ++i) {
			String pat = pats.get(i);
			int p1 = pat.indexOf('*');
			prefix[i] = pat.substring(0, p1);
			int p2 = pat.lastIndexOf('*');
			suffix[i] = pat.substring(p2 + 1);
			mid[i] = pat.substring(p1, p2 + 1);
		}

		String start = "";
		for (String pre : prefix) {
			if (start.length() < pre.length()) {
				String tmp = start; start = pre; pre = tmp;
			}
			if (!start.startsWith(pre)) return "*";
		}
		String end = "";
		for (String suf : suffix) {
			if (end.length() < suf.length()) {
				String tmp = end; end = suf; suf = tmp;
			}
			if (!end.endsWith(suf)) return "*";
		}
		StringBuilder sb = new StringBuilder();
		sb.append(start);
		for (String m : mid) {
			sb.append(m.replace("*",""));
		}
		sb.append(end);
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numTest = sc.nextInt();
		for (int test = 1; test <= numTest; ++test) {
			int n = sc.nextInt();
			Set<String> patsSet = new HashSet<>();
			for (int i = 0; i < n; ++i) patsSet.add(sc.next());
			List<String> pats = new ArrayList<>(patsSet);
			if (pats.size() == 1) {
				System.out.printf("#Case %d: %s\n", test, pats.get(0).replace("*", ""));
			} else {
				System.out.printf("#Case %d: %s\n", test, solve(pats));
			}
		}
		sc.close();
	}

}
