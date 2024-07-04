import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numCases = in.nextInt();
		for (int i = 1; i <= numCases; i++) {
			System.out.println("Case #" + i + ": " + processProblem(in));
		}
		in.close();
	}

	private static String processProblem(Scanner in) {
		int N = in.nextInt();
		int[][] matrix = new int[N][];
		for (int i = 0; i < N; i++) {
			matrix[i] = new int[N];
			for (int j = 0; j < N; j++) {
				matrix[i][j] = in.nextInt();
			}
		}
		return solve(N, matrix);
	}
	
	/**
	 * k r c,
	 * k is the trace of the matrix,
	 * r is the number of rows of the matrix that contain repeated elements,
	 * and c is the number of columns of the matrix that contain repeated elements.
	 * @param N
	 * @param matrix
	 * @return
	 */
	private static String solve(int N, int[][] matrix) {
		int k = 0;
		for (int i = 0; i < N; i++) {
			k += matrix[i][i];
		}
		
		int r = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				int val = matrix[i][j];
				boolean foundVal = false;
				for (int j1 = j + 1; j1 < N; j1++) {
					if (matrix[i][j1] == val) {
						r++;
						foundVal = true;
						break;
					}
				}
				if (foundVal) {
					break;
				}
			}
		}
		
		int c = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				int val = matrix[j][i];
				boolean foundVal = false;
				for (int j1 = j + 1; j1 < N; j1++) {
					if (matrix[j1][i] == val) {
						c++;
						foundVal = true;
						break;
					}
				}
				if (foundVal) {
					break;
				}
			}
		}
		
		return "" + k + " " + r + " " + c;
	}

}
