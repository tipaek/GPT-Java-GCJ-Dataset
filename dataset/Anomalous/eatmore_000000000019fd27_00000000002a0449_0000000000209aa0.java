import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    static void solve() throws Exception {
        int n = scanInt(), k = scanInt();
        printCase();
        if (k == n + 1 || k == n * n - 1 || (n == 3 && k % 3 != 0)) {
            out.println("IMPOSSIBLE");
            return;
        }
        out.println("POSSIBLE");
        if (k % n == 0) {
            printMatrix(n, k);
            return;
        }
        int a = Math.min((k - 2) / (n - 2), n);
        int b = k - a * (n - 2) - 1, c = 1;
        if (b > n) {
            c += b - n;
            b = n;
        }
        if (a == b || a == c) {
            --b;
            ++c;
        }
        if (a == b || a == c) {
            --a;
            b += n - 2;
            if (b > n) {
                c += b - n;
                b = n;
            }
            if (a == b || a == c) {
                --b;
                ++c;
            }
        }
        --a;
        --b;
        --c;
        int[] p = new int[n];
        java.util.Arrays.fill(p, -1);
        if (b != c) {
            p[0] = a;
            p[1] = b;
            p[n - 1] = c;
        } else if (n % 2 == 0) {
            p[0] = a;
            p[n / 2] = b;
        } else {
            p[n - 2] = a;
            p[n - 1] = b;
        }
        boolean[] have = new boolean[n];
        have[a] = have[b] = have[c] = true;
        for (int i = 0, j = 0; i < n; i++) {
            if (p[i] < 0) {
                while (have[j]) {
                    ++j;
                }
                have[j] = true;
                p[i] = j;
            }
        }
        printMatrix(n, p, b, c);
    }

    static void printMatrix(int n, int k) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                out.print(((k / n + i - j + n - 1) % n + 1) + " ");
            }
            out.println();
        }
    }

    static void printMatrix(int n, int[] p, int b, int c) {
        if (b != c) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    out.print((p[((i < 2 ? 1 - i : i) - j + n) % n] + 1) + " ");
                }
                out.println();
            }
        } else if (n % 2 == 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    out.print((p[((i == 0 ? n / 2 : i == n / 2 ? 0 : i) - j + n) % n] + 1) + " ");
                }
                out.println();
            }
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    out.print((p[getIndex(i, j, n)] + 1) + " ");
                }
                out.println();
            }
        }
    }

    static int getIndex(int i, int j, int n) {
        if (i < n - 2 && j < n - 2) {
            if (i == j) return n - 2;
            if (i == (j + 1) % (n - 2)) return n - 1;
            return (i + j) % (n - 2);
        }
        if (i < n - 2) {
            if (j == n - 2) return 2 * i % (n - 2);
            return (2 * i + n - 3) % (n - 2);
        }
        if (j < n - 2) {
            if (i == n - 2) return 2 * j % (n - 2);
            return (2 * j + 1) % (n - 2);
        }
        return i == j ? n - 1 : n - 2;
    }

    static int scanInt() throws IOException {
        return Integer.parseInt(scanString());
    }

    static long scanLong() throws IOException {
        return Long.parseLong(scanString());
    }

    static String scanString() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    static void printCase() {
        out.print("Case #" + test + ": ");
    }

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;
    static int test;

    public static void main(String[] args) {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int tests = scanInt();
            for (test = 1; test <= tests; test++) {
                solve();
            }
            in.close();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}