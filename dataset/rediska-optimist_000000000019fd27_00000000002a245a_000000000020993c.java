import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = null;
		if (System.getProperties().getProperty("user.name").equals("Svetlana")) {
			sc = new Scanner(new FileInputStream("io/input1.txt"));
			System.err.println("development mode, reading from file");
		} else {
			sc = new Scanner((System.in));
		}

		int testCases = Integer.parseInt(sc.nextLine());
		for (int i = 1; i <= testCases; i++) {
			int matrixSize = Integer.parseInt(sc.nextLine());
			int[][] matrix = new int[matrixSize][matrixSize];
			for (int j = 0; j < matrix.length; j++) {
				String[] mRow = sc.nextLine().split(" ");
				for (int k = 0; k < mRow.length; k++) {
					matrix[j][k] = Integer.parseInt(mRow[k]);
				}
			}
			String result = readAndResolveSingleCase(matrix);
			System.out.println("Case #" + i + ": " + result);
			System.out.flush();
		}
		sc.close();
	}

	private static String readAndResolveSingleCase(int[][] matrix) {

		String result = null;

		int k = 0;
		for (int i = 0; i < matrix.length; i++) {
			k = k + matrix[i][i];
		}

		int r = 0;
		for (int i = 0; i < matrix.length; i++) {
			MIDDLE: for (int j = 0; j < matrix[i].length; j++) {
				for (int j2 = j + 1; j2 < matrix.length; j2++) {
					if (matrix[i][j] == matrix[i][j2]) {
						r++;
						break MIDDLE;
					}
				}
			}
		}

		int c = 0;
		for (int j = 0; j < matrix.length; j++) {
			l2: for (int i = 0; i < matrix[j].length; i++) {
				for (int i2 = i + 1; i2 < matrix.length; i2++) {
					if (matrix[i][j] == matrix[i2][j]) {
						c++;
						break l2;
					}
				}
			}
		}

		result = k + " " + r + " " + c;

		return result;
	}

}
