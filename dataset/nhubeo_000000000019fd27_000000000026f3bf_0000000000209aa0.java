
import java.util.Scanner;

public class Solution {
	public static int[][] compute(int n, int k){
		if (k%n != 0) {
			return new int[0][0];
		}
		
		int[][] mat = new int[n][n];
		int t = k;
		for (int i=0; i<n; i++) {
			mat[i][i] = Math.min(t -(n-1-i), n);
			//System.out.println(mat[i][i]);
			t = t - mat[i][i];
		}
		
		for (int i=0; i<n; i++) {
			for (int j=1; j<n; j++) {
				int c = (j+i)%n;
				mat[i][c] = (mat[i][i] + j)%n;
				if (mat[i][c] == 0) {
					mat[i][c] = n;
				}
			}
		}
		return mat;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		
		for (int i=0; i<testCase; i++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[][] result = compute(n, k);
			
			if (result.length == 0) {
				System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
			} else {
				System.out.println("Case #" + (i+1) + ": POSSIBLE");
				for (int x=0; x<n; x++) {
					for (int j=0; j < n; j++) {
						System.out.print(result[x][j]);
						if (j<n-1) {
							System.out.print(" ");
						}
					}
					System.out.println();
				}
			}
		}
	}
}
