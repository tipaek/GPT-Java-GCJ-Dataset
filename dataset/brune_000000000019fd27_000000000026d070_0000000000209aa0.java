

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String ns = in.readLine();
		int n = Integer.parseInt(ns);
		for (int i = 0; i < n; i++) {
			String ss = in.readLine();
			String[] s = ss.split(" ");
			int size = Integer.parseInt(s[0]);
			int trace = Integer.parseInt(s[1]);
			map = new int[size][size];
			if (solve(map, 0, trace, 0, 0)) {
				System.out.println("Case #" + (i + 1) + ": POSSIBLE");
				for(int j = 0; j < map.length; j++) {
					for(int k = 0; k < map[0].length; k++) {
						System.out.print(map[j][k] + " ");
					}
					System.out.println();
				}
			} else {
				System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
			}

		}
	}

	public static boolean solve(int[][] map, int sum, int trace, int y, int x) {
		if (y == map.length && x == 0 && sum == trace) {
			return true;
		}
		if (y == map.length) {
			return false;
		}
		int current = sum;
		for (int i = 1; i < map.length+1; i++) {
			if (valid(map, y, x, i)) {
				if (x == y && (current + i) > trace) {
					continue;
				} else if (x == y) {
					current += i;
				}
				map[y][x] = i;
				if (x < map[0].length - 1) {
					if (solve(map, current, trace, y, x + 1)) {
						return true;
					}
				} else {
					if (solve(map, current, trace, y + 1, 0)) {
						return true;
					}
				}
				current = sum;
			}
		}
		map[y][x] = 0;
		return false;
	}

	public static boolean valid(int[][] map, int y, int x, int num) {
		for (int i = 0; i < map.length; i++) { // row
			if (map[y][i] == num) {
				return false;
			}
		}
		for (int i = 0; i < map[0].length; i++) { // column
			if (map[i][x] == num) {
				return false;
			}
		}
		return true;
	}
}
