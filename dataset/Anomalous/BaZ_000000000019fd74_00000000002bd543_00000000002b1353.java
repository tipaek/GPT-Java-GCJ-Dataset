import java.util.*;
import java.io.*;

public class Solution {
    private static MyScanner scan;
    private static PrintWriter pw;
    private static final long MOD = 1_000_000_007;
    private static final long INF = 1_000_000_000_000_000_000L;
    private static final long inf = 2_000_000_000;

    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            @Override
            public void run() {
                try {
                    solve();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }, "BaZ", 1 << 27).start();
    }

    private static void solve() throws IOException {
        initIo(false, "");
        StringBuilder sb = new StringBuilder();
        int t = ni();
        long[][] nCr = new long[61][61];
        for (int i = 0; i < 61; ++i) {
            nCr[i][0] = 1;
        }
        for (int i = 1; i < 61; ++i) {
            for (int j = 1; j < 61; ++j) {
                nCr[i][j] = nCr[i - 1][j] + nCr[i - 1][j - 1];
            }
        }
        for (int case_ = 1; case_ <= t; ++case_) {
            pw.print("Case #" + case_ + ":");
            int n = ni();
            long walked = 0;
            for (int i = 0; i < 32; ++i) {
                if (n - (i + 1) >= 0 && ((1L << (i + 1)) - (i + 1)) >= (n - i)) {
                    int x = n - i;
                    int dir = 1;
                    int bc = Integer.bitCount(x);
                    int j;
                    for (j = 0; j <= i; ++j) {
                        int curr_y = (dir == 1 ? 1 : (j + 1));
                        pw.println((j + 1) + " " + curr_y);
                        walked += nCr[j][curr_y - 1];
                        if ((x & (1 << j)) != 0) {
                            for (int k = 0; k < j; ++k) {
                                curr_y += dir;
                                pw.println((j + 1) + " " + curr_y);
                                walked += nCr[j][curr_y - 1];
                            }
                            dir *= -1;
                        }
                    }
                    bc--;
                    while (bc-- > 0) {
                        int curr_y = (dir == 1 ? 1 : (j + 1));
                        pw.println((j + 1) + " " + curr_y);
                        walked += nCr[j][curr_y - 1];
                        j++;
                    }
                    if (walked != n) {
                        pw.println("ERRRRRR");
                        System.exit(1);
                    }
                    break;
                }
            }
        }
        pw.flush();
        pw.close();
    }

    private static void initIo(boolean isFileIO, String suffix) throws IOException {
        scan = new MyScanner(isFileIO, suffix);
        if (isFileIO) {
            pw = new PrintWriter("/Users/amandeep/Desktop/output" + suffix + ".txt");
        } else {
            pw = new PrintWriter(System.out, true);
        }
    }

    private static int ni() throws IOException {
        return scan.nextInt();
    }

    private static long nl() throws IOException {
        return scan.nextLong();
    }

    private static double nd() throws IOException {
        return scan.nextDouble();
    }

    private static String ne() throws IOException {
        return scan.next();
    }

    private static String nel() throws IOException {
        return scan.nextLine();
    }

    private static class MyScanner {
        private BufferedReader br;
        private StringTokenizer st;

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
            if (st == null || !st.hasMoreTokens()) {
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