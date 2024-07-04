import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class Solution {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {
			int n = sc.nextInt();
			int rowCnt = 0;
			int colCnt = 0;
			long sum = 0;

			boolean b[] = new boolean[n];
			boolean a[] = new boolean[n];
			Map<Integer, Set<Integer>> map = new HashMap<>();
			for (int l = 0; l < n; l++) {
				Set<Integer> set = new HashSet<>();
				for (int m = 0; m < n; m++) {
					int r = sc.nextInt();
					if (map.containsKey(m)) {
						Set<Integer> sets = map.get(m);
						b[m] = sets.contains(r) ? true : false;
						sets.add(r);
					} else {
						Set<Integer> st = new HashSet<>();
						st.add(r);
						map.put(m, st);
					}

					if (set.contains(r))
						a[l] = true;
					set.add(r);
					if (l == m)
						sum += r;
				}
			}

			for (int j = 0; j < n; j++) {
				if (a[j])
					rowCnt++;
			}
			for (int j = 0; j < n; j++) {
				if (b[j])
					colCnt++;
			}

			System.out.println("Case #" + i + ": " + sum + " " + rowCnt + " " + colCnt);
		}

		sc.close();

	}

}