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
        int duplicateRows = 0;
        int duplicateCols = 0;

        // Calculate trace
        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
        }

        // Check for duplicate rows
        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                duplicateRows++;
            }
        }

        // Check for duplicate columns
        for (int col = 0; col < N; col++) {
            int[] column = new int[N];
            for (int row = 0; row < N; row++) {
                column[row] = matrix[row][col];
            }
            if (hasDuplicates(column)) {
                duplicateCols++;
            }
        }

        System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateCols);
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1]; // Assuming values are 1 to N
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }

    private static Scanner createScanner() {
        return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    }
}