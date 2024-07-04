import java.io.*;
import java.util.*;

public class Solution implements Runnable {
    private boolean judge = true;
    private FastReader scn;
    private PrintWriter out;
    private String INPUT = "";

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        boolean isOnlineJudge = System.getProperty("ONLINE_JUDGE") != null || judge;
        out = new PrintWriter(System.out);
        scn = new FastReader(isOnlineJudge);
        solve();
        out.flush();
        if (!isOnlineJudge) {
            System.out.println("Execution time: " + (System.currentTimeMillis() - startTime) + " ms");
        }
    }

    public static void main(String[] args) {
        new Thread(null, new Solution(), "Main", 1 << 28).start();
    }

    private void solve() {
        int T = scn.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            out.print("Case #" + testCase + ": ");
            int n = scn.nextInt(), k = scn.nextInt();
            int ans = k - 1;
            long[] arr = scn.nextLongArray(n);
            Map<Long, Integer> countMap = new HashMap<>();
            Map<Long, Long> cutMap = new HashMap<>();
            Map<Long, List<Long>> divisorsMap = new HashMap<>();

            for (long a : arr) {
                countMap.merge(a, 1, Integer::sum);
                if (countMap.get(a) >= k) {
                    ans = 0;
                }
            }

            arr = scn.uniq(arr);

            for (long value : arr) {
                for (long d = 1; d * d <= value; d++) {
                    if (value % d == 0) {
                        long x = value / d, y = value / x;
                        divisorsMap.computeIfAbsent(x, key -> new ArrayList<>()).add(y - 1);
                        cutMap.merge(x, y, Long::sum);

                        if (x != y) {
                            divisorsMap.computeIfAbsent(y, key -> new ArrayList<>()).add(x - 1);
                            cutMap.merge(y, x, Long::sum);
                        }
                    }
                }
            }

            for (long key : divisorsMap.keySet()) {
                List<Long> list = divisorsMap.get(key);
                Collections.sort(list);

                if (cutMap.get(key) >= k) {
                    int add = k - countMap.getOrDefault(key, 0);
                    int sum = 0;
                    for (long z : list) {
                        if (z + 1 < add) {
                            sum += z;
                            add -= z + 1;
                        } else {
                            sum += add;
                            break;
                        }
                    }
                    ans = Math.min(ans, sum);
                } else {
                    int sum = 0;
                    int remaining = (int) (k - cutMap.get(key));
                    for (long z : list) {
                        sum += z;
                    }
                    sum += remaining;
                    ans = Math.min(ans, sum);
                }
            }

            out.println(ans);
        }
    }

    class FastReader {
        private final InputStream is;
        private final byte[] inbuf = new byte[1024];
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

        public long nextLong() {
            long num = 0;
            int b;
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

        public long[] nextLongArray(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

        public long[] uniq(long[] arr) {
            Arrays.sort(arr);
            long[] uniqueArr = new long[arr.length];
            int pos = 0;
            uniqueArr[pos++] = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] != arr[i - 1]) {
                    uniqueArr[pos++] = arr[i];
                }
            }
            return Arrays.copyOf(uniqueArr, pos);
        }
    }
}