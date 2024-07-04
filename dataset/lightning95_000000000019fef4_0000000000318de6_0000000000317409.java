import java.io.*;
import java.util.StringTokenizer;

/**
 * @author Aydar Gizatullin a.k.a. lightning95, aydar.gizatullin@gmail.com
 */
public class Solution {
    class Pair {
        int a, b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    class Event {
        int id, time, type;

        Event(int cId, int cTime, int cType) {
            id = cId;
            time = cTime;
            type = cType;
        }
    }

    private void solveOne() {
        int sX = rw.nextInt();
        int sY = rw.nextInt();
        String s = rw.next();
        int ans = Integer.MAX_VALUE;
        int t = 0;
        if (sX == 0 && sY == 0)
            ans = 0;
        for (char c : s.toCharArray()){
            if (c == 'N')
                sY++;
            else if (c == 'E')
                sX++;
            else if (c == 'W')
                sX--;
            else
                sY--;
            ++t;
            int cur = Math.abs(sX) + Math.abs(sY);
            if (cur <= t)
                ans = Math.min(ans, t);
        }
        if (ans == Integer.MAX_VALUE)
            rw.print("IMPOSSIBLE");
        else
            rw.print(ans);
    }

    private void solve() {
        int t = rw.nextInt();
        for (int i = 1; i <= t; ++i) {
            rw.print("Case #" + i + ": ");
            solveOne();
            rw.println();
        }
    }

    long gcd(long a, long b) {
        if (a == 0 || b == 0) return a + b;
        if (a > b) return gcd(a % b, b);
        return gcd(a, b % a);
    }

    long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    <T> void errArray(T[] a) {
        for (T i : a)
            System.err.print(i + " ");
        System.err.println();
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
