import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static int[][] generateMatrix(int n, int trace) {
        int start = findStartingValue(n, trace);
        if (start == 0) {
            return null;
        }

        int[] arr = generateSequence(n, start);
        return buildMatrix(n, arr);
    }

    private static int findStartingValue(int n, int trace) {
        for (int i = 1; i <= n; i++) {
            if (trace == i * n) {
                return i;
            }
        }
        return 0;
    }

    private static int[] generateSequence(int n, int start) {
        int[] sequence = new int[n];
        int value = start;
        for (int i = 0; i < n; i++) {
            sequence[i] = value;
            value = (value % n) + 1;
        }
        return sequence;
    }

    private static int[][] buildMatrix(int n, int[] sequence) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            int index = 0;
            for (int j = n - i; j < n; j++) {
                matrix[i][index++] = sequence[j];
            }
            for (int j = 0; j < n - i; j++) {
                matrix[i][index++] = sequence[j];
            }
        }
        return matrix;
    }

    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int caseNum = 1; caseNum <= testCases; caseNum++) {
                int n = scanner.nextInt();
                int k = scanner.nextInt();
                int[][] result = generateMatrix(n, k);

                if (result != null) {
                    System.out.println("Case #" + caseNum + ": POSSIBLE");
                    printMatrix(result);
                } else {
                    System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
                }
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                if (i > 0) {
                    System.out.print(" ");
                }
                System.out.print(row[i]);
            }
            System.out.println();
        }
    }
}