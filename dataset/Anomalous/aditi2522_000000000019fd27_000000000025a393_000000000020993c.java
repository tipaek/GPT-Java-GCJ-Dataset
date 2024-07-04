import java.util.HashSet;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int duplicateRows = 0;
            int duplicateCols = 0;
            int trace = 0;

            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;

                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (!rowSet.add(matrix[i][j]) && !rowHasDuplicate) {
                        duplicateRows++;
                        rowHasDuplicate = true;
                    }
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                boolean colHasDuplicate = false;

                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j]) && !colHasDuplicate) {
                        duplicateCols++;
                        colHasDuplicate = true;
                        break;
                    }
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }
}