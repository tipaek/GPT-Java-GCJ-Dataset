import java.util.HashMap;
import java.util.Scanner;

public class Vestigium {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testNo = scanner.nextInt();
		
		for (int i = 1; i <= testNo; i++) {
			int n = scanner.nextInt();
			int[][] matrix = new int[n][n];
			for (int j = 0; j < n; j++) {
				for (int k = 0; k <n; k++) {
					matrix[j][k] = scanner.nextInt();
				}
			}
			
			int trace = 0;
			for (int j = 0; j < n; j++) {
				trace = trace + matrix[j][j];
			}
			
			int row = 0;
			for (int j = 0; j < n; j++) {
				HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
				for (int k = 0; k < n; k++) {
					if (hash.containsKey(matrix[j][k])) {
						row = row + 1;
						break;
					}
					hash.put(matrix[j][k], 0);
				}
			}
			
			int col = 0;
			for (int j = 0; j < n; j++) {
				HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
				for (int k = 0; k < n; k++) {
					if (hash.containsKey(matrix[k][j])) {
						col = col + 1;
						break;
					}
					hash.put(matrix[k][j], 0);
				}
			}
			
			System.out.println("Case #" + i + ": " + trace + " " + row + " " + col);
		}
		scanner.close();
	}

}
