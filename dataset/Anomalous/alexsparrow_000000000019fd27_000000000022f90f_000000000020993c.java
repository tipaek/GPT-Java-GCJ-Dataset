import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int k = 0; k < testCases; k++) {
            int rowDuplicates = 0;
            int colDuplicates = 0;
            int diagonalSum = 0;
            int n = scanner.nextInt();

            int[][] matrix = new int[n][n];

            // Reading the matrix and calculating the diagonal sum
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
                diagonalSum += matrix[i][i];
            }

            // Checking for duplicate elements in rows
            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[101];
                for (int j = 0; j < n; j++) {
                    if (rowCheck[matrix[i][j]]) {
                        rowDuplicates++;
                        break;
                    }
                    rowCheck[matrix[i][j]] = true;
                }
            }

            // Checking for duplicate elements in columns
            for (int i = 0; i < n; i++) {
                boolean[] colCheck = new boolean[101];
                for (int j = 0; j < n; j++) {
                    if (colCheck[matrix[j][i]]) {
                        colDuplicates++;
                        break;
                    }
                    colCheck[matrix[j][i]] = true;
                }
            }

            System.out.println(diagonalSum + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}