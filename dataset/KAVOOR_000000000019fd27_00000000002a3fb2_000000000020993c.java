import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    int n = in.nextInt();
    
    for (int i = 1; i <= t; ++i) {
        int[][] mat = new int [n][n];
        for (int j = 0; j < n; j++){
            for (int k =0; k< n; k++){
                mat[j][k] = in.nextInt();
            }
        }
        
        // for (int m = 0; m < n; m++) {
        //     for (int l = 0; l < mat[m].length; l++) {
        //       System.out.print(mat[m][l] + " ");   
        //     }
        //     System.out.print("\n");
        // }
      
        int k = trace(mat, n);
        int r = num_rows(mat, n);
        int c = num_cols(mat, n);
      
      System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
    }
  }
  
  public static int num_rows(int[][] mat, int n){
    int r = 0;
    // System.out.println(n);
    for (int i = 0; i < n; i++) {
        boolean arr[] = new boolean[n];
        for (int j = 0; j < n; j++){
            // System.out.println(mat[j][i]);
            if (arr[mat[j][i] - 1]){
                r = r + 1;
                break;
            }
            arr[mat[j][i]-1] = true;
        }
    }
    return r;
  }
  
  public static int num_cols(int[][] mat, int n){
    int c = 0;
    for (int i = 0; i < n; i++) {
        boolean arr[] = new boolean[n];
        for (int j = 0; j < n; j++){
            // System.out.println(mat[j][i]);
            if (arr[mat[i][j] - 1]){
                c = c + 1;
                break;
            }
            arr[mat[i][j]-1] = true;
        }
    }
    return c;
  }
  
  public static int trace(int[][] mat, int n){
      int trace = 0;
      for (int i = 0; i < n; i++){
        trace = trace + mat[i][i];
      }
      return trace;
  }
}