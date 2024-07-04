import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {

			int N = sc.nextInt();

			int[] start = new int[N];
			int[] end = new int[N];
			TreeMap<Integer, Integer> times = new TreeMap<>();
			TreeMap<Integer, Character> ppr = new TreeMap<>();
			for (int i = 0; i < N; i++) {
				start[i] = sc.nextInt();
				end[i] = sc.nextInt();
				times.put(end[i], start[i]);
			}

			int camEnd = 0, jaimeEnd = 0;
			int count = 0;

			for (int e : times.keySet()) {
				if (times.get(e) >= jaimeEnd) {
					ppr.put(e, 'J');
					jaimeEnd = e;
				} else if (times.get(e) >= camEnd) {
					ppr.put(e, 'C');
					camEnd = e;
				} else {
					count = 1;
					break;
				}
			}

			char[] op = new char[N];

			if (count == 1) {
				System.out.println("Case #" + (tc + 1) + ": IMPOSSIBLE");
			} else {
				for (int e : times.keySet()) {
					for (int i = 0; i < end.length; i++) {
						if (end[i] == e) {
							op[i] = ppr.get(e);
						}
					}
				}

				System.out.println("Case #" + (tc + 1) + ": " + String.valueOf(op));
			}

		}

		sc.close();

	}

}