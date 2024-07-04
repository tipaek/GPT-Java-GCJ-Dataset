import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {
			int N = in.nextInt();
			int [][] M = new int[N][N];
			for (int i=0; i<N; i++)
				for (int j=0; j<N; j++)
					M[i][j] = in.nextInt();
			int k = 0;
			int r = 0;
			int c = 0;
			boolean [] check = new boolean[N];
			for (int i=0; i<N; i++) {
				k += M[i][i];
				Arrays.fill(check, false);
				for (int j=0; j<N; j++) {
					if (check[M[i][j]]) {
						r++;
						break;
					}
					check[M[i][j]] = true;
				}
				Arrays.fill(check, false);
				for (int j=0; j<N; j++) {
					if (check[M[j][i]]) {
						c++;
						break;
					}
					check[M[j][i]] = true;
				}
			}
			System.out.println("Case #"+(t+1)+": "+k+" "+r+" "+c);
		}
		in.close();
	}
}
