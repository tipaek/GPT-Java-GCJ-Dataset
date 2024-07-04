import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int[][] transposeMatrix = new int[matrixSize][matrixSize];
            int diagonalSum = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            for (int row = 0; row < matrixSize; row++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt();
                    matrix[row][col] = value;
                    transposeMatrix[col][row] = value;

                    if (row == col) {
                        diagonalSum += value;
                    }
                    rowSet.add(value);
                }
                if (rowSet.size() < matrixSize) {
                    duplicateRows++;
                }
            }

            for (int col = 0; col < matrixSize; col++) {
                Set<Integer> colSet = new HashSet<>();
                for (int row = 0; row < matrixSize; row++) {
                    colSet.add(transposeMatrix[col][row]);
                }
                if (colSet.size() < matrixSize) {
                    duplicateColumns++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}