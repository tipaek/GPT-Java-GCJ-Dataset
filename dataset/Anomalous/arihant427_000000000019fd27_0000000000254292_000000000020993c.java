import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int k = 0; k < testCases; k++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            // Calculate the trace
            for (int i = 0; i < size; i++) {
                trace += matrix[i][i];
            }

            // Check for duplicate rows
            for (int i = 0; i < size; i++) {
                if (hasDuplicate(matrix[i])) {
                    duplicateRows++;
                }
            }

            // Check for duplicate columns
            for (int j = 0; j < size; j++) {
                int[] column = new int[size];
                for (int i = 0; i < size; i++) {
                    column[i] = matrix[i][j];
                }
                if (hasDuplicate(column)) {
                    duplicateColumns++;
                }
            }

            System.out.println("Case #" + (k + 1) + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }

    private static boolean hasDuplicate(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int value : array) {
            if (!seen.add(value)) {
                return true;
            }
        }
        return false;
    }
}