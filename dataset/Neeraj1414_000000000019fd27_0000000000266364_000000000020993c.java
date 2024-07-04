package codejam;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Vestigium {

	private static int[] solveProblem(int[][] matrix) {

		int l = matrix[0].length;

		Set<Integer> set = new HashSet<>();

		int rowCount = 0;

		for(int i=0;i<l;i++) {

			set.clear();

			for(int j=0;j<l;j++) {

				if(set.contains(matrix[i][j])) {
					rowCount++;
					break;
				}
				else {
					set.add(matrix[i][j]);
				}

			}

		}

		int colCount = 0;

		for(int i=0;i<l;i++) {

			set.clear();

			for(int j=0;j<l;j++) {

				if(set.contains(matrix[j][i])) {
					colCount++;
					break;
				}
				else {
					set.add(matrix[j][i]);
				}

			}

		}

		int[] solution = new int[3];
		solution[0] = getTrace(matrix);
		solution[1] = rowCount;
		solution[2] = colCount;

		return solution;
	}

	private static int getTrace(int[][] matrix) {

		int trace = 0;

		for(int i=0;i<matrix[0].length;i++) {
			trace += matrix[i][i];
		}

		return trace;

	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int T = Integer.parseInt(scanner.nextLine());

		for(int k=1;k<=T;k++) {

			int n = Integer.parseInt(scanner.nextLine());

			int[][] matrix = new int[n][n];

			String[] input = new String[n];

			for(int i=0;i<n;i++) {
				input[i] = scanner.nextLine();

				String[] temp = input[i].split(" ");

				for(int j=0;j<n;j++) {
					matrix[i][j] = Integer.parseInt(temp[j]);
				}
				
			}

			int[] result = solveProblem(matrix);
			System.out.println(String.format("Case #%s: %s %s %s", k, result[0], result[1], result[2]));
		}

		scanner.close();

	}

}
