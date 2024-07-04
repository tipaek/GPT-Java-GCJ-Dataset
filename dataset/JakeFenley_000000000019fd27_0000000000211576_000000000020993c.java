import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    int t = scnr.nextInt();
    for (int cas = 0; cas < t; cas++) { // Each file
      int n = scnr.nextInt();
      
      int k = 0, r = 0, c = 0;
    
      int[][] matrix = new int[n][n];
      for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
          if (i == j) {
            int temp = scnr.nextInt();
            k += temp;
            matrix[i][j] = temp;
          }
          matrix[i][j] = scnr.nextInt(); // Fill matrix
        }
      }
      
//      for (int i = 0; i < n; ++i) {
//        
//      }
      
      System.out.println("Case: #" + (cas + 1) + " " + k);
      
    }
    
  }

}
