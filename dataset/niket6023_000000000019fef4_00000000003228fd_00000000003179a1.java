
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner nik = new Scanner(System.in);
		int t = nik.nextInt();
		StringBuilder st = new StringBuilder();
		for (int tc = 1; tc <= t; tc++) {
			st.append("Case #" + tc + ": ");
			int u = nik.nextInt();
			HashMap<Character, ArrayList<Long>> ht = new HashMap<>();
			for (int i = 0; i < 10000; i++) {
				long m = (nik.nextLong());
				char[] c = nik.next().toCharArray();

				for (char val : c) {

					ArrayList<Long> a1 = new ArrayList<>();
					if (ht.containsKey(val)) {
						a1 = ht.get(val);
					}
					a1.add(m);
					ht.put(val, a1);
				}

			}
			int idx = 0;

			pair[] p = new pair[10];
			for (Character val : ht.keySet()) {
				ArrayList<Long> a1 = ht.get(val);
				Collections.sort(a1);
				ht.put(val, a1);
				long temp = a1.get(0) % 16;
				p[idx] = new pair(val, temp);
				idx++;
			}
			Arrays.sort(p);

			for (int i = 0; i < p.length; i++) {
				st.append(p[i].c);
			}
			st.append("\n");
		}
		System.out.println(st);
	}

	private static class pair implements Comparable<pair> {
		char c;
		long idx;

		pair(char c, long idx) {
			this.c = c;
			this.idx = idx;
		}

		public int compareTo(pair o) {

			if (this.idx > o.idx) {
				return 1;
			} else {
				return -1;
			}
		}
	}
}
