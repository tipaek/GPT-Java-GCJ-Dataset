    import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int row = 0;
            int col = 0;
            for (int j = 0; j < n; ++j) {
                Set<Integer> duplicates = initializeSet(n);
                for (int k = 0; k < n; ++k) {
                    matrix[j][k] = in.nextInt();
                    if(j == k) {
                        trace = trace + matrix[j][k];
                    }
                    duplicates.remove(matrix[j][k]);
                }
                if(!duplicates.isEmpty()) {
                    row++;
                }
            }
            
            for (int j = 0; j < n; ++j) {
                Set<Integer> duplicates = initializeSet(n);
                for (int k = 0; k < n; ++k) {
                    duplicates.remove(matrix[k][j]);
                }
                if(!duplicates.isEmpty()) {
                    col++;
                }
            }
            
            System.out.println("Case #" + i + ": " + trace + " " + row + " " + col);
        }
      }
      
      private static Set<Integer> initializeSet(int n) {
        Set<Integer> duplicates = new HashSet<>();
        for (int j = 1; j <= n; ++j) {
            duplicates.add(j);
        }
        return duplicates;
      }
    }