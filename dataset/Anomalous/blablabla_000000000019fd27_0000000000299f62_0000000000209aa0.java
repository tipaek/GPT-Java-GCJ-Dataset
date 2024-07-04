import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int caseId = 1; caseId <= t; caseId++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            int[][] matrix = generateMatrix(n, k);

            if (matrix == null) {
                System.out.println("Case #" + caseId + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseId + ": POSSIBLE");
                System.out.print(formatMatrix(matrix));
            }
        }
    }

    private static String formatMatrix(int[][] matrix) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result.append(matrix[i][j]).append(' ');
            }
            result.append(System.lineSeparator());
        }
        return result.toString();
    }

    private static int[][] generateMatrix(int n, int k) {
        int trace = 0;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            int val = i + 1;
            for (int j = 0; j < n; j++) {
                matrix[i][j] = val;
                val = (val % n) + 1;

                if (i == j) {
                    trace += matrix[i][j];
                }
            }
        }

        if (trace == k) {
            return matrix;
        } else {
            return null;
        }
    }
}