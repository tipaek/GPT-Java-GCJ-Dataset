import java.util.*;
import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        
        int trace = 0;
        int row = 0;
        int column = 0;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int grid = in.nextInt();
          for (int j = 1; j<=grid; ++i){
            int[][]matrix = new int[grid][grid];
            for (int k = 1; j<=grid; ++i){
                matrix[j][k] = in.nextInt();
            }
          }
        
        for (int k=0;k<=matrix.length;k=k+1){
            for (int l=0;l<=matrix[0].length;l=l+1){
                if ((matrix[k][l]==matrix[k][l+1])||(matrix[k][l]==matrix[k][l+2])||(matrix[k][l]==matrix[k][l+3])||(matrix[k][l]==matrix[k][l+4])||(matrix[k][l+2]==matrix[k][l+3])||(matrix[k][l+3]==matrix[k][l+4])){
                     row = row+1;    
                }
            }
            for (int n=0;n<=matrix[0].length;n=n+1){
                if ((matrix[k][n]==matrix[k+1][n])||(matrix[k][n]==matrix[k+2][n])||(matrix[k][n]==matrix[k+3][n])||(matrix[k][n]==matrix[k+4][n])||(matrix[k+2][n]==matrix[k+3][n])||(matrix[k+3][n]==matrix[k+4][n])){
                    column = column+1;    
                }
            }
        }
        for (int x=0;x<=matrix.length;x=x+1){
            for (int y=0;y<=matrix[0].length;y=y+1){
                if (x==y){
                    trace = trace + matrix[x][y];
                }
        
            }
        }
          
        System.out.println("Case #" + i + ": " + row + " " + column + " " + trace);
        } 
      }
    }

