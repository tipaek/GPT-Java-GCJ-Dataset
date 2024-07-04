import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = Integer.parseInt(scanner.nextLine());
        StringBuilder resultBuilder = new StringBuilder();

        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            int matrixSize = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[matrixSize][matrixSize];

            // Read matrix
            for (int row = 0; row < matrixSize; row++) {
                String[] rowEntries = scanner.nextLine().split(" ");
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = Integer.parseInt(rowEntries[col]);
                }
            }

            // Calculate trace
            int trace = 0;
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }

            // Calculate row repetitions
            int rowRepetitions = 0;
            for (int row = 0; row < matrixSize; row++) {
                Set<Integer> uniqueElements = new HashSet<>();
                for (int col = 0; col < matrixSize; col++) {
                    if (!uniqueElements.add(matrix[row][col])) {
                        rowRepetitions++;
                        break;
                    }
                }
            }

            // Calculate column repetitions
            int columnRepetitions = 0;
            for (int col = 0; col < matrixSize; col++) {
                Set<Integer> uniqueElements = new HashSet<>();
                for (int row = 0; row < matrixSize; row++) {
                    if (!uniqueElements.add(matrix[row][col])) {
                        columnRepetitions++;
                        break;
                    }
                }
            }

            // Append result for current test case
            resultBuilder.append("Case #")
                         .append(testCase)
                         .append(": ")
                         .append(trace)
                         .append(" ")
                         .append(rowRepetitions)
                         .append(" ")
                         .append(columnRepetitions)
                         .append("\n");
        }

        // Print all results
        System.out.print(resultBuilder.toString());
    }
}