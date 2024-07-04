import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
class VestigiumTask {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCasesNumber = in.nextInt();
		ArrayList<int[][]> testCases = new ArrayList<int[][]>();
		for(int i = 0; i < testCasesNumber; i++) {
			int matrixRows = in.nextInt();
			int matrix[][] = new int[matrixRows][matrixRows]; 
			for(int row = 0; row < matrixRows; row++) {
				for(int column = 0; column < matrixRows; column++) {
					int matrixNumber = in.nextInt();
					matrix[row][column] = matrixNumber;
				}
			}
			testCases.add(matrix);
		}
		int testCaseInd = 1;
		for(int[][] testCase: testCases) {
			int traceScore = 0;
			int notUniqueRows = 0;
			int notUniqueCols = 0;
			for(int row = 0; row < testCase.length; row++) {
				Set<Integer> uniqueNumbersInRow = new HashSet<>();
				Set<Integer> uniqueNumbersInColumn = new HashSet<>();
				for(int column = 0; column < testCase[row].length; column++) {
					uniqueNumbersInRow.add(testCase[row][column]);
					uniqueNumbersInColumn.add(testCase[column][row]);
					if(row == column) {
						traceScore += testCase[row][column];
					}
				}
				if(uniqueNumbersInRow.size() < testCase.length) {
					notUniqueRows++;
				}
				if(uniqueNumbersInColumn.size() < testCase.length) {
					notUniqueCols++;
				}
			}
			System.out.println("Case #" + testCaseInd + ": " + traceScore + " " + notUniqueRows + " " + notUniqueCols);
			testCaseInd++;
		}
	}
}
