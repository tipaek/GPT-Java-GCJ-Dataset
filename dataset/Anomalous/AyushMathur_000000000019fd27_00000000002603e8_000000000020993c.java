import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        
        int numberOfTestCases = Integer.parseInt(reader.readLine().trim());

        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            output.append("Case #").append(testCase).append(": ");
            
            int matrixSize = Integer.parseInt(reader.readLine().trim());
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                String[] inputLine = reader.readLine().trim().split(" ");
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = Integer.parseInt(inputLine[col]);
                }
            }

            output.append(calculateTrace(matrixSize, matrix)).append(" ")
                  .append(countInvalidRows(matrixSize, matrix)).append(" ")
                  .append(countInvalidCols(matrixSize, matrix)).append("\n");
        }

        System.out.print(output);
    }

    private static int countInvalidRows(int n, int[][] matrix) {
        int invalidRows = 0;

        for (int row = 0; row < n; row++) {
            boolean[] seen = new boolean[n + 1];

            for (int col = 0; col < n; col++) {
                if (seen[matrix[row][col]]) {
                    invalidRows++;
                    break;
                }
                seen[matrix[row][col]] = true;
            }
        }

        return invalidRows;
    }

    private static int countInvalidCols(int n, int[][] matrix) {
        int invalidCols = 0;

        for (int col = 0; col < n; col++) {
            boolean[] seen = new boolean[n + 1];

            for (int row = 0; row < n; row++) {
                if (seen[matrix[row][col]]) {
                    invalidCols++;
                    break;
                }
                seen[matrix[row][col]] = true;
            }
        }

        return invalidCols;
    }

    private static int calculateTrace(int n, int[][] matrix) {
        int traceSum = 0;

        for (int i = 0; i < n; i++) {
            traceSum += matrix[i][i];
        }

        return traceSum;
    }
}