
import java.util.*;

public class Solution{

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int repeat = in.nextInt();

		for(int n = 0; n < repeat; n++) {
			
			int size = in.nextInt();
			int[][] matrix = new int[size][size];
			int trace = 0;

			for (int row = 0; row < matrix.length; row++) {
				for (int col = 0; col < matrix[0].length; col++) {
					matrix[row][col] = in.nextInt();
				}
			}

			for (int i = 0; i < matrix.length; i++) {
				trace += matrix[i][i];
			}

			for (int row = 0; row < matrix.length; row++) {
				for (int col = 0; col < matrix[0].length; col++) {
					System.out.print(matrix[row][col] + " ");
				}
				System.out.println();
			}

			int dupRows = 0;
			int dupCols = 0;

			for (int row = 0; row < matrix.length; row++) {
				HashSet<Integer> rows = new HashSet<Integer>();
				
				for (int col = 0; col < matrix[0].length; col++) {
					
					if (!rows.add(matrix[row][col])) {
						dupRows++;
						col = matrix[0].length;
					}

				}
			}
			
			for (int col = 0; col < matrix[0].length; col++) {
				HashSet<Integer> cols = new HashSet<Integer>();
				
				for (int row = 0; row < matrix.length; row++) {
					
					if (!cols.add(matrix[row][col])) {
						dupCols++;
						row = matrix.length;
					}

				}
			}
			
			System.out.println("Case #" + n + ": " + trace + " " + dupRows + " " + dupCols);
		}
	}
}
