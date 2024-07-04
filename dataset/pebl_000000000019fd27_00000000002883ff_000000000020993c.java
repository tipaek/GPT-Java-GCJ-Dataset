import java.util.Scanner;

public class Solution {

	private static boolean check_row(int[][] matrix, int r, int N) {
		boolean[] seen = new boolean[N];
		for(int i=0; i<N; i++) {
			int m = matrix[r][i];
			if (seen[m-1])
				return false;
			seen[m-1] = true;
		}
		
		return true;
	}


	private static boolean check_col(int[][] matrix, int c, int N) {
		boolean[] seen = new boolean[N];
		for(int i=0; i<N; i++) {
			int m = matrix[i][c];
			if (seen[m-1])
				return false;
			seen[m-1] = true;
		}
		
		return true;
	}


	private static void solve(int nr, Scanner sc) {
		int N = sc.nextInt();

		int[][] matrix = new int[N][N];
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				int M = sc.nextInt();
				matrix[r][c] = M;				
			}
		}

		int bad_row = 0;
		int bad_col = 0;
		for(int i=0; i<N; i++) {
			boolean okr = check_row(matrix, i, N);
			if (!okr)
				bad_row++;
			boolean okc = check_col(matrix, i, N);
			if (!okc)
				bad_col++;
		}
		
		int K = 0;
		for(int i=0; i<N; i++) {
			K += matrix[i][i];
		}
		
		System.out.println("Case #"+nr+": "+K+" "+bad_row+" "+bad_col);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			solve(i+1,sc);
		}
	}
}
