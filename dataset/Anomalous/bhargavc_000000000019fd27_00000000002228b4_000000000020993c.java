import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine().trim());

        for (int id = 0; id < testCases; id++) {
            int matrixSize = Integer.parseInt(scanner.nextLine().trim());
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                String[] rowData = scanner.nextLine().trim().split(" ");
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = Integer.parseInt(rowData[col]);
                }
            }

            Vestigium vestigium = new Vestigium(id, matrix);
            System.out.println(vestigium.process());
        }
        scanner.close();
    }
}

class Vestigium {
    private final int[][] matrix;
    private final int testId;

    public Vestigium(int testId, int[][] matrix) {
        this.matrix = matrix;
        this.testId = testId;
    }

    public String process() {
        int trace = computeTrace();
        String mismatches = computeMismatches();
        return formatOutput(trace, mismatches);
    }

    private int computeTrace() {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private String computeMismatches() {
        int rowCount = 0;
        int colCount = 0;
        int size = matrix.length;
        boolean[][] colTracker = new boolean[size][size];
        boolean[] colInvalid = new boolean[size];

        for (int i = 0; i < size; i++) {
            boolean[] rowTracker = new boolean[size];
            boolean rowInvalid = false;

            for (int j = 0; j < size; j++) {
                int value = matrix[i][j] - 1;

                if (rowTracker[value]) {
                    rowInvalid = true;
                } else {
                    rowTracker[value] = true;
                }

                if (colTracker[j][value]) {
                    colInvalid[j] = true;
                } else {
                    colTracker[j][value] = true;
                }
            }

            if (rowInvalid) rowCount++;
        }

        for (boolean col : colInvalid) {
            if (col) colCount++;
        }

        return rowCount + " " + colCount;
    }

    private String formatOutput(int trace, String mismatches) {
        return "Case #" + (testId + 1) + ": " + trace + " " + mismatches;
    }
}