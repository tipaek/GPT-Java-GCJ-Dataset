import java.util.*;
import java.io.*;


public class Solution {

	public static void main(String[] args) {

		Scanner stdin = new Scanner(System.in);
		int numCases = stdin.nextInt();

		// Process cases.
		for (int loop=1; loop<=numCases; loop++) {

			int[] who = new int[1440];

			int[] num = new int[2];
			for (int i=0; i<2; i++) num[i] = stdin.nextInt();

			// Fill in who is required at each minute.
			for (int person=1; person<=2; person++) {
				for (int i=0; i<num[person-1]; i++) {
					int s = stdin.nextInt();
					int e = stdin.nextInt();
					for (int j=s; j<e; j++) who[j] = person;
				}
			}

			// dp[i][j][k] is min transitions to get to person 1 = i minutes, person 2 = j minutes with person k+1 getting the last minute.
			int[][][] dp = new int[721][721][2];
			for (int i=0; i<=720; i++)
				for (int j=0; j<=720; j++)
					Arrays.fill(dp[i][j], 10000);

			// Set up first minute for DP.
			if (who[0] == 1 || who[0] == 0) dp[1][0][0] = 0;
			if (who[0] == 2 || who[0] == 0) dp[0][1][1] = 0;

			// Go through person 1's minutes.
			for (int i=0; i<=720; i++) {

				// And person 2's minutes.
				for (int j=0; j<=720; j++) {

					// These are already filled in.
					if (i+j < 2) continue;

					// Build off previous minute - allow both options if possible.
					if ((who[i+j-1] == 1 || who[i+j-1] == 0) && i > 0) dp[i][j][0] = min(dp[i][j][0], dp[i-1][j][0], dp[i-1][j][1] + 1);
					if ((who[i+j-1] == 2 || who[i+j-1] == 0) && j > 0) dp[i][j][1] = min(dp[i][j][1], dp[i][j-1][1], dp[i][j-1][0] + 1);

				}
			}

			// Look at the appropriate DP square to get the final result.
			int res = 0;
			if (who[1439] == 0) res = Math.min(dp[720][720][0], dp[720][720][1]);
			else if (who[1439] == 1) res = dp[720][720][0];
			else res = dp[720][720][1];

			// This will take care of a switch at midnight.
			if (res%2 == 1) res ++;

			System.out.println("Case #"+loop+": "+res);
		}
	}

	public static int min(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}
}