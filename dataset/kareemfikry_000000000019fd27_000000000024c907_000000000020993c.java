import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = in.nextInt();
                }
            }

            int sum = 0;
            int rows = 0;
            int columns = 0;

            for (int j = 0; j < n; j++) {
                sum += matrix[j][j];
            }

            Set<Integer> rowRepeated;
            Set<Integer> columnsRepeated;

            boolean repeatedRows;
            boolean repeatedColumns;
            
            for (int j = 0; j < n; j++) {
                repeatedRows = false;
                repeatedColumns = false;
                rowRepeated = new HashSet<>();
                columnsRepeated = new HashSet<>();
                
                for (int k = 0; k < n; k++) {
                    if (repeatedRows && repeatedColumns) {
                        break;
                    }

                    if (!repeatedRows && rowRepeated.contains(matrix[j][k])) {
                        rows++;
                        repeatedRows = true;
                    }
                    
                    if (!repeatedColumns && columnsRepeated.contains(matrix[k][j])) {
                        columns++;
                        repeatedColumns = true;
                    }
                    
                    rowRepeated.add(matrix[j][k]);
                    columnsRepeated.add(matrix[k][j]);
                }
            }

            System.out.println("Case #" + i + ": " + sum + " " + rows + " " + columns);
        }
    }
}