import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt(); //size of matrix
          int[][] matrix = new int[n][n];
          int trace = 0;
          int row_dup = 0;
          int col_dup = 0;
          for (int j = 0; j < n; j++) {
        	  	Set<Integer> row = new HashSet<>();
        	  	boolean flag = true;
        	  	for (int k = 0; k < n; k++) {
        	  		matrix[j][k] = in.nextInt();
        	  		if(!row.add(matrix[j][k]) && flag) {
        	  			row_dup++;
        	  			flag = false;
        	  		}
        	  		if(j == k) {
        	  			trace += matrix[j][k];
        	  		}
        	  	}
          }
          for (int k = 0; k < n; k++) {
      	  	Set<Integer> col = new HashSet<>();
      	  	boolean flag = true;
      	  	for (int j = 0; j < n; k++) {
      	  		if(!col.add(matrix[j][k]) && flag) {
      	  			col_dup++;
      	  			flag = false;
      	  		}
      	  	}
        }
        System.out.println("Case #" + i + ": " + trace + " " + row_dup + " " + col_dup);
        }
      }
    }
  
