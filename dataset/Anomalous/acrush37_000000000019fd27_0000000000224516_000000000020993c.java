import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int diagonalSum = 0;
            for (int i = 0; i < matrixSize; i++) {
                diagonalSum += matrix[i][i];
            }
            System.out.print("Case #" + caseNum + ": " + diagonalSum);

            int rowDuplicates = 0;
            for (int i = 0; i < matrixSize; i++) {
                boolean[] rowCheck = new boolean[matrixSize + 1];
                for (int j = 0; j < matrixSize; j++) {
                    if (rowCheck[matrix[i][j]]) {
                        rowDuplicates++;
                        break;
                    } else {
                        rowCheck[matrix[i][j]] = true;
                    }
                }
            }
            System.out.print(" " + rowDuplicates);

            int colDuplicates = 0;
            for (int j = 0; j < matrixSize; j++) {
                boolean[] colCheck = new boolean[matrixSize + 1];
                for (int i = 0; i < matrixSize; i++) {
                    if (colCheck[matrix[i][j]]) {
                        colDuplicates++;
                        break;
                    } else {
                        colCheck[matrix[i][j]] = true;
                    }
                }
            }
            System.out.println(" " + colDuplicates);
        }
    }
}