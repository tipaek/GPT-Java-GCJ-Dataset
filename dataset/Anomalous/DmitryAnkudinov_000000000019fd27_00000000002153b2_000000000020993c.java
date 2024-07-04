import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int N = scanner.nextInt();

            int[][] matrix = new int[N][N];
            int rowCount = 0;
            int columnCount = 0;
            int trace = 0;

            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            for (int row = 0; row < N; row++) {
                trace += matrix[row][row];

                if (hasDuplicates(matrix[row])) {
                    rowCount++;
                }

                int[] column = new int[N];
                for (int col = 0; col < N; col++) {
                    column[col] = matrix[col][row];
                }
                if (hasDuplicates(column)) {
                    columnCount++;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowCount + " " + columnCount);
        }
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