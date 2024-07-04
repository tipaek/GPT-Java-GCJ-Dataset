import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static void analyzeMatrix(int caseNumber, int size, int[][] matrix) {
        int trace = 0;
        int duplicateRows = 0;
        int duplicateCols = 0;

        // Check rows and calculate trace
        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                rowSet.add(matrix[i][j]);
                if (i == j) {
                    trace += matrix[i][j];
                }
            }
            if (rowSet.size() != size) {
                duplicateRows++;
            }
        }

        // Check columns
        for (int j = 0; j < size; j++) {
            Set<Integer> colSet = new HashSet<>();
            for (int i = 0; i < size; i++) {
                colSet.add(matrix[i][j]);
            }
            if (colSet.size() != size) {
                duplicateCols++;
            }
        }

        System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, duplicateRows, duplicateCols);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= cases; caseNumber++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            analyzeMatrix(caseNumber, size, matrix);
        }

        scanner.close();
    }
}