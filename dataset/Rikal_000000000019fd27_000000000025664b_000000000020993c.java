
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int map[][];

	static String findDiag() {

		int sum = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) {
					sum += map[i][j];
				}
			}
		}
		return sum + "";
	}

	static String findRow() {

		HashSet<Integer> rowSet, colSet;

		int rowDuple = 0;
		int colDuple = 0;
		for (int i = 0; i < N; i++) {
			rowSet = new HashSet<>();
			for (int j = 0; j < N; j++) {
				rowSet.add(map[i][j]);
			}
			if (rowSet.size() != N) {
				rowDuple++;
			}

			colSet = new HashSet<Integer>();
			for (int j = 0; j < N; j++) {
				colSet.add(map[j][i]);
			}
			if (colSet.size() != N) {
				colDuple++;
			}
		}

		return rowDuple + " " + colDuple;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());

		int t = 1;
		while (T-- > 0) {

//			input

			N = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken().trim());
				}
			}

			StringBuilder sb = new StringBuilder();

			// find diag
			sb.append(findDiag() + " ");
//			 find row, col
			sb.append(findRow() + " ");

			System.out.println("Case #" + t + ": " + sb.toString());

			t++;
		}
	}

}
