import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
				PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
			for (int testCases = in.nextInt(), testCase = 1; testCase <= testCases; testCase++) {
				final int n = 10_000, u = in.nextInt();
				final long[] a = new long[n];
				final String[] b = new String[n];
				for (int i = 0; i < n; i++) {
					a[i] = in.nextLong();
					b[i] = in.next();
				}
				out.println("Case #" + testCase + ": " + solve(u, a, b));
			}
		}
	}

	private static String solve(int u, long[] a, String[] b) {
		final Map<Character, Set<Integer>> m = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			final int bl = b[i].length();
			for (int j = 0; j < bl; j++) {
				if (!m.containsKey(b[i].charAt(j))) {
					final Set<Integer> d = new HashSet<>();
					for (int k = 0; k < 10; k++) {
						d.add(k);
					}
					m.put(b[i].charAt(j), d);
				}
			}
			long c = a[i], j = 0;
			while (c >= 10) {
				c /= 10;
				j++;
			}
			if (bl == j + 1) {
				final Set<Integer> d = m.get(b[i].charAt(0));
				for (int k = (int) c + 1; k < 10; k++) {
					d.remove(k);
				}
			}
			if (b[i].length() == 1) {
				m.get(b[i].charAt(0)).remove(0);
			}
			for (Map.Entry<Character, Set<Integer>> e : m.entrySet()) {
				if (e.getValue().size() == 1) {
					int z = -1;
					for (Integer z1 : e.getValue()) {
						z = z1;
					}
					for (Map.Entry<Character, Set<Integer>> f : m.entrySet()) {
						if (!f.getKey().equals(e.getKey())) {
							f.getValue().remove(z);
						}
					}
				}
			}
		}
		StringBuilder ans = new StringBuilder("0123456789");
		for (Map.Entry<Character, Set<Integer>> e : m.entrySet()) {
			if (e.getValue().size() == 1) {
				for (Integer y : e.getValue()) {
					ans.setCharAt(y, e.getKey());
				}
			}
		}
		return ans.toString();
	}

}
