import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = input.nextInt();

        for (int t = 1; t <= testCaseCount; t++) {
            int diagonalSum = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;
            int matrixSize = input.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            // Read the matrix
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = input.nextInt();
                }
            }

            // Calculate the sum of the diagonal
            for (int i = 0; i < matrixSize; i++) {
                diagonalSum += matrix[i][i];
            }

            // Check for duplicate values in rows and columns
            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < matrixSize; j++) {
                    rowSet.add(matrix[i][j]);
                    colSet.add(matrix[j][i]);
                }
                if (rowSet.size() != matrixSize) {
                    duplicateRows++;
                }
                if (colSet.size() != matrixSize) {
                    duplicateColumns++;
                }
            }

            System.out.println("Case #" + t + ": " + diagonalSum + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}