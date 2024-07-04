import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        StringBuilder resultBuilder = new StringBuilder();

        for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
            int matrixSize = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[matrixSize][matrixSize];

            int trace = 0;
            for (int row = 0; row < matrixSize; row++) {
                String[] elements = reader.readLine().split(" ");
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = Integer.parseInt(elements[col]);
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }

            int duplicateRows = countDuplicateRows(matrix, matrixSize);
            int duplicateCols = countDuplicateCols(matrix, matrixSize);

            resultBuilder.append("Case #").append(caseIndex).append(": ")
                         .append(trace).append(' ')
                         .append(duplicateRows).append(' ')
                         .append(duplicateCols).append('\n');
        }

        System.out.print(resultBuilder.toString());
    }

    private static int countDuplicateRows(int[][] matrix, int size) {
        int duplicateRows = 0;
        for (int row = 0; row < size; row++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int col = 0; col < size; col++) {
                if (!rowSet.add(matrix[row][col])) {
                    duplicateRows++;
                    break;
                }
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateCols(int[][] matrix, int size) {
        int duplicateCols = 0;
        for (int col = 0; col < size; col++) {
            Set<Integer> colSet = new HashSet<>();
            for (int row = 0; row < size; row++) {
                if (!colSet.add(matrix[row][col])) {
                    duplicateCols++;
                    break;
                }
            }
        }
        return duplicateCols;
    }
}