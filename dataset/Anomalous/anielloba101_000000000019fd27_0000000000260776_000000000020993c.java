import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int caseNumber = 1;

        while (T-- > 0) {
            int N = in.nextInt();
            int[][] matrix = new int[N][N];
            int sum = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = in.nextInt();
                    if (i == j) {
                        sum += matrix[i][j];
                    }
                }
            }

            int repeatedRows = countRepeatedRows(matrix);
            int repeatedCols = countRepeatedCols(matrix);

            System.out.println("Case #" + caseNumber + ": " + sum + " " + repeatedRows + " " + repeatedCols);
            caseNumber++;
        }
    }

    private static int countRepeatedRows(int[][] matrix) {
        int count = 0;

        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                count++;
            }
        }

        return count;
    }

    private static int countRepeatedCols(int[][] matrix) {
        int count = 0;
        int N = matrix.length;

        for (int col = 0; col < N; col++) {
            int[] column = new int[N];
            for (int row = 0; row < N; row++) {
                column[row] = matrix[row][col];
            }
            if (hasDuplicates(column)) {
                count++;
            }
        }

        return count;
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int value : array) {
            if (!seen.add(value)) {
                return true;
            }
        }
        return false;
    }
}