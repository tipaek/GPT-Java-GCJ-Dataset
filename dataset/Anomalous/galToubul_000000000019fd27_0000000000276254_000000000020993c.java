import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		scanner.nextLine();
		
		int[] results = new int[testCases * 3];
		
		for(int i = 0; i < testCases; i++) {
			int trace = 0;
			int rowCount = 0;
			int colCount = 0;
			int matrixSize = scanner.nextInt();
			
			int[][] rowOccurrences = new int[matrixSize][matrixSize];
			int[][] colOccurrences = new int[matrixSize][matrixSize];
			
			boolean[] rowFlags = new boolean[matrixSize];
			boolean[] colFlags = new boolean[matrixSize];

			int[][] matrix = new int[matrixSize][matrixSize];
			
			for (int j = 0; j < matrixSize; j++) {
				for(int l = 0; l < matrixSize; l++) {
					rowOccurrences[j][l] = 0;
					colOccurrences[j][l] = 0;
				}
			}
			
			for (int j = 0; j < matrixSize; j++) {
				for (int k = 0; k < matrixSize; k++) {
					
					matrix[j][k] = scanner.nextInt();
					
					if(!rowFlags[j] && rowOccurrences[j][matrix[j][k] - 1] == 1) {
						rowCount++;
						rowFlags[j] = true;
					} else {
						rowOccurrences[j][matrix[j][k] - 1] = 1;
					}
					
					if(!colFlags[k] && colOccurrences[matrix[j][k] - 1][k] == 1) {
						colCount++;
						colFlags[k] = true;
					} else {
						colOccurrences[matrix[j][k] - 1][k] = 1;
					}
					
					if (j == k) {
						trace += matrix[j][k];
					}
				}
			}
			
			results[i * 3] = trace;
			results[i * 3 + 1] = rowCount;
			results[i * 3 + 2] = colCount;
		}
		scanner.close();
		
		for(int i = 0; i < testCases; i++) {
			System.out.println("Case #" + (i + 1) + ": " + results[i * 3] + " " + results[i * 3 + 1] + " " + results[i * 3 + 2]);
		}
	}
}