import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) throws IOException {
		 Scanner in = new Scanner(System.in);
		Integer testNo = 1;
		in.nextLine();
		while (in.hasNext()) {
			int N = Integer.parseInt(in.next());
			int[][] array = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					array[i][j] = Integer.parseInt(in.next());
				}
			}
			int k = addAllOnDiagonal(array);
			int r = checkNumberOfRowsHavingDuplicateValues(array);
			int c = checkNumberOfColumnsHavingDuplicateValues(array);
			System.out.println("Case #" + testNo + ": " + k + " " + r + " " + c);
			testNo++;
		}
	}

	private static int checkNumberOfColumnsHavingDuplicateValues(int[][] array) {
		int numberOfColumns = 0;
		for (int row = 0; row < array.length; row++) {
			Set<Integer> addInThis = new HashSet<>();
			for (int col = 0; col < array.length; col++) {
				addInThis.add(array[col][row]);
			}
			if (addInThis.size() != array.length) {
				numberOfColumns++;
			}
		}
		return numberOfColumns;
	}

	private static int checkNumberOfRowsHavingDuplicateValues(int[][] array) {
		int numberOfRows = 0;
		for (int row = 0; row < array.length; row++) {
			Set<Integer> addInThis = new HashSet<>();
			for (int col = 0; col < array.length; col++) {
				addInThis.add(array[row][col]);
			}
			if (addInThis.size() != array.length) {
				numberOfRows++;
			}
		}
		return numberOfRows;
	}

	private static int addAllOnDiagonal(int[][] array) {
		int total = 0;
		for (int row = 0; row < array.length; row++) {
			total += array[row][row];
		}
		return total;
	}

}