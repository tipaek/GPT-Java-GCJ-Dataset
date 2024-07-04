  import java.util.*;
  import java.io.*;
  public class Solution {

    public static boolean repeated_in_row(int[] row, int len){
      for(int i=0;i<len;i++){
        for(int j=0;j<len;j++){
          if(row[i]==row[j])
            return true;
        }
      }
      return false;
    }

    public static boolean repeated_in_col(int[] col, int len){
      for(int i=0;i<len;i++){
        for(int j=0;j<len;j++){
          if(col[i]==col[j])
            return true;
        }
      }
      return false;
    }

    public static void main(String[] args) {
      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

      for (int i = 1; i <= t; ++i) {
        int n = in.nextInt();
        int[][] latin_square = new int[n][n];
        int repeated_r = 0;  // rows contains repeated values
        int repeated_c = 0;  // columns contains repeated values
        int trace = 0;       // Sum of the values on the diagonal

        // Read the values of latin square
        for(int r=0; r<n; r++){
          for(int c=0; c<n; c++){
            latin_square[r][c] = in.nextInt();

            // Calc of trace
            if(r==c){
              trace += latin_square[r][c];
            }
          }

          // check if just readed row contains repeated values
          if (repeated_in_row(latin_square[r], n)){
            repeated_r += 1;
          }
        }

        int[] column = new int[n];

        // check if columns contains repeated values
        for(int c=0;c<n;c++){
          for(int r=0;r<n;r++){
            column[r] = latin_square[r][c];
          }

          if(repeated_in_col(column, n)){
            repeated_c += 1;
          }
        }

        System.out.println("Case #" + i + ": " + trace + " " + repeated_r + " " + repeated_c);
      }
    }
  }
