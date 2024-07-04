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
      			matrix[j][i] = in.nextInt();
      		}
      	}
      	String sol = solve(matrix);
      System.out.println("Case #" + x + ": " + sol.substring(0,1) + " " + sol.substring(1,2) +
      	" " + sol.substring(2,3));
    }
  }
  String solve(int[][] input) {
  	int n = input.length;
  	int col = 0;
  	int row = 0;
  	int trace = 0;
  	for (int i = 0; i < n; i++) {
    		for (int j = 0; j < n; j++){
    			if (i == 0 && j == 0 || i == 1 && j == 1 || i == 2 && j == 2 || i == 3 && j == 3) {
    				trace++;
    			}
      			if (i+1 < n && j+1 < n) {
      				if (input[j][i] == input[j][i+1]){
      					col++;
      				}
      				if (input[j][i] == input[j+1][i]){
      					row++;
      				}
      			}
      			if (i+2 < n && j+2 < n) {
      				if (input[j][i] == input[j][i+2]){
      					col++;
      				}
      				if (input[j][i] == input[j+2][i]){
      					row++;
      				}
      			}
      			if (i+3 < n && j+3 < n) {
      				if (input[j][i] == input[j][i+3]){
      					col++;
      				}
      				if (input[j][i] == input[j+3][i]){
      					row++;
      				}
      			}
      		}
      	}
    return trace + "" + row + "" + col;
  }
}