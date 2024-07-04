import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int testCase = 1;
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int trace = 0;
			for (int i = 0; i < n; i++) {
				trace += arr[i][i];
			}
			int row = 0;
			for (int i = 0; i < n; i++) {
				Set<Integer> check = new HashSet<>();
				for (int j = 0; j < n; j++) {
					check.add(arr[i][j]);
				}
				if (check.size() != n) {
					row++;
				}
			}
			int col = 0;
			for (int i = 0; i < n; i++) {
				Set<Integer> check = new HashSet<>();
				for (int j = 0; j < n; j++) {
					check.add(arr[j][i]);
				}
				if (check.size() != n) {
					col++;
				}
			}
			System.out.printf("Case #%d: %d %d %d\n", testCase, trace, row, col);
			testCase++;
		}
	}
}