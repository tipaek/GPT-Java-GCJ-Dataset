import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int l = 1; l <= t; l++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int diagonalSum = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            // Read matrix values
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            // Calculate diagonal sum
            for (int i = 0; i < n; i++) {
                diagonalSum += matrix[i][i];
            }

            // Check for duplicate values in rows
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() != n) {
                    rowRepeats++;
                }
            }

            // Check for duplicate values in columns
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    colSet.add(matrix[i][j]);
                }
                if (colSet.size() != n) {
                    colRepeats++;
                }
            }

            // Output the result for the current test case
            System.out.println("case #" + l + ": " + diagonalSum + " " + rowRepeats + " " + colRepeats);
        }

        sc.close();
    }
}