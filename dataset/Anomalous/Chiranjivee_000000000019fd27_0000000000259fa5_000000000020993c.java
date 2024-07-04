import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int trace = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            // Read matrix and calculate trace and duplicate rows
            for (int i = 0; i < size; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean hasDuplicateRow = false;
                for (int j = 0; j < size; j++) {
                    int value = scanner.nextInt();
                    matrix[i][j] = value;
                    if (!rowSet.add(value)) {
                        hasDuplicateRow = true;
                    }
                    if (i == j) {
                        trace += value;
                    }
                }
                if (hasDuplicateRow) {
                    duplicateRows++;
                }
            }

            // Check for duplicate columns
            for (int j = 0; j < size; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean hasDuplicateColumn = false;
                for (int i = 0; i < size; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        hasDuplicateColumn = true;
                    }
                }
                if (hasDuplicateColumn) {
                    duplicateColumns++;
                }
            }

            System.out.println("Case #" + caseNumber++ + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}