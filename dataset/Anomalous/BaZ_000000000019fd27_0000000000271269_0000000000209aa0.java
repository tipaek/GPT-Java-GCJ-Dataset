import java.util.*;
import java.io.*;

public class Solution {
    static MyScanner scanner;
    static PrintWriter writer;
    static final long MOD = 1_000_000_007;
    static final long INF = 1_000_000_000_000_000_000L;
    static final long inf = 2_000_000_000;

    public static void main(String[] args) {
        new Thread(null, () -> {
            try {
                solve();
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        }, "BaZ", 1 << 27).start();
    }

    static void solve() throws IOException {
        initIo(false, "");
        int t = nextInt();
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = nextInt();
            int k = nextInt();
            if (k % n != 0) {
                println("Case #" + caseNum + ": IMPOSSIBLE");
            } else {
                int[][] ans = new int[n][n];
                for (int i = 0; i < n; i++) {
                    int val = k / n;
                    for (int j = i; j < n; j++) {
                        ans[i][j] = val++;
                        if (val == n + 1) val = 1;
                    }
                    for (int j = 0; j < i; j++) {
                        ans[i][j] = val++;
                        if (val == n + 1) val = 1;
                    }
                }
                println("Case #" + caseNum + ": POSSIBLE");
                for (int[] row : ans) {
                    for (int num : row) {
                        print(num);
                    }
                    println();
                }
            }
        }
        writer.flush();
        writer.close();
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
        BufferedReader br;
        StringTokenizer st;

        MyScanner(boolean readingFromFile, String suffix) throws IOException {
            if (readingFromFile) {
                br = new BufferedReader(new FileReader("/Users/amandeep/Desktop/input" + suffix + ".txt"));
            } else {
                br = new BufferedReader(new InputStreamReader(System.in));
            }
        }

        String nextLine() throws IOException {
            return br.readLine();
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
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