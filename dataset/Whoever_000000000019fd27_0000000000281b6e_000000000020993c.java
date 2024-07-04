import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int numTests  = scanner.nextInt();
		
		for(int i = 0; i < numTests; i++) {
			int n = scanner.nextInt();
			int[][] mat = new int[n][n];
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++)
					mat[j][k] = scanner.nextInt();
			}
			int[] res = result(mat);
			System.out.println("Case #" + (i + 1) + ": " + res[0] + " " + res[1] + " " + res[2]);
		}
	}


	static int[] result(int[][] mat) {

		int trace = 0;
		for(int i = 0; i < mat.length; i++)
			trace += mat[i][i];

		int n = mat.length;
		int numRows = 0;
		for(int i = 0; i < n; i++) {
			Set<Integer> elements = new HashSet<>();
			for(int j = 0; j < n; j++) {
				if(!elements.add(mat[i][j])) {
					numRows++;
					break;
				}
			}	
		}

		int numCols = 0;
		for(int i = 0; i < n; i++) {
			Set<Integer> elements = new HashSet<>();
			for(int j = 0; j < n; j++) {
				if(!elements.add(mat[j][i])) {
					numCols++;
					break;
				}
			}	
		}
	
		int[] res = new int[3];
		res[0] = trace;
		res[1] = numRows;
		res[2] = numCols;

		return res;
	}

}