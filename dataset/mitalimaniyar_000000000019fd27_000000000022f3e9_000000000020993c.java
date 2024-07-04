import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int t = s.nextInt();

		int traces[] = new int[t];
		int rowsRepeat[] = new int[t];
		int colsRepeat[] = new int[t];

		for (int count = 0; count < t; count++) {

			int n = s.nextInt();

			int trace = 0, rowRepeat = 0, colRepeat = 0;
			int[][] matrix = new int[n][n];

			Set<Integer> row = new HashSet<Integer>();
			List<Set<Integer>> col = new ArrayList<>();
			int colFlag[] = new int[n];

			for (int i = 0; i < n; i++) {
				col.add(new HashSet<>());
				colFlag[i] = 0;
			}

			for (int i = 0; i < n; i++) {

				row = new HashSet<Integer>();
				int rowFlag = 0;

				for (int j = 0; j < n; j++) {
					int num = s.nextInt();
					matrix[i][j] = num;
					if (i == j) {
						trace += num;
					}

					if (row.contains(num) && rowFlag == 0) {
						rowRepeat++;
						rowFlag = 1;
					}

					row.add(num);

					if (col.get(j).contains(num) && colFlag[j] == 0) {
						colRepeat++;
						colFlag[j] = 1;
					}

					col.get(j).add(num);
				}
			}

			traces[count] = trace;
			rowsRepeat[count] = rowRepeat;
			colsRepeat[count] = colRepeat;

		}

		for (int count = 0; count < t; count++) {
			System.out.println("Case #" + (count + 1) 
			    + ": " + traces[count] + " " + rowsRepeat[count] + " " + colsRepeat[count]);
		}

	}

}