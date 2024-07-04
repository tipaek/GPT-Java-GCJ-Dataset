import java.io.*;
import java.util.*;

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
        int n = rw.nextInt();
        int d = rw.nextInt();
        Map<Long, Integer> map = new HashMap<>();
        boolean if3 = false;
        boolean if2 = false;
        long[] all = new long[n];
        for (int i = 0; i < n; ++i) {
            long x = rw.nextLong();
            int num = map.getOrDefault(x, 0) + 1;
            map.put(x, num);
            if (num == 3)
                if3 = true;
            if (num == 2)
                if2 = true;
            all[i] = x;
        }

        Arrays.sort(all);
        if (d == 2) {
            if (if2) {
                rw.print(0);
            } else {
                rw.print(1);
            }
        } else {
            if (if3) {
                rw.print(0);
            } else if (if2) {
                // any bigger
                boolean one = false;
                for (int i = 0; i + 2 < n; ++i) {
                    if (all[i] == all[i + 1]) {
                        one = true;
                        break;
                    }
                }
                for (int i = 0; i < n; ++i) {
                    if (map.containsKey(all[i] * 2)) {
                        one = true;
                        break;
                    }
                }
                if (one) {
                    rw.print(1);
                } else {
                    rw.print(2);
                }
            } else {
                boolean one = false;
                for (int i = 0; i < n; ++i) {
                    if (map.containsKey(all[i] * 2)) {
                        one = true;
                        break;
                    }
                }
                if (one) {
                    rw.print(1);
                } else
                    rw.print(d - 1);
            }
        }
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

    void errArray(long[] a) {
        for (long i : a)
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
