import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int t = in.nextInt();
      for (int i = 1; i <= t; ++i) {
    	int n = in.nextInt();
    	int[][] matrix = new int[n][];
    	for(int j = 0; j < n; j++) {
    		matrix[j] = new int[n];
    		for(int k = 0; k < n; k++) {
    			matrix[j][k] = in.nextInt();
    		}
    	}
        System.out.println("Case #" + i + ": " + solve(matrix, n));
      }
      in.close();
    }

	private static String solve(int[][] matrix, int n) {
		int trace = 0;
		for(int i = 0; i < n; i++)
			trace += matrix[i][i];
		
		int r = 0;
		for(int i = 0; i < n; i++) {
			boolean[] appeared = new boolean[n];
			for(int j = 0; j < n; j++) {
				if(appeared[matrix[i][j]-1]) {
					r++;
					break;
				}
				appeared[matrix[i][j]-1] = true;
			}
		}
		
		int c = 0;
		for(int j = 0; j < n; j++) {
			boolean[] appeared = new boolean[n];
			for(int i = 0; i < n; i++) {
				if(appeared[matrix[i][j]-1]) {
					c++;
					break;
				}
				appeared[matrix[i][j]-1] = true;
			}
		}
			
		return trace+" "+r+" "+c;
	}
	
}
