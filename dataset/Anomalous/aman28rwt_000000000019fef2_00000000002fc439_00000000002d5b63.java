import java.io.*;
import java.util.*;

public class Solution implements Runnable {
    private boolean judge = false;
    private FastReader scn;
    private PrintWriter out;
    private static final String INPUT = "";

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
        int a = scn.nextInt();
        int b = scn.nextInt();
        for (int tt = 1; tt <= T; tt++) {
            out.print("Case #" + tt + ": ");
            Random random = new Random();
            for (int i = 0; i < 300; i++) {
                int x = random.nextInt(51) * (random.nextBoolean() ? 1 : -1);
                int y = random.nextInt(51) * (random.nextBoolean() ? 1 : -1);
                out.print(x + " " + y);
                out.flush();
                String response = scn.next();
                if ("CENTER".equals(response)) {
                    break;
                }
                if ("WRONG".equals(response)) {
                    return;
                }
            }
        }
    }

    private static class FastReader {
        private final InputStream is;
        private final byte[] buffer = new byte[1024];
        private int bufferLength = 0;
        private int bufferPointer = 0;

        public FastReader(boolean onlineJudge) {
            this.is = onlineJudge ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        }

        public int nextInt() {
            int number = 0;
            int b;
            boolean negative = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
            if (b == '-') {
                negative = true;
                b = readByte();
            }
            while (true) {
                if (b >= '0' && b <= '9') {
                    number = number * 10 + (b - '0');
                } else {
                    return negative ? -number : number;
                }
                b = readByte();
            }
        }

        public String next() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (b != -1 && !isSpaceChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        private int readByte() {
            if (bufferLength == -1) throw new InputMismatchException();
            if (bufferPointer >= bufferLength) {
                bufferPointer = 0;
                try {
                    bufferLength = is.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (bufferLength <= 0) return -1;
            }
            return buffer[bufferPointer++];
        }

        private int skip() {
            int b;
            while ((b = readByte()) != -1 && isSpaceChar(b));
            return b;
        }

        private boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }
    }
}