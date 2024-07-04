import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 0; i < t; ++i) {
			int sizeOfMatrix = in.nextInt();
			int matrix[][] = new int[sizeOfMatrix][sizeOfMatrix];
			for (int j = 0; j < sizeOfMatrix; ++j) {
				for(int k = 0; k < sizeOfMatrix; ++k) {
					matrix[j][k] = in.nextInt();
				}
			}
			solve(matrix, sizeOfMatrix, t);
		}
	}

	private static void solve(int[][] matrix, int sizeOfMatrix, int testCase) {
		int trace = 0;
		int checkRowArrayFact[] = new int[sizeOfMatrix];
		int checkColArrayFact[] = new int[sizeOfMatrix];
		int checkRowArraySum[] = new int[sizeOfMatrix];
		int checkColArraySum[] = new int[sizeOfMatrix];
		int rowsWithReps = 0;
		int colsWithReps = 0;
		int sum = sizeOfMatrix * (sizeOfMatrix + 1) /2;
		int fact = 1;
		for(int f=1; f <= sizeOfMatrix; f++) {
			fact = fact * f;
			checkRowArrayFact[f-1] = 1;
			checkColArrayFact[f-1] = 1;
		}
		for (int j = 0; j < sizeOfMatrix; ++j) {
			for(int k = 0; k < sizeOfMatrix; ++k) {
				if(j==k) {
					trace = trace + matrix[j][k];
				}
				checkRowArraySum[j] = checkRowArraySum[j] + matrix[j][k];
				checkColArraySum[k] = checkColArraySum[k] + matrix[j][k];
				checkRowArrayFact[j] = checkRowArrayFact[j] * matrix[j][k];
				checkColArrayFact[k] = checkColArrayFact[k] * matrix[j][k];
			}
		}
		for (int c = 0; c < sizeOfMatrix ; c++) {
			if(checkRowArrayFact[c] != fact || checkRowArraySum[c] != sum ) {
				rowsWithReps = rowsWithReps + 1;
			}
			if(checkColArrayFact[c] != fact || checkColArraySum[c] != sum) {
				colsWithReps = colsWithReps + 1;
			}
		}
		System.out.println("Case #" + testCase+ ": " + trace + " " + rowsWithReps + " " + colsWithReps);
	}
}
