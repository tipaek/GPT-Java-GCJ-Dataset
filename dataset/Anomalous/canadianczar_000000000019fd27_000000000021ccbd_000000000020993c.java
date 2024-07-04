import java.util.*;
import java.io.*;

class Vest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            processMatrix(n, matrix);
        }
        scanner.close();
    }

    public static void processMatrix(int n, int[][] matrix) {
        BitSet[] rowSets = new BitSet[n];
        BitSet[] colSets = new BitSet[n];
        for (int i = 0; i < n; i++) {
            rowSets[i] = new BitSet(n + 1);
            colSets[i] = new BitSet(n + 1);
        }

        int diagonalSum = 0;
        int duplicateRows = 0;
        int duplicateCols = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = matrix[i][j];
                if (i == j) {
                    diagonalSum += value;
                }
                rowSets[i].set(value);
                colSets[j].set(value);
            }
        }

        for (BitSet rowSet : rowSets) {
            if (rowSet.cardinality() != n) {
                duplicateRows++;
            }
        }

        for (BitSet colSet : colSets) {
            if (colSet.cardinality() != n) {
                duplicateCols++;
            }
        }

        System.out.println(diagonalSum + " " + duplicateRows + " " + duplicateCols);
    }
}