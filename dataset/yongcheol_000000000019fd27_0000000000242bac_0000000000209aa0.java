import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			
			boolean isPossible = false;
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			boolean[][] row = new boolean[N+1][N+1];
			boolean[][] col = new boolean[N+1][N+1];
			
			int[][] mat = new int[N+1][N+1];
			// case 1 : each value in diagonal is different.
			
			int sum = N*(N+1)/2;

			if(sum == K) {
				
				// fill diagonal
				for(int i = 1; i <=N; i++)	{
					mat[i][i] = i;
					row[i][i] = true;
					col[i][i] = true;
				}
				
				// fill rest cells.
				for(int i = 1; i <=N; i++) {
					
					int k = N;
					
					for(int j = i+1; j<=N;j++) {
					
						while(row[i][k] || col[j][k]) --k;
						if(k < 1) continue;
						mat[i][j] = k;
						row[i][k] = true;
						col[j][k] = true;
					}
					
					k = N;
					for(int j = 1; j < i; j++) {
						
						while(row[i][k] || col[j][k]) --k;
						if(k < 1) continue;
						mat[i][j] = k;
						row[i][k] = true;
						col[j][k] = true;
					}
				}
				
				isPossible = true;
			}
			
			// case 2 : values in diagonal is same.
			// if cannot find it in case 1, do case 2.
			
			if(!isPossible && (K%N == 0)) {
				int v = K/N;
				// fill diagonal
				for(int i = 1; i <=N; i++)	{
					mat[i][i] = v;
					row[i][v] = true;
					col[i][v] = true;
				}
				
				// fill rest cells.
				for(int i = 1; i <=N; i++) {
					
					int k = 1;
					
					for(int j = i+1; j<=N;j++) {
					
						while(row[i][k] || col[j][k]) ++k;
						if(k > N) continue;
						mat[i][j] = k;
						row[i][k] = true;
						col[j][k] = true;
					}
					
					k = 1;
					
					for(int j = 1; j < i; j++) {
						
						while(row[i][k] || col[j][k]) ++k;
						if(k > N) continue;
						mat[i][j] = k;
						row[i][k] = true;
						col[j][k] = true;
					}
				}
				
				isPossible = true;
			}
			
			for(int i = 1; i <= N && isPossible; i++) {
				for(int j = 1; j <= N && isPossible; j++) {
					if(row[i][j] == false) isPossible = false;
				}
				
				for(int j = 1; j <= N && isPossible; j++) {
					if(col[i][j] == false) isPossible = false;
				}
			}
				
				
			System.out.println("Case #" + tc + ": ");

			if(isPossible) {
				System.out.println("POSSIBLE");
				
				for(int i = 1; i <=N; i++) {
					for(int j = 1; j <= N; j++) {
						System.out.print(mat[i][j] + " ");
					}
					System.out.println();
				}

			} else {
				System.out.println("IMPOSSIBLE");
			}
			
		}

	}
    
}
