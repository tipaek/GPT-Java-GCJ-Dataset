import java.io.*;
import java.util.Arrays;
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

    private void solveOne() {
        int n = rw.nextInt();
        Event[] e = new Event[n * 2];
        for (int i = 0; i < n; ++i) {
            int l = rw.nextInt();
            int r = rw.nextInt();
            e[i] = new Event(i, l, 0);
            e[i + n] = new Event(i, r, 1);
        }
        Arrays.sort(e, (o1, o2) -> {
            if (o1.time == o2.time) {
                return Integer.compare(o2.type, o1.type);
            }
            return Integer.compare(o1.time, o2.time);
        });

        char[] ans = new char[n];
        int c = -1, j = -1;
        for (int i = 0; i < 2 * n; ++i) {
            if (e[i].type == 0) {
                if (c >= 0 && j >= 0) {
                    rw.print("IMPOSSIBLE");
                    return;
                } else if (c >= 0) {
                    ans[e[i].id] = 'J';
                    j = e[i].id;
                } else {
                    ans[e[i].id] = 'C';
                    c = e[i].id;
                }
            } else {
                if (c == e[i].id)
                    c = -1;
                else
                    j = -1;
            }
        }
        rw.print(new String(ans));
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
