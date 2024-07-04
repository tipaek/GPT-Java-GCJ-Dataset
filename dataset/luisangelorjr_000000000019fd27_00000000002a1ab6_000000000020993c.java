package codejam2020;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class vestigium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String stringCase = "Case ";

		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numberTestCases = sc.nextInt();

		for (int testCaseNumber = 1; numberTestCases >= testCaseNumber; testCaseNumber++) {

			int sizeOfMatrix = sc.nextInt();

			int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];

			for (int row = 0; row < sizeOfMatrix; row++) {
				for (int col = 0; col < sizeOfMatrix; col++) {
					matrix[row][col] = sc.nextInt();
				}
			}

			int kTraceOfMatrix = 0;
			int rRowsRepeatedElements = 0;
			int cColsRepeatedElements = 0;
			for (int row = 0; row < sizeOfMatrix; row++) {
				for (int col = 0; col < sizeOfMatrix; col++) {

				}
			}

			StringBuffer sb = new StringBuffer();
			sb.append(stringCase);
			sb.append(testCaseNumber);
			sb.append(": ");
			sb.append("");

			System.out.println(sb.toString());
		}
		sc.close();
	}
	

}