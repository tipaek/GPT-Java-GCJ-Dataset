import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] matrix = new int[n][n];

            if (isPossibleCase1(n, k)) {
                fillMatrixCase1(matrix, n, k);
                printSolution(caseNum, "POSSIBLE", matrix);
            } else if (isImpossibleCase(n, k)) {
                printSolution(caseNum, "IMPOSSIBLE", null);
            } else {
                if (solveCase(matrix, n, k)) {
                    printSolution(caseNum, "POSSIBLE", matrix);
                } else {
                    printSolution(caseNum, "IMPOSSIBLE", null);
                }
            }
        }
        scanner.close();
    }

    private static boolean isPossibleCase1(int n, int k) {
        return k % n == 0;
    }

    private static void fillMatrixCase1(int[][] matrix, int n, int k) {
        int diagonalElement = k / n;
        for (int i = 0; i < n; i++) {
            matrix[i][i] = diagonalElement;
            for (int j = 1; j < n; j++) {
                matrix[i][(j + i) % n] = (diagonalElement - 1 + j) % n + 1;
            }
        }
    }

    private static boolean isImpossibleCase(int n, int k) {
        return k == Math.pow(n, 2) - 1 || k == n + 1 || (n == 3 && (k == 5 || k == 7));
    }

    private static boolean solveCase(int[][] matrix, int n, int k) {
        for (int j = 1; j <= n; j++) {
            int remainder = k - (n - 2) * j;
            if (isValidRemainder(remainder, n, j)) {
                fillMatrix(matrix, n, j, remainder);
                return true;
            }
        }
        return false;
    }

    private static boolean isValidRemainder(int remainder, int n, int j) {
        return remainder % 2 == 0 && remainder <= 2 * n && remainder / 2 != j;
    }

    private static void fillMatrix(int[][] matrix, int n, int j, int remainder) {
        for (int i = 0; i < n - 2; i++) {
            matrix[i][i] = j;
            matrix[i][(i + 1) % (n - 2)] = remainder / 2;
        }
        for (int i = n - 2; i < n; i++) {
            matrix[i][i] = remainder / 2;
        }
        matrix[n - 2][n - 1] = j;
        matrix[n - 1][n - 2] = j;

        List<Integer> remainingNumbers = new ArrayList<>();
        for (int x = 1; x <= n; x++) {
            if (x != j && x != remainder / 2) {
                remainingNumbers.add(x);
            }
        }

        for (int i = 0; i < n - 2; i++) {
            matrix[i][n - 1] = remainingNumbers.get(i);
            matrix[(i + 1) % (n - 2)][n - 2] = remainingNumbers.get(i);
        }

        if (n > 4) {
            for (int i = 0; i < n - 2; i++) {
                matrix[i][(i + 2) % (n - 2)] = remainingNumbers.get((i + 1) % (n - 2));
            }
        }

        for (int i = 0; i < n - 2; i++) {
            matrix[n - 2][i] = remainingNumbers.get(i);
            matrix[n - 1][i] = remainingNumbers.get((i + 1) % (n - 2));
        }
    }

    private static void printSolution(int caseNum, String result, int[][] matrix) {
        System.out.println("Case #" + caseNum + ": " + result);
        if ("POSSIBLE".equals(result) && matrix != null) {
            for (int[] row : matrix) {
                System.out.println(Arrays.toString(row).replace("[", "").replace(",", "").replace("]", ""));
            }
        }
    }
}