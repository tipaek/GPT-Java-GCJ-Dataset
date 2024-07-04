import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String testcase = br.readLine();
		String[] t = testcase.split(" ");
		int T = Integer.parseInt(t[0]);

		for (int i = 0; i < T; i++) {

			String no_of_rows = br.readLine();
			String[] n = no_of_rows.split(" ");
			int N = Integer.parseInt(n[0]);

			int matrix[][] = new int[N][N];

			for (int j = 0; j < N; j++) {
				String str = br.readLine();
				String[] arr = str.split(" ");
				for (int k = 0; k < N; k++) {
					matrix[j][k] = Integer.parseInt(arr[k]);
				}
			}
			int row_count = 0;
			int column_count = 0;
			int trace = 0;

			for (int u = 0; u < N; u++) {
			outer :	for (int r = 0; r < N - 1; r++) {
					for (int c = r + 1; c < N; c++) {
						if (matrix[u][r] == matrix[u][c]) {
							row_count++;
							break outer;
						}
					}
				}
			}

			for (int u = 0; u < N; u++) {
			inner :	for (int r = 0; r < N - 1; r++) {
					for (int c = r + 1; c < N; c++) {
						if (matrix[r][u] == matrix[c][u]) {
							column_count++;
							break inner;
						}
					
					}
				}
			}
			for (int y = 0; y < N; y++) {
				trace += matrix[y][y];
			}
		System.out.println("Case #"+(i+1)+": "+trace+" "+row_count+" "+column_count);}
	}
}
