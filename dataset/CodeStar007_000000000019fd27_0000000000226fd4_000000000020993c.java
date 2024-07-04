import java.util.HashSet;
import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner S = new Scanner(System.in);
		int case_num = 1;
		int T = S.nextInt();
		while (T > 0) {
			int N = S.nextInt();
			int[][] mat = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					mat[i][j] = S.nextInt();
				}
			}
			solve(N, mat, case_num);
			T--;
			case_num++;
		}
	}

	static void solve(int N, int[][] mat, int case_num) {
		int sum = (N * (N + 1)) / 2;
		int rowcount = 0;
		int colcount = 0;
		int trace = 0;
		for (int i = 0; i < N; i++) {
			HashSet<Integer> myset = new HashSet<Integer>();
			for (int j = 0; j < N; j++) {
				if (myset.contains(mat[i][j])) {
					rowcount++;
					break;
				} else {
					myset.add(mat[i][j]);
				}
			}
		}

		for (int j = 0; j < N; j++) {
			HashSet<Integer> myset = new HashSet<Integer>();
			for (int i = 0; i < N; i++) {
				if (myset.contains(mat[i][j])) {
					colcount++;
					break;
				} else {
					myset.add(mat[i][j]);
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			trace+=mat[i][i];
		}

		System.out.println("Case #" + case_num + ": " + trace + " " + rowcount + " " + colcount);
	}

}
