import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static int[] solve(int length, int[][] d) {
		Map<Integer, Set<Integer>> rows = new HashMap<Integer, Set<Integer>>(length);
		Map<Integer, Set<Integer>> cols = new HashMap<Integer, Set<Integer>>(length);

		int diagSum = 0;
		int rowDups = 0;
		int colDups = 0;

		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d[i].length; j++) {
				Set<Integer> possibleRows = rows.getOrDefault(i, new HashSet<Integer>(length));
				Set<Integer> possibleCols = cols.getOrDefault(j, new HashSet<Integer>(length));
				int element = d[i][j];

				if (possibleRows.contains(element)) {
					if (rowDups != length)
						rowDups++;
				}
				if (possibleCols.contains(element)) {
					if (colDups != length)
						colDups++;
				}

				possibleCols.add(element);
				possibleRows.add(element);
				cols.put(j, possibleCols);
				rows.put(i, possibleRows);

				if (i == j)
					diagSum += element;
			}
		}
		return new int[] { diagSum, rowDups, colDups };
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tests = in.nextInt();

		for (int test = 1; test < tests+1; test++) {
			int size = in.nextInt();

			int[][] matrix = new int[size][size];

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					matrix[i][j] = Integer.valueOf(in.next());
				}
			}
			int[] result = solve(size, matrix);
			System.out.println("Case #" + test + ": "+ result[0] + " " + result[1] + " " + result[2]);

		}
	}

}
