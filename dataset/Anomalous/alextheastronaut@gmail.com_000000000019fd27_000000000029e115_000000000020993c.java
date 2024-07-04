import java.io.*;
import java.util.*;

public class Vestigium {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        int testCases = Integer.parseInt(reader.readLine());
        List<int[][]> matrices = new ArrayList<>();
        
        for (int t = 0; t < testCases; t++) {
            int size = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[size][size];
            
            for (int i = 0; i < size; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }
            matrices.add(matrix);
        }

        for (int t = 0; t < testCases; t++) {
            int[][] matrix = matrices.get(t);
            int trace = calculateTrace(matrix);
            int duplicateRows = countDuplicateRows(matrix);
            int duplicateColumns = countDuplicateColumns(matrix);
            
            writer.printf("Case #%d: %d %d %d%n", t + 1, trace, duplicateRows, duplicateColumns);
        }

        writer.flush();
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
        int duplicateRows = 0;
        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateColumns(int[][] matrix) {
        int duplicateColumns = 0;
        for (int col = 0; col < matrix.length; col++) {
            int[] column = new int[matrix.length];
            for (int row = 0; row < matrix.length; row++) {
                column[row] = matrix[row][col];
            }
            if (hasDuplicates(column)) {
                duplicateColumns++;
            }
        }
        return duplicateColumns;
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length];
        for (int num : array) {
            if (seen[num - 1]) {
                return true;
            }
            seen[num - 1] = true;
        }
        return false;
    }
}