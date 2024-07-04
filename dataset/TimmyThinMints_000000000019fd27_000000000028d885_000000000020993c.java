import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int r = 1; r <= t; r++) {
			int n = in.nextInt();
			int a[][] = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					a[j][i] = in.nextInt()-1;
				}
			}
			int sum = 0;
			int colS = 0;
			int rowS = 0;
			for (int i = 0; i < n; i++) {
				sum += a[i][i]+1;
			}

			for (int i = 0; i < n; i++) {
				boolean colA[] = new boolean[n];
				boolean hit=false;
				for (int j = 0; j < n; j++) {
					if (colA[a[i][j]]) {
						hit=true;
					}
					colA[a[i][j]] = true;
				}
				if(hit) {
					colS++;
				}
			}
			for (int i = 0; i < n; i++) {
				boolean rowA[] = new boolean[n];
				boolean hit=false;
				for (int j = 0; j < n; j++) {
					if (rowA[a[j][i]]) {
						hit=true;
					}
					rowA[a[j][i]] = true;
				}
				if(hit) {
					rowS++;
				}
			}
			System.out.println("Case #" + t + ": " + sum + " " + rowS + " " + colS);
		}
	}
}
