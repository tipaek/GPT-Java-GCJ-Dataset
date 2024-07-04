import java.util.Scanner;

class Matrix {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();

        while (testcase > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];

            // Read the matrix input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = sc.nextInt();
                }
            }

            int colDuplicateCount = 0;
            int rowDuplicateCount = 0;
            int m = 0; // Count of columns with duplicates
            int h = 0; // Count of rows with duplicates

            // Check for duplicate elements in columns and rows
            for (int i = 0; i < n; i++) {
                colDuplicateCount = 0;
                rowDuplicateCount = 0;

                for (int j = 0; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if (a[j][i] == a[k][i]) {
                            colDuplicateCount++;
                        }
                        if (a[i][j] == a[i][k]) {
                            rowDuplicateCount++;
                        }
                    }
                }

                if (colDuplicateCount > 0) {
                    m++;
                }
                if (rowDuplicateCount > 0) {
                    h++;
                }
            }

            // Calculate the sum of the diagonal elements
            int diagonalSum = 0;
            for (int i = 0; i < n; i++) {
                diagonalSum += a[i][i];
            }

            System.out.println("case #" + testcase + ": " + diagonalSum + " " + h + " " + m);
            testcase--;
        }

        sc.close();
    }
}