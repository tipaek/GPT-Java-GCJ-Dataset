import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = Integer.valueOf(scanner.nextLine());
		for (int i = 0; i < T; i++) {
			String line = scanner.nextLine();
			int N = Integer.valueOf(line.substring(0, 1));
			int K = Integer.valueOf(line.substring(2, 3));
		    solve(N, K, i);
		    }
	}

		
	public static void solve (int N, int K, int number) {
		if (K % N != 0) {
			System.out.println("Case #" + (number + 1) + ": IMPOSSIBLE");	
		} else {
			int[][] solution = new int[N][N];
			for (int i = 0; i < N; i++) { //fills all to 0
				for (int j = 0; j < N; j++) {
					solution[i][j] = 0;
				}
			}
			for (int i = 0; i < N; i++) { //makes trace, works
				solution[i][i] = K / N;
			}
			
			int num = 1; //fills first line in order, works
			for (int i = 0; i < N; i++) {
				if (num == K / N) {
					num++;
				}
				if (solution[0][i] == 0) {
					solution[0][i] = num;
					num++;
				} 
			}
			
			for (int i = 1; i < N; i++) { // fills board
				for (int j = 0; j < N; j++) {
					if (j == 0) {
						solution[i][j] = solution[i - 1][N - 1];
					} else {
						solution[i][j] = solution[i - 1][j - 1];
					}
				}
			}
			System.out.println("Case #" + (number + 1) + ": POSSIBLE");
			
			for (int i = 0; i < N; i++) { // prints board
				for (int j = 0; j < N; j++) {
					System.out.print(solution[i][j] + " ");
				}
				System.out.println();
			}
		}
	}	
	
}