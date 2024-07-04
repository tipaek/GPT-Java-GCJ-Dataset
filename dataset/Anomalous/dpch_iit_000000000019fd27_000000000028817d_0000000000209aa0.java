import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        processInput();
    }

    private static void processInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int testCases = Integer.parseInt(tokenizer.nextToken());

        for (int i = 1; i <= testCases; i++) {
            handleTestCase(i, reader);
        }
    }

    private static void handleTestCase(int caseNumber, BufferedReader reader) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int size = Integer.parseInt(tokenizer.nextToken());
        int targetTrace = Integer.parseInt(tokenizer.nextToken());
        int[][] matrix = new int[size][size];

        if (fillMatrix(size, matrix, 0, 0, new boolean[size][size + 1], new boolean[size][size + 1], targetTrace)) {
            System.out.println("Case #" + caseNumber + ": POSSIBLE");
            printMatrix(matrix);
        } else {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    private static long calculateTrace(int[][] matrix) {
        int size = matrix.length;
        long trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static boolean fillMatrix(int size, int[][] matrix, int row, int col, boolean[][] rowUsed, boolean[][] colUsed, long targetTrace) {
        if (row == size) {
            return calculateTrace(matrix) == targetTrace;
        }

        for (int value = 1; value <= size; value++) {
            if (!rowUsed[row][value] && !colUsed[col][value]) {
                rowUsed[row][value] = true;
                colUsed[col][value] = true;
                matrix[row][col] = value;

                boolean result = (col < size - 1)
                    ? fillMatrix(size, matrix, row, col + 1, rowUsed, colUsed, targetTrace)
                    : fillMatrix(size, matrix, row + 1, 0, rowUsed, colUsed, targetTrace);

                if (result) {
                    return true;
                }

                rowUsed[row][value] = false;
                colUsed[col][value] = false;
            }
        }

        return false;
    }
}