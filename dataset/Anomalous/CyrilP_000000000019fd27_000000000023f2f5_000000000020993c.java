import java.util.BitSet;
import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        int testCases = sc.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int size = sc.nextInt();
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            BitSet[] columnSets = new BitSet[size];
            for (int i = 0; i < size; i++) {
                columnSets[i] = new BitSet(size + 1);
            }

            BitSet rowSet = new BitSet(size + 1);
            BitSet repeatedRows = new BitSet(size);
            BitSet repeatedCols = new BitSet(size);

            int[][] matrix = new int[size][size];

            for (int row = 0; row < size; row++) {
                rowSet.clear();
                for (int col = 0; col < size; col++) {
                    int value = sc.nextInt();
                    matrix[row][col] = value;

                    if (row == col) {
                        trace += value;
                    }

                    if (rowSet.get(value) && !repeatedRows.get(row)) {
                        repeatedRows.set(row);
                        rowRepeats++;
                    } else {
                        rowSet.set(value);
                    }

                    if (columnSets[col].get(value) && !repeatedCols.get(col)) {
                        repeatedCols.set(col);
                        colRepeats++;
                    } else {
                        columnSets[col].set(value);
                    }
                }
            }

            result.append(String.format("Case #%d: %d %d %d%n", t, trace, rowRepeats, colRepeats));
        }

        System.out.print(result);
    }
}