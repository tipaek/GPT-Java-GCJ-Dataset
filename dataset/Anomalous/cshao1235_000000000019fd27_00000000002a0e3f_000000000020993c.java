import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    public static int calculateTrace(int[][] matrix, int size) {
        int traceSum = 0;
        for (int i = 0; i < size; i++) {
            traceSum += matrix[i][i];
        }
        return traceSum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            int trace = calculateTrace(matrix, matrixSize);
            int rowsWithRepeats = countRowsWithRepeats(matrix, matrixSize);
            int colsWithRepeats = countColsWithRepeats(matrix, matrixSize);

            System.out.println("Case #" + testCase + ": " + trace + " " + rowsWithRepeats + " " + colsWithRepeats);
        }
        reader.close();
    }

    private static int countRowsWithRepeats(int[][] matrix, int size) {
        int rowsWithRepeats = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!seen.add(matrix[i][j])) {
                    rowsWithRepeats++;
                    break;
                }
            }
        }
        return rowsWithRepeats;
    }

    private static int countColsWithRepeats(int[][] matrix, int size) {
        int colsWithRepeats = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!seen.add(matrix[j][i])) {
                    colsWithRepeats++;
                    break;
                }
            }
        }
        return colsWithRepeats;
    }
}