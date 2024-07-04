package codejam2020;

import java.util.Scanner;

public class vestigium {

	public static void main(String[] args) {
		final String stringCase = "Case #";
		Scanner sc = new Scanner(System.in);
		int numberTestCases = sc.nextInt();

		for (int testCaseNumber = 1; numberTestCases >= testCaseNumber; testCaseNumber++) {

			int sizeOfMatrix = sc.nextInt();

			int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];
			Integer kTraceOfMatrix = 0;
			Integer rRowsRepeatedElements = 0;
			Integer cColsRepeatedElements = 0;

			for (int row = 0; row < sizeOfMatrix; row++) {
				for (int col = 0; col < sizeOfMatrix; col++) {
					matrix[row][col] = sc.nextInt();
				}
			}


			for (int row = 0; row < sizeOfMatrix; row++) {
				for (int col = 0; col < sizeOfMatrix; col++) {
					
				}
				kTraceOfMatrix += matrix[row][row];
			}

			StringBuffer sb = new StringBuffer();
			sb.append(stringCase);
			sb.append(testCaseNumber);
			sb.append(": ");
			sb.append(kTraceOfMatrix.toString());
			sb.append(" ");
			sb.append(rRowsRepeatedElements.toString());
			sb.append(" ");
			sb.append(cColsRepeatedElements.toString());

			System.out.println(sb.toString());
		}
		sc.close();
	}

}
