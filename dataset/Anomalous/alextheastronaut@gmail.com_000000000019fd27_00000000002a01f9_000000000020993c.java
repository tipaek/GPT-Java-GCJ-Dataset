import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        int testCases = Integer.parseInt(reader.readLine());
        List<int[][]> matrices = new ArrayList<>();

        for (int i = 0; i < testCases; i++) {
            int size = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[size][size];

            for (int row = 0; row < size; row++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = Integer.parseInt(tokenizer.nextToken());
                }
            }
            matrices.add(matrix);
        }

        for (int i = 0; i < testCases; i++) {
            int[][] matrix = matrices.get(i);
            int trace = calculateTrace(matrix);
            int duplicateRows = countDuplicateRows(matrix);
            int duplicateCols = countDuplicateColumns(matrix);

            writer.printf("Case #%d: %d %d %d%n", i + 1, trace, duplicateRows, duplicateCols);
        }

        writer.close();
        reader.close();
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix) {
        int duplicates = 0;
        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                duplicates++;
            }
        }
        return duplicates;
    }

    private static int countDuplicateColumns(int[][] matrix) {
        int duplicates = 0;
        int size = matrix.length;
        for (int col = 0; col < size; col++) {
            int[] column = new int[size];
            for (int row = 0; row < size; row++) {
                column[row] = matrix[row][col];
            }
            if (hasDuplicates(column)) {
                duplicates++;
            }
        }
        return duplicates;
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