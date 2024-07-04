import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int diagonalSum = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            // Reading the matrix
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculating the sum of the main diagonal
            for (int i = 0; i < matrixSize; i++) {
                diagonalSum += matrix[i][i];
            }

            // Checking for repeated elements in rows
            for (int i = 0; i < matrixSize; i++) {
                boolean[] seen = new boolean[matrixSize + 1];
                for (int j = 0; j < matrixSize; j++) {
                    if (seen[matrix[i][j]]) {
                        rowRepeats++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }

            // Checking for repeated elements in columns
            for (int i = 0; i < matrixSize; i++) {
                boolean[] seen = new boolean[matrixSize + 1];
                for (int j = 0; j < matrixSize; j++) {
                    if (seen[matrix[j][i]]) {
                        colRepeats++;
                        break;
                    }
                    seen[matrix[j][i]] = true;
                }
            }

            System.out.println("Case #" + (caseIndex + 1) + ": " + diagonalSum + " " + rowRepeats + " " + colRepeats);
        }
        scanner.close();
    }
}