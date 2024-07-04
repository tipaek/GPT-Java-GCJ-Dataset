import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();
          int matrix[][] = new int[n][n];
          
          //Reading the Matrix
          for( int j = 0; j < n; j++) {
        	  for( int k = 0; k < n; k++ )
        	  {
        		  matrix[j][k] = in.nextInt();
        	  }
        	
          }
          
          // Calculating Trace
          int trace = 0;
          for( int j=0; j < n; j++) {
        	  trace += matrix[j][j];
          }
          
          //Counting row duplicates 
          int rowDups = 0;
          for (int j = 0; j < n; j++) 
          {
			int[] row = matrix[j];
			boolean[] s = new boolean[n+1];
			for (int k = 0; k < row.length; k++) {
				if( s[row[k]])
				{
					rowDups++;
					break;
				}
				s[row[k]] = true;
			}
          }
          
          //Counting Col Duplicates
          int colDups = 0;
          for(int k = 0; k < n; k++) {
        	  boolean[] s = new boolean[n+1];
        	  for (int j = 0; j < n; j++) {
				if( s[matrix[j][k]]) {
					colDups++;
					break;
				}
				s[matrix[j][k]] = true; 
			}
          }
          System.out.println("Case #"+i+": " + trace + " " + rowDups + " " + colDups);  
        }
        in.close();
      }
      
    }
