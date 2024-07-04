

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Solution {

	private void checkTrace(int n, int trace, int caseNo) {


		int traceSum = 0;
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++)
			arr[0][i] = i + 1;

		for (int cur = 0; cur < n; cur++) {
			int swap = arr[0][cur];
			arr[0][cur] = arr[0][0];
			arr[0][0] = swap;

			for (int i = 1; i < n; i++) {
				int temp = arr[i-1][0];
				for (int j = 1; j < n; j++) {
					arr[i][j - 1] = arr[i - 1][j];
				}
				arr[i][n - 1] = temp;
			}
			for (int i = 0; i < n; i++)
				traceSum = traceSum + arr[i][i];
			if (traceSum == trace) {
				System.out.println("Case #" + caseNo + ": " + "POSSIBLE");
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						System.out.print(arr[i][j] + " ");
					}
					System.out.print("\n");
				}
				return;
			}
		}
		
			for (int i = 0; i < n; i++)
			arr[i][0] = i + 1;

		for (int cur = 0; cur < n; cur++) {
			int swap = arr[cur][0];
			arr[cur][0] = arr[0][0];
			arr[0][0] = swap;

			for (int i = 1; i < n; i++) {
				int temp = arr[0][i-1];
				for (int j = 1; j < n; j++) {
					arr[j-1][i] = arr[j][i-1];
				}
				arr[n-1][i] = temp;
			}
			for (int i = 0; i < n; i++)
				traceSum = traceSum + arr[i][i];
			if (traceSum == trace) {
				System.out.println("Case #" + caseNo + ": " + "POSSIBLE");
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						System.out.print(arr[i][j] + " ");
					}
					System.out.print("\n");
				}
				return;
			}
		}
		System.out.println("Case #" + caseNo + ": " + "IMPOSSIBLE");
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(
				System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int tr = in.nextInt();

			obj.checkTrace(n, tr, i);
		}
	}

}
