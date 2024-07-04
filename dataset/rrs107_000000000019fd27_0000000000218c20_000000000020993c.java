import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {

		int t = Integer.parseInt(br.readLine());

		int index = 1;
		while (t-- > 0) {
			solve(index++);
		}

	}

	private static void solve(int index) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());

		int[][] matrix = new int[n][n];

		for (int i = 0; i < n; i++) {
			String[] split = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				matrix[i][j] = Integer.parseInt(split[j]);
			}
		}

		int traceSum = 0;

		for (int i = 0; i < n; i++) {
			traceSum += matrix[i][i];
		}

		int rowRepeated = 0;

		for (int i = 0; i < n; i++) {
			Set<Integer> set = new HashSet<>();
			for (int j = 0; j < n; j++) {
				if (set.contains(matrix[i][j])) {
					rowRepeated++;
					break;
				} else {
					set.add(matrix[i][j]);
				}
			}
		}
		int colRepeated = 0;

		for (int i = 0; i < n; i++) {
			Set<Integer> set = new HashSet<>();
			for (int j = 0; j < n; j++) {
				if (set.contains(matrix[j][i])) {
					colRepeated++;
					break;
				} else {
					set.add(matrix[j][i]);
				}
			}
		}

		System.out.println("Case #" + index + ": " + traceSum + " " + rowRepeated + " " + colRepeated);

	}
}
