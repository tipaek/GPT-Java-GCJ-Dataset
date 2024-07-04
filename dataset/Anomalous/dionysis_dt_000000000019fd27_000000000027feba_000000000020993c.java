import java.util.*;

public class Vestigium {

    private int testCases;
    private List<int[][]> matrices = new ArrayList<>();

    public static void main(String[] args) {
        Vestigium vestigium = new Vestigium();
        vestigium.readInput();
        vestigium.processMatrices();
    }

    private void readInput() {
        Scanner scanner = new Scanner(System.in);
        
        if (scanner.hasNextLine()) {
            testCases = Integer.parseInt(scanner.nextLine());
        }

        for (int i = 0; i < testCases; i++) {
            int matrixSize = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int j = 0; j < matrixSize; j++) {
                String[] row = scanner.nextLine().split(" ");
                for (int k = 0; k < matrixSize; k++) {
                    matrix[j][k] = Integer.parseInt(row[k]);
                }
            }

            matrices.add(matrix);
        }

        scanner.close();
    }

    private void processMatrices() {
        for (int i = 0; i < matrices.size(); i++) {
            int[][] matrix = matrices.get(i);
            int trace = calculateTrace(matrix);
            int duplicateRows = calculateDuplicateRows(matrix);
            int duplicateColumns = calculateDuplicateColumns(matrix);
            System.out.printf("Case #%d: %d %d %d%n", i + 1, trace, duplicateRows, duplicateColumns);
        }
    }

    private int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private int calculateDuplicateRows(int[][] matrix) {
        int duplicateRows = 0;
        for (int[] row : matrix) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int element : row) {
                uniqueElements.add(element);
            }
            if (uniqueElements.size() < row.length) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private int calculateDuplicateColumns(int[][] matrix) {
        int duplicateColumns = 0;
        for (int col = 0; col < matrix.length; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < matrix.length; row++) {
                uniqueElements.add(matrix[row][col]);
            }
            if (uniqueElements.size() < matrix.length) {
                duplicateColumns++;
            }
        }
        return duplicateColumns;
    }
}