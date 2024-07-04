import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	class Data {
		long val;
		int cnt;
	}

	String fnc(int n, int d, long[] a) {
		if (d == 2) {
			Set<Long> set = new HashSet<Long>();
			for (long aa : a) {
				set.add(aa);
			}
			if (set.size() == n) {
				return "1";
			} else {
				return "0";
			}
		} else if (d == 3) {
			List<Data> list = new ArrayList<Data>();
			int maxCnt = -1;
			long maxValue = -1L;
			for (int i = 0; i < n; i++) {
				Data data = find(list, a[i]);
				if (data == null) {
					data = new Data();
					data.val = a[i];
					data.cnt = 1;
					list.add(data);
				} else {
					data.cnt++;
				}

				maxValue = Math.max(maxValue, data.val);
				maxCnt = Math.max(maxCnt, data.cnt);
			}

			if (maxCnt >= 3) {
				return "0";
			}

			for (Data data : list) {
				if (data.cnt == 2 && data.val < maxValue) {
					return "1";
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					if (a[i] * 2 == a[j] || a[i] == a[j] * 2) {
						return "1";
					}
				}
			}

			return "2";
		}

		return "" + (d - 1);
	}

	Data find(List<Data> list, long value) {
		for (Data data : list) {
			if (data.val == value) {
				return data;
			}
		}

		return null;
	}

	void run() {
		try (Scanner sc = new Scanner(System.in)) {
			int testNum = sc.nextInt();
			for (int t = 1; t <= testNum; t++) {
				int n = sc.nextInt();
				int d = sc.nextInt();
				long[] a = new long[n];
				for (int i = 0; i < n; i++) {
					a[i] = sc.nextLong();
				}
				System.out.println("Case #" + t + ": " + fnc(n, d, a));
			}
		}
	}

	public static void main(String[] args) {
		new Solution().run();
	}
}
