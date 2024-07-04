import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(
				System.in)));
		PrintWriter w = new PrintWriter(System.out);
		int testCount = sc.nextInt();
		for (int i = 1; i <= testCount; i++)
			solve(i, sc, w);
		w.close();
	}

	public static void solve(int testNumber, Scanner sc, PrintWriter out) {
		int N = sc.nextInt();
		int K = sc.nextInt();
		boolean traceExists = false;
		for (int i = 1; i <= N; i++) {
			if (K == i * N) {
				out.println("Case #" + testNumber + ": " + "POSSIBLE");
				out.println(getMatrixWithDiagnaldiagn(i, N).toString());
				traceExists = true;
				break;
			}
		}
		if (!traceExists) {
			int mat[][] = new int[N][N];
			StringBuilder ans2 = new StringBuilder();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i + j + 1 > N) {
						mat[i][j] = (i + j + 1) % N;
					} else {
						mat[i][j] = i + j + 1;
					}
					ans2.append(mat[i][j] + " ");
				}
				if(i<N-1)
				  ans2.append("\n");
			}
			int count = K;
			for (int i = 0; i < N; i++)
				count -= mat[i][i];
			if (count == 0) {
				out.println("Case #" + testNumber + ": " + "POSSIBLE");
				out.println(ans2.toString());
			}
			else
			 out.println("Case #" + testNumber + ": " + "IMPOSSIBLE");
		}	

	}

	static StringBuilder getMatrixWithDiagnaldiagn(int diagn, int N) {
		StringBuilder ans = new StringBuilder();
		int[][] mat = matrixWithDiagnoalOne(N);

		if (diagn != 1) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (mat[i][j] == diagn) {
						int temp = mat[i][i];
						mat[i][i] = mat[i][j];
						mat[i][j] = temp;
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				{
					ans.append(mat[i][j] + " ");
				}
			}
			if (i < N - 1)
				ans.append("\n");
		}

		return ans;
	}

	static int[][] matrixWithDiagnoalOne(int n) {
		int k = n + 1;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			int temp = k;
			while (temp <= n) {
				sb.append(temp + " ");
				temp++;
			}
			for (int j = 1; j < k; j++)
				sb.append(j + " ");
			k--;
			sb.append("\n");
		}
		int[][] mat = new int[n][n];
		String[] str = sb.toString().split("\n");
		for (int i = 0; i < n; i++) {
			String[] row = str[i].split(" ");
			for (int j = 0; j < n; j++) {
				mat[i][j] = Integer.parseInt(row[j]);
			}
		}
		str = null;
		return mat;
	}
}