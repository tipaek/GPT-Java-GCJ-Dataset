import java.util.Scanner;

class Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();

        while (testcase > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];

            // Reading matrix elements
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = sc.nextInt();
                }
            }

            int c = 0;
            int m = 0;

            // Checking columns for duplicate elements
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if (a[j][i] == a[k][i]) {
                            c++;
                        }
                    }
                }
                if (c > n) {
                    m++;
                } else if (c != 0 && c < n) {
                    m++;
                }
                c = 0;
            }

            c = 0;
            int con = 0;

            // Checking rows for duplicate elements
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if (a[i][j] == a[i][k]) {
                            c++;
                        }
                    }
                }
                if (c > n) {
                    con++;
                } else if (c != 0 && c < n) {
                    con++;
                }
                c = 0;
            }

            int t = 0;

            // Calculating the trace of the matrix
            for (int i = 0; i < n; i++) {
                t += a[i][i];
            }

            // Printing the result for the current testcase
            System.out.println("case #" + testcase + ": " + t + " " + con + " " + m);
            testcase--;
        }
    }
}