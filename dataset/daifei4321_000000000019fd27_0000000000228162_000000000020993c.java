import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 0; t < T; t++) {
			int N = in.nextInt();
			int[][] grid = new int[N][N];
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					grid[y][x] = in.nextInt();
				}
			}
			int k = 0; {
				for (int i = 0; i < N; i++) {
					k += grid[i][i];
				}
			}
			int[] buffer = new int[N + 1];
			int r, c;
			{
				int count = 0;
				for (int y = 0; y < N; y++) {
					Arrays.fill(buffer, 0);
					for (int x = 0; x < N; x++) {
						if (++buffer[grid[y][x]] > 1) {
							count++;
							break;
						}
					}
				}
				r = count;
			}
			{
				int count = 0;
				for (int x = 0; x < N; x++) {
					Arrays.fill(buffer, 0);
					for (int y = 0; y < N; y++) {
						if (++buffer[grid[y][x]] > 1) {
							count++;
							break;
						}
					}
				}
				c = count;
			}
			System.out.println("CASE #" + (t + 1) + ": " + k + " " + r + " " + c);
		}
	}
}
