import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		try (Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
			int numOfTestCases = scan.nextInt();
			for (int i = 1; i <= numOfTestCases; ++i) {
				int matrixSize = scan.nextInt();
				System.out.println("Case #" + i + ": " + solve(scan, matrixSize));
			}
		}
	}

	private static String solve(Scanner scan, int matrixSize) {
		HashSet<Integer>[] rows = new HashSet[matrixSize];
		HashSet<Integer>[] cols = new HashSet[matrixSize];
		int diagonal = 0;
		int numOfRowsWithDuplicates = 0;
		int numOfColsWithDuplicates = 0;

		// init
		for (int i = 0; i < matrixSize; ++i) {
			rows[i] = new HashSet<Integer>();
			cols[i] = new HashSet<Integer>();
		}

		// read
		for (int r = 0; r < matrixSize; ++r) {
			for (int c = 0; c < matrixSize; ++c) {
				int elem = scan.nextInt();
				rows[r].add(elem);
				cols[c].add(elem);
				if (r == c) {
					diagonal += elem;
				}
			}
			if (rows[r].size() < matrixSize) {
				numOfRowsWithDuplicates += 1;
			}
		}

		// process
		for (int c = 0; c < matrixSize; ++c) {
			if (cols[c].size() < matrixSize) {
				numOfColsWithDuplicates += 1;
			}
		}
		return String.format("%d %d %d", diagonal, numOfRowsWithDuplicates, numOfColsWithDuplicates);
	}
}