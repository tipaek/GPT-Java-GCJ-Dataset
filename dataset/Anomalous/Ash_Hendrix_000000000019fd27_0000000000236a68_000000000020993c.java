import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        for (int k = 1; k <= T; k++) {
            int n = in.nextInt();
            int[][] a = new int[n][n];
            int[][] b = new int[n][n];
            int trace = 0;
            int rc = 0;
            int cc = 0;

            // Read the matrix and calculate the trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = in.nextInt();
                    if (i == j) {
                        trace += a[i][j];
                    }
                }
            }

            // Check for duplicate rows
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(a[i][j])) {
                        rc++;
                        break;
                    }
                }
            }

            // Transpose the matrix to `b`
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    b[i][j] = a[j][i];
                }
            }

            // Check for duplicate columns (in the transposed matrix `b`)
            for (int i = 0; i < n; i++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!colSet.add(b[i][j])) {
                        cc++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + k + ": " + trace + " " + rc + " " + cc);
        }
    }
}