import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
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

            int duplicateRows = 0;
            for (int i = 0; i < matrixSize; i++) {
                boolean[] rowCheck = new boolean[matrixSize + 1];
                for (int j = 0; j < matrixSize; j++) {
                    if (rowCheck[matrix[i][j]]) {
                        duplicateRows++;
                        break;
                    }
                    rowCheck[matrix[i][j]] = true;
                }
            }

            int duplicateColumns = 0;
            for (int j = 0; j < matrixSize; j++) {
                boolean[] colCheck = new boolean[matrixSize + 1];
                for (int i = 0; i < matrixSize; i++) {
                    if (colCheck[matrix[i][j]]) {
                        duplicateColumns++;
                        break;
                    }
                    colCheck[matrix[i][j]] = true;
                }
            }

            System.out.println("Case #" + caseNum + ": " + diagonalSum + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}