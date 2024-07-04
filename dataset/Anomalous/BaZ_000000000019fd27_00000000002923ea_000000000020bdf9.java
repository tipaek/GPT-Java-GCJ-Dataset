import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class Solution {
    static MyScanner scanner;
    static PrintWriter writer;
    static final long MOD = 1_000_000_007;
    static final long INF = 1_000_000_000_000_000_000L;
    static final long inf = 2_000_000_000;

    public static void main(String[] args) {
        new Thread(null, null, "BaZ", 1 << 27) {
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

    static void solve() throws IOException {
        initIo(false, "");
        int t = nextInt();
        for (int cs = 1; cs <= t; ++cs) {
            int n = nextInt();
            StringBuilder result = new StringBuilder(n);
            for (int i = 0; i < n; i++) {
                result.append("C");
            }
            Tuple[] intervals = new Tuple[n];
            for (int i = 0; i < n; ++i) {
                intervals[i] = new Tuple(nextInt(), nextInt(), i);
            }
            Arrays.sort(intervals);
            int cEnd = 0, jEnd = 0;
            for (Tuple interval : intervals) {
                if (interval.start >= cEnd) {
                    cEnd = interval.end;
                    result.setCharAt(interval.index, 'C');
                } else if (interval.start >= jEnd) {
                    jEnd = interval.end;
                    result.setCharAt(interval.index, 'J');
                } else {
                    cEnd = Integer.MAX_VALUE;
                    break;
                }
            }
            if (cEnd == Integer.MAX_VALUE) {
                println("Case #" + cs + ": IMPOSSIBLE");
            } else {
                println("Case #" + cs + ": " + result.toString());
            }
        }
        writer.flush();
        writer.close();
    }

    static class Tuple implements Comparable<Tuple> {
        int start, end, index;

        Tuple(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        public int compareTo(Tuple other) {
            if (this.start != other.start) {
                return this.start - other.start;
            }
            return this.end - other.end;
        }

        public String toString() {
            return "(" + start + "," + end + ")";
        }
    }

    static void initIo(boolean isFileIO, String suffix) throws IOException {
        scanner = new MyScanner(isFileIO, suffix);
        if (isFileIO) {
            writer = new PrintWriter("/Users/amandeep/Desktop/output" + suffix + ".txt");
        } else {
            writer = new PrintWriter(System.out, true);
        }
    }

    static int nextInt() throws IOException {
        return scanner.nextInt();
    }

    static long nextLong() throws IOException {
        return scanner.nextLong();
    }

    static double nextDouble() throws IOException {
        return scanner.nextDouble();
    }

    static String next() throws IOException {
        return scanner.next();
    }

    static String nextLine() throws IOException {
        return scanner.nextLine();
    }

    static void print(Object o) {
        writer.print(o + " ");
    }

    static void println(Object o) {
        writer.println(o);
    }

    static void println() {
        writer.println();
    }

    static class MyScanner {
        BufferedReader reader;
        StringTokenizer tokenizer;

        MyScanner(boolean readingFromFile, String suffix) throws IOException {
            if (readingFromFile) {
                reader = new BufferedReader(new FileReader("/Users/amandeep/Desktop/input" + suffix + ".txt"));
            } else {
                reader = new BufferedReader(new InputStreamReader(System.in));
            }
        }

        String nextLine() throws IOException {
            return reader.readLine();
        }

        String next() throws IOException {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
}