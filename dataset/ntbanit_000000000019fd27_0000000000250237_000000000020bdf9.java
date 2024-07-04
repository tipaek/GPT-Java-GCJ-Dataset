//package codejam2020.q1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		//System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = sc.nextInt();
		int tc = 1;

		class A {
			A(int s, int e, int idx) {
				this.s = s;
				this.e = e;
				this.idx = idx;
			}

			char c;
			int s, e, idx;
		}

		while (T-- > 0) {
			int N = sc.nextInt();
			int tempOfC = -1, tempOfJ = -1;
			boolean isOk = true;

			List<A> items = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				items.add(new A(start, end, i));
			}

			items.sort(new Comparator<A>() {
				@Override
				public int compare(A o1, A o2) {
					if (o1.e != o2.e)
						return o1.e - o2.e;
					return o1.s - o2.s;
				}
			});

			int tt = 0;
			++tt;
			for (A a : items) {
				if (!isOk)
					continue;
				if (a.s >= tempOfC) {
					a.c = 'C';
					tempOfC = a.e;
				} else if (a.s >= tempOfJ) {
					tempOfJ = a.e;
					a.c = 'J';
				} else {
					isOk = false;
					break;
				}
			}
			StringBuilder sb = new StringBuilder();
			if (isOk) {
				items.sort(new Comparator<A>() {
					@Override
					public int compare(A o1, A o2) {
						return o1.idx - o2.idx;
					}
				});
				items.forEach(a -> sb.append(a.c));
			}
			System.out.printf("Case #%d: %s\n", tc++, !isOk ? "IMPOSSIBLE" : sb.toString());
		}
	}
}