
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
		      
		      int realK = 0;
		      for (int j1=0; j1<n; j1++) {
			      for (int j2=0; j2<n; j2++) {
			    	  int[] temp = matrix[j1];
			    	  matrix[j1]=matrix[j2];
			    	  matrix[j2]=temp;
				      for (int i = 0; i < n; i++) realK+=matrix[i][i];
				      if (realK==k) break;
				      else {
				    	  temp = matrix[j2];
				    	  matrix[j2]=matrix[j1];
				    	  matrix[j1]=temp;
				      }
				      
			      }
			      if (realK==k) break;
		    	  
		      }

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
}