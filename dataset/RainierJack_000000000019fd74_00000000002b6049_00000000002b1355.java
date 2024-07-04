import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {

			int R = in.nextInt();
			int C = in.nextInt();

			int[][] S = new int[R][C];
			for (int i=0; i<R; i++)
				for (int j=0; j<C; j++)
					S[i][j] = in.nextInt();

			double[] rAv = new double[R];
			double[] cAv = new double[C];
			Arrays.fill(rAv, -1);
			Arrays.fill(cAv, -1);
			int interest = 0;
			int eliminated;
			do {
				eliminated = 0;
				for (int i=0; i<R; i++)
					for (int j=0; j<C; j++)
						interest += S[i][j];
				for (int i=0; i<R; i++) {
					if (rAv[i] == 0)
						continue;
					double sum = 0;
					int cpt = 0;
					for (int j=0; j<C; j++) {
						if (S[i][j] > 0) {
							sum += S[i][j];
							cpt++;
						}
					}
					if (cpt > 0)
						rAv[i] = sum/cpt;
					else
						rAv[i] = 0;
				}
				for (int i=0; i<C; i++) {
					if (cAv[i] == 0)
						continue;
					double sum = 0;
					int cpt = 0;
					for (int j=0; j<R; j++) {
						if (S[j][i] > 0) {
							sum += S[j][i];
							cpt++;
						}
					}
					if (cpt > 0)
						cAv[i] = sum/cpt;
					else
						cAv[i] = 0;
				}
				for (int i=0; i<R; i++) {
					for (int j=0; j<C; j++)
						if (S[i][j] > 0)
							if (S[i][j] < rAv[i] || S[i][j] < cAv[j]) {
								S[i][j] = 0;
								eliminated++;
							}
				}
			} while (eliminated > 0);

			System.out.println("Case #"+(t+1)+": "+interest);
		}
		in.close();
	}
}
