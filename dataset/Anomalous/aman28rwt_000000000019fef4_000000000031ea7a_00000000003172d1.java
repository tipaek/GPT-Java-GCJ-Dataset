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
            System.out.println((System.currentTimeMillis() - startTime) + " ms");
        }
    }

    private void solve() {
        int T = scn.nextInt();
        for (int tt = 1; tt <= T; tt++) {
            out.print("Case #" + tt + ": ");
            
            int n = scn.nextInt(), k = scn.nextInt();
            long[] arr = scn.nextLongArray(n);
            int maxFreq = 1;
            Map<Long, Integer> countMap = new HashMap<>();
            
            for (long num : arr) {
                countMap.merge(num, 1, Integer::sum);
                maxFreq = Math.max(maxFreq, countMap.get(num));
            }

            arr = scn.uniq(arr);

            if (maxFreq >= k) {
                out.println(0);
                continue;
            }

            if (n == 1) {
                out.println(k - 1);
                continue;
            }

            if (k == 2) {
                out.println(1);
            } else if (k == 3) {
                int minOperations = k - 1;
                for (int i = 0; i < n; i++) {
                    int count = countMap.get(arr[i]);
                    if (count == 2) {
                        minOperations = Math.min(minOperations, i < n - 1 ? 1 : 2);
                    } else if (count == 1 && arr[n - 1] >= 2 * arr[i]) {
                        minOperations = Math.min(minOperations, Arrays.binarySearch(arr, 2 * arr[i]) >= 0 ? 1 : 2);
                    } else if (count == 1) {
                        minOperations = Math.min(minOperations, 2);
                    }
                }
                out.println(minOperations);
            }
        }
    }

    class FastReader {
        private InputStream is;
        private byte[] inbuf = new byte[1024];
        private int lenbuf = 0, ptrbuf = 0;

        public FastReader(boolean onlineJudge) {
            is = onlineJudge ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        }

        private int readByte() {
            if (lenbuf == -1) throw new InputMismatchException();
            if (ptrbuf >= lenbuf) {
                ptrbuf = 0;
                try {
                    lenbuf = is.read(inbuf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (lenbuf <= 0) return -1;
            }
            return inbuf[ptrbuf++];
        }

        private boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        private int skip() {
            int b;
            while ((b = readByte()) != -1 && isSpaceChar(b));
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
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
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

        public long nextLong() {
            long num = 0;
            int b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
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

        public long[] nextLongArray(int n) {
            long[] array = new long[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextLong();
            }
            return array;
        }

        public long[] uniq(long[] array) {
            Arrays.sort(array);
            long[] uniqueArray = new long[array.length];
            int pos = 0;
            uniqueArray[pos++] = array[0];
            for (int i = 1; i < array.length; i++) {
                if (array[i] != array[i - 1]) {
                    uniqueArray[pos++] = array[i];
                }
            }
            return Arrays.copyOf(uniqueArray, pos);
        }
    }
}