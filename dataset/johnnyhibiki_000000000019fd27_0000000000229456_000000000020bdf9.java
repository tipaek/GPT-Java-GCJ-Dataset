import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

	String fnc(int n, int[][] map) {
		Arrays.sort(map, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		boolean[] check = new boolean[n];
		int[] tt = new int[2];

		for (int[] m : map) {
			if (m[0] >= tt[0]) {
				tt[0] = m[1];
				check[m[2]] = true;
			} else if (m[0] >= tt[1]) {
				tt[1] = m[1];
			} else {
				return "IMPOSSIBLE";
			}
		}

		StringBuilder sb = new StringBuilder();
		for (boolean f : check) {
			sb.append(f ? "C" : "J");
		}

		return sb.toString();
	}

	void run() {
		try (Scanner sc = new Scanner(System.in)) {
			int testNum = sc.nextInt();
			for (int t = 1; t <= testNum; t++) {
				int n = sc.nextInt();
				int[][] map = new int[n][3];
				for (int i = 0; i < n; i++) {
					map[i][0] = sc.nextInt();
					map[i][1] = sc.nextInt();
					map[i][2] = i;
				}
				System.out.println("Case #" + t + ": " + fnc(n, map));
			}
		}
	}

	public static void main(String[] args) {
		new Solution().run();
	}
}
