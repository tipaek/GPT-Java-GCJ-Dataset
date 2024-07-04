import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
	public static void main(String[] args) {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int i = 1; i <= t; ++i) {
	      int n = in.nextInt();
	      int[][] mat = new int[n][n];
	      for (int j = 0; j < n; j++) {
	      	for (int k = 0; k < n; k++) {
	      		mat[j][k] = in.nextInt();
	      	}
	      }
	      System.out.println("Case #" + i + ": " + solve(mat));
	    }
  	}

  	public static String solve(int[][] mat){
  		int trace = 0, rows = 0, cols = 0;
  		int n = mat.length;

  		// Row
  		for (int i = 0; i < n; i++) {
  			Set<Integer> set = new HashSet<>();
  			for (int j = 0; j < n; j++) {
  				if (set.contains(mat[i][j])) {
  					rows++;
  					break;
  				} else {
  					set.add(mat[i][j]);
  				}
  			}
  		}

  		for (int j = 0; j < n; j++) {
  			Set<Integer> set = new HashSet<>();
  			for (int i = 0; i < n; i++) {
  				if (set.contains(mat[i][j])) {
  					cols++;
  					break;
  				} else {
  					set.add(mat[i][j]);
  				}
  			}
  		}

  		for (int i = 0; i < n; i++) trace += mat[i][i];
  		return trace + " " + rows + " " + cols;
  	}
}
