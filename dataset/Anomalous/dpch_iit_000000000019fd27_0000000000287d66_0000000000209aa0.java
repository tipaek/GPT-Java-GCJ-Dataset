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
        int numberOfTestCases = Integer.parseInt(new StringTokenizer(reader.readLine()).nextToken());

        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            handleTestCase(testCase, reader);
        }
    }

    private static void handleTestCase(int caseNumber, BufferedReader reader) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int matrixSize = Integer.parseInt(tokenizer.nextToken());
        int targetTrace = Integer.parseInt(tokenizer.nextToken());
        int[][] matrix = new int[matrixSize][matrixSize];

        if (matrixSize > 6) {
            throw new RuntimeException("Matrix size too large");
        }

        boolean isPossible = fillMatrix(matrixSize, matrix, 0, 0, new boolean[matrixSize][matrixSize + 1], new boolean[matrixSize][matrixSize + 1], targetTrace);

        if (!isPossible) {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        } else {
            System.out.println("Case #" + caseNumber + ": POSSIBLE");
            printMatrix(matrix);
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

    private static boolean fillMatrix(int size, int[][] matrix, int row, int col, boolean[][] rowFlags, boolean[][] colFlags, long targetTrace) {
        if (row == size) {
            return calculateTrace(matrix) == targetTrace;
        }

        for (int value = 1; value <= size; value++) {
            if (!rowFlags[row][value] && !colFlags[col][value]) {
                rowFlags[row][value] = true;
                colFlags[col][value] = true;
                matrix[row][col] = value;

                boolean result;
                if (col < size - 1) {
                    result = fillMatrix(size, matrix, row, col + 1, rowFlags, colFlags, targetTrace);
                } else {
                    result = fillMatrix(size, matrix, row + 1, 0, rowFlags, colFlags, targetTrace);
                }

                if (result) {
                    return true;
                }

                rowFlags[row][value] = false;
                colFlags[col][value] = false;
            }
        }
        return false;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}