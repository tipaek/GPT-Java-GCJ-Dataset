import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Aydar Gizatullin a.k.a. lightning95, aydar.gizatullin@gmail.com
 */
public class Solution {

    class Event {
        int id, time, type;

        Event(int a, int b, int c) {
            id = a;
            time = b;
            type = c;
        }
    }

    int[] xxx(int n, int len) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(n)).reverse();
        while (sb.length() < len) {
            sb.append('0');
        }
        char[] c = sb.toString().toCharArray();
        int[] a = new int[len];
        for (int i = 0; i < len; ++i) {
            a[i] = c[i] - '0';
        }
        return a;
    }

    private void solveOne() {
        int sn = rw.nextInt();
        int sm = rw.nextInt();

        int n = Math.abs(sn);
        int m = Math.abs(sm);
        if ((n + m) % 2 == 0) {
            rw.print("IMPOSSIBLE");
            return;
        }
        int len2 = Integer.toBinaryString(n + m).length() + 1;

        int[] a = xxx(n, len2);
        int[] b = xxx(m, len2);
        int j = 0;
        while (j < len2 - 1) {
            if (j + 1 < len2) {
                a[j + 1] += a[j] / 2;
                a[j] %= 2;

                b[j + 1] += b[j] / 2;
                b[j] %= 2;
            }
            if (a[j] == 0 && b[j] == 0) {
                if (a[j - 1] != 0) {
                    a[j] = a[j - 1];
                    a[j - 1] *= -1;
                } else {
                    b[j] = b[j - 1];
                    b[j - 1] *= -1;
                }
            } else if (Math.abs(a[j]) == 1 && Math.abs(b[j]) == 1) {
                if (a[j - 1] != 0) {
                    a[j + 1] += a[j - 1];
                    a[j] = 0;
                    a[j - 1] *= -1;
                } else {
                    b[j + 1] += b[j - 1];
                    b[j] = 0;
                    b[j - 1] *= -1;
                }
            }

            ++j;
        }

        StringBuilder sb = new StringBuilder();
        if (a[len2 - 1] == 0 && b[len2 - 1] == 0)
            len2--;
        for (int i = 0; i < len2; ++i) {
            if (a[i] * Math.signum(sn) == 1)
                sb.append('E');
            else if (a[i] * Math.signum(sn) == -1)
                sb.append('W');
            else if (b[i] * Math.signum(sm) == 1)
                sb.append('N');
            else
                sb.append('S');
        }
//        pr(a, "a");
//        pr(b, "b");
        rw.print(sb.toString());
    }

    void pr(int[] a, String s) {
        for (int i : a)
            System.err.print(i + " ");
        System.err.println();

    }

    private void solve() {
        int t = rw.nextInt();
        for (int i = 1; i <= t; ++i) {
            rw.print("Case #" + i + ": ");
            solveOne();

            rw.println();
        }
    }

    private RW rw;
    private String FILE_NAME = "file";

    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        rw = new RW(FILE_NAME + ".in", FILE_NAME + ".out");
        solve();
        rw.close();
    }

    private class RW {
        private StringTokenizer st;
        private PrintWriter out;
        private BufferedReader br;
        private boolean eof;

        RW(String inputFile, String outputFile) {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(new OutputStreamWriter(System.out));

            File f = new File(inputFile);
            if (f.exists() && f.canRead()) {
                try {
                    br = new BufferedReader(new FileReader(inputFile));
                    out = new PrintWriter(new FileWriter(outputFile));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private String nextLine() {
            String s = "";
            try {
                s = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return s;
        }

        private String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    eof = true;
                    return "-1";
                }
            }
            return st.nextToken();
        }

        private long nextLong() {
            return Long.parseLong(next());
        }

        private int nextInt() {
            return Integer.parseInt(next());
        }

        private void println() {
            out.println();
        }

        private void println(Object o) {
            out.println(o);
        }

        private void print(Object o) {
            out.print(o);
        }

        private void close() {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.close();
        }
    }
}
