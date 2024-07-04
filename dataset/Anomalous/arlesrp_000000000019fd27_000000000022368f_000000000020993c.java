import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Vestigium {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[matrixSize][matrixSize];

            int diagonalSum = 0;

            for (int i = 0; i < matrixSize; i++) {
                String[] row = reader.readLine().split(" ");
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            int repeatedRows = 0;
            for (int i = 0; i < matrixSize; i++) {
                boolean[] seen = new boolean[matrixSize + 1];
                for (int j = 0; j < matrixSize; j++) {
                    if (seen[matrix[i][j]]) {
                        repeatedRows++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }

            int repeatedCols = 0;
            for (int j = 0; j < matrixSize; j++) {
                boolean[] seen = new boolean[matrixSize + 1];
                for (int i = 0; i < matrixSize; i++) {
                    if (seen[matrix[i][j]]) {
                        repeatedCols++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + repeatedRows + " " + repeatedCols);
        }
    }
}