import java.util.HashSet;
import java.util.Scanner;

class Solution {

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix, int size) {
        int duplicateRowCount = 0;
        for (int i = 0; i < size; i++) {
            HashSet<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    duplicateRowCount++;
                    break;
                }
            }
        }
        return duplicateRowCount;
    }

    private static int countDuplicateColumns(int[][] matrix, int size) {
        int duplicateColumnCount = 0;
        for (int j = 0; j < size; j++) {
            HashSet<Integer> columnSet = new HashSet<>();
            for (int i = 0; i < size; i++) {
                if (!columnSet.add(matrix[i][j])) {
                    duplicateColumnCount++;
                    break;
                }
            }
        }
        return duplicateColumnCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = calculateTrace(matrix, size);
            int duplicateRows = countDuplicateRows(matrix, size);
            int duplicateColumns = countDuplicateColumns(matrix, size);

            System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}