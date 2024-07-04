import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; i++) { // each case
          int n = in.nextInt();
          int[][] matrix = new int[n][n];
          int mastersum = (n*(n+1))/2;
          int hk = 0;
          int r = 0;
          int c = 0;
          for (int j = 0; j < n; j++){ // each row
            int sum = 0;
            for (int k = 0; k < n; k++){ // each column
              matrix[j][k] = in.nextInt();
              sum += matrix[j][k];
            }
            if (sum != mastersum) r++;
          }
          for (int x = 0; x < n; n++){
            hk += matrix[x][x];
          }
          for (int l = 0; l < n; l++){ //each column
            int colsum = 0;
            for (int m = 0; m < n; m++){ // each row
              colsum += matrix[m][l];
            }
            if (colsum != mastersum) c++;
          }
          for (int y = 0; y < n; y++){ //each column
            for (int z = 0; z < n; z++){ // each row
              System.out.print(matrix[y][z]);
            }
            System.out.println();
          }
          System.out.println("Case #" + i + ": " + hk + " " + r + " " + c);
        }
    }
}