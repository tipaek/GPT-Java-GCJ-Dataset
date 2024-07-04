import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int trace = calculateTrace(matrix, size);
            int duplicateRows = countDuplicateRows(matrix, size);
            int duplicateColumns = countDuplicateColumns(matrix, size);

            System.out.printf("Case #%d: %d %d %d%n", testCase, trace, duplicateRows, duplicateColumns);
        }
        
        scanner.close();
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix, int size) {
        int duplicateRows = 0;
        for (int row = 0; row < size; row++) {
            Set<Integer> rowSet = new HashSet<>();
            boolean hasDuplicate = false;
            for (int col = 0; col < size; col++) {
                if (!rowSet.add(matrix[row][col])) {
                    hasDuplicate = true;
                    break;
                }
            }
            if (hasDuplicate) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateColumns(int[][] matrix, int size) {
        int duplicateColumns = 0;
        for (int col = 0; col < size; col++) {
            Set<Integer> colSet = new HashSet<>();
            boolean hasDuplicate = false;
            for (int row = 0; row < size; row++) {
                if (!colSet.add(matrix[row][col])) {
                    hasDuplicate = true;
                    break;
                }
            }
            if (hasDuplicate) {
                duplicateColumns++;
            }
        }
        return duplicateColumns;
    }
}