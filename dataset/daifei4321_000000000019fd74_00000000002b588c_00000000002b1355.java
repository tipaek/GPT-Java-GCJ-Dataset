import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 0; t < T; t++) {
			int R = in.nextInt();
			int C = in.nextInt();
			int[][] grid = readGridInt(in, C, R);
			boolean[][] out = new boolean[R][C];
			long level = 0;
			for (;;) {
				int outCount = 0;
				for (int r = 0; r < R; r++) {
					for (int c = 0; c < C; c++) {
						int vCurr = grid[r][c];
						if (vCurr == 0) {
							continue;
						}
						int vTotal = 0;
						int vTotalCount = 0;
						{
							for (int y = r - 1; y >= 0; y--) {
								int v = grid[y][c];
								if (v > 0) {
									vTotal += v;
									vTotalCount++;
//									System.out.println("For " + r + " " + c + " U" + y);
									break;
								}
							}
						}
						{
							for (int y = r + 1; y < R; y++) {
								int v = grid[y][c];
								if (v > 0) {
									vTotal += v;
									vTotalCount++;
//									System.out.println("For " + r + " " + c + " D" + y);
									break;
								}
							}
						}
						{
							for (int x = c - 1; x >= 0; x--) {
								int v = grid[r][x];
								if (v > 0) {
									vTotal += v;
									vTotalCount++;
//									System.out.println("For " + r + " " + c + " L" + x);
									break;
								}
							}
						}
						{
							for (int x = c + 1; x < C; x++) {
								int v = grid[r][x];
								if (v > 0) {
									vTotal += v;
									vTotalCount++;
//									System.out.println("For " + r + " " + c + " R" + x);
									break;
								}
							}
						}
						if (vTotalCount > 0) {
							if (vCurr * vTotalCount < vTotal) {
								out[r][c] = true;
								outCount++;
//								System.out.println("out " + r + " " + c);
							}
						}
					}
				}
				for (int y = 0; y < R; y++) {
					for (int x = 0; x < C; x++) {
						int v = grid[y][x];
						level += v;
					}
				}
//				System.out.println("L=" + level);
				if (0 == outCount) {
					break;
				}
				for (int y = 0; y < R; y++) {
					for (int x = 0; x < C; x++) {
						if (out[y][x]) {
							grid[y][x] = 0;
						}
					}
				}
				for (int i = 0; i < R; i++) {
					Arrays.fill(out[i], false);
				}
			}
			System.out.println("CASE #" + (t + 1) + ": " + level);
		}
	}
	public static int[][] readGridInt(Scanner in, int w, int h) {
		int[][] grid = new int[h][w];
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				grid[y][x] = in.nextInt();
			}
		}
		return grid;
	}
}
