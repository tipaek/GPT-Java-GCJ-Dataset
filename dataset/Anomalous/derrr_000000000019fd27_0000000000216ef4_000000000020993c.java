import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
                int size = scanner.nextInt();
                int[][] matrix = new int[size][size];
                for (int row = 0; row < size; row++) {
                    for (int col = 0; col < size; col++) {
                        matrix[row][col] = scanner.nextInt();
                    }
                }
                int[] result = computeVestigium(matrix);
                System.out.printf("Case #%d: %d %d %d%n", caseNumber, result[0], result[1], result[2]);
            }
        }
    }

    private static int[] computeVestigium(int[][] matrix) {
        int trace = 0;
        int repeatRows = 0;
        int repeatCols = 0;
        int size = matrix.length;

        Set<Integer>[] colSets = new Set[size];
        for (int i = 0; i < size; i++) {
            colSets[i] = new HashSet<>();
        }

        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            boolean rowHasDuplicate = false;

            for (int j = 0; j < size; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }

                if (!rowHasDuplicate && !rowSet.add(matrix[i][j])) {
                    repeatRows++;
                    rowHasDuplicate = true;
                }

                if (!colSets[j].add(matrix[i][j])) {
                    repeatCols++;
                    colSets[j] = new HashSet<>(); // reset to avoid counting duplicates again
                }
            }
        }

        return new int[]{trace, repeatRows, repeatCols};
    }
}