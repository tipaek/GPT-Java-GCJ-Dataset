import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int x = 1; x <= t; ++x) {
            int n = in.nextInt();
            int[][] matrix = convertToArrray(n, in);
            vestigium(matrix, x);
        }
    }

    public static void vestigium(int[][] matrix, int x) {
        int k = 0;
        int r = 0;
        int c = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] rowValues = new int[100];
            int[] columnValues = new int[100];
            boolean isRowValueRepeated = false;
            boolean isColumnValueRepeated = false;
            for (int j = 0; j < matrix[i].length; j++) {
                int rowNum = matrix[i][j];
                int colNum = matrix[j][i];

                if (i == j) k += rowNum;
                if (!isRowValueRepeated && rowValues[rowNum] == 1) {
                    r++;
                    isRowValueRepeated = true;
                }

                if (!isColumnValueRepeated && columnValues[colNum] == 1) {
                    c++;
                    isColumnValueRepeated = true;
                }

                rowValues[rowNum] = 1;
                columnValues[colNum] = 1;
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

