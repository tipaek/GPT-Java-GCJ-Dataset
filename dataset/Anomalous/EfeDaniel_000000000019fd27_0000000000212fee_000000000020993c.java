import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
                int size = scanner.nextInt();
                int[][] matrix = new int[size][size];
                for (int row = 0; row < size; row++) {
                    for (int col = 0; col < size; col++) {
                        matrix[row][col] = scanner.nextInt();
                    }
                }
                System.out.println(String.format("Case #%d: %s", caseNumber, analyzeMatrix(size, matrix)));
            }
        }
    }

    private static String analyzeMatrix(int size, int[][] matrix) {
        Set<String> uniqueEntries = new HashSet<>();
        Set<Integer> duplicateRows = new HashSet<>();
        Set<Integer> duplicateColumns = new HashSet<>();
        int trace = 0;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (row == col) {
                    trace += matrix[row][col];
                }

                String rowKey = row + "-r-" + matrix[row][col];
                String colKey = col + "-c-" + matrix[row][col];

                if (!uniqueEntries.add(rowKey)) {
                    duplicateRows.add(row);
                }
                if (!uniqueEntries.add(colKey)) {
                    duplicateColumns.add(col);
                }
            }
        }

        return trace + " " + duplicateRows.size() + " " + duplicateColumns.size();
    }
}