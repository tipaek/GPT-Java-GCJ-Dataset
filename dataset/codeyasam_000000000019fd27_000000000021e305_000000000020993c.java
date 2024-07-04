import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int x = 1; x <= t; ++x) {
            int n = in.nextInt();
            int[][] matrix = convertToArrray(n, in);
            vestigium(matrix, n, x);
        }
    }

    public static void vestigium(int[][] matrix, int n, int x) {
        int k = 0;
        int r = 0;
        int c = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> rowValues = new HashSet<>();
            Set<Integer> columnValues = new HashSet<>();
            boolean isRowValueRepeated = false;
            boolean isColumnValueRepeated = false;
            for (int j = 0; j < n; j++) {
                int rowNum = matrix[i][j];
                int colNum = matrix[j][i];

                if (i == j) k += rowNum;
                if (!isRowValueRepeated && rowValues.contains(rowNum)) {
                    r++;
                    isRowValueRepeated = true;
                }

                if (!isColumnValueRepeated && columnValues.contains(colNum)) {
                    c++;
                    isColumnValueRepeated = true;
                }

                rowValues.add(rowNum);
                columnValues.add(colNum);
            }
        }   

        System.out.println("Case #" + x + ": " + k + " " + r + " " + c);
    }

    private static int[][] convertToArrray(int n, Scanner in) {
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = in.nextInt();
            }
        }
        return result;
    }
}

