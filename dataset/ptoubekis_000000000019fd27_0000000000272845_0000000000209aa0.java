import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int i = 1; i <= cases; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[][] m = new int[n][n];
            String s = foo(n, k, m);
            System.out.println("Case #" + i + ": " + s);
            if (s.equals("POSSIBLE")) {
                for (int l = 0; l < n; l++) {
                    for (int c = 0; c < n; c++) {
                        System.out.print(m[l][c] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    private static String foo(int n, int k, int[][] m) {
        if (k % n == 0) {
            copy(m1(n, k / n), m);
            return "POSSIBLE";
        }
        if (n == 4) {
            if (k == 6) {
                copy(m42(new int[]{1, 2, 3, 4}), m);
                return "POSSIBLE";
            } else if (k == 10) {
                copy(m42(new int[]{2, 3, 1, 4}), m);
                return "POSSIBLE";
            } else if (k == 14) {
                copy(m42(new int[]{3, 4, 1, 2}), m);
                return "POSSIBLE";
            } else if (k == 7) {
                copy(m43(new int[]{1, 2, 3, 4}), m);
                return "POSSIBLE";
            } else if (k == 9) {
                copy(m43(new int[]{1, 4, 3, 2}), m);
                return "POSSIBLE";
            } else if (k == 11) {
                copy(m43(new int[]{2, 3, 4, 1}), m);
                return "POSSIBLE";
            } else if (k == 13) {
                copy(m43(new int[]{4, 3, 2, 1}), m);
                return "POSSIBLE";
            }
        } else if (n == 5) {
            for (int i = 1; i <= 5; i++) {
                for (int j = 1; j <= 5; j++) {
                    if (i != j && k == i * 3 + j * 2) {
                        int[] e = new int[5];
                        e[0] = i;
                        e[1] = j;
                        boolean[] in = new boolean[5];
                        in[i - 1] = in[j - 1] = true;
                        for (int x = 2; x < 5; x++) {
                            for (int y = 0; y < 5; y++) {
                                if (!in[y]) {
                                    e[x] = y + 1;
                                    in[y] = true;
                                    break;
                                }
                            }
                        }
                        copy(m52(e), m);
                        return "POSSIBLE";
                    }
                }
            }
        }
        return "IMPOSSIBLE";
    }

    private static int[][] m1(int n, int d) {
        int e[] = new int[n];
        for (int i = 0; i < n; i++) {
            e[i] = i + 1;
        }
        e[d - 1] = 1;
        e[0] = d;
        int[][] m = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[j][(j + i) % n] = e[i];
            }
        }
        return m;
    }

    private static int[][] m42(int[] e) {
        int[][] m = new int[][]{{1, 2, 3, 4}, {2, 1, 4, 3}, {3, 4, 2, 1}, {4, 3, 1, 2}};
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                m[i][j] = e[m[i][j] - 1];
            }
        }
        return m;
    }

    private static int[][] m43(int[] e) {
        int[][] m = new int[][]{{1, 2, 3, 4}, {3, 1, 4, 2}, {4, 3, 2, 1}, {2, 4, 1, 3}};
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                m[i][j] = e[m[i][j] - 1];
            }
        }
        return m;
    }

    private static int[][] m52(int[] e) {
        int[][] m = new int[][]{
            {1, 2, 4, 3, 5},
            {5, 1, 2, 4, 3},
            {2, 3, 1, 5, 4},
            {3, 4, 5, 2, 1},
            {4, 5, 3, 1, 2}
        };
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                m[i][j] = e[m[i][j] - 1];
            }
        }
        return m;
    }

    private static void copy(int[][] from, int[][] to) {
        int n = from.length;
        for (int i = 0; i < n; i++) {
            System.arraycopy(from[i], 0, to[i], 0, n);
        }
    }

}
