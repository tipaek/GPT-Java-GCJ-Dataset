import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int r = 0; r < size; r++) {
                for (int c = 0; c < size; c++) {
                    matrix[r][c] = scanner.nextInt();
                }
            }

            int trace = calculateTrace(matrix, size);
            int duplicateRows = countDuplicateRows(matrix, size);
            int duplicateColumns = countDuplicateColumns(matrix, size);

            printResult(i, trace, duplicateRows, duplicateColumns);
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
        for (int r = 0; r < size; r++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int c = 0; c < size; c++) {
                if (!uniqueElements.add(matrix[r][c])) {
                    duplicateRows++;
                    break;
                }
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateColumns(int[][] matrix, int size) {
        int duplicateColumns = 0;
        for (int c = 0; c < size; c++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int r = 0; r < size; r++) {
                if (!uniqueElements.add(matrix[r][c])) {
                    duplicateColumns++;
                    break;
                }
            }
        }
        return duplicateColumns;
    }

    private static void printResult(int caseNumber, int trace, int duplicateRows, int duplicateColumns) {
        System.out.println("Case #" + (caseNumber + 1) + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
    }
}