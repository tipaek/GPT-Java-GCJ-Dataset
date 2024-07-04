import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int traceValue = calculateTrace(matrix, size);
            int rowDuplicates = countRowDuplicates(matrix, size);
            int colDuplicates = countColDuplicates(matrix, size);

            System.out.printf("Case #%d: %d %d %d%n", t, traceValue, rowDuplicates, colDuplicates);
        }
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowDuplicates(int[][] matrix, int size) {
        int duplicateCount = 0;
        for (int i = 0; i < size; i++) {
            if (hasDuplicates(matrix[i])) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }

    private static int countColDuplicates(int[][] matrix, int size) {
        int duplicateCount = 0;
        for (int i = 0; i < size; i++) {
            int[] column = new int[size];
            for (int j = 0; j < size; j++) {
                column[j] = matrix[j][i];
            }
            if (hasDuplicates(column)) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int value : array) {
            if (!seen.add(value)) {
                return true;
            }
        }
        return false;
    }
}