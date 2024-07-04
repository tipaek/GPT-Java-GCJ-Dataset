import java.util.*;
import java.io.*;
public class Solution {
  private static String soln(int[][] matrix) {
        int trace = 0, dupRows = 0, dupCols = 0;
        int size = matrix.length;
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();

        for (int r = 0; r < size; r++) {
            trace += matrix[r][r];

            for (int c = 0; c < size; c++) {
                rowSet.add(matrix[r][c]);
                colSet.add(matrix[c][r]);
            }

            if (colSet.size() != size) {
                dupCols++;
            }
            if (rowSet.size() != size) {
                dupRows++;
            }
            colSet.clear();
            rowSet.clear();
        }

        return String.format("%d %d %d", trace, dupRows, dupCols);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int matrixSize = in.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            for (int r = 0; r < matrixSize; r++) {
                for (int c = 0; c < matrixSize; c++) {
                    matrix[r][c] = in.nextInt();
                }
            }
            System.out.println("Case #" + i + ": " + soln(matrix));
        }
    }
}