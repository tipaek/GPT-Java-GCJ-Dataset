
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = scn.nextInt();
		int tc = 0;
		for (int i = 0; i < 4; i++) {

		}
		C: while (tc++ < t) {
			sb.append("Case #" + tc + ": ");
			int n = scn.nextInt(), d = scn.nextInt();
			HashMap<Long, Integer> hm = new HashMap<>();
			for (int i = 0; i < n; i++) {
				long x = scn.nextLong();
				hm.put(x, hm.getOrDefault(x, 0) + 1);
			}
			if (n == 1) {
				sb.append((d - 1) + "\n");
				continue C;
			}
			boolean mt = false;
			long mint = Long.MAX_VALUE;
			for (long v : hm.keySet()) {
				if (hm.get(v) >= d) {
					sb.append("0\n");
					continue C;
				}
				if (hm.get(v) == 2) {
					mt = true;
					mint = Math.min(mint, v);
				}
			}
			if (d == 2) {
				sb.append((mt ? 0 : 1) + "\n");
				continue C;
			}
			if (mt)
				for (long v : hm.keySet()) {
					if (v > mint) {
						sb.append("1\n");
						continue C;
					}
				}
			for (long v : hm.keySet()) {
				if (hm.get(v) == 3) {
					sb.append("0\n");
					continue C;
				}
			}
			for (long x : hm.keySet()) {
				for (long y : hm.keySet()) {
					if (x < y) {
						if (x == y - x || hm.get(x) >= 2 || hm.getOrDefault(y - x, 0) >= 2) {
							sb.append("1\n");
							continue C;
						}
					}
				}
			}
			sb.append("2\n");
		}
		System.out.print(sb);
	}
}