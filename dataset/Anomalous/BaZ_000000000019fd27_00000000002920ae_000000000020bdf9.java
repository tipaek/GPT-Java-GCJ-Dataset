import java.io.*;
import java.util.*;

public class Solution {
    private static MyScanner scan;
    private static PrintWriter pw;
    private static final long MOD = 1_000_000_007;
    private static final long INF = 1_000_000_000_000_000_000L;
    private static final long inf = 2_000_000_000;

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

    private static void solve() throws IOException {
        initIo(false, "");
        int t = ni();
        for (int cs = 1; cs <= t; ++cs) {
            int n = ni();
            StringBuilder sb = new StringBuilder(n);
            for (int i = 0; i < n; i++) {
                sb.append("C");
            }
            Tuple[] arr = new Tuple[n];
            for (int i = 0; i < n; ++i) {
                arr[i] = new Tuple(ni(), ni(), i);
            }
            Arrays.sort(arr);
            int c = 0, j = 0;
            for (Tuple p : arr) {
                if (p.x >= c) {
                    c = p.y;
                    sb.setCharAt(p.idx, 'C');
                } else if (p.x >= j) {
                    j = p.y;
                    sb.setCharAt(p.idx, 'J');
                } else {
                    c = Integer.MAX_VALUE;
                    break;
                }
            }
            if (c == Integer.MAX_VALUE) {
                pl("Case " + cs + ": IMPOSSIBLE");
            } else {
                pl("Case " + cs + ": " + sb.toString());
            }
        }
        pw.flush();
        pw.close();
    }

    private static class Tuple implements Comparable<Tuple> {
        int x, y, idx;

        Tuple(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }

        @Override
        public int compareTo(Tuple other) {
            if (this.x != other.x) {
                return this.x - other.x;
            }
            return this.y - other.y;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
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
        for (Object[] objects : arr) {
            for (Object o : objects) {
                p(o);
            }
            pl();
        }
    }

    private static void pa(String arrayName, int[][] arr) {
        pl(arrayName + " : ");
        for (int[] ints : arr) {
            for (int o : ints) {
                p(o);
            }
            pl();
        }
    }

    private static void pa(String arrayName, long[][] arr) {
        pl(arrayName + " : ");
        for (long[] longs : arr) {
            for (long o : longs) {
                p(o);
            }
            pl();
        }
    }

    private static void pa(String arrayName, char[][] arr) {
        pl(arrayName + " : ");
        for (char[] chars : arr) {
            for (char o : chars) {
                p(o);
            }
            pl();
        }
    }

    private static void pa(String arrayName, double[][] arr) {
        pl(arrayName + " : ");
        for (double[] doubles : arr) {
            for (double o : doubles) {
                p(o);
            }
            pl();
        }
    }

    private static void pa(String arrayName, boolean[][] arr) {
        pl(arrayName + " : ");
        for (boolean[] booleans : arr) {
            for (boolean o : booleans) {
                p(o);
            }
            pl();
        }
    }

    private static class MyScanner {
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