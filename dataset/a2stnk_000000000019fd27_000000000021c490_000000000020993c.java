import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			System.out.printf("Case #%d: ", i+1);
			solve(sc);
		}
		
		sc.close();
	}

	static void solve(Scanner sc) {
		int N = sc.nextInt();
		boolean[][] rows = new boolean[N][N];
		boolean[][] columns = new boolean[N][N];
		int vestigium = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int M = sc.nextInt();
				if(i==j)
					vestigium += M;
				rows[i][M-1] = true;
				columns[j][M-1] = true;
			}
		}
		int r = 0;
		for(int i=0; i<N; i++) {
			boolean ok = true;
			for(int j=0; j<N; j++) {
				if(!rows[i][j]) {
					ok = false;
					break;
				}
			}
			if(!ok)
				r++;
		}
		int c = 0;
		for(int i=0; i<N; i++) {
			boolean ok = true;
			for(int j=0; j<N; j++) {
				if(!columns[i][j]) {
					ok = false;
					break;
				}
			}
			if(!ok)
				c++;
		}
		System.out.println(vestigium + " " + r + " " + c);
	}
}
