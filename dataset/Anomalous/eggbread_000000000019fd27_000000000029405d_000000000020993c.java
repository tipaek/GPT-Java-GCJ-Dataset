import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0, duplicateRows = 0, duplicateCols = 0;

            // Reading matrix and calculating trace
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }

            // Checking for duplicate rows
            for (int row = 0; row < N; row++) {
                if (hasDuplicates(matrix[row])) {
                    duplicateRows++;
                }
            }

            // Checking for duplicate columns
            for (int col = 0; col < N; col++) {
                int[] columnArray = new int[N];
                for (int row = 0; row < N; row++) {
                    columnArray[row] = matrix[row][col];
                }
                if (hasDuplicates(columnArray)) {
                    duplicateCols++;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + duplicateRows + " " + duplicateCols);
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