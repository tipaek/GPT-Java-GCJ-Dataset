import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		Set<Integer> latinSquareValidElements = new HashSet<>();
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));) {
			int numberOfTests = in.nextInt();
			Integer[] traces = new Integer[numberOfTests];
			Integer[] duplicateRows = new Integer[numberOfTests];
			Integer[] duplicateColumns = new Integer[numberOfTests];
			for (int t = 0; t < numberOfTests; t++) {
				int latinSquareSize = in.nextInt();
				Integer[][] latinSquare = new Integer[latinSquareSize][latinSquareSize];
				for (int i = 0, row = 0; i < latinSquareSize; i++, row++) {
					for (int col = 0; col < latinSquareSize; col++) {
						latinSquare[row][col] = in.nextInt();
					}
					latinSquareValidElements.add(i + 1);
				}
				int duplicateRowsCounter = 0;
				int duplicateColumnsCounter = 0;
				int trace = 0;
				for (int row = 0; row < latinSquareSize; row++) {
					Set<Integer> latinSquareValidRowElements = new HashSet<>(latinSquareValidElements);
					Set<Integer> latinSquareValidColumnElements = new HashSet<>(latinSquareValidElements);
					boolean isRowNotCounted=true;
					boolean isColumnNotCounted=true;
					for (int col = 0; col < latinSquareSize; col++) {
						if ( isRowNotCounted && !latinSquareValidRowElements.remove(latinSquare[row][col])) {
							duplicateRowsCounter++;
							isRowNotCounted=false;
						}
						if (isColumnNotCounted && !latinSquareValidColumnElements.remove(latinSquare[col][row])) {
							duplicateColumnsCounter++;
							isColumnNotCounted=false;
						}
						if (row == col) {
							trace += latinSquare[row][col];
						}
					}
				}
				traces[t] = trace;
				duplicateRows[t] = duplicateRowsCounter;
				duplicateColumns[t] = duplicateColumnsCounter;
			}
			for (int i = 0; i < numberOfTests; i++) {
				System.out.println(
						"Case #" + (i + 1) + ": " + traces[i] + " " + duplicateRows[i] + " " + duplicateColumns[i]);
			}
		}
	}
}
