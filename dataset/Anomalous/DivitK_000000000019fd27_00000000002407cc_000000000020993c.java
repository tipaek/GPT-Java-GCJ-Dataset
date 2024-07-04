import java.util.Scanner;
import java.io.*;

public class Vestigium {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            // Reading matrix input
            for (int r = 0; r < matrixSize; r++) {
                for (int c = 0; c < matrixSize; c++) {
                    matrix[r][c] = scanner.nextInt();
                }
            }

            // Calculating trace
            int trace = 0;
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }

            // Counting rows with duplicate elements
            int rowDuplicates = 0;
            for (int r = 0; r < matrixSize; r++) {
                boolean[] seen = new boolean[matrixSize + 1];
                for (int c = 0; c < matrixSize; c++) {
                    if (seen[matrix[r][c]]) {
                        rowDuplicates++;
                        break;
                    }
                    seen[matrix[r][c]] = true;
                }
            }

            // Counting columns with duplicate elements
            int colDuplicates = 0;
            for (int c = 0; c < matrixSize; c++) {
                boolean[] seen = new boolean[matrixSize + 1];
                for (int r = 0; r < matrixSize; r++) {
                    if (seen[matrix[r][c]]) {
                        colDuplicates++;
                        break;
                    }
                    seen[matrix[r][c]] = true;
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }

        scanner.close();
    }
}