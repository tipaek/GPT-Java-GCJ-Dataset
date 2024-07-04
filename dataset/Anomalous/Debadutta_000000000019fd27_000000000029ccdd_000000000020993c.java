import java.util.Scanner;

class Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();

        while (testcase > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = sc.nextInt();
                }
            }

            int duplicateColumns = 0;
            int duplicateRows = 0;
            int trace = 0;

            // Calculate trace
            for (int i = 0; i < n; i++) {
                trace += a[i][i];
            }

            // Check for duplicate elements in columns
            for (int i = 0; i < n; i++) {
                Set<Integer> columnSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!columnSet.add(a[j][i])) {
                        duplicateColumns++;
                        break;
                    }
                }
            }

            // Check for duplicate elements in rows
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(a[i][j])) {
                        duplicateRows++;
                        break;
                    }
                }
            }

            System.out.println("case #" + testcase + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
            testcase--;
        }
        sc.close();
    }
}