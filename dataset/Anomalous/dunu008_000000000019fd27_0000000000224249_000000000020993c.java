import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = createScanner();

        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; i++) {
            int N = scanner.nextInt();
            scanner.nextLine();
            int[][] matrix = new int[N][N];

            for (int row = 0; row < N; row++) {
                String[] line = scanner.nextLine().split(" ");
                for (int col = 0; col < N; col++) {
                    matrix[row][col] = Integer.parseInt(line[col]);
                }
            }

            solve(i, N, matrix);
        }
    }

    private static void solve(int testCase, int N, int[][] matrix) {
        int trace = 0;
        int rowCount = 0;
        int colCount = 0;

        // Calculate trace
        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
        }

        // Calculate row duplicates
        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                rowCount++;
            }
        }

        // Calculate column duplicates
        for (int col = 0; col < N; col++) {
            int[] column = new int[N];
            for (int row = 0; row < N; row++) {
                column[row] = matrix[row][col];
            }
            if (hasDuplicates(column)) {
                colCount++;
            }
        }

        System.out.printf("Case #%d: %d %d %d%n", testCase, trace, rowCount, colCount);
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int num : array) {
            if (seen[num]) {
                return true;
            }
            seen[num] = true;
        }
        return false;
    }

    private static Scanner createScanner() {
        return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    }
}