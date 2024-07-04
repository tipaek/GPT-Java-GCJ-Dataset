import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; i++) {
            int N = scanner.nextInt();
            scanner.nextLine();
            int[][] matrix = new int[N][N];

            for (int a = 0; a < N; a++) {
                String[] row = scanner.nextLine().split(" ");
                for (int b = 0; b < N; b++) {
                    matrix[a][b] = Integer.parseInt(row[b]);
                }
            }

            solve(i, N, matrix);
        }
    }

    private static void solve(int testCase, int N, int[][] matrix) {
        int trace = calculateTrace(matrix, N);
        int rowsCount = countLatinSquareRows(matrix, N);
        int columnsCount = countLatinSquareColumns(matrix, N);

        System.out.println("Case #" + testCase + ": " + trace + " " + rowsCount + " " + columnsCount);
    }

    private static int calculateTrace(int[][] matrix, int N) {
        int trace = 0;
        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countLatinSquareRows(int[][] matrix, int N) {
        int rowsCount = 0;
        for (int i = 0; i < N; i++) {
            if (hasDuplicates(matrix[i])) {
                rowsCount++;
            }
        }
        return rowsCount;
    }

    private static int countLatinSquareColumns(int[][] matrix, int N) {
        int columnsCount = 0;
        for (int i = 0; i < N; i++) {
            int[] column = new int[N];
            for (int j = 0; j < N; j++) {
                column[j] = matrix[j][i];
            }
            if (hasDuplicates(column)) {
                columnsCount++;
            }
        }
        return columnsCount;
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }
}