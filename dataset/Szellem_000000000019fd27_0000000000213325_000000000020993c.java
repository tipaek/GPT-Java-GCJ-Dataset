import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.IntStream;

public class Solution {
    static class TestCase {
        final int index;
        boolean[][] columns;
        boolean[][] rows;
        int trace = 0;
        int n;
        int r;
        int c;

        TestCase(int index) {
            this.index = index;
        }

        void solve() {
            System.out.println("Case #" + index + ": " + " " + trace + " " + r + " " + c);
        }
    }

    TestCase readTestCase(Scanner in, int index) {
        TestCase tc = new TestCase(index);

        tc.n = in.nextInt();
        tc.columns = new boolean[tc.n][tc.n+1];
        tc.rows = new boolean[tc.n][tc.n+1];

        for (int i = 0; i < tc.n; i++) {
            for (int j = 0; j < tc.n; j++) {
                int x = in.nextInt();
                if (i == j) {
                    tc.trace += x;
                }
                if (tc.columns[j][x] && !tc.columns[j][0]) {
                    tc.c++;
                    tc.columns[j][0] = true;
                }
                tc.columns[j][x] = true;

                if (tc.rows[i][x] && !tc.rows[i][0]) {
                    tc.r++;
                    tc.rows[i][0] = true;
                }
                tc.rows[i][x] = true;
            }
        }

        return tc;
    }

    void run() {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            readTestCase(in, i).solve();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.run();
    }
}
