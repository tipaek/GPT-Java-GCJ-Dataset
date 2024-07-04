
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(System.out, false);

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			long sum = 0;
			int repRows = 0;
			int repCols = 0;
			int N = Integer.parseInt(br.readLine());
			int[][] matrix = new int[N][N];
			long s = (N * (N + 1)) / 2;
			Set<Integer> rowSet = new HashSet<>();
			Set<Integer> colSet = new HashSet<>();
			for (int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < N; k++) {
					matrix[j][k] = Integer.parseInt(st.nextToken());
					if (j == k) {
						sum += matrix[j][k];
					}
					rowSet.add(matrix[j][k]);
				}
				if (rowSet.size() != N) {
					repRows++;
				}
				rowSet.clear();
			}

			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					colSet.add(matrix[k][j]);
				}
				if (colSet.size() != N) {
					repCols++;
				}
				colSet.clear();
			}

			pw.println("Case #" + i + ": " + sum + " " + repRows + " " + repCols);
		}
		pw.flush();
	}
}
