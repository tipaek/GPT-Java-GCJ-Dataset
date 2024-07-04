import java.util.Arrays;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.IOException;
import java.util.NoSuchElementException;

public class Solution {

    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        FastScanner scanner = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        solve(scanner, out);
        out.flush();
    }

    public void solve(FastScanner scanner, PrintWriter out) {
        int T = scanner.nextInt();
        int N = scanner.nextInt();
        int C = scanner.nextInt();
        AI[] aiArray = new AI[T];
        for (int i = 0; i < T; i++) {
            aiArray[i] = new AI(N, T, C);
        }

        while (true) {
            int sum = 0;
            for (int i = 0; i < T; i++) {
                int next = aiArray[i].next();
                sum += next;
                if (i != 0) out.print(" ");
                out.print(next);
            }
            out.println();
            out.flush();

            if (sum == 0) {
                for (int i = 0; i < T; i++) {
                    if (i != 0) out.print(" ");
                    out.print(aiArray[i].ans1 + " " + aiArray[i].ans2);
                }
                out.println();
                break;
            }

            for (int i = 0; i < T; i++) {
                aiArray[i].result(scanner.nextInt());
            }
        }
    }

    class AI {
        int choose = 1, count = 0;
        public int ans1 = 1, ans2 = 2;
        boolean[] live;
        int T, C;

        AI(int N, int T, int C) {
            this.T = T;
            this.C = C;
            live = new boolean[N];
            Arrays.fill(live, true);
        }

        int next() {
            return choose;
        }

        void result(int last) {
            if (choose == 0) return;
            if (last == 0) {
                live[count] = false;
                count = 0;
                choose++;
                if (choose >= live.length) choose = 0;
                int up = 0, down = 0;
                for (int i = 0; i < live.length; i++) {
                    for (int j = i + 1; j < live.length; j++) {
                        if (!(live[i] && live[j])) continue;
                        down++;
                        if (i + j >= live.length) up++;
                    }
                }
                if (up * T >= down * C) {
                    ans1 = choose;
                    ans2 = choose + 1;
                    choose = 0;
                }
            } else {
                count++;
            }
        }
    }

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1024];
        private int ptr = 0;
        private int buflen = 0;

        private boolean hasNextByte() {
            if (ptr < buflen) return true;
            ptr = 0;
            try {
                buflen = in.read(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return buflen > 0;
        }

        private byte readByte() {
            return hasNextByte() ? buffer[ptr++] : -1;
        }

        private static boolean isPrintableChar(byte c) {
            return 32 < c || c < 0;
        }

        private static boolean isNumber(int c) {
            return '0' <= c && c <= '9';
        }

        public boolean hasNext() {
            while (hasNextByte() && !isPrintableChar(buffer[ptr])) {
                ptr++;
            }
            return hasNextByte();
        }

        public String next() {
            if (!hasNext()) throw new NoSuchElementException();
            StringBuilder sb = new StringBuilder();
            byte b = readByte();
            while (isPrintableChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public int nextInt() {
            if (!hasNext()) throw new NoSuchElementException();
            int n = 0;
            boolean negative = false;
            byte b = readByte();
            if (b == '-') {
                negative = true;
                b = readByte();
            }
            if (!isNumber(b)) throw new NumberFormatException();
            do {
                n = n * 10 + b - '0';
                b = readByte();
            } while (isNumber(b));
            return negative ? -n : n;
        }

        public long nextLong() {
            if (!hasNext()) throw new NoSuchElementException();
            long n = 0;
            boolean negative = false;
            byte b = readByte();
            if (b == '-') {
                negative = true;
                b = readByte();
            }
            if (!isNumber(b)) throw new NumberFormatException();
            do {
                n = n * 10 + b - '0';
                b = readByte();
            } while (isNumber(b));
            return negative ? -n : n;
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}