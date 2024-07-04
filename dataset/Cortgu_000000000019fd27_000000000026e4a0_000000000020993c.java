import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
			int numberOfCases = in.nextInt(); // Number of cases
			for (int i = 1; i <= numberOfCases; i++) {
				final int N = in.nextInt();

				int trace = 0;
				List<Set<Integer>> seenInColumns = new ArrayList<>();
				Set<Integer> repeatedRows = new HashSet<>();
				Set<Integer> repeatedColumns = new HashSet<>();
				for (int row = 0; row < N; row++) {
					Set<Integer> seenInRow = new HashSet<>();
					for (int column = 0; column < N; column++) {
						if (seenInColumns.size() < column + 1) {
							seenInColumns.add(column, new HashSet<>());
						}
						
						int M = in.nextInt();
						if (row == column) {
							// diagonal
							trace += M;
						}
						if (!seenInRow.add(M)) {
							repeatedRows.add(row);
						}
						if (!seenInColumns.get(column).add(M)) {
							repeatedColumns.add(column);
						}
					}
				}

				String result = String.format("%d %d %d", trace, repeatedRows.size(), repeatedColumns.size());
				System.out.println("Case #" + i + ": " + result);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}