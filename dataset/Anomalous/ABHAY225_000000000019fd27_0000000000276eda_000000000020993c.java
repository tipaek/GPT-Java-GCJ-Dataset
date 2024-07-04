import java.util.Scanner;

class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int p = 1; p <= T; p++) {
            int n = sc.nextInt();
            int sum = 0;
            int row_count = 0;
            int col_count = 0;

            int[][] mat = new int[n][n];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }

            // Calculating the sum of the diagonal
            for (int i = 0; i < n; i++) {
                sum += mat[i][i];
            }

            // Checking for duplicate rows
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(mat[i][j])) {
                        row_count++;
                        break;
                    }
                }
            }

            // Checking for duplicate columns
            for (int i = 0; i < n; i++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!colSet.add(mat[j][i])) {
                        col_count++;
                        break;
                    }
                }
            }

            // Printing the result
            System.out.println("Case #" + p + ": " + sum + " " + row_count + " " + col_count);
        }
    }
}