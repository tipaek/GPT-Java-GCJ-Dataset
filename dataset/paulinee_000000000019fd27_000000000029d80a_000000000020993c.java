import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int tt = kb.nextInt();
		for(int t = 0; t < tt; t++) {
			int n = kb.nextInt();
			int[][] matrix = new int[n][n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					matrix[i][j] = kb.nextInt();
				}
			}
			int sum = 0;
			for(int i = 0; i < n; i++) {
				sum += matrix[i][i];

			}

			int rows = 0;
			for(int i = 0; i < n; i++) {
				boolean[] seen = new boolean[n+1];
				for(int j = 0; j < n; j++) {
					int el = matrix[i][j];
					if(seen[el]) {
						rows++; 
						break;
					}
					seen[el] = true;
				}
			}
			
			int cols = 0;
			for(int i = 0; i < n; i++) {
				boolean[] seen = new boolean[n+1];
				for(int j = 0; j < n; j++) {
					int el = matrix[j][i];
					if(seen[el]) {
						cols++; 
						break;
					}
					seen[el] = true;
				}
			}
			System.out.println("Case #"+(t+1)+": "+sum+" "+rows+" "+cols);

		}
	}
}
