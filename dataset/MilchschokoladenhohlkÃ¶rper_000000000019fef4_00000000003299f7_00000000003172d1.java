import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

	Scanner in = new Scanner(System.in);

	int rec(Map<Long, Integer> m, int minCuts, int d) {
		for (long l1 : m.keySet())
			for (long l2 : m.keySet())
				if (l1 > l2 && l1 % l2 == 0) {
					long div = l1 / l2;
					if (div + m.get(l2) >= d) {
						TreeMap<Long, Integer> sub = new TreeMap<Long, Integer>();
						sub.putAll(m);
						if (sub.get(l1) > 1) sub.put(l1, sub.get(l1) - 1);
						else sub.remove(l1);
						sub.put(l2, (int) (sub.get(l2) + div - 1));
						minCuts = (int) Math.min(minCuts, rec(sub, (int) Math.min(minCuts, div - 1), d));
					}
				}
		return minCuts;
	}

	void solve() throws Exception {
		int					n	= in.nextInt(), d = in.nextInt();
		TreeMap<Long, Integer>	m	= new TreeMap<>(Collections.reverseOrder());

		// Count sizes
		for (int i = 0; i < n; ++i)
			m.merge(in.nextLong(), 1, (k, v) -> v + 1);
		
		if(m.values().parallelStream().anyMatch(c -> c >= d)) {
			System.out.println(0);
			return;
		}
		
		System.out.println(rec(m, d - 1, d));
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
