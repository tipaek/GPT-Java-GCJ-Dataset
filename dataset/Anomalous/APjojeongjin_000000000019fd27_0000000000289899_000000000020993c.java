import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            int diagonalSum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            int rowCount = 0;
            int columnCount = 0;

            for (int i = 0; i < n; i++) {
                if (hasDuplicate(matrix[i])) {
                    rowCount++;
                }

                int[] column = new int[n];
                for (int j = 0; j < n; j++) {
                    column[j] = matrix[j][i];
                }
                if (hasDuplicate(column)) {
                    columnCount++;
                }
            }

            System.out.println("Case #" + testCase + ": " + diagonalSum + " " + rowCount + " " + columnCount);
        }
    }

    private static boolean hasDuplicate(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }
}