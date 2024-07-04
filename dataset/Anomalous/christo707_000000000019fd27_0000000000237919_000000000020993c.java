import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int k = 0; k < t; k++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowDuplicateFound = false;
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (!rowDuplicateFound && !rowSet.add(matrix[i][j])) {
                        rowDuplicates++;
                        rowDuplicateFound = true;
                    }
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean colDuplicateFound = false;
                for (int i = 0; i < n; i++) {
                    if (!colDuplicateFound && !colSet.add(matrix[i][j])) {
                        colDuplicates++;
                        colDuplicateFound = true;
                    }
                }
            }

            System.out.println("Case #" + (k + 1) + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}