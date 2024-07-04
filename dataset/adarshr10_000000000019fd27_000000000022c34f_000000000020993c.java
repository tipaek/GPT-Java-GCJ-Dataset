import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int x = 1; x <= t; ++x) {
    	int n = in.nextInt();
    	int[][] matrix = new int[n][n];
    	for (int i = 0; i < n; i++) {
    		for (int j = 0; j < n; j++){
      			matrix[i][j] = in.nextInt();
      		}
      	}
      	int[] sol = Solution.solve(matrix);
      System.out.println("Case #" + x + ": " + sol[0] + " " + sol[1] +
      	" " + sol[2]);
    }
  }
  static int[] solve(int[][] input) {
  	int n = input.length;
  	int col = 0;
  	int row = 0;
  	int trace = 0;
  	for (int i = 0; i < n; i++) {
		trace+=input[i][i];
	}
	for (int y = 0; y < n; y++) {
		for (int j = 0; j < n; j++) {
			for (int k = 1; k < n; k++) {
				if (j+k < n) {
      				if (input[y][j] == input[y][j+k]){
      					row++;
      					j=n;
      				}	 
      			}
  			}
		}
	}
	for (int x = 0; x < n; x++) {
		for (int i = 0; i < n; i++) {
			for (int k = 1; k < n; k++) {
				if (i+k < n) {
	      			if (input[i][x] == input[i+k][x]){
	      				col++;
	      				i=n;
	      			}
	      		}
  			}
		}
	}
    	
    return new int[]{trace, row, col};
  }
}