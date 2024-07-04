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
          for( int j=0,k=0; j < n && k < n; j++,k++ ) {
        	  trace += matrix[j][k];
          }
          
          //Counting row duplicates 
          int rowDups = 0;
          for (int j = 0; j < n; j++) 
          {
			int[] row = matrix[j];
			String s = "";
			for (int k = 0; k < row.length; k++) {
				if( s.contains(row[k]+"")) 
				{
					rowDups++;
					break;
				}
				s = s + row[k];
			}
          }
          
          //Counting Col Duplicates
          int colDups = 0;
          for(int k = 0; k < n; k++) {
        	  String s = "";
        	  for (int j = 0; j < n; j++) {
				if( s.contains(matrix[j][k]+"")) {
					colDups++;
					break;
				}
				s = s + matrix[j][k]; 
			}
          }
          System.out.println("Case #"+t+": " + trace + " " + rowDups + " " + colDups);  
        }
        in.close();
      }
      
    }