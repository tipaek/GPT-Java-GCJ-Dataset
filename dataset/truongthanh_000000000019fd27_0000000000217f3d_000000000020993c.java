import java.util.*;
import java.io.*;
public class Solution {
	static boolean isDebug = false;

	static int maxDiff = Integer.MAX_VALUE - 1;
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int[][] arr = new int[n][n];
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					arr[j][k] = in.nextInt();
				}
			}
			int[] res = compute(n, arr);
			System.out.println("Case #" + i + ": " + res[0] + " " + res[1] + " " + res[2]);
		}
	}

	public static int[] compute(int n, int[][] arr) {
		int[] res = new int[3];
		for (int i = 0; i < n; i++) {
			res[0] += arr[i][i];
		}
		for (int i = 0; i < n; i++) {
			boolean[] check = new boolean[n];
			for (int j = 0; j < n; j++) {
				check[arr[i][j] - 1] = true;
			}
			for (int j = 0; j < n; j++) {
				if (!check[j]) {
					res[1]++;
					break;
				}
			}
			check = new boolean[n];
			for (int j = 0; j < n; j++) {
				check[arr[j][i] - 1] = true;
			}
			for (int j = 0; j < n; j++) {
				if (!check[j]) {
					res[2]++;
					break;
				}
			}
		}
		return res;
	}
}
// class Coord {
// 	int r, c;
// 	int val = 9;
// 	boolean isBorder;
// 	boolean hit = false;
// 	Coord(int row, int col) {
// 		r = row;
// 		c = col;
// 	}
// 	Coord(int row, int col, boolean isBorder) {
// 		r = row;
// 		c = col;
// 		this.isBorder = isBorder;
// 		val = 0;
// 	}
// }