import java.io.*;
import java.util.*;

public class Solution implements Runnable {
    boolean judge = true;
    FastReader scn;
    PrintWriter out;
    String INPUT = "";

    void solve() {
        int T = scn.nextInt();
        for (int tt = 1; tt <= T; tt++) {
            out.print("Case #" + tt + ": ");

            int n = scn.nextInt();
            int k = scn.nextInt();
            int ans = k - 1;
            long[] arr = scn.nextLongArray(n);
            HashMap<Long, Integer> cnt = new HashMap<>();

            for (long a : arr) {
                cnt.merge(a, 1, Integer::sum);
                if (cnt.get(a) >= k) {
                    ans = 0;
                }
            }

            Arrays.parallelSort(arr);

            if (k == 3) {
                for (int i = 0; i < n; i++) {
                    int c = cnt.get(arr[i]);
                    if (c == 2 && arr[n - 1] > arr[i]) {
                        ans = Math.min(ans, 1);
                    } else if (c == 1 && cnt.getOrDefault(2 * arr[i], 0) > 0) {
                        ans = Math.min(ans, 1);
                    }
                }
            }

            out.println(ans);
        }
    }

    public void run() {
        long startTime = System.currentTimeMillis();
        boolean onlineJudge = System.getProperty("ONLINE_JUDGE") != null || judge;
        out = new PrintWriter(System.out);
        scn = new FastReader(onlineJudge);
        solve();
        out.flush();
        if (!onlineJudge) {
            System.out.println((System.currentTimeMillis() - startTime) + " ms");
        }
    }

    public static void main(String[] args) {
        new Thread(null, new Solution(), "Main", 1 << 28).start();
    }

    class FastReader {
        InputStream is;
        byte[] buffer = new byte[1024];
        int lenbuf = 0, ptrbuf = 0;

        public FastReader(boolean onlineJudge) {
            is = onlineJudge ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        }

        public FastReader() {
            is = System.in;
        }

        int readByte() {
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

        boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        int skip() {
            int b;
            while ((b = readByte()) != -1 && isSpaceChar(b)) ;
            return b;
        }

        String next() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!isSpaceChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        int nextInt() {
            int num = 0;
            int b = skip();
            boolean minus = false;
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

        long nextLong() {
            long num = 0;
            int b = skip();
            boolean minus = false;
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

        long[] nextLongArray(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }
    }
}