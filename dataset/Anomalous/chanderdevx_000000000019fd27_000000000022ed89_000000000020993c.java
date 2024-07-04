import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        for (int x = 1; x <= t; x++) {
            int n = Integer.parseInt(sc.nextLine());
            int[][] matrix = new int[n][n];
            int sum = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            // Reading the matrix and calculating the sum of the diagonal
            for (int i = 0; i < n; i++) {
                String[] row = sc.nextLine().split(" ");
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;

                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);

                    // Sum of the diagonal
                    if (i == j) {
                        sum += matrix[i][j];
                    }

                    // Check for duplicates in the row
                    if (!rowHasDuplicate && !rowSet.add(matrix[i][j])) {
                        rowHasDuplicate = true;
                        rowDuplicates++;
                    }
                }
            }

            // Check for duplicates in each column
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean colHasDuplicate = false;

                for (int i = 0; i < n; i++) {
                    if (!colHasDuplicate && !colSet.add(matrix[i][j])) {
                        colHasDuplicate = true;
                        colDuplicates++;
                    }
                }
            }

            System.out.println("Case #" + x + ": " + sum + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}