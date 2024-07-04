
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {

			solveMe(sc, i);

		}

	}

	private static void solveMe(Scanner sc, int i) {
		Map<int[], Integer> map = new HashMap<>();
		int n = sc.nextInt();
		int[][] start = new int[n][2];
		for (int j = 0; j < n; j++) {
			start[j][0] = sc.nextInt();
			start[j][1] = sc.nextInt();
			map.put(start[j], j);
		}

		Arrays.sort(start, new Comparator<int[]>() {

			public int compare(int[] x, int[] y) {
				return x[0] - y[0];
			};
		});

		Stack<int[]> first = new Stack<int[]>();

		Stack<int[]> second = new Stack<int[]>();
		char[] ans = new char[n];
		boolean flag = false;
		char possiblity = 'J';

		flag = runMe(map, start, first, second, ans, flag, possiblity);
		System.out.print("Case #");
		System.out.print((i + 1) + ": ");
		System.out.print(flag ? "IMPOSSIBLE" : new String(ans));
		System.out.println();
	}

	private static boolean runMe(Map<int[], Integer> map, int[][] start, Stack<int[]> first, Stack<int[]> second,
			char[] ans, boolean flag, char possiblity) {
		for (int j = 0; j < start.length; j++) {
			ans[map.get(start[j])] = possiblity;

			if (j < start.length - 1 && isCollide(start[j], start[j + 1])) {
				if (possiblity == 'J') {
					first.push(start[j]);
					possiblity = submit(possiblity);
					if (!second.isEmpty() && isCollide(second.peek(), start[j + 1])) {
						flag = true;
						break;
					}
				} else {
					second.push(start[j]);
					possiblity = submit(possiblity);
					if (!first.isEmpty() && isCollide(first.peek(), start[j + 1])) {
						flag = true;
						break;
					}
				}
			} else {
				pushInStack(start, first, second, possiblity, j);
			}
		}
		return flag;
	}

	private static void pushInStack(int[][] start, Stack<int[]> first, Stack<int[]> second, char possiblity, int j) {
		if (possiblity == 'J') {
			first.push(start[j]);
		} else {
			second.push(start[j]);
		}
	}

	private static boolean isCollide(int[] is, int[] is2) {
		return is[1] > is2[0];

	}

	private static char submit(char person) {
		return person == 'J' ? 'C' : 'J';

	}
}