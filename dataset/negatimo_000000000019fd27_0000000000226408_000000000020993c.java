import java.util.Scanner;

public class Solution {

    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            solve(i);
        }
        sc.close();
    }

    static void solve(int x) {
        int N = sc.nextInt();

        int[][] matrix = new int[N][N];
        for (int ir = 0; ir < N; ir++) {
            for (int ic = 0; ic < N; ic++) {
                matrix[ir][ic] = sc.nextInt();
            }
        }

        int k = trace(matrix);
        int r = r(matrix);
        int c = c(matrix);

        String ans = String.format("Case #%d: %d %d %d", x, k, r, c);
        System.out.println(ans);

    }

    static int trace(int[][] m) {
        int N = m.length;

        int trace = 0;
        for (int i = 0; i < N; i++) {
            trace += m[i][i];
        }

        return trace;
    }

    static int r(int[][] m) {
        int N = m.length;

        int value = 0;
        for (int ri = 0; ri < N; ri++) {
            boolean[] b = new boolean[N + 1];

            for (int ci = 0; ci < N; ci++) {
                if (b[m[ri][ci]]) {
                    value++;
                    break;
                } else {
                    b[m[ri][ci]] = true;
                }
            }
        }

        return value;
    }

    static int c(int[][] m) {
        int N = m.length;

        int value = 0;
        for (int ci = 0; ci < N; ci++) {
            boolean[] b = new boolean[N + 1];

            for (int ri = 0; ri < N; ri++) {
                if (b[m[ri][ci]]) {
                    value++;
                    break;
                } else {
                    b[m[ri][ci]] = true;
                }
            }
        }

        return value;
    }

}
