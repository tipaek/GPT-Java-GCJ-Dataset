import java.util.*;
import java.io.*;

public class Solution {

	private static final String VALUES_TO_SKIP = "(\r\n|[\n\r\u2028\u2029\u0085])?";

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numberOfCases = in.nextInt();
		in.skip(VALUES_TO_SKIP);

		for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
			int matrixSize = in.nextInt();
			in.skip(VALUES_TO_SKIP);

			int[][] array = new int[matrixSize][matrixSize];
			for(int rowIndex = 0; rowIndex < matrixSize; rowIndex++) {

				String[] rowItems = in.nextLine().split(" ");
				in.skip(VALUES_TO_SKIP);

				for (int j = 0; j < matrixSize; j++) {
					int arrayItem = Integer.parseInt(rowItems[j]);
					array[rowIndex][j] = arrayItem;
				}
			}
			calculateForTestCase(caseIndex, matrixSize, array);
		}
	}

	private static void calculateForTestCase(int caseIndex, int matrixSize, int[][] array) {
		int diagonalSum = 0;
		int rowRepeats = 0;
		long columnRepeats = 0;
		Map<Integer, Set<Integer>> uniqueColumnValues = new HashMap<>();

		for(int i = 0; i< matrixSize; i++) {
			Set<Integer> uniqueRowValues = new HashSet<>();
			for(int j=0; j<matrixSize; j++) {
				int current = array[i][j];

				uniqueRowValues.add(current);

				Set<Integer> existingRowItems = uniqueColumnValues.getOrDefault(j, new HashSet<>());
				existingRowItems.add(current);
				uniqueColumnValues.put(j, existingRowItems);

				if(i==j) {
					diagonalSum += current;
				}

			}

			if(uniqueRowValues.size() < matrixSize) {
				rowRepeats++;
			}

			columnRepeats = uniqueColumnValues.entrySet().stream()
					.filter(entry -> entry.getValue().size() < matrixSize)
					.count();

		}

		System.out.println("Case #" + caseIndex + ": " + diagonalSum + " " + rowRepeats + " " + columnRepeats);
	}

}