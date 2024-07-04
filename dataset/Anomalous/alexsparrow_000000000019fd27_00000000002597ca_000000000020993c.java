import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        for (int k = 0; k < t; k++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int diagonalSum = 0, rowDuplicates = 0, colDuplicates = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
                diagonalSum += matrix[i][i];
            }

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