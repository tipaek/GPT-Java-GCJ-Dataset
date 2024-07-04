import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = scanner.nextInt();
        
        for (int test = 1; test <= numberOfTests; test++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            processTestCase(test, n, matrix);
        }
        
        scanner.close();
    }

    private static void processTestCase(int testCaseNumber, int matrixSize, int[][] matrix) {
        BitSet[] rowSets = new BitSet[matrixSize];
        BitSet[] columnSets = new BitSet[matrixSize];
        
        for (int i = 0; i < matrixSize; i++) {
            rowSets[i] = new BitSet(matrixSize + 1);
            columnSets[i] = new BitSet(matrixSize + 1);
        }
        
        int diagonalSum = 0;
        int duplicateRows = 0;
        int duplicateColumns = 0;
        
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                int value = matrix[i][j];
                if (i == j) {
                    diagonalSum += value;
                }
                rowSets[i].set(value);
                columnSets[j].set(value);
            }
        }
        
        for (BitSet rowSet : rowSets) {
            if (rowSet.cardinality() != matrixSize) {
                duplicateRows++;
            }
        }
        
        for (BitSet columnSet : columnSets) {
            if (columnSet.cardinality() != matrixSize) {
                duplicateColumns++;
            }
        }
        
        System.out.printf("Case #%d: %d %d %d\n", testCaseNumber, diagonalSum, duplicateRows, duplicateColumns);
    }
}