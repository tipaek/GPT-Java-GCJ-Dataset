import java.io.*;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            processInput(reader, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processInput(BufferedReader reader, BufferedWriter writer) throws IOException {
        int testCount = Integer.parseInt(reader.readLine());
        for (int i = 0; i < testCount; i++) {
            handleTestCase(i, reader, writer);
        }
    }

    private static void handleTestCase(int testCaseNumber, BufferedReader reader, BufferedWriter writer) throws IOException {
        int[][] matrix = readMatrix(reader);
        int trace = computeTrace(matrix);
        int repeatedRows = countRepeatedRows(matrix);
        int repeatedColumns = countRepeatedColumns(matrix);
        writeResult(testCaseNumber, trace, repeatedRows, repeatedColumns, writer);
    }

    private static int[][] readMatrix(BufferedReader reader) throws IOException {
        int size = Integer.parseInt(reader.readLine());
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            String[] row = reader.readLine().split(" ");
            for (int j = 0; j < size; j++) {
                matrix[i][j] = Integer.parseInt(row[j]);
            }
        }
        return matrix;
    }

    private static int computeTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRepeatedRows(int[][] matrix) {
        int repeatedRows = 0;
        boolean[] seen;
        for (int[] row : matrix) {
            seen = new boolean[matrix.length];
            for (int value : row) {
                if (seen[value - 1]) {
                    repeatedRows++;
                    break;
                }
                seen[value - 1] = true;
            }
        }
        return repeatedRows;
    }

    private static int countRepeatedColumns(int[][] matrix) {
        int repeatedColumns = 0;
        boolean[] seen;
        for (int col = 0; col < matrix.length; col++) {
            seen = new boolean[matrix.length];
            for (int row = 0; row < matrix.length; row++) {
                if (seen[matrix[row][col] - 1]) {
                    repeatedColumns++;
                    break;
                }
                seen[matrix[row][col] - 1] = true;
            }
        }
        return repeatedColumns;
    }

    private static void writeResult(int testCaseNumber, int trace, int repeatedRows, int repeatedColumns, BufferedWriter writer) throws IOException {
        writer.write(String.format("Case #%d: %d %d %d\n", testCaseNumber + 1, trace, repeatedRows, repeatedColumns));
        writer.flush();
    }
}