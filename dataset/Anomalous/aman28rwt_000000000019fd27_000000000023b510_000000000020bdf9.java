import java.io.*;
import java.util.*;

public class Solution implements Runnable {
    private boolean judge = true;
    private FastReader scn;
    private PrintWriter out;
    private String INPUT = "";

    public static void main(String[] args) {
        new Thread(null, new Solution(), "Main", 1 << 28).start();
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        boolean isOnlineJudge = System.getProperty("ONLINE_JUDGE") != null || judge;
        out = new PrintWriter(System.out);
        scn = new FastReader(isOnlineJudge);
        solve();
        out.flush();
        if (!isOnlineJudge) {
            System.out.println(Arrays.deepToString(new Object[]{System.currentTimeMillis() - startTime + " ms"}));
        }
    }

    private void solve() {
        int T = scn.nextInt();
        for (int tt = 1; tt <= T; tt++) {
            out.print("Case #" + tt + ": ");
            int n = scn.nextInt();
            int[][] intervals = new int[n][3];
            for (int i = 0; i < n; i++) {
                intervals[i] = new int[]{scn.nextInt(), scn.nextInt() - 1, i};
            }

            Arrays.parallelSort(intervals, Comparator.<int[]>comparingInt(a -> a[0]).thenComparingInt(a -> a[1]));

            int endC = -1, endJ = -1;
            int[] assignments = new int[n];
            boolean possible = true;

            for (int[] interval : intervals) {
                if (interval[0] > endC) {
                    endC = interval[1];
                    assignments[interval[2]] = 0;
                } else if (interval[0] > endJ) {
                    endJ = interval[1];
                    assignments[interval[2]] = 1;
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                out.println("IMPOSSIBLE");
            } else {
                for (int assignment : assignments) {
                    out.print(assignment == 0 ? 'C' : 'J');
                }
                out.println();
            }
        }
    }

    class FastReader {
        private InputStream is;
        private byte[] buffer = new byte[1024];
        private int lenbuf = 0, ptrbuf = 0;

        public FastReader(boolean onlineJudge) {
            is = onlineJudge ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        }

        private int readByte() {
            if (lenbuf == -1) throw new InputMismatchException();
            if (ptrbuf >= lenbuf) {
                ptrbuf = 0;
                try {
                    lenbuf = is.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (lenbuf <= 0) return -1;
            }
            return buffer[ptrbuf++];
        }

        private boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        private int skip() {
            int b;
            while ((b = readByte()) != -1 && isSpaceChar(b)) ;
            return b;
        }

        public String next() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!isSpaceChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public int nextInt() {
            int num = 0, b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }
            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }
    }
}