import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int t = 1; t <= testCases; t++) {
            int N = scanner.nextInt();
            scanner.nextLine();
            int[][] matrix = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
            }
            solve(t, N, matrix);
        }
    }

    private static void solve(int testCase, int N, int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
        }

        int rowCount = countDuplicateRows(matrix);
        int colCount = countDuplicateCols(matrix);

        System.out.println("Case #" + testCase + ": " + trace + " " + rowCount + " " + colCount);
    }

    private static int countDuplicateRows(int[][] matrix) {
        int count = 0;
        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                count++;
            }
        }
        return count;
    }

    private static int countDuplicateCols(int[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] col = new int[matrix.length];
            for (int j = 0; j < matrix.length; j++) {
                col[j] = matrix[j][i];
            }
            if (hasDuplicates(col)) {
                count++;
            }
        }
        return count;
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
}