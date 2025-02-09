
import java.util.Scanner;

public class Vestigium {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		
		int cases = in.nextInt();
		for ( int i = 1; i <= cases; i++ ) {
			processCase(i, in);
		}
	}
	
	static void processCase(int caseNo, Scanner in) throws Exception {
		int N = in.nextInt();
		
		System.err.printf("Case %s: ", caseNo);
		int[][] matrix = new int[N][];
		for ( int i = 0; i < N; i++ ) {
			matrix[i] = new int[N];
			for ( int j = 0; j < N; j++ )
				matrix[i][j] = in.nextInt();
		}

		int trace = 0;
		for ( int i = 0; i < N; i++ )
			trace += matrix[i][i];

		boolean[] flags = new boolean[N];

		int dupRows = 0;
		for ( int i = 0; i < N; i++ ) {
			for ( int j = 0; j < N; j++ )
				flags[j] = false;
			for ( int j = 0; j < N; j++ ) {
				if ( flags[matrix[i][j]] ) {
					dupRows++;
					break;
				}
				flags[matrix[i][j]] = true;
			}
		}

		int dupCols = 0;
		for ( int i = 0; i < N; i++ ) {
			for ( int j = 0; j < N; j++ )
				flags[j] = false;
			for ( int j = 0; j < N; j++ ) {
				if ( flags[matrix[j][i]] ) {
					dupRows++;
					break;
				}
				flags[matrix[j][i]] = true;
			}
		}
	}
}
