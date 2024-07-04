import java.util.HashSet;
import java.util.Scanner;

public class Vest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            // Read matrix and calculate trace
            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    rowSet.add(matrix[i][j]);
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
                if (rowSet.size() < n) {
                    duplicateRows++;
                }
            }

            // Check for duplicate columns
            for (int j = 0; j < n; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    colSet.add(matrix[i][j]);
                }
                if (colSet.size() < n) {
                    duplicateCols++;
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
        scanner.close();
    }
}