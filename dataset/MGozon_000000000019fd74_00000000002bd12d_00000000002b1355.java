import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		for (int t = 1; t <= tc; t++) {
			int r = in.nextInt();
			int c = in.nextInt();
			int[][] grid = new int[r][c];
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					grid[i][j] = in.nextInt();
				}
			}
			long total = 0;
			while (true) {
				//System.out.println("Stuck out");
				boolean[][] lev = new boolean[r][c];
				int l = 0;
				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						if (grid[i][j] == -1) continue;
						total += grid[i][j];
						// evaluate all directions
						int index = j-1;
						int sum = 0, n = 0;
						while (index >= 0 && grid[i][index] == -1) index--;
						if (index >= 0) { sum += grid[i][index]; n++; }
						index = j+1;
						while (index < c && grid[i][index] == -1) index++;
						if (index < c) { sum += grid[i][index]; n++; }
						index = i-1;
						while (index >= 0 && grid[index][j] == -1) index--;
						if (index >= 0) { sum += grid[index][j]; n++; }
						index = i+1;
						while (index < r && grid[index][j] == -1) index++;
						if (index < r) { sum += grid[index][j]; n++; }
						if (n > 0) {
							double avg = (double) sum / n;
							if (grid[i][j] < avg) { lev[i][j] = true; l++; }
						}
					}
				}
				
				/*for (int i = 0; i < r; i++) System.out.println(Arrays.toString(grid[i]));
				System.out.println();
				for (int i = 0; i < r; i++) System.out.println(Arrays.toString(lev[i]));
				System.out.println();*/
				if (l == 0) break;
				//System.out.println(l);
				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						if (lev[i][j] == true) grid[i][j] = -1;
					}
				}
			}
			
			System.out.println("Case #" + t + ": " + total);
		}
	}
}
