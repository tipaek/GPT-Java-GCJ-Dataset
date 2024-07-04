import java.util.*;

public class Solution {
    public static void main(String[] args) {
        naturalLatinSquareFromScannerInput();
    }

    public static void naturalLatinSquareFromScannerInput() {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = Integer.parseInt(scanner.nextLine());
        String[][] inputMatrices = getInput(scanner, numberOfTestCases);
        String[] output = new String[numberOfTestCases];

        for (int matrixCase = 0; matrixCase < numberOfTestCases; matrixCase++) {
            int[][] matrix = parseMatrix(inputMatrices[matrixCase]);
            int traceOfMatrix = calculateTrace(matrix);
            int numberOfWrongRows = countRowsWithDuplicates(inputMatrices[matrixCase]);
            int numberOfWrongColumns = countColumnsWithDuplicates(matrix);

            output[matrixCase] = String.format("Case #%d: %d %d %d", matrixCase + 1, traceOfMatrix, numberOfWrongRows, numberOfWrongColumns);
        }

        for (String result : output) {
            System.out.println(result);
        }
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int[][] parseMatrix(String[] rows) {
        int size = rows.length;
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            String[] cells = rows[i].split(" ");
            for (int j = 0; j < cells.length; j++) {
                matrix[i][j] = Integer.parseInt(cells[j]);
            }
        }
        return matrix;
    }

    private static String[][] getInput(Scanner scanner, int numberOfTestCases) {
        String[][] matrices = new String[numberOfTestCases][];
        for (int i = 0; i < numberOfTestCases; i++) {
            int size = Integer.parseInt(scanner.nextLine());
            String[] rows = new String[size];
            for (int j = 0; j < size; j++) {
                rows[j] = scanner.nextLine();
            }
            matrices[i] = rows;
        }
        return matrices;
    }

    private static int countRowsWithDuplicates(String[] rows) {
        int count = 0;
        for (String row : rows) {
            if (hasDuplicates(row.split(" "))) {
                count++;
            }
        }
        return count;
    }

    private static int countColumnsWithDuplicates(int[][] matrix) {
        int count = 0;
        for (int col = 0; col < matrix.length; col++) {
            int[] column = new int[matrix.length];
            for (int row = 0; row < matrix.length; row++) {
                column[row] = matrix[row][col];
            }
            if (hasDuplicates(column)) {
                count++;
            }
        }
        return count;
    }

    private static boolean hasDuplicates(String[] array) {
        Set<String> set = new HashSet<>(Arrays.asList(array));
        return set.size() != array.length;
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            set.add(num);
        }
        return set.size() != array.length;
    }
}