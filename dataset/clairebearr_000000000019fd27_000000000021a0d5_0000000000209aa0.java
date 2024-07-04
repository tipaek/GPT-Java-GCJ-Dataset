import java.io.*;
import java.util.*;

//solution
public class Solution {
	
	static int[][] grid;
	static HashSet<Integer>[] column;
	static HashSet<Integer>[] row;
	static int n;
	static boolean done = false;
	static int k;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int test = 1; test <= t; test++) {
			n = sc.nextInt();
			k = sc.nextInt();
			grid = new int[n][n];
			done = false;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					grid[i][j] = -1;
				}
			}
			column = new HashSet[n];
			row = new HashSet[n];
			for (int i = 0; i < n; i++) {
//				HashSet<Integer> add = new HashSet<>();
//				HashSet<Integer> add2 = new HashSet<>();;
				column[i] = new HashSet<>();;
				row[i] = new HashSet<>();;
			}
			dfs(0, 0);
			if (done) {
				System.out.println("Case #" + test + ": POSSIBLE");
				for (int i = 0; i < n; i++) {
					String str = "";
					for (int j = 0; j < n; j++) {
						str += grid[i][j] + " ";
					}
					System.out.println(str.substring(0, str.length()-1));
				}
			} else {
				System.out.println("Case #" + test + ": IMPOSSIBLE");
			}
		}
	}
	
	static void dfs(int i, int j) {
		if (done) return;
		if (j == n) {
			i++;
			j = 0;
			if (i == n) {
				int sum = 0;
//				for (int ii = 0; ii < n; ii++) {
//					String str = "";
//					for (int jj = 0; jj < n; jj++) {
//						str += grid[ii][jj] + " ";
//					}
//					System.out.println(str.substring(0, str.length()-1));
//				}
				for (int x = 0; x < n; x++) {
					sum += grid[x][x];
				}
				if (sum == k) {
					done = true;
					return;
				}
				return;
			}
//			return;
		}
//		if (i == 1 && j == 1)
//			System.out.println();
		if (grid[i][j] != -1) return;
		for (int num = 1; num <= n; num++) {
			if (!column[j].contains(num) && !row[i].contains(num)) {
				grid[i][j] = num;
				row[i].add(num);
				column[j].add(num);
				dfs(i, j+1);
				if (done) return;
				row[i].remove(num);
				column[j].remove(num);
				grid[i][j] = -1;
			}
		}
	}

}
