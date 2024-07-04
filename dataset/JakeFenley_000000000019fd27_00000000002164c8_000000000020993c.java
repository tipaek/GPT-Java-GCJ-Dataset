import java.util.Arrays;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    int t = scnr.nextInt();
    //System.out.println("Total cases: " + t);
    
    for (int cas = 0; cas < t; cas++) { // Each file
      //System.out.println("Cases: " + cas);

      int n = scnr.nextInt();
      //System.out.println("Size" + n);

      int k = 0;
      int r = 0;
      int c = 0;
    
      int[][] matrix = new int[n][n];
      int[][] copy = new int[n][n];
      
      
      
      for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
          int temp = scnr.nextInt();
          if (i == j) {
            k += temp;
          }
          matrix[i][j] = temp; // Fill matrix
          copy[i][j] = temp;
        }
      }
      
      
      
      for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
          if(matrix[i][Math.abs(matrix[i][j]) - 1] >= 0) {
            matrix[i][Math.abs(matrix[i][j]) - 1] *= -1;
          } else {
            r += 1;
            //System.out.println("Duplicate on row: " + i);
            break;
          }
        }
      }
      
      for (int j = 0; j < n; ++j) {
        for (int i = 0; i < n; ++i) {
          //System.out.print(i);
          //System.out.println(j);
          if(copy[Math.abs(copy[i][j]) - 1][j] >= 0) {
            copy[Math.abs(copy[i][j]) - 1][j] *= -1;
          } else {
            c += 1;
            //System.out.println("Duplicate on col: " + j + ", " + i);
            break;
          }
        }
      }
      
      System.out.println("Case #" + (cas + 1) + ": " + k + " " + r + " " + c);
      
    }
    
  }
}
