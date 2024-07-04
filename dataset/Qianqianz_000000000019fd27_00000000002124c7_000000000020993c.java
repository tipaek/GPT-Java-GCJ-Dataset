    import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; i++) {
          int size = in.nextInt();
          int[][] matrix = new int[size][size];
          for(int j = 0; j < size; j++)
          {
              for(int k = 0; k < size; k ++)
              {
                matrix[j][k] = in.nextInt();
              }
          }
          int trace = 0;
          int r = 0;
          int c = 0;
          for (int j = 0; j < size; j++) {
            trace += matrix[j][j];
            Set<Integer> row = new HashSet();
            Set<Integer> col = new HashSet();
            for(int k = 0; k<size;k++)
            {
              row.add(matrix[j][k]);
              col.add(matrix[k][j]);
            }
            if(row.size() < size) {
              r+=1;
            }
            if(col.size() < size) {
              c+=1;
            }
          }
          System.out.println("Case #" + i + ": " + trace + " " + r + " " + c);
        }
      }
    }