import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] latinMatrix = createLatinMatrix(n);
            Possibility possibility = new Possibility();
            checkPossibility(n, latinMatrix, k, caseNum, possibility);
            if (!possibility.possible) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }
    }

    static int[][] createLatinMatrix(int n) {
        int[][] matrix = new int[n][n];
        int k = n + 1;
        for (int row = 0; row < n; row++) {
            int col = 0;
            int temp = k;
            while (temp <= n) {
                matrix[row][col++] = temp++;
            }
            for (int j = 1; j < k; j++) {
                matrix[row][col++] = j;
            }
            k--;
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static boolean isPossible(int[][] matrix, int trace) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum == trace;
    }

    public static void checkPossibility(int n, int[][] matrix, int trace, int caseNum, Possibility possibility) {
        if (isPossible(matrix, trace)) {
            System.out.println("Case #" + caseNum + ": POSSIBLE");
            printMatrix(matrix);
            possibility.possible = true;
            return;
        }

        if (n > 1) {
            for (int i = 0; i < n - 1; i++) {
                checkPossibility(n - 1, matrix, trace, caseNum, possibility);
                if (n % 2 == 0) {
                    swap(matrix, i, n - 1);
                } else {
                    swap(matrix, 0, n - 1);
                }
            }
            checkPossibility(n - 1, matrix, trace, caseNum, possibility);
        }
    }

    private static void swap(int[][] matrix, int a, int b) {
        int[] temp = matrix[a];
        matrix[a] = matrix[b];
        matrix[b] = temp;
    }

    static class Possibility {
        boolean possible = false;
    }
}