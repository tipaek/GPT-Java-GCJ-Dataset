import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String nextLine = null;
		// Read number of test cases
		nextLine = scanner.nextLine();
		int n = Integer.parseInt(nextLine);
		int size = 0;
		String [] output = new String[n];
		for(int i=0; i < n; i++) {
			// Read size for matrix i+1;
			nextLine = scanner.nextLine();
			size = Integer.parseInt(nextLine);
			output[i] = "Case #" + (i+1) + ": " + solveMatrix(scanner, size);
		}
		//Print output
		for(int i=0; i < n; i++) {
			System.out.println(output[i]);
		}
		
		//close scanner
		scanner.close();
	}
	

	private static String solveMatrix(Scanner scanner, int size) {
		
		int [][] matrix = new int[size][size];
		String nextLine = null;
		StringTokenizer st = null;
		//Read values for matrix and build it
		for(int i=0; i < size; i++) {
			nextLine = scanner.nextLine();
			st = new StringTokenizer(nextLine, " ");
			int j = 0;
			while(st.hasMoreTokens()) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
				j++;
			}
		}
		int trace = findTrace(size, matrix);
		int rowRepeats = findRowRepeatCount(size, matrix);
		int colRepeats = findColRepeatCount(size, matrix);
		
		return trace + " " + rowRepeats + " " + colRepeats;
	}
	
	private static int findTrace(int size, int [][] matrix) {
		
		int trace = 0;
		for(int i=0; i < size; i++) {
			trace = trace + matrix[i][i];
		}
		return trace;
	}

	private static int findRowRepeatCount(int size, int [][] matrix) {
		
		int rowRepeats = 0;
		for(int i=0; i < size; i++) {
			// Checking row i+1
			row: 
			for(int j=0; j < size; j++) {
				for(int k=j+1; k < size; k++) {
					if(matrix[i][j] == matrix[i][k]) {
						// There is duplicate number in row i+1;
						rowRepeats++;
						break row;
					}
				}
			}
		}		
		return rowRepeats;
	}

	private static int findColRepeatCount(int size, int [][] matrix) {
		
		int colRepeats = 0;
		for(int i=0; i < size; i++) {
			// Checking col i+1
			row: 
			for(int j=0; j < size; j++) {
				for(int k=j+1; k < size; k++) {
					if(matrix[j][i] == matrix[k][i]) {
						// There is duplicate number in row i+1;
						colRepeats++;
						break row;
					}
				}
			}
		}		
		return colRepeats;
	}

}
