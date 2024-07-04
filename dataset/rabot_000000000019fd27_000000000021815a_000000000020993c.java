import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner((Readable) new BufferedReader(
				new InputStreamReader(System.in)));
		int T = sc.nextInt();
		for ( int t = 1 ; t <= T ; t++ ) {
			int N = sc.nextInt();
			int[][] M = new int[N][N];
			int[] check = new int[N + 1];
			int k = 0;
			int r = 0;
			int c = 0;
			for ( int i = 0 ; i < N ; i++ ) {
				boolean repeated = false;
				Arrays.fill(check, 0);
				for ( int j = 0 ; j < N ; j++ ) {
					M[i][j] = sc.nextInt();
					if ( i == j ) {
						k += M[i][j];
					}
					check[M[i][j]]++;
					if ( check[M[i][j]] >= 2 ) {
						repeated = true;
					}
				}
				if ( repeated ) {
					r++;
				}
			}
			for ( int j = 0 ; j < N ; j++ ) {
				boolean repeated = false;
				Arrays.fill(check, 0);
				for ( int i = 0 ; i < N ; i++ ) {
					check[M[i][j]]++;
					if ( check[M[i][j]] >= 2 ) {
						repeated = true;
					}
				}
				if ( repeated ) {
					c++;
				}
			}

			System.out.println("Case #" + t + ": " + k + " " + r + " " + c);
		}
		sc.close();
	}
}
