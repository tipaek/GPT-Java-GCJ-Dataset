import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	static int N;
	static boolean isPossible;
	static boolean[][] row, col;
	static int[][] mat;
	static int[][] ans;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			
			isPossible = false;

			N = sc.nextInt();
			int K = sc.nextInt();
			
			row = new boolean[N+1][N+1];
			col = new boolean[N+1][N+1];
			
			mat = new int[N+1][N+1];
			ans = new int[N+1][N+1];

			fillDiagonal(1, K);
			
			System.out.print("Case #" + tc + ": ");
			if(isPossible) {
				
				System.out.println("POSSIBLE");
				showMat();
			} 
			else {
				System.out.println("IMPOSSIBLE");
			}
		}

	}
	
	public static void fillMat(int pos) {
		if(isPossible) return;
		//terminal condition
		if(pos > N*N) {
			
			for(int i = 1; i<= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(!row[i][j] || !col[i][j]) return;
					ans[i][j] = mat[i][j];
				}
			}
			isPossible = true;
			return;
		}
		
		int r = (pos-1)/N + 1;
		int c = pos%N == 0 ? N : pos%N;
		
		
		// find that mat[r][c] is 0;
		if(mat[r][c] != 0) 
			fillMat(pos+1);
		else {
			for(int value = 1; value<= N && !isPossible; value++) {
					
				if(row[r][value] || col[c][value]) continue;
				row[r][value] = true;
				col[c][value] = true;
				mat[r][c] = value;

				fillMat(pos+1);
				mat[r][c] = 0;
				row[r][value] = false;
				col[c][value] = false;
			}
		}
		
	}
	
	public static void fillDiagonal(int dia, int k) {
		if(isPossible) return;
		
		// terminal condition
		if(dia > N) {
			
			// fillMat
			if(k == 0) {
				
				// showMat();
				int pos = 1;
				fillMat(pos);
			}
			return;
		}
		
		for(int i = 1; i <=N && !isPossible; i++) {
			
			if(row[dia][i] || col[dia][i]) continue;
			if(k - i < 0) continue;
			
			row[dia][i] = true;
			col[dia][i] = true;
			mat[dia][dia] = i;
			fillDiagonal(dia+1, k-i);
			mat[dia][dia] = 0;
			row[dia][i] = false;
			col[dia][i] = false;
		}
	}
	
	public static void showMat() {

		for(int i = 1; i <= N; i++) {
			for(int j =1; j <=N; j++) {
				
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}
}






















