import java.io.*;
import java.util.*;

public class Solution {

    static long arrayManipulation(int n, int[][] queries) {
        return 1L;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static int[] vestigium(int[][] matrix) {
        int matrixSize = matrix.length;
        int trace = 0, rowRepeats = 0, colRepeats = 0;

        for (int i = 0; i < matrixSize; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            boolean rowHasRepeat = false;
            boolean colHasRepeat = false;

            for (int j = 0; j < matrixSize; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }
                if (!rowSet.add(matrix[i][j])) {
                    rowHasRepeat = true;
                }
                if (!colSet.add(matrix[j][i])) {
                    colHasRepeat = true;
                }
            }

            if (rowHasRepeat) {
                rowRepeats++;
            }
            if (colHasRepeat) {
                colRepeats++;
            }
        }

        return new int[]{trace, rowRepeats, colRepeats};
    }

    public static void main(String[] args) throws IOException {
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCases; i++) {
            int matrixSize = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int x = 0; x < matrixSize; x++) {
                String[] row = scanner.nextLine().split(" ");
                for (int y = 0; y < matrixSize; y++) {
                    matrix[x][y] = Integer.parseInt(row[y]);
                }
            }

            int[] result = vestigium(matrix);
            System.out.println("Case #" + i + ": " + result[0] + " " + result[1] + " " + result[2]);
        }

        scanner.close();
    }
}