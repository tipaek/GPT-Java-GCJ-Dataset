import java.io.*;
import java.util.*;

public class Solution implements Runnable {
    static class InputReader {
        private final InputStream stream;
        private final byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private final BufferedReader br;

        public InputReader(InputStream stream) {
            this.stream = stream;
            this.br = new BufferedReader(new InputStreamReader(stream));
        }

        private int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                throw new InputMismatchException();
            }
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res = res * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res = res * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E') {
                    return res * Math.pow(10, nextInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res = res * 10 + (c - '0');
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return res * Math.pow(10, nextInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }
    }

    public static void main(String[] args) {
        new Thread(null, new Solution(), "Main", 1 << 27).start();
    }

    @Override
    public void run() {
        InputReader in = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);

        int t = in.nextInt();
        int initialT = t;

        while (t-- > 0) {
            int n = in.nextInt();
            int[] s = new int[n];
            int[] e = new int[n];

            for (int i = 0; i < n; i++) {
                s[i] = in.nextInt();
                e[i] = in.nextInt();
            }

            TreeMap<Integer, Integer> timeMap = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                timeMap.put(s[i], e[i]);
            }

            int[] startTime = new int[n];
            int[] endTime = new int[n];
            int index = 0;

            for (Map.Entry<Integer, Integer> entry : timeMap.entrySet()) {
                startTime[index] = entry.getKey();
                endTime[index] = entry.getValue();
                index++;
            }

            String result = "";
            for (int i = 2; i < n; i++) {
                if (startTime[i] < endTime[i - 1] && startTime[i] < endTime[i - 2]) {
                    result = "IMPOSSIBLE";
                    break;
                }
            }

            if (!result.equals("IMPOSSIBLE")) {
                HashMap<Integer, String> assignment = new HashMap<>();
                result = "J";
                assignment.put(startTime[0], "J");

                for (int i = 1; i < n; i++) {
                    if (startTime[i] < endTime[i - 1]) {
                        result += result.endsWith("J") ? "C" : "J";
                        assignment.put(startTime[i], result.substring(result.length() - 1));
                    } else {
                        result += result.substring(result.length() - 1);
                        assignment.put(startTime[i], result.substring(result.length() - 1));
                    }
                }

                result = assignment.get(s[0]);
                for (int i = 1; i < n; i++) {
                    result += assignment.get(s[i]);
                }
            }

            int caseNo = initialT - t;
            w.println("Case #" + caseNo + ": " + result);
        }

        w.close();
    }
}