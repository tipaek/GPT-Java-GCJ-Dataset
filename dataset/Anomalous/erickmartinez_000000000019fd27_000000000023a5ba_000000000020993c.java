import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            evaluateMatrix(matrix, n, i);
        }
    }

    public static void evaluateMatrix(int[][] matrix, int n, int caseNumber) {
        int duplicateRows = 0;
        int duplicateColumns = 0;
        int trace = 0;

        for (int i = 0; i < n; i++) {
            HashSet<Integer> rowSet = new HashSet<>();
            HashSet<Integer> colSet = new HashSet<>();
            trace += matrix[i][i];

            boolean rowHasDuplicate = false;
            boolean colHasDuplicate = false;

            for (int j = 0; j < n; j++) {
                if (!rowHasDuplicate && !rowSet.add(matrix[i][j])) {
                    duplicateRows++;
                    rowHasDuplicate = true;
                }
                if (!colHasDuplicate && !colSet.add(matrix[j][i])) {
                    duplicateColumns++;
                    colHasDuplicate = true;
                }
            }
        }

        System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
    }
}