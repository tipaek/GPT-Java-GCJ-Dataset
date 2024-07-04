import java.util.Scanner;

class Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();

        while (testcase > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];

            // Read matrix input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = sc.nextInt();
                }
            }

            int duplicateColumns = 0;
            int duplicateRows = 0;
            int diagonalSum = 0;

            // Check for duplicate elements in columns
            for (int i = 0; i < n; i++) {
                int columnDuplicates = 0;
                for (int j = 0; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if (a[j][i] == a[k][i]) {
                            columnDuplicates++;
                        }
                    }
                }
                if (columnDuplicates > 0) {
                    duplicateColumns++;
                }
            }

            // Check for duplicate elements in rows
            for (int i = 0; i < n; i++) {
                int rowDuplicates = 0;
                for (int j = 0; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if (a[i][j] == a[i][k]) {
                            rowDuplicates++;
                        }
                    }
                }
                if (rowDuplicates > 0) {
                    duplicateRows++;
                }
            }

            // Calculate the sum of the diagonal elements
            for (int i = 0; i < n; i++) {
                diagonalSum += a[i][i];
            }

            // Print the result for the current test case
            System.out.println("case #" + testcase + ": " + diagonalSum + " " + duplicateRows + " " + duplicateColumns);
            testcase--;
        }
    }
}