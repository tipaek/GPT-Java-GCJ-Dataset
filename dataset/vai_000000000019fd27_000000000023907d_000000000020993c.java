import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
	
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int total = in.nextInt();
		for (int counter = 1; counter <= total; counter++) {
			int n = in.nextInt();
			int[][] matrix = new int[n][n];
			for (int i = 0; i < n; i++) {
				String row = in.next() + in.nextLine();
				String[] nums = row.split(" ");
				for (int j = 0; j < nums.length; j++) {
					matrix[i][j] = Integer.parseInt(nums[j]);
				}
			}

			// Diagonal
			int diag = 0;
			for (int i = 0; i < n; i++) {
				diag += (matrix[i][i]);
			}

			// Rows
			int dupRows = 0;
			for (int i = 0; i < n; i++) {
				List<Integer> dedup = new ArrayList<Integer>();
				for (int j = 0; j < n; j++) {
					if (!dedup.contains(matrix[i][j])) {
						dedup.add(matrix[i][j]);
					} else {
						dupRows++;
						break;
					}
				}
			}
			
			// Columns
			int dupCols = 0;
			for (int i = 0; i < n; i++) {
				List<Integer> dedup = new ArrayList<Integer>();
				for (int j = 0; j < n; j++) {
					if (!dedup.contains(matrix[j][i])) {
						dedup.add(matrix[j][i]);
					} else {
						dupCols++;
						break;
					}
				}
			}
			
			System.out.println("Case #" + counter + ": " + diag + " " + dupRows + " " + dupCols);

		}
		in.close();

	}

}
