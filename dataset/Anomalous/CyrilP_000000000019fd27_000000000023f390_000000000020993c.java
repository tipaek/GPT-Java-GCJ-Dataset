import java.util.BitSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int size = scanner.nextInt();
            int trace = 0, invalidRows = 0, invalidCols = 0;
            BitSet[] columnSets = new BitSet[size];
            BitSet rowSet = new BitSet(size);
            BitSet countedRows = new BitSet(size);
            BitSet countedCols = new BitSet(size);
            int[][] matrix = new int[size][size];

            for (int row = 0; row < size; row++) {
                rowSet.clear();
                for (int col = 0; col < size; col++) {
                    if (row == 0) {
                        columnSets[col] = new BitSet(size);
                    }
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                    if (rowSet.get(matrix[row][col])) {
                        if (!countedRows.get(row)) {
                            countedRows.set(row);
                            invalidRows++;
                        }
                    } else {
                        rowSet.set(matrix[row][col]);
                    }
                    if (columnSets[col].get(matrix[row][col])) {
                        if (!countedCols.get(col)) {
                            countedCols.set(col);
                            invalidCols++;
                        }
                    } else {
                        columnSets[col].set(matrix[row][col]);
                    }
                }
            }
            result.append(String.format("Case #%d: %d %d %d\n", t + 1, trace, invalidRows, invalidCols));
        }
        System.out.println(result.toString());
    }
}