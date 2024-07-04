import java.util.*;
public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tC = sc.nextInt();
		
		for(int t = 1; t <= tC; t++) {
			
			int n = sc.nextInt();
			int[][] matrix = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					matrix[i][j] = sc.nextInt();
				}
			}
			
			int trace = 0;
			int r = 0;
			int c = 0;
			
			for(int i = 0; i < n; i++) {
				trace += matrix[i][i];
				
				Set<Integer> setRow = new HashSet<Integer>(n);
				Set<Integer> setCol = new HashSet<Integer>(n);
				setRow.add(matrix[i][0]);
				setCol.add(matrix[0][i]);
				
				for(int j = 1; j < n; j++) {
					if(setRow.contains(matrix[i][j])) {
						r++;
						break;
					}
					setRow.add(matrix[i][j]);
				}
				
				for(int j = 1; j < n; j++) {
					if(setCol.contains(matrix[j][i])) {
						c++;
						break;
					}
					setCol.add(matrix[j][i]);
				}
			}
			
			System.out.println("Case #" + t + ": " + trace + " " + r + " " + c);
			
		}
	}
}
