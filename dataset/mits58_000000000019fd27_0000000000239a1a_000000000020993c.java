import java.util.Scanner;

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();	// # of testcases
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[][] M = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					M[i][j] = sc.nextInt();
				}
			}

			// calc trace
			int k = 0;
			for(int i = 0; i < N; i++) k += M[i][i];

			// calc the number of rows of the matrix that contain repeated elements
			int r = 0;
			for(int i = 0; i < N; i++) {
				int[] counter = new int[N];
				for(int j = 0; j < N; j++) counter[M[i][j] - 1]++;
				boolean is_rep = false;
				for(int j = 0; j < N; j++) if(counter[j] > 1) is_rep = true;
				if(is_rep) r++;
			}

			// calc the number of columns of the matrix that contain repeated element
			int c = 0;
			for(int i = 0; i < N; i++) {
				int[] counter = new int[N];
				for(int j = 0; j < N; j++) counter[M[j][i] - 1]++;
				boolean is_rep = false;
				for(int j = 0; j < N; j++) if(counter[j] > 1) is_rep = true;
				if(is_rep) c++;
			}
			System.out.println("Case #" + t + ": " + k + " " + r + " " + c);
		}
	}
}
