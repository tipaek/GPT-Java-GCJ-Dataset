import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int cases = 1; cases <= t; cases++) {
			int n = sc.nextInt();
			int k = 0, r = 0, c = 0;
			int[][] input = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					input[i][j] = sc.nextInt();
					if (i == j) {
						k += input[i][j];
					}
				}
			}
			for (int i = 0; i < n; i++) {
				boolean[] outputR = new boolean[n + 1];
				boolean[] outputC = new boolean[n + 1];
				for (int j = 0; j < n; j++) {

					if (!outputR[0] && !outputR[input[i][j]]) {
						outputR[input[i][j]] = true;
					} else if (!outputR[0]) {
						r++;
						outputR[0] = true;
					}

					if (!outputC[0] && !outputC[input[j][i]]) {
						outputC[input[j][i]] = true;
					} else if (!outputC[0]) {
						c++;
						outputC[0] = true;
					}
				}
			}
			System.out.println("Case #" + cases + ": " + k + " " + r + " " + c);
		}
		sc.close();
	}

}