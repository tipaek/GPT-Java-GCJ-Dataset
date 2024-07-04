
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

            int[][] matrix = generate(n, k);

            if (matrix == null) {
                System.out.println("Case #" + caseId + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseId + ": POSSIBLE");
                System.out.println(printArray(matrix));
            }
        }
    }

    private static StringBuilder printArray(int[][] matrix) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                result.append(matrix[j][i]).append(' ');
            }
            if (i != matrix.length - 1) {
                result.append(System.lineSeparator());
            }
        }
        return result;
    }

    private static int[][] generate(int n, int k) {
        int trace = 0;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            int val = i;
            for (int j = 0; j < n; j++) {
                matrix[j][i] = (val % n) + 1;
                val++;

                if (i == j) {
                    trace += matrix[j][i];
                }
            }
        }

        if (trace == k) {
            return matrix;
        } else {

            return null;
        }
    }

    private static String generate2(int n, int diagVal) {
        StringBuilder matrix = new StringBuilder();
        boolean[][] colVals = new boolean[n][n + 1];

        // column
        for (int i = 0; i < n; i++) {

            boolean[] rowVals = new boolean[n + 1];

            // row
            for (int j = 0; j < n; j++) {
                rowVals[diagVal] = true;

                if (i == j) {
                    matrix.append(diagVal).append(' ');
                    colVals[j][diagVal] = true;
                } else {
                    boolean added = false;
                    for (int x = 1; x <= n; x++) {
                        if (!rowVals[x] && !colVals[j][x]) {
                            // x can be added
                            rowVals[x] = true;
                            colVals[j][x] = true;
                            matrix.append(x).append(' ');
                            added = true;
                        }
                    }
                    if (!added) {
                        System.err.println("matrix " + matrix.toString());
                        return null;
                    }
                }
            }

            matrix.append(System.lineSeparator());
        }
        return matrix.toString();
    }
}
