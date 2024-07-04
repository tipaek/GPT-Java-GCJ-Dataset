/**
 * BaZ :D
 */

import java.io.*;
import java.util.*;

public class Solution {
    private static MyScanner scan;
    private static PrintWriter pw;
    private static final long MOD = 1_000_000_007;
    private static final long INF = 1_000_000_000_000_000_000L;
    private static final long inf = 2_000_000_000;

    public static void main(String[] args) {
        new Thread(null, new Runnable() {
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
        for (int cs = 1; cs <= t; ++cs) {
            char[] c = ne().toCharArray();
            sb.setLength(0); // Clear the StringBuilder
            int n = c.length, bal = 0;
            for (int i = 0; i < n; ++i) {
                int d = c[i] - '0';
                for (int j = 0; j < Math.abs(bal - d); ++j) {
                    sb.append(bal > d ? ')' : '(');
                }
                sb.append(c[i]);
                bal = d;
            }
            while (bal-- > 0) {
                sb.append(')');
            }
            pl("Case #" + cs + ": " + sb.toString());
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

    private static void pl() {
        pw.println();
    }

    private static void p(Object o) {
        pw.print(o + " ");
    }

    private static void pl(Object o) {
        pw.println(o);
    }

    private static void psb(StringBuilder sb) {
        pw.print(sb);
    }

    private static void pa(String arrayName, Object[] arr) {
        pl(arrayName + " : ");
        for (Object o : arr) {
            p(o);
        }
        pl();
    }

    private static void pa(String arrayName, int[] arr) {
        pl(arrayName + " : ");
        for (int o : arr) {
            p(o);
        }
        pl();
    }

    private static void pa(String arrayName, long[] arr) {
        pl(arrayName + " : ");
        for (long o : arr) {
            p(o);
        }
        pl();
    }

    private static void pa(String arrayName, double[] arr) {
        pl(arrayName + " : ");
        for (double o : arr) {
            p(o);
        }
        pl();
    }

    private static void pa(String arrayName, char[] arr) {
        pl(arrayName + " : ");
        for (char o : arr) {
            p(o);
        }
        pl();
    }

    private static void pa(String listName, List<?> list) {
        pl(listName + " : ");
        for (Object o : list) {
            p(o);
        }
        pl();
    }

    private static void pa(String arrayName, Object[][] arr) {
        pl(arrayName + " : ");
        for (Object[] subArray : arr) {
            for (Object o : subArray) {
                p(o);
            }
            pl();
        }
    }

    private static void pa(String arrayName, int[][] arr) {
        pl(arrayName + " : ");
        for (int[] subArray : arr) {
            for (int o : subArray) {
                p(o);
            }
            pl();
        }
    }

    private static void pa(String arrayName, long[][] arr) {
        pl(arrayName + " : ");
        for (long[] subArray : arr) {
            for (long o : subArray) {
                p(o);
            }
            pl();
        }
    }

    private static void pa(String arrayName, char[][] arr) {
        pl(arrayName + " : ");
        for (char[] subArray : arr) {
            for (char o : subArray) {
                p(o);
            }
            pl();
        }
    }

    private static void pa(String arrayName, double[][] arr) {
        pl(arrayName + " : ");
        for (double[] subArray : arr) {
            for (double o : subArray) {
                p(o);
            }
            pl();
        }
    }

    private static void pa(String arrayName, boolean[][] arr) {
        pl(arrayName + " : ");
        for (boolean[] subArray : arr) {
            for (boolean o : subArray) {
                p(o);
            }
            pl();
        }
    }

    static class MyScanner {
        private final BufferedReader br;
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