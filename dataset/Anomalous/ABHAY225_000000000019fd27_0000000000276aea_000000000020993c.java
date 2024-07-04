import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int p = 1; p <= T; p++) {
            int n = sc.nextInt();
            int[][] mat = new int[n][n];
            int sum = 0, row_count = 0, col_count = 0;

            // Read matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }

            // Calculate diagonal sum
            for (int i = 0; i < n; i++) {
                sum += mat[i][i];
            }

            // Check for duplicate rows
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(mat[i][j])) {
                        row_count++;
                        break;
                    }
                }
            }

            // Check for duplicate columns
            for (int i = 0; i < n; i++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!colSet.add(mat[j][i])) {
                        col_count++;
                        break;
                    }
                }
            }

            // Print result for the current case
            System.out.println("Case #" + p + ": " + sum + " " + row_count + " " + col_count);
        }
    }
}