import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
                Writer writer = new BufferedWriter(
                        new OutputStreamWriter(System.out))) {
            solve(reader, writer);
        }
    }

    private static void solve(BufferedReader reader, Writer writer)
            throws Exception {
        int testCount = Integer.parseInt(reader.readLine());
        for (int i = 0; i < testCount; i++) {
            solveTestCase(i, reader, writer);
        }
    }

    private static void solveTestCase(int t, BufferedReader reader,
            Writer writer) throws Exception {
        int[][] matrix = parseMatrix(reader);
        int trace = calculateTrace(matrix);
        int repeatedRows = calculateRepeatedRows(matrix);
        int repeatedColumns = calculateRepeatedColumns(matrix);
        printResult(t, trace, repeatedRows, repeatedColumns, writer);
    }

    private static int[][] parseMatrix(
            BufferedReader reader)
            throws NumberFormatException, IOException {
        int n = Integer.parseInt(reader.readLine());
        int[][] matrix = new int[n][];
        for (int i = 0; i < n; i++) {
            matrix[i] = new int[n];
            String[] tokens = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(tokens[j]);
            }
        }
        return matrix;
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        int n = matrix[0].length;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int calculateRepeatedRows(int[][] matrix) {
        int repeatedRows = 0;
        int n = matrix[0].length;
        boolean[] present = new boolean[n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(present, false);
            for (int j = 0; j < n; j++) {
                int elem = matrix[i][j];
                if (present[elem - 1]) {
                    repeatedRows++;
                    break;
                } else {
                    present[elem - 1] = true;
                }
            }
        }
        return repeatedRows;
    }

    private static int calculateRepeatedColumns(int[][] matrix) {
        int repeatedColumns = 0;
        int n = matrix[0].length;
        boolean[] present = new boolean[n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(present, false);
            for (int j = 0; j < n; j++) {
                int elem = matrix[j][i];
                if (present[elem - 1]) {
                    repeatedColumns++;
                    break;
                } else {
                    present[elem - 1] = true;
                }
            }
        }
        return repeatedColumns;
    }

    private static void printResult(int t, int trace, int repeatedRows,
        int repeatedColumns, Writer writer) throws IOException {
        writer.write(String.format("Case #%d: %d %d %d\n", t + 1, trace, repeatedRows, repeatedColumns));
        writer.flush();
    }
}
