import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();
		for( int x = 0; x < T; x++ ) {
			int n = input.nextInt();
			
			int k = 0;
			int r = 0;
			int c = 0;
			
			int[][] M = new int[n][n];
			
			for( int i = 0; i < n; i++ ) {
				for( int j = 0; j < n; j++ ) {
					int m = input.nextInt();
					
					if( i == j ) {
						k += m;
					}
					
					M[i][j] = m;
				}
			}
			
			for( int i = 0; i < n; i++ ) {
				if( checkLine( M[i] ) ) {
					r += 1;
				}
			}
			
			for( int i = 0; i < n; i++ ) {
				if( checkColumn( M, i ) ) {
					c += 1;
				}
			}
			
			

			System.out.println("Case #" + ( x + 1 ) + ": " + k + " " + r + " " + c);
		}
		
		input.close();
	}

	private static boolean checkLine(int l[]) {
		for( int i = 0; i < l.length; i++ ) {
			for( int j = i + 1; j < l.length; j++ ) {
				if( l[i] == l[j] ) {
					return true;
				}
			}
		}
		
		return false;
	}

	private static boolean checkColumn(int M[][], int column) {
		for( int i = 0; i < M.length; i++ ) {
			for( int j = i + 1; j < M.length; j++ ) {
				if( M[i][column] == M[j][column] ) {
					return true;
				}
			}
		}
		
		return false;
	}

}
