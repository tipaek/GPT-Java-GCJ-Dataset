import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

    static boolean fillMatrix(int i, int j, int k, int n, int[][] b, int[][] row, int[][] col, int count) {
        for (int l = i; l < n; l++) {
            for (int m = j; m < n; m++) {
                if (b[l][m] != -1)
                    continue;
                for (int o = k; o <= n; o++) {
                    count++;
                    if (o == n && (row[l][o] == 1 || col[m][o] == 1)) {
                        return false;
                    } else if (row[l][o] == 1 || col[m][o] == 1) {
                        continue;
                    } else {
                        b[l][m] = o;
                        row[l][o] = 1;
                        col[m][o] = 1;
                        boolean check;
                        if (m + 1 < n)
                            check = fillMatrix(l, m + 1, 1, n, b, row, col, count);
                        else
                            check = fillMatrix(l + 1, 0, 1, n, b, row, col, count);
                        if (!check) {
                            b[l][m] = -1;
                            row[l][o] = 0;
                            col[m][o] = 0;
                            if (o == n)
                                return false;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        for (int i = 1; i <= testCases; i++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int tr = Integer.parseInt(input[1]);

            if (n == 2 && (tr == 3 || tr == 2 || tr == 4)) {
                System.out.printf("Case #%d: %s\n", i, tr == 3 ? "IMPOSSIBLE" : "POSSIBLE");
                if (tr == 2) {
                    System.out.println("1 2");
                    System.out.println("2 1");
                } else if (tr == 4) {
                    System.out.println("2 1");
                    System.out.println("1 2");
                }
                continue;
            }

            if (n == 3 && (tr == 4 || tr == 5 || tr == 7 || tr == 8 || tr == 6 || tr == 9)) {
                System.out.printf("Case #%d: %s\n", i, (tr == 4 || tr == 5 || tr == 7 || tr == 8) ? "IMPOSSIBLE" : "POSSIBLE");
                if (tr == 6) {
                    System.out.println("1 2 3");
                    System.out.println("2 3 1");
                    System.out.println("3 1 2");
                } else if (tr == 9) {
                    System.out.println("3 1 2");
                    System.out.println("2 3 1");
                    System.out.println("1 2 3");
                }
                continue;
            }

            if (tr < n || tr == n + 1 || tr == n * n - 1) {
                System.out.printf("Case #%d: %s\n", i, "IMPOSSIBLE");
                continue;
            } else if (tr == n) {
                int[][] b = new int[n][n];
                for (int j = 0; j < n; j++) {
                    b[0][j] = j + 1;
                }
                for (int j = 1; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        b[j][k] = b[j - 1][(n - 1 + k) % n];
                    }
                }
                printMatrix(i, n, b);
                continue;
            }

            int[] a = new int[n];
            int[][] b = new int[n][n];
            int[][] row = new int[n + 1][n + 1];
            int[][] col = new int[n + 1][n + 1];
            for (int j = 0; j < n - 2; j++) {
                a[j] = 1;
            }
            a[n - 2] = 2;
            a[n - 1] = 2;
            int sum = n - 2 + 4;
            tr -= sum;
            for (int j = n - 1; tr != 0; j--) {
                if (j == -1) {
                    j = n - 1;
                }
                if (a[j] + 1 <= n) {
                    a[j]++;
                    tr--;
                }
            }
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    b[j][k] = -1;
                }
            }
            for (int j = 0; j < n; j++) {
                b[j][j] = a[j];
                row[j][a[j]] = 1;
                col[j][a[j]] = 1;
            }
            fillMatrix(0, 0, 1, n, b, row, col, 0);
            printMatrix(i, n, b);
        }
    }

    private static void printMatrix(int caseNumber, int n, int[][] b) {
        System.out.printf("Case #%d: %s\n", caseNumber, "POSSIBLE");
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                System.out.print(b[j][k] + " ");
            }
            System.out.println();
        }
    }
}