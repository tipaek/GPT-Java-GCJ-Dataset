import java.util.*;
import java.io.*;

public class Solution {
    static MyScanner scan;
    static PrintWriter pw;
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
        int t = ni();
        long[][] nCr = new long[61][61];
        for (int i = 0; i < 61; i++) {
            nCr[i][0] = 1;
        }
        for (int i = 1; i < 61; i++) {
            for (int j = 1; j < 61; j++) {
                nCr[i][j] = nCr[i - 1][j] + nCr[i - 1][j - 1];
            }
        }
        for (int case_ = 1; case_ <= t; case_++) {
            pl("Case #" + case_ + ":");
            int n = ni();
            long walked = 0;
            for (int i = 0; i < 32; i++) {
                if (n - (i + 1) >= 0 && ((1L << (i + 1)) - (i + 1)) >= (n - i)) {
                    int x = n - i;
                    int dir = 1;
                    int bitCount = Integer.bitCount(x);
                    int j;
                    for (j = 0; j <= i; j++) {
                        int currY = (dir == 1) ? 1 : (j + 1);
                        pl((j + 1) + " " + currY);
                        walked += nCr[j][currY - 1];
                        if ((x & (1 << j)) != 0) {
                            for (int k = 0; k < j; k++) {
                                currY += dir;
                                pl((j + 1) + " " + currY);
                                walked += nCr[j][currY - 1];
                            }
                            dir *= -1;
                        }
                    }
                    bitCount--;
                    while (bitCount-- > 0) {
                        int currY = (dir == 1) ? 1 : (j + 1);
                        pl((j + 1) + " " + currY);
                        walked += nCr[j][currY - 1];
                        j++;
                    }
                    if (walked != n) {
                        pl("ERRRRRR");
                        System.exit(1);
                    }
                    break;
                }
            }
        }
        pw.flush();
        pw.close();
    }

    static void initIo(boolean isFileIO, String suffix) throws IOException {
        scan = new MyScanner(isFileIO, suffix);
        pw = isFileIO ? new PrintWriter("/Users/amandeep/Desktop/output" + suffix + ".txt") : new PrintWriter(System.out, true);
    }

    static int ni() throws IOException {
        return scan.nextInt();
    }

    static long nl() throws IOException {
        return scan.nextLong();
    }

    static String ne() throws IOException {
        return scan.next();
    }

    static String nel() throws IOException {
        return scan.nextLine();
    }

    static void pl() {
        pw.println();
    }

    static void p(Object o) {
        pw.print(o + " ");
    }

    static void pl(Object o) {
        pw.println(o);
    }

    static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        MyScanner(boolean readingFromFile, String suffix) throws IOException {
            br = readingFromFile ? new BufferedReader(new FileReader("/Users/amandeep/Desktop/input" + suffix + ".txt")) : new BufferedReader(new InputStreamReader(System.in));
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
    }
}