import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	private static int currentTestCase = 0;
	private static int matrixTrace = 0;
	private static int rowsWithNumberRepeated = 0;
	private static int columnsWithNumberRepeated = 0;
	
	private static void printOutput() {
		System.out.println(
				"Case #" + 
						currentTestCase + 
						": " +
						matrixTrace +
						" " +
						rowsWithNumberRepeated +
						" " +
						columnsWithNumberRepeated
				);
	}
	
	private static void compute(int[][] matrix) {
		
		matrixTrace = 0;
		rowsWithNumberRepeated = 0;
		columnsWithNumberRepeated = 0;
		
        Set<Integer> setRows = new LinkedHashSet<>();
        Set<Integer> columnsRows = new LinkedHashSet<>();
        
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				// Compute Matrix Trace
				if(i == j) {
					matrixTrace += matrix[i][j];
				}
				
				// Rows with number repeated
				setRows.add(matrix[i][j]);
				
				// Columns with number repeated
				columnsRows.add(matrix[j][i]);
			}
			
			// Rows with number repeated
			if(setRows.size() < matrix.length) {
				rowsWithNumberRepeated++;
			}
			
			// Columns with number repeated
			if(columnsRows.size() < matrix.length) {
				columnsWithNumberRepeated++;
			}
			
			setRows.clear();
			columnsRows.clear();
		}

		printOutput();
	}

	public static void main(String[] args) {
		
		final Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		
        for (int i = 0; i < testCases; i++) {
        	currentTestCase++;
    		
        	int matrixSize = scanner.nextInt();
        	
        	int[][] matrix = new int[matrixSize][matrixSize];
        	
        	for (int j = 0; j < matrixSize; j++) {
				for (int k = 0; k < matrixSize; k++) {
					matrix[j][k] = scanner.nextInt();
				}
			}
        	
        	compute(matrix);
        }

        scanner.close();
	}
}

