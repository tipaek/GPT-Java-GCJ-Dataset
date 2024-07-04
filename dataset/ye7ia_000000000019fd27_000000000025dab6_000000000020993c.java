import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = in.nextInt();
			int[][] matrix = new int[n][n];
			int repeatedRows = 0, trace = 0, repeatedCols = 0; 
			for (int i = 0; i < n; i++) {
				HashSet<Integer> set = new HashSet<Integer>();
				boolean isRepeatdRow = false;
				for (int j = 0; j < n; j++) {
					matrix[i][j] = in.nextInt();
					isRepeatdRow |= set.contains(matrix[i][j]);
					set.add(matrix[i][j]);
					if (i == j) {
						trace += matrix[i][j];
					}
				}
				if (isRepeatdRow) {
					repeatedRows++;
				}
			}
			for (int i = 0; i < n; i++) {
				HashSet<Integer> set = new HashSet<Integer>();
				boolean isRepeatedCol = false;
				for (int j = 0; !isRepeatedCol && j < n; j++) {
					isRepeatedCol |= set.contains(matrix[j][i]);
					set.add(matrix[j][i]);
				}
				if (isRepeatedCol) {
					repeatedCols++;
				}
			}
			System.out.printf("Case #%d: %d %d %d\n", tc, trace, repeatedRows, repeatedCols);
		}
		in.close();
	}
}
