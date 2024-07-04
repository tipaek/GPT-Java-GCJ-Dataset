import java.util.*;
import java.io.*;

public class lp {
    static PrintWriter out = new PrintWriter(System.out);

    static class Pair implements Comparable<Pair> {
        int time, index, flag;

        Pair(int time, int index, int flag) {
            this.time = time;
            this.index = index;
            this.flag = flag;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.time == other.time) {
                return this.flag - other.flag;
            }
            return this.time - other.time;
        }
    }

    static void solve() throws Exception {
        int testCases = ni();
        for (int t = 1; t <= testCases; t++) {
            int n = ni();
            Pair[] events = new Pair[2 * n];
            for (int i = 0; i < n; i++) {
                int start = ni();
                int end = ni();
                events[2 * i] = new Pair(start, i, 1);
                events[2 * i + 1] = new Pair(end, i, -1);
            }
            Arrays.sort(events);

            char[] result = new char[n];
            int activityCount = 0, lastAssigned = 0; // 0 for C, 1 for J
            boolean impossible = false;

            for (Pair event : events) {
                activityCount += event.flag;
                if (activityCount > 2) {
                    impossible = true;
                    break;
                }
                if (event.flag == -1) {
                    if (lastAssigned == 0) {
                        result[event.index] = 'C';
                        lastAssigned = 1;
                    } else {
                        result[event.index] = 'J';
                        lastAssigned = 0;
                    }
                }
            }

            if (impossible) {
                pn("Case #" + t + ": IMPOSSIBLE");
            } else {
                p("Case #" + t + ": ");
                for (char c : result) {
                    p(c);
                }
                pn("");
            }
        }
        out.flush();
    }

    public static void main(String[] args) {
        new Thread(null, null, "Name", 99999) {
            public void run() {
                try {
                    solve();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }.start();
    }

    static int[] ai(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = ni();
        }
        return array;
    }

    static long[] al(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = nl();
        }
        return array;
    }

    static void p(Object o) {
        out.print(o);
    }

    static void pn(Object o) {
        out.println(o);
    }

    static int abs(int x) {
        return Math.abs(x);
    }

    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static int countSetBits(int n) {
        return Integer.bitCount(n);
    }

    static void subtractOne(char[] s) {
        if (s[0] == '0') return;
        int n = s.length, i = n - 1;
        while (s[i] == '0') i--;
        s[i] = (char) (s[i] - 1);
        for (int j = i + 1; j < n; j++) {
            s[j] = '9';
        }
    }

    static long pow(long a, long b, long mod) {
        long result = 1;
        while (b > 0) {
            if (b % 2 == 1) result = (result * a) % mod;
            a = (a * a) % mod;
            b /= 2;
        }
        return result;
    }

    static long min(long a, long b) {
        return Math.min(a, b);
    }

    static long max(long a, long b) {
        return Math.max(a, b);
    }

    static boolean isPalindrome(String s) {
        int n = s.length(), i = 0, j = n - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    static FastReader sc = new FastReader();

    static int ni() {
        return sc.nextInt();
    }

    static long nl() {
        return sc.nextLong();
    }

    static String n() {
        return sc.next();
    }

    static String ns() {
        return sc.nextLine();
    }

    static double nd() {
        return sc.nextDouble();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}