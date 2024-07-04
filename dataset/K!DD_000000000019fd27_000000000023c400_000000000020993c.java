import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testNumber = in.nextInt();
		List<VestigiumTest> tests = new ArrayList<>(testNumber);
		for (int i = 1; i <= testNumber; i++) {
			final int N = in.nextInt();
			VestigiumTest cur = new VestigiumTest(N);
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					cur.matrix[row][col] = in.nextInt();
				}
			}
			tests.add(cur);
		}

		for (int i = 0; i < tests.size(); i++) {
			VestigiumTest test = tests.get(i);
			isLatinTrace(i+1, test.N, test.matrix);
		}
	}

	static class VestigiumTest {
		int N;
		int[][] matrix;

		VestigiumTest(int N) {
			this.N = N;
			this.matrix = new int[N][N];
		}

		@Override
		public String toString() {
			return N + " " + matrixPrint(matrix);
		}

		String matrixPrint(int[][] matrix) {
			String result = "";
			for (int[] row : matrix) {
				result += Arrays.toString(row);
			}
			return result;
		}
	}

	static boolean isLatinTrace(int testCase, int N, int[][] matrix) {
		List<Set<Integer>> rows = new ArrayList<>(N);
		List<Set<Integer>> cols = new ArrayList<>(N);

		for (int i = 0; i < N; i++) {
			rows.add(new HashSet<>());
			cols.add(new HashSet<>());
		}

		int trace = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int cur = matrix[i][j];
				if(i == j) trace+=cur;
				rows.get(i).add(cur);
				cols.get(j).add(cur);
			}
		}

		int rowCollisions = calcRowCollisions(N, rows);
		int colCollisions = calcRowCollisions(N, cols);
		printAnswer(testCase, trace, rowCollisions, colCollisions);
		return true;
	}

	private static int calcRowCollisions(int N, List<Set<Integer>> lst) {
		int collisions = N;
		for (int i = 0; i < N; i++) if (lst.get(i).size() == N) collisions--;
		return collisions;
	}

	private static void printAnswer(int i, int trace, int rowCollisions, int colCollisions) {
		System.out.println("Case #" + i + ": " + trace + " " + rowCollisions + " " + colCollisions);
	}
}