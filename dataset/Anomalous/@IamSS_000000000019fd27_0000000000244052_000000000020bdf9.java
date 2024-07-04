import java.util.*;
import java.io.*;

public class Solution {
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
        int testCases = nextInt();
        for (int t = 1; t <= testCases; t++) {
            int n = nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            Pair[] events = new Pair[2 * n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = nextInt();
                endTimes[i] = nextInt();
                events[2 * i] = new Pair(startTimes[i], i, 1);
                events[2 * i + 1] = new Pair(endTimes[i], i, -1);
            }

            Arrays.sort(events);

            char[] result = new char[n];
            int concurrentTasks = 0, endJ = 0, endC = 0;

            for (Pair event : events) {
                concurrentTasks += event.flag;
                if (concurrentTasks > 2) {
                    break;
                } else if (event.flag == -1) {
                    if (startTimes[event.index] >= endJ) {
                        result[event.index] = 'J';
                        endJ = event.time;
                    } else {
                        result[event.index] = 'C';
                        endC = event.time;
                    }
                }
            }

            if (concurrentTasks > 2) {
                println("Case #" + t + ": IMPOSSIBLE");
            } else {
                println("Case #" + t + ": " + new String(result));
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

    static int nextInt() {
        return sc.nextInt();
    }

    static long nextLong() {
        return sc.nextLong();
    }

    static String next() {
        return sc.next();
    }

    static String nextLine() {
        return sc.nextLine();
    }

    static double nextDouble() {
        return sc.nextDouble();
    }

    static void print(Object o) {
        out.print(o);
    }

    static void println(Object o) {
        out.println(o);
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

    static FastReader sc = new FastReader();
}