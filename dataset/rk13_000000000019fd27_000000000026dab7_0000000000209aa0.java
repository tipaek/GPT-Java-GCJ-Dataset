import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static int n;
    static int k;

    static List<int[]> diagonals;
    static boolean[][] rows;
    static boolean[][] cols;

    static int[][] a;

    private static void findDiagonals(int[] row, int pos, int sum) {

        if (sum == k && pos == n) {
            diagonals.add(Arrays.copyOf(row, row.length));
            return;
        }
        if (sum > k || pos >= n) {
            return;
        }
        for (int i = 0; i < n; i++) {
            row[pos] = i + 1;
            findDiagonals(row, pos + 1, sum + i + 1);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());
        for (int ti = 1; ti <= t; ti++) {
            String[] s = in.nextLine().split(" ");
            calculate(ti, Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }
    }

    public static void calculate(int ti, int nn, int kk) {
        n = nn;
        k = kk;

        diagonals = new ArrayList<>();
        findDiagonals(new int[n], 0, 0);

        for (int i = 0; i < diagonals.size(); i++) {
            int[] diagonal = diagonals.get(i);

            rows = new boolean[n][n + 1];
            cols = new boolean[n][n + 1];
            a = new int[n][n];

            for (int j = 0; j < n; j++) {
                a[j][j] = diagonal[j];
                rows[j][diagonal[j]] = true;
                cols[j][diagonal[j]] = true;
            }

            if (next(0)) {
                System.out.println("Case #" + ti + ": POSSIBLE");
                for (int r = 0; r < n; r++) {
                    for (int c = 0; c < n; c++) {
                        System.out.print(a[r][c]);
                        if (c < n - 1) {
                            System.out.print(' ');
                        }
                    }
                    System.out.println();
                }
                return;
            }
        }
        System.out.println("Case #" + ti + ": IMPOSSIBLE");
    }

    private static boolean next(int pos) {
        if (pos == n * n) {
            return true;
        }

        int r = pos / n;
        int c = pos % n;

        if (a[r][c] != 0) {
            return next(pos + 1);
        } else {
            for (int i = 1; i <= n; i++) {
                if (!rows[r][i] && !cols[c][i]) {
                    rows[r][i] = true;
                    cols[c][i] = true;
                    a[r][c] = i;

                    if (next(pos + 1)) {
                        return true;
                    }

                    a[r][c] = 0;
                    rows[r][i] = false;
                    cols[c][i] = false;
                }
            }
        }
        return false;
    }
}
