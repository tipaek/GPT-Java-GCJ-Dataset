import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine().trim());
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = Integer.parseInt(reader.readLine().trim());
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                matrix[row] = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int[] result = analyzeMatrix(matrix, matrixSize);
            System.out.printf("Case #%d: %d %d %d%n", caseNumber, result[0], result[1], result[2]);
        }
    }

    private static int[] analyzeMatrix(int[][] matrix, int size) {
        int trace = 0;
        int duplicateRows = 0;
        int duplicateCols = 0;

        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }

        for (int i = 0; i < size; i++) {
            if (hasDuplicates(matrix[i])) {
                duplicateRows++;
            }
        }

        for (int j = 0; j < size; j++) {
            int[] column = new int[size];
            for (int i = 0; i < size; i++) {
                column[i] = matrix[i][j];
            }
            if (hasDuplicates(column)) {
                duplicateCols++;
            }
        }

        return new int[]{trace, duplicateRows, duplicateCols};
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length];
        for (int value : array) {
            if (seen[value - 1]) {
                return true;
            }
            seen[value - 1] = true;
        }
        return false;
    }
}