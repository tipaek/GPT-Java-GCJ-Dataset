import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

	Scanner in = new Scanner(System.in);

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
		
		int minCuts = d - 1;
		for(long l1 : m.keySet())
			for(long l2 : m.keySet())
				if(l1 > l2 && l1 % l2 == 0) {
					long div = l1 / l2;
					if(div + m.get(l2) >= d) {
						minCuts = (int) Math.min(minCuts, div - 1);
					}
				}
		
		System.out.println(minCuts);
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
