import java.util.Scanner;

public class Codejam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int rowCount = 0;
            int colCount = 0;

            // Read the matrix and calculate the trace
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = sc.nextInt();
                    if (j == k) {
                        trace += matrix[j][k];
                    }
                }
            }

            // Check for duplicate values in each row
            for (int j = 0; j < n; j++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    if (!rowSet.add(matrix[j][k])) {
                        rowCount++;
                        break;
                    }
                }
            }

            // Check for duplicate values in each column
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    if (!colSet.add(matrix[k][j])) {
                        colCount++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + rowCount + " " + colCount);
        }

        sc.close();
    }
}