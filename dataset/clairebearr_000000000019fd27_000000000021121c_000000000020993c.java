import java.io.*;
import java.util.*;

//solution
public class Solution {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int test = 1; test <= t; test++) {
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int trace = 0;
			for (int i = 0; i < n; i++) {
				trace += arr[i][i];
			}
			int r = 0;
			for (int row = 0; row < n; row++) {
				boolean[] seen = new boolean[n+1];
				for (int col = 0; col < n; col++) {
					if (seen[arr[row][col]]) {
						r++;
						break;
					}
					seen[arr[row][col]] = true;
				}
			}
			int c = 0;
			for (int col = 0; col < n; col++) {
				boolean[] seen = new boolean[n+1];
				for (int row = 0; row < n; row++) {
					if (seen[arr[row][col]]) {
						c++;
						break;
					}
					seen[arr[row][col]] = true;
				}
			}
			System.out.println("Case #" + test + ": " + trace + " " + r + " " + c);
		}
		//change class name to solution
	}

}
