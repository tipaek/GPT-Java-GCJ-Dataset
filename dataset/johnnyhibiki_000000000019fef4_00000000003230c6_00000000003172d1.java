import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

	class Data {
		long val;
		int cnt;
	}

	String fnc(int n, int d, long[] a) {
		if (n == 1) {
			return "" + (d - 1);
		}

		List<Data> list = new ArrayList<Data>();
		for (int i = 0; i < n; i++) {
			Data data = find(list, a[i]);
			if (data == null) {
				Data nData = new Data();
				nData.val = a[i];
				nData.cnt = 1;
				list.add(nData);
			} else {
				data.cnt++;
			}
		}

		Collections.sort(list, new Comparator<Data>() {
			public int compare(Data o1, Data o2) {
				if (o1.cnt > o2.cnt) {
					return 1;
				} else {
					return -1;
				}
			}
		});

		if (list.get(list.size() - 1).cnt >= d) {
			return "0";
		}

		Collections.sort(list, new Comparator<Data>() {
			public int compare(Data o1, Data o2) {
				if (o1.val > o2.val) {
					return 1;
				} else {
					return -1;
				}
			}
		});

		for (int i = 1; i < list.size(); i++) {
			Data data = list.get(i);
			if (data.cnt >= 2) {
				return "1";
			}
		}

		for (Data data1 : list) {
			for (Data data2 : list) {
				if (data1.val * 2 == data2.val) {
					return "1";
				}
			}
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
