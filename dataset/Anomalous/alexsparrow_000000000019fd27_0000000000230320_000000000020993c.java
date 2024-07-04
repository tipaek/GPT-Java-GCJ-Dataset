import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            int diagonalSum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
                diagonalSum += matrix[i][i];
            }

            int rowDuplicates = countRowDuplicates(matrix, n);
            int colDuplicates = countColumnDuplicates(matrix, n);

            System.out.println(diagonalSum + " " + rowDuplicates + " " + colDuplicates);
        }
    }

    private static int countRowDuplicates(int[][] matrix, int n) {
        int rowDuplicates = 0;
        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[101]; // assuming values are between 1 and 100
            for (int j = 0; j < n; j++) {
                if (seen[matrix[i][j]]) {
                    rowDuplicates++;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
        }
        return rowDuplicates;
    }

    private static int countColumnDuplicates(int[][] matrix, int n) {
        int colDuplicates = 0;
        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[101]; // assuming values are between 1 and 100
            for (int j = 0; j < n; j++) {
                if (seen[matrix[j][i]]) {
                    colDuplicates++;
                    break;
                }
                seen[matrix[j][i]] = true;
            }
        }
        return colDuplicates;
    }
}