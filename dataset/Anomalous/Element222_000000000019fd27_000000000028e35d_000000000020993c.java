import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();

        for (int p = 0; p < cases; p++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            // Read the matrix and compute the trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Check for duplicate rows
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean hasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        hasDuplicate = true;
                    }
                }
                if (hasDuplicate) {
                    duplicateRows++;
                }
            }

            // Check for duplicate columns
            for (int i = 0; i < n; i++) {
                Set<Integer> colSet = new HashSet<>();
                boolean hasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    if (!colSet.add(matrix[j][i])) {
                        hasDuplicate = true;
                    }
                }
                if (hasDuplicate) {
                    duplicateColumns++;
                }
            }

            System.out.println("Case #" + (p + 1) + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}