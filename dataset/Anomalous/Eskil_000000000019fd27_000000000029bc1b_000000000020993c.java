import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(reader.readLine());

        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int matrixSize = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                String[] rowValues = reader.readLine().split(" ");
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = Integer.parseInt(rowValues[col]);
                }
            }

            int diagonalSum = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                boolean rowHasDuplicates = false;
                boolean colHasDuplicates = false;

                diagonalSum += matrix[i][i];

                for (int j = 0; j < matrixSize; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowHasDuplicates = true;
                    }
                    if (!colSet.add(matrix[j][i])) {
                        colHasDuplicates = true;
                    }
                }

                if (rowHasDuplicates) {
                    duplicateRows++;
                }
                if (colHasDuplicates) {
                    duplicateCols++;
                }
            }

            System.out.println("Case #" + testCase + ": " + diagonalSum + " " + duplicateRows + " " + duplicateCols);
        }
    }
}