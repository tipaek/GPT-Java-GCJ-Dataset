import java.util.Scanner;

public class Solution {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int N, k, r, c;
		int[][] matrix;
		boolean[] dup;
		
		for (int t = 1; t <= T; t++) {
			N = k = r = c = 0;
			
			N = sc.nextInt();
			matrix = new int[N][N];
			
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < N; m++) {
					matrix[n][m] = sc.nextInt();
				}
			}

			for (int n = 0; n < N; n++) {
				k += matrix[n][n];
			}

			for (int n = 0; n < N; n++) {
				dup = new boolean[N + 1];

				for (int m = 0; m < N; m++) {
					if (dup[matrix[n][m]]) {
						r++;
						break;
					} else {
						dup[matrix[n][m]] = true;
					}
				}
			}
			
			for (int n = 0; n < N; n++) {
				dup = new boolean[N + 1];

				for (int m = 0; m < N; m++) {
					if (dup[matrix[m][n]]) {
						c++;
						break;
					} else {
						dup[matrix[m][n]] = true;
					}
				}
			}
			
			System.out.println(String.format("Case #%d: %d %d %d ", t, k, r, c));
		}
				
	}

}
