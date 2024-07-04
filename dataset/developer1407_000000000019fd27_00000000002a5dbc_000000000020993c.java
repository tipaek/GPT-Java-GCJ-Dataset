 import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt(); //rows, cols
          int[][] mat = new int [n][n];
          
          for (int j = 0;  j< n; j++) {
            for(int k = 0 ; k < n; k++) {
                mat[i][j] = in.nextInt();
            }
          }
          trace(mat, i);
        }
        
    }
    
    public static void trace(int[][] mat, int n) {
        int trace = 0;
        int r = mat[0][0];
        int c = mat[0][0];
        int sr = 0, sc = 0;
        for(int i = 1; i <= mat.length; i++) {
            for(int j = 1; j <= mat.length; j++) {
                if( i == j) {
                    trace += mat[i][j];
                }
                
                if(mat[i][j] == r)
                    sr++;
                if(mat[i][j] == c)
                    sc++;
            }
        }
        System.out.println("Case #" + n + ": " + trace + " " + sr + " " + sc);
    }
}