import java.util.Scanner;

class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int testcase = 1;

        for (int p = 0; p < T; p++) {
            int n = sc.nextInt();
            int[][] mat = new int[n][n];
            int sum = 0, rowCount = 0, colCount = 0;

            // Read matrix input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }

            // Calculate the sum of the diagonal
            for (int i = 0; i < n; i++) {
                sum += mat[i][i];
            }

            // Check for duplicate values in rows
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(mat[i][j])) {
                        rowCount++;
                        break;
                    }
                }
            }

            // Check for duplicate values in columns
            for (int i = 0; i < n; i++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!colSet.add(mat[j][i])) {
                        colCount++;
                        break;
                    }
                }
            }

            // Print the results for the current test case
            System.out.println("Case #" + testcase + ": " + sum + " " + rowCount + " " + colCount);
            testcase++;
        }

        sc.close();
    }
}