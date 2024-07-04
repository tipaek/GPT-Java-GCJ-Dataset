import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = scanner.nextInt();
        
        for (int currentTest = 1; currentTest <= numberOfTests; currentTest++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            
            processTestCase(currentTest, matrixSize, matrix);
        }
        
        scanner.close();
    }

    public static void processTestCase(int testCaseNumber, int matrixSize, int[][] matrix) {
        BitSet[] rowSets = new BitSet[matrixSize];
        BitSet[] colSets = new BitSet[matrixSize];
        
        for (int i = 0; i < matrixSize; i++) {
            rowSets[i] = new BitSet(matrixSize + 1);
            colSets[i] = new BitSet(matrixSize + 1);
        }

        int diagonalSum = 0;
        int duplicateRows = 0;
        int duplicateCols = 0;
        
        for (int row = 0; row < matrixSize; row++) {
            for (int col = 0; col < matrixSize; col++) {
                int value = matrix[row][col];
                if (row == col) {
                    diagonalSum += value;
                }
                rowSets[row].set(value);
                colSets[col].set(value);
            }
        }

        for (BitSet rowSet : rowSets) {
            if (rowSet.cardinality() != matrixSize) {
                duplicateRows++;
            }
        }

        for (BitSet colSet : colSets) {
            if (colSet.cardinality() != matrixSize) {
                duplicateCols++;
            }
        }

        System.out.printf("Case #%d: %d %d %d\n", testCaseNumber, diagonalSum, duplicateRows, duplicateCols);
    }
}