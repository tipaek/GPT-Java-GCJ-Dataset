import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    static void sortBy(int[] a, int n, int[] v) {
        if (n == 0) return;

        for (int i = 1; i < n; i++) {
            int j = i;
            int ca = a[i];
            int cv = v[ca];
            while (j > 0) {
                int parent = (j - 1) >> 1;
                if (cv <= v[a[parent]]) break;
                a[j] = a[parent];
                j = parent;
            }
            a[j] = ca;
        }

        for (int i = n - 1; i > 0; i--) {
            int ca = a[0];
            a[0] = a[i];
            int j = 0;
            while (true) {
                int left = (j << 1) + 1;
                int right = left + 1;
                if (left >= i) break;
                int maxChild = (right < i && v[a[right]] > v[a[left]]) ? right : left;
                if (v[ca] >= v[a[maxChild]]) break;
                a[j] = a[maxChild];
                j = maxChild;
            }
            a[j] = ca;
        }
    }

    static void solve() throws IOException {
        int n = scanInt();
        int[] s = new int[n];
        int[] e = new int[n];
        int[] idx = new int[n];

        for (int i = 0; i < n; i++) {
            s[i] = scanInt();
            e[i] = scanInt();
            idx[i] = i;
        }

        sortBy(idx, n, s);
        char[] ans = new char[n];
        int have0 = 0, have1 = 0;

        for (int i : idx) {
            if (s[i] >= have0) {
                ans[i] = 'C';
                have0 = e[i];
            } else if (s[i] >= have1) {
                ans[i] = 'J';
                have1 = e[i];
            } else {
                printCase();
                out.println("IMPOSSIBLE");
                return;
            }
        }
        printCase();
        out.println(ans);
    }

    static int scanInt() throws IOException {
        return Integer.parseInt(scanString());
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