import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = null;
		if (System.getProperties().getProperty("user.name").equals("Alexey")) {
			sc = new Scanner(new FileInputStream("input.txt"));
			System.err.println("development mode, reading from file");
		} else {
			sc = new Scanner((System.in));
		}

		int testCases = Integer.parseInt(sc.nextLine());
		for (int i = 1; i < testCases + 1; i++) {
			String taskLine1 = sc.nextLine();
			int N = Integer.parseInt(taskLine1);
			int[][] matrix = new int[N][N];
			for (int row = 0; row < N; row++) {
				String[] rowValuesAsString = sc.nextLine().split(" ");
				for (int col = 0; col < N; col++) {
					matrix[row][col] = Integer.parseInt(rowValuesAsString[col]);
				}
			}

			String result = readAndresolveSingleCase(matrix);
			System.out.println("Case #" + i + ": " + result);
			System.out.flush();
		}
		sc.close();
	}

	private static String readAndresolveSingleCase(int[][] matrix) {
		String result = null;
		int trace = 0, colrepeats = 0, rowrepeats = 0, N = matrix.length;

		byte[] repeatsCounter = null;
		for (int i = 0; i < N; i++) {
			trace += matrix[i][i];

			repeatsCounter = new byte[N];
			for (int j = 0; j < N; j++) {
				repeatsCounter[matrix[i][j] - 1]++;
				if (repeatsCounter[matrix[i][j] - 1] > 1) {
					rowrepeats++;
					break;
				}
			}

			repeatsCounter = new byte[N];
			for (int j = 0; j < N; j++) {
				repeatsCounter[matrix[j][i] - 1]++;
				if (repeatsCounter[matrix[j][i] - 1] > 1) {
					colrepeats++;
					break;
				}
			}
		}
		System.err.println("test debug output");
		return trace + " " + rowrepeats + " " + colrepeats;
	}

}
