import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		int tc = 1;
		while (tc <= t) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			calculate(n, k,tc);
			tc++;
		}

	}

	private static void calculate(int n, int k, int tc) {
		int[][] mat = new int[n][n];
		int start = 0;
		int sum = 0;
		boolean check = false;
		for (int i = 1; i <= n; i++) {
			if (n * i == k) {
				start = i;
				check = true;
				break;
			}
		}
        int fill=start;
		if (check) {
			for (int i = 0; i < n; i++) {
				
				for (int j = 0; j < n; j++) {
					if (fill > 3) {
						fill=fill%3;
					}
					mat[i][j] = fill;
					fill ++;

				}
				fill--;
			}
			System.out.println("Case #" + tc + ":" + " " + "POSSIBLE");
			printMat(mat,n);

		} else {
			System.out.println("Case #" + tc + ":" + " " + "IMPOSSIBLE");
		}
	}

	private static void printMat(int[][] mat, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(mat[i][j]+" ");

			}
			System.out.println();
		}
		
	}

}
