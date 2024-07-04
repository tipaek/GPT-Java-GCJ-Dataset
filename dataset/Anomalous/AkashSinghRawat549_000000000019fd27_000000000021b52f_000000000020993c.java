import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = scanner.nextInt();

        List<String> results = new ArrayList<>();
        for (int i = 0; i < cases; i++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int j = 0; j < matrixSize; j++) {
                for (int k = 0; k < matrixSize; k++) {
                    matrix[j][k] = scanner.nextInt();
                }
            }

            int trace = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            for (int j = 0; j < matrixSize; j++) {
                trace += matrix[j][j];

                if (hasDuplicate(matrix[j])) {
                    duplicateRows++;
                }

                if (hasDuplicate(getColumn(matrix, j))) {
                    duplicateCols++;
                }
            }

            results.add(String.format("Case #%d: %d %d %d", i + 1, trace, duplicateRows, duplicateCols));
        }

        scanner.close();

        for (String result : results) {
            System.out.println(result);
        }
    }

    private static boolean hasDuplicate(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int num : array) {
            if (seen[num]) {
                return true;
            }
            seen[num] = true;
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int colIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][colIndex];
        }
        return column;
    }
}