import java.io.*;
import java.util.*;

//Solution
public class Solution {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int test = 1; test <= t; test++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int[][] arr = new int[r][c];
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			boolean ongoing = true;
			int[] dx = {1, -1, 0, 0};
			int[] dy = {0, 0, 1, -1};
			int totalint = 0;
			while (ongoing) {
				int roundint = 0;
				boolean change = false;
				int[][] update = new int[r][c];
				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						update[i][j] = arr[i][j];
						if (arr[i][j] == -1) continue;
						roundint += arr[i][j];
						int neighcount = 0;
						int sum = 0;
						for (int neigh = 0; neigh < dx.length; neigh++) {
							int x = i + dx[neigh];
							int y = j + dy[neigh];
							while (x >= 0 && y >= 0 && x < r && y < c && arr[x][y] == -1) {
								x += dx[neigh];
								y += dy[neigh];
							}
							if (x < 0 || y < 0 || x >= r || y >= c || arr[x][y] == -1) continue;
							neighcount++;
							sum += arr[x][y];
						}
						if (neighcount == 0) {
							continue;
						}
						double avg = ((double) sum) / neighcount;
						if (arr[i][j] < avg) {
//							if (arr[i][j] == 2)
//								System.out.println("sad");
//							System.out.println(i + " " + j);
							update[i][j] = -1;
							change = true;
						}
					}
				}
				arr = update;
//				if (roundint == 5)
//				System.out.println(roundint);
				totalint += roundint;
				if (!change) {
					System.out.println("Case #" + test + ": " + totalint);
					break;
				}
			}
		}
	}

}
