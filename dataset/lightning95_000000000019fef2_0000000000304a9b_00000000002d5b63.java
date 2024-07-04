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

    private void solveOne(int a, int b) {
        int minX = -1_000_000_000;
        int minY = -1_000_000_000;
        int maxX = 1_000_000_000;
        int maxY = 1_000_000_000;

        int lx = minX + a;
        int rx = maxX - a;

        int ly = minY + b;
        int ry = maxY - b;
        while (lx < rx) {
            int mx1 = (rx + lx) / 2;

            boolean anyHit = false;
            while (ly < ry) {
                int my1 = (ry + ly) / 2 ;
                rw.println((mx1 - a) + " " + (my1 - b));
                rw.out.flush();
                String resp = rw.next();
                if (resp.equals("MISS")) {
                    ly = my1;
                } else if (resp.equals("HIT")) {
                    anyHit = true;
                    ry = my1;
                } else {
                    return;
                }
            }
            if (anyHit) {
                rx = mx1;
            } else {
                lx = mx1;
            }
        }

        rw.println(lx + " " + rx);
        rw.out.flush();
        String resp = rw.next();
        if (resp.equals("CENTER")) {
            return;
        } else {
            System.exit(100500);
        }
    }

    void pr(int[] a, String s) {
        for (int i : a)
            System.err.print(i + " ");
        System.err.println();
    }

    private void solve() {
        int t = rw.nextInt();
        int a = rw.nextInt();
        int b = rw.nextInt();

        for (int i = 1; i <= t; ++i) {
//            rw.print("Case #" + i + ": ");
            solveOne(a, b);
//            rw.println();
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
         PrintWriter out;
        private BufferedReader br;
        private boolean eof;

        RW(String inputFile, String outputFile) {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(new OutputStreamWriter(System.out));

//            File f = new File(inputFile);
//            if (f.exists() && f.canRead()) {
//                try {
//                    br = new BufferedReader(new FileReader(inputFile));
//                    out = new PrintWriter(new FileWriter(outputFile));
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
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
