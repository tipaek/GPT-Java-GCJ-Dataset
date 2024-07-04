
import java.util.*;
import java.io.*;

public class Solution {
	  public static void main(String[] args) {
		    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		    int t = in.nextInt();  
		    for (int x = 1; x <= t; x++) {
		      int n = in.nextInt();
		      int[][] matrix = new int[n][n];
		      int k = in.nextInt();
		      

		      for (int i = 0; i < n; i++) {
			      for (int j = 0; j < n; j++) {
			    	  matrix[i][j] = (i+j)%n+1;
			      }
		      }
		      

		      matrix = scramble(matrix, 0, k, n);
		      int realK = 0;
		      for (int i = 0; i < n; i++) realK+=matrix[i][i];

		      if (realK==k) {
			      System.out.println("Case #" + x + ": POSSIBLE");
	
			      for (int i = 0; i < n; i++) {
				      for (int j = 0; j < n; j++) {
				    	  System.out.print(""+matrix[i][j]+" ");
				      }
				      System.out.println("");
			      }
		      } else System.out.println("Case #" + x + ": IMPOSSIBLE");

		    }
		}
	  
	  private static int[][] scramble (int[][] matrix, int start, int k, int n) {
		  int realK=0;
		  for (int i = 0; i < n; i++) realK+=matrix[i][i];
		  if (realK==k) return matrix;

		  for (int i=start+1; i<n; i++) {
	    	  int[] temp = matrix[start];
	    	  matrix[start]=matrix[i];
	    	  matrix[i]=temp;
	    	  matrix = scramble(matrix, start+1,k,n);
			  for (int j = 0; j < n; j++) realK+=matrix[j][j];
			  if (realK==k) return matrix;
		  }
		  
		  return matrix;
	  }
}