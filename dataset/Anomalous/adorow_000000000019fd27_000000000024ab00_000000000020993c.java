import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.BitSet;
import java.util.Scanner;

public class Solution {

    private static Scanner scanner;
    private static PrintStream output;

    private static final String CASE_PREFIX = "Case #";
    private static final String SEPARATOR = ": ";

    public static void main(String[] args) throws Throwable {
        scanner = new Scanner(System.in);
        // scanner = new Scanner(new FileInputStream("./src/main/resources/codejam/year2020/qualification/A/A.in"));
        output = System.out;
        // output = new PrintStream(new FileOutputStream("A_Vestigium.out"));

        int[][] matrix = new int[101][101];

        BitSet duplicateRows = new BitSet();
        BitSet duplicateCols = new BitSet();

        BitSet[] rowBits = new BitSet[101];
        BitSet[] colBits = new BitSet[101];
        for (int i = 0; i < 101; i++) {
            rowBits[i] = new BitSet();
            colBits[i] = new BitSet();
        }

        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int trace = 0;
            int duplicateRowCount, duplicateColCount;

            int size = scanner.nextInt();

            // Clear bits
            duplicateRows.clear();
            duplicateCols.clear();
            for (int i = 0; i <= size; i++) {
                rowBits[i].clear();
                colBits[i].clear();
            }

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    int value = scanner.nextInt();
                    if (rowBits[i].get(value)) {
                        duplicateRows.set(i);
                    }
                    rowBits[i].set(value);
                    if (colBits[j].get(value)) {
                        duplicateCols.set(j);
                    }
                    colBits[j].set(value);

                    if (i == j) trace += value; // Calculate trace
                    matrix[i][j] = value;
                }
            }

            duplicateRowCount = duplicateRows.cardinality();
            duplicateColCount = duplicateCols.cardinality();

            output.print(CASE_PREFIX);
            output.print(t);
            output.print(SEPARATOR);

            output.print(trace);
            output.print(' ');
            output.print(duplicateRowCount);
            output.print(' ');
            output.print(duplicateColCount);

            output.println();
        }
        output.flush();
    }
}