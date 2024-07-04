import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            inputs.add(line);
        }

        if (inputs.isEmpty()) {
            return;
        }

        int caseCount = Integer.parseInt(inputs.get(0).trim());
        int currentIndex = 1;

        for (int caseNumber = 1; caseNumber <= caseCount; caseNumber++) {
            int matrixSize = Integer.parseInt(inputs.get(currentIndex).trim());
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                String[] rowValues = inputs.get(currentIndex + row + 1).split("\\s+");
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = Integer.parseInt(rowValues[col]);
                }
            }

            Result result = computeVestigium(matrix, matrixSize);
            System.out.printf("Case #%d: %d %d %d%n", caseNumber, result.trace, result.rowCount, result.columnCount);

            currentIndex += matrixSize + 1;
        }
    }

    private static Result computeVestigium(int[][] matrix, int size) {
        int trace = 0;
        int rowCount = 0;
        int columnCount = 0;

        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];

            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            boolean rowDuplicate = false;
            boolean colDuplicate = false;

            for (int j = 0; j < size; j++) {
                if (!rowDuplicate && !rowSet.add(matrix[i][j])) {
                    rowCount++;
                    rowDuplicate = true;
                }
                if (!colDuplicate && !colSet.add(matrix[j][i])) {
                    columnCount++;
                    colDuplicate = true;
                }
            }
        }

        return new Result(trace, rowCount, columnCount);
    }

    private static class Result {
        int trace;
        int rowCount;
        int columnCount;

        public Result(int trace, int rowCount, int columnCount) {
            this.trace = trace;
            this.rowCount = rowCount;
            this.columnCount = columnCount;
        }
    }
}