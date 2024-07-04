import java.util.Scanner;

public class Codejam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int rowRepeatCount = 0;
            int colRepeatCount = 0;

            // Read the matrix and calculate the trace
            for (int j = 0; j < n; j++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = sc.nextInt();
                    if (j == k) {
                        trace += matrix[j][k];
                    }
                    if (!rowSet.add(matrix[j][k])) {
                        rowHasDuplicate = true;
                    }
                }
                if (rowHasDuplicate) {
                    rowRepeatCount++;
                }
            }

            // Check for duplicates in each column
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean colHasDuplicate = false;
                for (int k = 0; k < n; k++) {
                    if (!colSet.add(matrix[k][j])) {
                        colHasDuplicate = true;
                    }
                }
                if (colHasDuplicate) {
                    colRepeatCount++;
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + rowRepeatCount + " " + colRepeatCount);
        }

        sc.close();
    }
}