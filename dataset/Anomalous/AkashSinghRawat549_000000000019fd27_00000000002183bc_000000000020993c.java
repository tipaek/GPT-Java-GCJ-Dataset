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

                int[] column = new int[matrixSize];
                for (int k = 0; k < matrixSize; k++) {
                    column[k] = matrix[k][j];
                }

                if (hasDuplicate(column)) {
                    duplicateCols++;
                }
            }

            results.add("Case #" + (i + 1) + ": " + trace + " " + duplicateRows + " " + duplicateCols);
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
}