import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();
        
        // Read input lines
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            inputs.add(line);
        }

        // Check if there are any inputs
        if (inputs.isEmpty()) {
            return;
        }

        int caseCount = Integer.parseInt(inputs.get(0).trim());
        int currentIndex = 1;
        
        // Process each test case
        for (int caseNumber = 0; caseNumber < caseCount; caseNumber++) {
            int matrixSize = Integer.parseInt(inputs.get(currentIndex).trim());
            int[][] matrix = new int[matrixSize][matrixSize];

            // Read matrix data
            for (int row = 0; row < matrixSize; row++) {
                String[] rowData = inputs.get(currentIndex + row + 1).split("\\s+");
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = Integer.parseInt(rowData[col]);
                }
            }

            // Compute the result for the current matrix
            Result result = computeVestigium(matrix, matrixSize);

            // Print the result
            System.out.printf("Case #%d: %d %d %d%n", caseNumber + 1, result.trace, result.rowCount, result.colCount);
            currentIndex += matrixSize + 1;
        }
    }

    private static Result computeVestigium(int[][] matrix, int size) {
        int trace = 0;
        int rowCount = 0;
        int colCount = 0;
        int targetSum = size * (size + 1) / 2;

        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
            int rowSum = 0;
            int colSum = 0;
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();

            for (int j = 0; j < size; j++) {
                rowSum += matrix[i][j];
                colSum += matrix[j][i];
                rowSet.add(matrix[i][j]);
                colSet.add(matrix[j][i]);
            }

            if (rowSum != targetSum || rowSet.size() != size) {
                rowCount++;
            }
            if (colSum != targetSum || colSet.size() != size) {
                colCount++;
            }
        }

        return new Result(trace, rowCount, colCount);
    }

    private static class Result {
        int trace;
        int rowCount;
        int colCount;

        Result(int trace, int rowCount, int colCount) {
            this.trace = trace;
            this.rowCount = rowCount;
            this.colCount = colCount;
        }
    }
}