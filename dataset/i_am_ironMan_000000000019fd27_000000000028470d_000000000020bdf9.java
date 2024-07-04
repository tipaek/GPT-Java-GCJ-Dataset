import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {

			int N = sc.nextInt();

			int[] start = new int[N];
			int[] end = new int[N];
			int[] end2 = new int[N];

			for (int i = 0; i < N; i++) {
				start[i] = sc.nextInt();
				end[i] = sc.nextInt();
				end2[i] = end[i];
			}
			int[] sortedStart = new int[N];
			int[] sortedEnd = new int[N];

			Map<Integer, Integer> lookup = new HashMap<>();

			Arrays.sort(end2);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (end2[i] == end[j]) {

						sortedStart[i] = start[j];
						sortedEnd[i] = end[j];
						lookup.put(i, j);
						if (((i + 1) < N) && end2[i] == end2[i + 1]) {
							end[j] = 0;
						}
						break;
					}
				}
			}
			// lookup.forEach((k,v)-> System.out.println(k+" "+v));
			int camEnd = 0, jaimeEnd = 0;
			int count = 0;
			char[] op = new char[N];
			for (int i = 0; i < sortedEnd.length; i++) {
				if (sortedStart[i] >= jaimeEnd) {
					op[lookup.get(i)] = 'J';
					jaimeEnd = sortedEnd[i];
				} else if (sortedStart[i] >= camEnd) {
					op[lookup.get(i)] = 'C';
					camEnd = sortedEnd[i];
				} else {
					count = 1;
					break;
				}
			}

			if (tc != T - 1) {
				if (count == 1) {
					System.out.println("Case #" + (tc + 1) + ": IMPOSSIBLE");
				} else {
					System.out.println("Case #" + (tc + 1) + ": " + String.valueOf(op));
				}
			} else {
				if (count == 1) {
					System.out.print("Case #" + (tc + 1) + ": IMPOSSIBLE");
				} else {
					System.out.print("Case #" + (tc + 1) + ": " + String.valueOf(op));
				}
			}

		}

		sc.close();

	}

}