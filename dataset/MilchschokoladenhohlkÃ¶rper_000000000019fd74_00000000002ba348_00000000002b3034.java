import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

	Scanner in = new Scanner(System.in);

	void solve() throws Exception {
		int			n	= in.nextInt();
		List<List<String>>	a	= new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			String			s	= in.next();
			List<String>	l	= new ArrayList<>(Arrays.asList(s.split("\\*")));
			a.add(l);
			if (s.charAt(s.length() - 1) == '*') l.add("");
		}

		// Longest begin and end
		String	begin	= a.stream().map(l -> l.get(0)).max((s1, s2) -> Integer.compare(s1.length(), s2.length())).get();
		String	end		= a.stream().map(l -> l.get(1)).max((s1, s2) -> Integer.compare(s1.length(), s2.length())).get();

		// Compare endings
		for (List<String> l : a) {
			if (!begin.startsWith(l.get(0)) || !end.endsWith(l.get(1))) {
				System.out.println('*');
				return;
			}
		}

		// LCS
		String res = begin + end;
		/*
		for (int i = 0; i < begin.length(); ++i)
			if (end.startsWith(begin.substring(i))) {
				res = begin + end.substring(begin.length() - i);
				break;
			}
        */
		System.out.println(res.length() > 10000 ? "*" : res);
	}

	void run() throws Exception {
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			System.out.printf("Case #%d: ", i);
			solve();
		}
	}

	public static void main(String[] args) throws Exception { new Solution().run(); }
}
