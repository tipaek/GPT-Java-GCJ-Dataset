

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner nik = new Scanner(System.in);
		int t = nik.nextInt();
		StringBuilder st = new StringBuilder();
		C: for (int tc = 1; tc <= t; tc++) {
			st.append("Case #" + tc + ": ");

			int n = nik.nextInt();
			int d = nik.nextInt();

			HashMap<Long, Integer> ht = new HashMap<>();
			for (int i = 0; i < n; i++) {
				long x = nik.nextLong();

				if (ht.containsKey(x)) {
					int g = ht.get(x);
					g++;
					ht.put(x, g);
				} else {
					ht.put(x, 1);
				}
			}

			if (n == 1) {
				st.append((d - 1) + "\n");
				continue C;
			}
			boolean mt = false;
			long mint = Long.MAX_VALUE;
			for (long v : ht.keySet()) {
				if (ht.get(v) >= d) {
					st.append("0\n");
					continue C;
				}
				if (ht.get(v) == 2) {
					mt = true;
					mint = Math.min(mint, v);
				}
			}
			if (d == 2) {
				st.append((mt ? 0 : 1) + "\n");
				continue C;
			}
			if (mt)
				for (long v : ht.keySet()) {
					if (v > mint) {
						st.append("1\n");
						continue C;
					}
				}

			for (long v : ht.keySet()) {
				if (ht.get(v) == 3) {
					st.append("0\n");
					continue C;
				}
			}
			for (long x : ht.keySet()) {
				for (long y : ht.keySet()) {
					if (x < y) {
						if (x == y - x || ht.get(x) >= 2 || ht.getOrDefault(y - x, 0) >= 2) {
							st.append("1\n");
							continue C;
						}
					}
				}
			}
			st.append("2\n");
		}
		System.out.print(st);

	}

}
