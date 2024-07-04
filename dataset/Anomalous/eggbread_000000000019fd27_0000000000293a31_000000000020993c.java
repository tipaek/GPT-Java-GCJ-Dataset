import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            int diagonalSum = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            // Reading matrix and calculating diagonal sum
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        diagonalSum += matrix[row][col];
                    }
                }
            }

            // Checking for duplicate elements in rows
            for (int row = 0; row < N; row++) {
                boolean[] seen = new boolean[N + 1];
                boolean hasDuplicate = false;
                for (int col = 0; col < N; col++) {
                    if (seen[matrix[row][col]]) {
                        hasDuplicate = true;
                        break;
                    }
                    seen[matrix[row][col]] = true;
                }
                if (hasDuplicate) {
                    duplicateRows++;
                }
            }

            // Checking for duplicate elements in columns
            for (int col = 0; col < N; col++) {
                boolean[] seen = new boolean[N + 1];
                boolean hasDuplicate = false;
                for (int row = 0; row < N; row++) {
                    if (seen[matrix[row][col]]) {
                        hasDuplicate = true;
                        break;
                    }
                    seen[matrix[row][col]] = true;
                }
                if (hasDuplicate) {
                    duplicateCols++;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + diagonalSum + " " + duplicateRows + " " + duplicateCols);
        }
        
        scanner.close();
    }
}