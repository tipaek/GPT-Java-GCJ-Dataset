import java.util.*;

public class Solution {

    private static int[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            matrix = new int[n][n];

            for (int row = 0; row < n; row++) {
                int value = row;
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = value + 1;
                    value = (value + 1) % n;
                }
            }

            int trace = calculateTrace(n);

            if (trace == k) {
                printResult(caseNumber, "POSSIBLE", n);
            } else {
                String result = "IMPOSSIBLE";
                for (int row = 0; row < n - 1; row++) {
                    for (int nextRow = row + 1; nextRow < n; nextRow++) {
                        int newTrace = trace - matrix[row][row] - matrix[nextRow][nextRow] + matrix[row][nextRow] + matrix[nextRow][row];
                        if (newTrace == k) {
                            result = "POSSIBLE";
                            swapRows(row, nextRow, n);
                            break;
                        }
                    }
                    if (result.equals("POSSIBLE")) {
                        break;
                    }
                }

                if (result.equals("POSSIBLE")) {
                    printResult(caseNumber, "POSSIBLE", n);
                } else {
                    System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                }
            }
        }
    }

    private static int calculateTrace(int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static void swapRows(int row1, int row2, int n) {
        for (int col = 0; col < n; col++) {
            int temp = matrix[row1][col];
            matrix[row1][col] = matrix[row2][col];
            matrix[row2][col] = temp;
        }
    }

    private static void printResult(int caseNumber, String result, int n) {
        System.out.println("Case #" + caseNumber + ": " + result);
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}