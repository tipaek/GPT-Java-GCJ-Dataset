import java.util.*;

public class Solution{

	public static void main(String[] args){

		Scanner stdin = new Scanner(System.in);
		int numCases = stdin.nextInt();

		for (int loop=1; loop<=numCases; loop++){

			int[] who = new int[1440];

			int[] num = new int[2];
			for (int i=0; i<2; i++) num[i] = stdin.nextInt();
			
			for (int person=1; person<=2; person++){
				for (int i=0; i<num[person-1]; i++){
					int s = stdin.nextInt();
					int e = stdin.nextInt();
					for (int j=s; j<e; j++) who[j] = person;
				}
			}

			int[][][] dp = new int[721][721][2];
			for (int i=0; i<=720; i++)
				for (int j=0; j<=720; j++)
					Arrays.fill(dp[i][j], 10000);

			if (who[0] == 1 || who[0] == 0) dp[1][0][0] = 0;
			if (who[0] == 2 || who[0] == 0) dp[0][1][1] = 0;

			
			for (int i=0; i<=720; i++){
				for (int j=0; j<=720; j++){
					if (i+j < 2) continue;

					if ((who[i+j-1] == 1 || who[i+j-1] == 0) && i > 0) dp[i][j][0] = min(dp[i][j][0], dp[i-1][j][0], dp[i-1][j][1] + 1);
					if ((who[i+j-1] == 2 || who[i+j-1] == 0) && j > 0) dp[i][j][1] = min(dp[i][j][1], dp[i][j-1][1], dp[i][j-1][0] + 1);

				}
			}
			
			int res = 0;
			if (who[1439] == 0) res = Math.min(dp[720][720][0], dp[720][720][1]);
			else if (who[1439] == 1) res = dp[720][720][0];
			else res = dp[720][720][1];

			if (res%2 == 1) res ++;

			System.out.println("Case #"+loop+": "+res);
		}
	}

	public static int min(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}
}