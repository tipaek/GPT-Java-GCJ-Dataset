import java.util.HashMap;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int i = 1; i<=T; i++) {
			int N = scanner.nextInt();
			int[][] matrix = new int[N][N];			
			for(int j=0; j<N; j++) {
				matrix[j] = new int[N];
				for(int k=0; k<N; k++) {					
					matrix[j][k] = scanner.nextInt();					
				}
			}			
			HashMap<Integer, Boolean> row = new HashMap<Integer, Boolean>();
			HashMap<Integer, Boolean> col = new HashMap<Integer, Boolean>();
			int rowCount = 0;
			int colCount = 0;
			for(int j=0; j<N; j++) {
				row.clear();
				for(int k=0; k<N; k++) {
					if(row.containsKey(matrix[j][k])) {
						rowCount++;
						break;
					}
					else {
						row.put(matrix[j][k], true);
					}
				}
			}
			for(int k=0; k<N;k++) {
				col.clear();
				for(int j=0; j<N; j++) {
					if(col.containsKey(matrix[j][k])) {
						colCount++;
						break;
					}
					else {
						col.put(matrix[j][k], true);
					}
				}
			}
			int trace = 0;
			for(int j=0; j<N; j++)
				trace += matrix[j][j];
			System.out.println("Case #"+i+": " + trace + " " + rowCount + " " + colCount);
			row.clear();
			col.clear();
		}
		scanner.close();
	}

}
