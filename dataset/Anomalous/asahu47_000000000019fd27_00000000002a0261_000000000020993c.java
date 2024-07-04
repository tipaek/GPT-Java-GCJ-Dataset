import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            int trace = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int duplicateRows = 0;
            int duplicateCols = 0;

            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                boolean colHasDuplicate = false;

                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowHasDuplicate = true;
                    }
                    if (!colSet.add(matrix[j][i])) {
                        colHasDuplicate = true;
                    }
                }

                if (rowHasDuplicate) {
                    duplicateRows++;
                }
                if (colHasDuplicate) {
                    duplicateCols++;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
        scanner.close();
    }
}