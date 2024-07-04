import java.util.Scanner;

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt(), K = sc.nextInt();
			if(K % N != 0) {
				System.out.println("Case #" + t + ": IMPOSSIBLE");
			} else {
				int[][] sq = new int[N][N];
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++) {
						sq[i][j] = (K / N + j - i + N) % N;
						if(sq[i][j] == 0) sq[i][j] = N;
					}
				}
				System.out.println("Case #" + t + ": POSSIBLE");
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N - 1; j++) {
						System.out.print(sq[i][j] + " ");
					}
					System.out.println(sq[i][N - 1]);
				}
			}
		}
	}
}