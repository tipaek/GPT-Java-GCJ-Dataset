import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int trace = 0, rowCount = 0, colCount = 0;

            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            scanner.nextLine();

            for (int row = 0; row < n; row++) {
                HashSet<Integer> rowSet = new HashSet<>();
                String line = scanner.nextLine();
                for (int col = 0; col < n; col++) {
                    int value = Character.getNumericValue(line.charAt(col * 2));
                    matrix[row][col] = value;
                    rowSet.add(value);
                    if (row == col) {
                        trace += value;
                    }
                }
                if (rowSet.size() < n) {
                    rowCount++;
                }
            }

            for (int col = 0; col < n; col++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int row = 0; row < n; row++) {
                    colSet.add(matrix[row][col]);
                }
                if (colSet.size() < n) {
                    colCount++;
                }
            }

            System.out.printf("case #%d: %d %d %d%n", caseNumber, trace, rowCount, colCount);
        }
    }
}