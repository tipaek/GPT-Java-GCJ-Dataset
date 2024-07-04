import java.io.*;
import java.util.*;

class Solution {
    public static int countDuplicateColumns(int[][] matrix) {
        int duplicateCount = 0;
        for (int col = 0; col < matrix.length; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < matrix.length; row++) {
                if (uniqueElements.contains(matrix[row][col])) {
                    duplicateCount++;
                    break;
                }
                uniqueElements.add(matrix[row][col]);
            }
        }
        return duplicateCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int trace = 0;
            int duplicateRows = 0;

            for (int row = 0; row < size; row++) {
                Set<Integer> uniqueElements = new HashSet<>();
                boolean hasDuplicate = false;
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                    if (!hasDuplicate && uniqueElements.contains(matrix[row][col])) {
                        duplicateRows++;
                        hasDuplicate = true;
                    }
                    uniqueElements.add(matrix[row][col]);
                }
            }

            int duplicateColumns = countDuplicateColumns(matrix);
            result.append(String.format("Case #%d: %d %d %d%n", t + 1, trace, duplicateRows, duplicateColumns));
        }

        System.out.print(result);
    }
}