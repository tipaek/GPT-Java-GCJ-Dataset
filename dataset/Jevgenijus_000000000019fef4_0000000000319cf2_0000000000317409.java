import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	static Scanner reader = new Scanner(System.in);
	static int max = Integer.MAX_VALUE;
	static String res = "";

	public static void main(String[] args) {
		int T = reader.nextInt();

		int XX = 1000;
		int YY = 1000;
		int[][] dp = new int[XX + 1][YY + 1];
		for (int i = 0; i <= XX; i++) {
			for (int j = 0; j <= YY; j++) {
				dp[i][j] = i + j;
			}
		}

		for (int t = 0; t < T; t++) {
			int X = reader.nextInt();
			int Y = reader.nextInt();
			if (X == 0 && Y == 0) {
				System.out.printf("Case #%d: %s\n", t + 1, 0);
				continue;
			}
			String M = reader.next();
			int res = -1;
			for (int i = 0; i < M.length(); i++) {
				char c = M.charAt(i);
				switch (c) {
				case 'N':
					Y++;
					break;
				case 'S':
					Y--;
					break;
				case 'E':
					X++;
					break;
				case 'W':
					X--;
					break;
				}
				int Xa = Math.abs(X);
				int Ya = Math.abs(Y);
								if(Xa > 1000 || Ya > 1000) {
					break;
				}
				if (dp[Math.abs(Xa)][Ya] <= i+1) {
					res = Math.max(i+1, dp[Xa][Ya]);

					break;
				}

			}

			if (res == -1) {
				System.out.printf("Case #%d: IMPOSSIBLE\n", t + 1);

			} else
				System.out.printf("Case #%d: %s\n", t + 1, res);

		}

	}

}
