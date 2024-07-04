import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder resultBuilder = new StringBuilder();

        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            resultBuilder.append("Case #").append(caseIndex + 1).append(": ");
            int matrixSize = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            // Read the matrix and calculate the trace
            for (int row = 0; row < matrixSize; row++) {
                String[] rowValues = reader.readLine().split(" ");
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = Integer.parseInt(rowValues[col]);
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }

            // Check for repeated values in rows
            for (int row = 0; row < matrixSize; row++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < matrixSize; col++) {
                    if (!rowSet.add(matrix[row][col])) {
                        rowRepeats++;
                        break;
                    }
                }
            }

            // Check for repeated values in columns
            for (int col = 0; col < matrixSize; col++) {
                Set<Integer> colSet = new HashSet<>();
                for (int row = 0; row < matrixSize; row++) {
                    if (!colSet.add(matrix[row][col])) {
                        colRepeats++;
                        break;
                    }
                }
            }

            resultBuilder.append(trace).append(' ').append(rowRepeats).append(' ').append(colRepeats).append('\n');
        }

        System.out.print(resultBuilder);
    }
}