import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int te = 0; te < T; te++) {

			int N = sc.nextInt();
			int[][] inputArray = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					inputArray[i][j] = sc.nextInt();
				}
			}

			int rowCount = 0, trace = 0, columnCount = 0;
			for (int i = 0; i < N; i++) {

				int count = 0,colCount=0;
				Map<Integer, Integer> row = new HashMap<>();
				Map<Integer, Integer> column = new HashMap<>();
				for (int j = 0; j < N; j++) {
					if (row.get(inputArray[i][j]) == null) {
						row.put(inputArray[i][j], inputArray[i][j]);
					} else {
						count = 1;
					}
					if (i == j) {
						trace += inputArray[i][j];
					}
					
					if (column.get(inputArray[j][i]) == null) {
						column.put(inputArray[j][i], inputArray[j][i]);
					} else {
						colCount = 1;
					}
				}
				if (count == 1) {
					rowCount++;
				}
				if (colCount == 1) {
					columnCount++;
				}
			}

			System.out.println("Case #" + (te + 1) + ": " + trace + " " + rowCount + " " + columnCount);
		}

		sc.close();

	}

}