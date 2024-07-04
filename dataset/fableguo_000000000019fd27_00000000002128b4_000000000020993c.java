import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
          int[][] matrix = new int[n][n];
          for(int j = 0; j < n; j++){
            for(int k = 0; k < n; k++){
                matrix[j][k] = in.nextInt();
            }
          }
          int sum = 0;
          int rowC = 0;
          int colC = 0;
          Set<Integer> row = new HashSet<Integer>();
          for(int j = 0; j < n; j++){
            sum += matrix[j][j];
          }
          for(int j = 0; j < n; j++){
              row = new HashSet<Integer>();
              for(int k = 0; k < n; k++){
                    // System.out.print(matrix[j][k] +" ");
                    if(!row.add(matrix[j][k])){
                        rowC++;
                        row = new HashSet<Integer>();
                        break;
                    }
              }
            //   System.out.println(" ");
          }
          for(int j = 0; j < n; j++){
              row = new HashSet<Integer>();
              for(int k = 0; k < n; k++){
                    if(!row.add(matrix[k][j])){
                        colC++;
                        row = new HashSet<Integer>();
                        break;
                    }
              }
          }

          
          System.out.println("Case #" + i + ": " + (sum) + " " + (rowC) + " " + (colC));
        }
      }
    }
  