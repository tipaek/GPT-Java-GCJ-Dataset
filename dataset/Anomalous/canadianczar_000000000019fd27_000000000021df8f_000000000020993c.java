import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = scanner.nextInt();
        
        for (int testCase = 1; testCase <= numberOfTests; testCase++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            processTestCase(testCase, matrixSize, matrix);
        }
        
        scanner.close();
    }

    private static void processTestCase(int testCase, int matrixSize, int[][] matrix) {
        BitSet[] rowSets = new BitSet[matrixSize];
        BitSet[] colSets = new BitSet[matrixSize];

        for (int i = 0; i < matrixSize; i++) {
            rowSets[i] = new BitSet(matrixSize + 1);
            colSets[i] = new BitSet(matrixSize + 1);
        }

        int diagonalSum = 0;
        int duplicateRows = 0;
        int duplicateCols = 0;

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                int value = matrix[i][j];
                if (i == j) {
                    diagonalSum += value;
                }
                rowSets[i].set(value);
                colSets[j].set(value);
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

        System.out.printf("Case #%d: %d %d %d\n", testCase, diagonalSum, duplicateRows, duplicateCols);
    }
}