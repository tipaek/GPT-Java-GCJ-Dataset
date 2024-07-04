import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		for (int t = 1; t <= test; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] matrix = new int[N][N];
			for (int i = 0; i < N; i++) {
				String[] str = br.readLine().split(" ");
				for (int j = 0; j < str.length; j++) {
					matrix[i][j] = Integer.parseInt(str[j]);
				}
			}

			int trace, rowCount, colCount;
			trace = rowCount = colCount = 0;

			for (int i = 0; i < matrix.length; i++)
				trace += matrix[i][i];

			for (int i = 0; i < N; i++) {
				HashSet<Integer> hs = new HashSet<>();
				boolean isRowDuplicate = false;
				for (int j = 0; j < N; j++) {
					if (hs.contains(matrix[i][j])) {
						isRowDuplicate = true;
						break;
					}
					hs.add(matrix[i][j]);
				}
				if (isRowDuplicate)
					rowCount++;
			}

			for (int i = 0; i < N; i++) {
				HashSet<Integer> hs = new HashSet<>();
				boolean isColDuplicate = false;
				for (int j = 0; j < N; j++) {
					if (hs.contains(matrix[j][i])) {
						isColDuplicate = true;
						break;
					}
					hs.add(matrix[j][i]);
				}
				if (isColDuplicate)
					colCount++;
			}

			System.out.println("Case #" + t + ": " + trace + " " + rowCount + " " + colCount);
		}
	}

}