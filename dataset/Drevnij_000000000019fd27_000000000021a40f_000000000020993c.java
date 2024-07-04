
import java.util.*;
import java.io.*;

public class Vestigium {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  
    for (int x = 1; x <= t; x++) {
      int n = in.nextInt();
      int[][] matrix = new int[n][n];
      for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
        	  matrix[i][j] = in.nextInt();
          }
      }
      int k=0;
      int r=0;
      int c=0;

      for (int i = 0; i < n; i++) k+=matrix[i][i];

      for (int i = 0; i < n; i++) {
    	  Set<Integer> set = new HashSet<Integer>();
          for (int j = 0; j < n; j++) {
        	   if (set.contains(matrix[i][j])) {
        		   r++;
        		   break;
        	   } else set.add(matrix[i][j]);
          }
          set = new HashSet<Integer>();
          for (int j = 0; j < n; j++) {
       	   if (set.contains(matrix[j][i])) {
       		   c++;
       		   break;
       	   } else set.add(matrix[j][i]);
         }
          
      }
      
      
      System.out.println("Case #" + x + ": "+k+" "+r+" "+c);
    }
  }
}