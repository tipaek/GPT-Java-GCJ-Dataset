import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			Integer[] start = new Integer[n];
			Integer[] end = new Integer[n];
			for (int j = 0; j < n; j++) {
				start[j] = sc.nextInt();
				end[j] = sc.nextInt();
			}
			solve(i + 1, n, start, end);
		}
	}

	private static void solve(int i, int n, Integer[] start, Integer[] end) {

		Integer[] indicesSorted = new Integer[n];
		for (int j = 0; j < n; j++) {
			indicesSorted[j] = j;
		}
		Arrays.sort(indicesSorted, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return Math.min(1, Math.max(-1, start[o1] - start[o2]));
			}

		});

		String[] erg = new String[n];

		int jEnd = 0;

		boolean finished = false;
		while (!finished) {
			int currentIndex = 0;

			while (currentIndex < n
					&& (indicesSorted[currentIndex] == -1 || jEnd > start[indicesSorted[currentIndex]])) {
				// skip
				currentIndex++;
			}
			if (currentIndex == n) {
				// j finished
				finished = true;
			} else {
				// found next activity for j
				erg[indicesSorted[currentIndex]] = "J";
				jEnd = end[indicesSorted[currentIndex]];
				indicesSorted[currentIndex] = -1; // ?
			}
		}
		// Fill with C
		finished = false;
		int cEnd = 0;
		while (!finished) {
			int currentIndex = 0;

			while (currentIndex < n
					&& (indicesSorted[currentIndex] == -1 || cEnd > start[indicesSorted[currentIndex]])) {
				// skip
				currentIndex++;
			}
			if (currentIndex == n) {
				// j finished
				finished = true;
			} else {
				// found next activity for j
				erg[indicesSorted[currentIndex]] = "C";
				cEnd = end[indicesSorted[currentIndex]];
				indicesSorted[currentIndex] = -1; // ?
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < n; j++) {
			if( indicesSorted[j] != -1){
				System.out.println(("Case #" + i + ": IMPOSSIBLE"));
				return;
			}
			sb.append(erg[j]);
		}
		System.out.println("Case #" + i + ": " + sb.toString());
	}


}
