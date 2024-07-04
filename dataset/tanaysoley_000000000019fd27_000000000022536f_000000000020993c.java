import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= testCases; tc++) {
			int n = Integer.parseInt(br.readLine());
			Integer[][] matrix = new Integer[n][n];

			//populate the matrix
			for (int i = 0; i < n; i++) {
				matrix[i] = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()).toArray(matrix[i]);
			}

			int trace = getTrace(matrix, n);
			int[] rep = repeated(matrix, n);

			System.out.println("Case #" + tc + ": " + trace + " " + rep[0] + " " + rep[1]);
		}
	}

	public static int getTrace(Integer[][] matrix, int n) {
		int trace = 0;
		for (int i = 0; i < n; i++) {
			trace += matrix[i][i];
		}
		return trace;
	}

	public static int[] repeated(Integer[][] matrix, int n) {
		int repeatedRows = 0;
		int repeatedCols = 0;
		int total = n * (n + 1) / 2;
		for (int i = 0; i < n; i++) {
			int sumRow = 0;
			int sumCol = 0;
			List<Integer> a = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				sumRow += matrix[i][j];
				sumCol += matrix[j][i];
				a.add(matrix[j][i]);
			}
			if (sumRow != total || Arrays.asList(matrix[i]).stream().distinct().collect(Collectors.toList()).size() != n) {
				repeatedRows++;
			}

			if (sumCol != total || a.stream().distinct().collect(Collectors.toList()).size() != n) {
				repeatedCols++;
			}
		}

		return new int[]{repeatedRows, repeatedCols};
	}
}
