import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: ngupta
 * Date: 4/4/2020 AD
 * Time: 21:05
 */
class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int x = 0;
        while (x < t) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            int[][] mat = latinMatrix(n);
            if (k % n == 0) {
                boolean test = checkMatrix(mat, n, k);
                if(test) {
                    System.out.println("Case #" + (x + 1) + ": POSSIBLE");
                    printMatrix(mat);
                } else {
                    System.out.println("Case #" + (x + 1) + ": IMPOSSIBLE");
                }
            } else {
                System.out.println("Case #" + (x + 1) + ": IMPOSSIBLE");
            }
            x++;
        }
    }

    private static boolean checkMatrix(int[][] mat, int n, int k) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                switchRow(mat, n, i, j);
                for (int r = 0; r < n; r++) {
                    for (int c = 0; c < n; c++) {
                        switchCol(mat, n, r, c);
                        int trc = trace(mat);
                        if (k == trc)
                            return true;
                        else {
                            for (int p = 0; p < n; p++) {
                                for (int q = 0; q < n; q++) {
                                    switchCol(mat, n, p, q);
                                    trc  = trace(mat);
                                    if (k == trc)
                                        return true;
                                    else switchCol(mat, n, p, q); //backtrack
                                }
                            }
                            switchCol(mat, n, r, c); //backtrack
                        }
                    }
                }
                switchRow(mat, n, i, j); //backtrack
            }
        }

        return false;
    }

    private static void switchCol(int[][] mat, int n, int c1, int c2) {
        for (int i = 0; i < n; i++) {
            int temp = mat[i][c1];
            mat[i][c1] = mat[i][c2];
            mat[i][c2] = temp;
        }
    }

    private static void switchRow(int[][] mat, int n, int r1, int r2) {
        for (int i = 0; i < n; i++) {
            int temp = mat[r1][i];
            mat[r1][i] = mat[r2][i];
            mat[r2][i] = temp;
        }
    }

    private static int trace(int[][] mat) {
        int n = mat.length;
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += mat[i][i];
        }

        return trace;
    }

    private static int[][] latinMatrix(int n) {
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = (i + j) % n + 1;
            }
        }
        return mat;
    }


    private static void printMatrix(int[][] mat) {
        int R = mat.length;
        int C = mat[0].length;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C - 1; c++) {
                System.out.print(mat[r][c] + " ");
            }
            System.out.println(mat[r][C-1]);
        }
    }
}