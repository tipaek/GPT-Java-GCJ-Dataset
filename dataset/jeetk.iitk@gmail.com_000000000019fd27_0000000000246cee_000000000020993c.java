import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static String traceRowColumn(int[][] matrix, int matrixSize) {
		int trace = 0;
		int numRowsWithRepeats = 0;
		int numColWithRepeats = 0;
		for (int i = 0; i < matrixSize; i++) {
			trace = trace + matrix[i][i];
		}
		for (int i = 0; i < matrixSize; i++) {
			int temp[] = new int[matrixSize];
			for (int j = 0; j < matrixSize; j++) {
				int thisNumber = matrix[i][j];
				if (temp[thisNumber - 1] == 0) {
					temp[thisNumber - 1] = 1;
				}
				else {
					numRowsWithRepeats++;
					break;
				}
			}
		}
		for (int i = 0; i < matrixSize; i++) {
			int temp[] = new int[matrixSize];
			for (int j = 0; j < matrixSize; j++) {
				int thisNumber = matrix[j][i];
				if (temp[thisNumber - 1] == 0) {
					temp[thisNumber - 1] = 1;
				}
				else {
					numColWithRepeats++;
					break;
				}
			}
		}
		
		return trace + " " + numRowsWithRepeats + " " + numColWithRepeats;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int numCases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int i = 1; i <= numCases; ++i) {
	      int matrixSize = in.nextInt();
	      int thisMatrix[][] = new int[matrixSize][matrixSize];
	      for (int row = 0; row < matrixSize; row++) {
	    	  for (int column = 0; column < matrixSize; column++) {
	    		  int thisValue = in.nextInt();
	    		  thisMatrix[row][column] = thisValue;
		      }
	      }
	      System.out.println("Case #" + i + ": " + traceRowColumn(thisMatrix, matrixSize));
	    }
	    in.close();

	}

}
