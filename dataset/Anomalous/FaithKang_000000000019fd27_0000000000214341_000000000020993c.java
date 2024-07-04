import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            // Reading the matrix
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int diagonalSum = 0;
            int rowCount = 0;
            int colCount = 0;

            for (int i = 0; i < size; i++) {
                diagonalSum += matrix[i][i];

                boolean isRowSame = true;
                boolean isColSame = true;

                for (int j = 0; j < size - 1; j++) {
                    if (matrix[i][j] != matrix[i][j + 1]) {
                        isRowSame = false;
                    }
                    if (matrix[j][i] != matrix[j + 1][i]) {
                        isColSame = false;
                    }
                }

                if (isRowSame) {
                    rowCount++;
                }
                if (isColSame) {
                    colCount++;
                }
            }

            System.out.println("#" + t + " " + diagonalSum + " " + rowCount + " " + colCount);
        }

        scanner.close();
    }
}