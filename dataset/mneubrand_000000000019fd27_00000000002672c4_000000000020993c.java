import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static void main(String[] args) throws Exception {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int numCases = Integer.parseInt(br.readLine());
			for (int i = 0; i < numCases; i++) {
				System.out.println("Case #" + (i+1) + ": " + handleCase(br));
			}
		}
	}

	private static String handleCase(BufferedReader br) throws Exception {
		int n = Integer.parseInt(br.readLine());
		int[][] matrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] temp = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				matrix[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		long trace = 0;
		long dupeRows = 0;
		long dupeCols = 0;
		
		for (int i = 0; i < n; i++) {
			Set<Integer> row = new HashSet<>();
			Set<Integer> column = new HashSet<>();
			
			for (int j = 0; j < n; j++) {
				if(i == j) {
					trace += matrix[i][j];
				}
				
				row.add(matrix[i][j]);
				column.add(matrix[j][i]);
			}
			
			if(row.size() < n) {
				dupeRows++;
			}
			if(column.size() < n) {
				dupeCols++;
			}
		}
		
		return trace + " " + dupeRows + " " + dupeCols;
	}

}
