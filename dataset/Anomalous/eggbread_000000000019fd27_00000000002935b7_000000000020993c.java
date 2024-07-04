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

            // Read matrix and calculate diagonal sum
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    int value = scanner.nextInt();
                    matrix[j][k] = value;
                    if (j == k) {
                        diagonalSum += value;
                    }
                }
            }

            // Check for duplicate elements in each row
            for (int j = 0; j < N; j++) {
                boolean[] seen = new boolean[N + 1];
                boolean hasDuplicates = false;
                for (int k = 0; k < N; k++) {
                    if (seen[matrix[j][k]]) {
                        hasDuplicates = true;
                        break;
                    }
                    seen[matrix[j][k]] = true;
                }
                if (hasDuplicates) {
                    duplicateRows++;
                }
            }

            // Check for duplicate elements in each column
            for (int j = 0; j < N; j++) {
                boolean[] seen = new boolean[N + 1];
                boolean hasDuplicates = false;
                for (int k = 0; k < N; k++) {
                    if (seen[matrix[k][j]]) {
                        hasDuplicates = true;
                        break;
                    }
                    seen[matrix[k][j]] = true;
                }
                if (hasDuplicates) {
                    duplicateCols++;
                }
            }

            System.out.println(diagonalSum + " " + duplicateRows + " " + duplicateCols);
        }
    }
}