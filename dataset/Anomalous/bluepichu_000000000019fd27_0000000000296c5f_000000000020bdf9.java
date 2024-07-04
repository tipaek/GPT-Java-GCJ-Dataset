import java.util.*;
import java.io.*;

public class Solution {
    public static final boolean DEBUG = false;

    public static void main(String[] args) throws Exception {
        PrintWriter pw = new PrintWriter(System.out);
        FastScanner sc = new FastScanner();

        int testCases = sc.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = sc.nextInt();

            Interval[] intervals = new Interval[n];
            Interval[] originalOrder = new Interval[n];

            for (int i = 0; i < n; i++) {
                intervals[i] = new Interval(sc.nextInt(), sc.nextInt());
                originalOrder[i] = intervals[i];
            }

            Arrays.sort(intervals);

            int endC = 0;
            int endJ = 0;
            boolean isPossible = true;

            for (int i = 0; i < n; i++) {
                if (intervals[i].start >= endC) {
                    intervals[i].assignment = 'C';
                    endC = intervals[i].end;
                } else if (intervals[i].start >= endJ) {
                    intervals[i].assignment = 'J';
                    endJ = intervals[i].end;
                } else {
                    isPossible = false;
                    break;
                }
            }

            pw.printf("Case #%d: ", t);

            if (isPossible) {
                for (int i = 0; i < n; i++) {
                    pw.print((char) originalOrder[i].assignment);
                }
            } else {
                pw.print("IMPOSSIBLE");
            }

            pw.println();
        }

        pw.close();
        sc.close();
    }

    static class Interval implements Comparable<Interval> {
        int start;
        int end;
        char assignment;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
            this.assignment = 0;
        }

        @Override
        public int compareTo(Interval other) {
            return Integer.compare(this.start, other.start);
        }
    }

    public static void debug(Object obj, String end) {
        if (DEBUG) {
            if (obj instanceof boolean[]) {
                System.err.print(Arrays.toString((boolean[]) obj));
            } else if (obj instanceof byte[]) {
                System.err.print(Arrays.toString((byte[]) obj));
            } else if (obj instanceof short[]) {
                System.err.print(Arrays.toString((short[]) obj));
            } else if (obj instanceof char[]) {
                System.err.print(Arrays.toString((char[]) obj));
            } else if (obj instanceof int[]) {
                System.err.print(Arrays.toString((int[]) obj));
            } else if (obj instanceof long[]) {
                System.err.print(Arrays.toString((long[]) obj));
            } else if (obj instanceof float[]) {
                System.err.print(Arrays.toString((float[]) obj));
            } else if (obj instanceof double[]) {
                System.err.print(Arrays.toString((double[]) obj));
            } else if (obj instanceof Object[]) {
                debug((Object[]) obj);
            } else {
                System.err.print(obj);
            }
            System.err.print(end);
        }
    }

    public static void debug(Object... args) {
        if (DEBUG) {
            System.err.print("#");
            for (Object arg : args) {
                debug(arg, " ");
            }
            System.err.println();
        }
    }

    public static void debug(Suspended sus) {
        if (DEBUG) {
            debug(sus.eval());
        }
    }

    public static void debugGrid(int[][] grid) {
        if (DEBUG) {
            for (int[] row : grid) {
                System.out.print("#");
                for (int cell : row) {
                    System.out.print(String.format("%3d ", cell));
                }
                System.out.println();
            }
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public String nextToken() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(nextLine());
            }
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(nextToken());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(nextToken());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(nextToken());
        }

        public void close() throws IOException {
            br.close();
        }
    }
}

interface Suspended {
    Object eval();
}