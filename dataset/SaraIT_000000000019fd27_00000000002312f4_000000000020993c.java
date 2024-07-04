import java.util.*;
import java.io.*;

public class Solution {
	static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));


	public static int[][] formatMatrix(int n) {
		int[][] matrix = new int[n][n];
		String line;
		String[] sPlit;

		int j = 0;
		while (j < n) {
			line = in.nextLine();
			sPlit = line.split("\\s+");
			for (int i = 0; i < n; i++) {
				matrix[j][i] = Integer.parseInt(sPlit[i]);
			}
			j++;
		}
		return matrix;
	}

	public static int[] matrixTrace(int[][] matrix) {
		int traceDiag = 0;
		int[] solution = new int[3];

		for (int i = 0; i < matrix.length; i++) {
			traceDiag = traceDiag + matrix[i][i];
		}
		solution[0] = traceDiag;
		solution[1] = 0;
		solution[2] = 0;

		return solution;
	}

	public static int[] matrixRepeat(int[][] matrix,int[] solution) {
		int n = matrix.length;
		int solutionLine = 0;
		int solutionColumn = 0;
		Set<Integer> kayenLine;
		Set<Integer> kayenColumn;
		int j = 0;
		
		boolean otherLine;
		boolean otherColumn;
		

		while (j < n) {
			kayenLine = new HashSet<Integer>();
			kayenColumn = new HashSet<Integer>();
			otherColumn = false;
			otherLine = false;
			
			for (int i = 0; i < n; i++) {
				//Line
				if (kayenLine.contains(matrix[j][i])) {
					otherLine = true;
				} else {
					kayenLine.add(matrix[j][i]);
				}
						
			}
			
			for (int i = 0; i < n; i++) {
				//Column
				if (kayenColumn.contains(matrix[i][j])) {
					otherColumn = true;
				} else {
					kayenColumn.add(matrix[i][j]);
				}
			}
			
			if (otherLine) {
				solutionLine++;
			}if (otherColumn) {
				solutionColumn++;
			}
			j++;
		}
		solution[1] = solutionLine;		
		solution[2] = solutionColumn;

		return solution;
	}

	public static void main(String[] args) throws FileNotFoundException {
		// Scanner in = new Scanner(new BufferedReader(new
		// InputStreamReader(System.in)));
		// System.setOut(new PrintStream("output.txt"));

		int N;
		int T = Integer.parseInt(in.nextLine());
		int[][] matrix;
		int[] solution;

		for (int i = 1; i <= T; i++) {
			N = Integer.parseInt(in.nextLine());
			matrix = formatMatrix(N);
			solution = matrixTrace(matrix);
			solution = matrixRepeat(matrix, solution);

			System.out.print("Case #" + i + ":");
			for (int j = 0; j < 3; j++) {
				System.out.print(" " + solution[j]);
			}
			System.out.println();
		}

	}

}
