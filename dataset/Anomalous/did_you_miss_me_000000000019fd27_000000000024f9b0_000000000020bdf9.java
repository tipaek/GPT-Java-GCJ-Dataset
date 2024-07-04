import java.io.*;
import java.util.*;

class Solution implements Runnable {

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        public InputReader(InputStream stream) {
            this.stream = stream;
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

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }
    }

    public static void main(String[] args) {
        new Thread(null, new Solution(), "Main", 1 << 27).start();
    }

    public void run() {
        InputReader in = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);

        int t = in.nextInt();
        int originalT = t;

        while (t-- > 0) {
            int n = in.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = in.nextInt();
                endTimes[i] = in.nextInt();
            }

            TreeMap<Integer, Integer> events = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                events.put(startTimes[i], endTimes[i]);
            }

            int[] sortedStartTimes = new int[n];
            int[] sortedEndTimes = new int[n];
            int index = 0;
            for (Map.Entry<Integer, Integer> entry : events.entrySet()) {
                sortedStartTimes[index] = entry.getKey();
                sortedEndTimes[index] = entry.getValue();
                index++;
            }

            String result = "";
            int maxEndTime = sortedEndTimes[0];
            int overlapCount = 0;

            for (int i = 1; i < n; i++) {
                if (sortedEndTimes[i] > maxEndTime) {
                    maxEndTime = sortedEndTimes[i];
                    overlapCount = 0;
                } else {
                    overlapCount++;
                    if (overlapCount == 2) {
                        result = "IMPOSSIBLE";
                        break;
                    }
                }
            }

            if (!result.equals("IMPOSSIBLE")) {
                HashMap<Integer, String> assignment = new HashMap<>();
                result = "J";
                assignment.put(sortedStartTimes[0], "J");

                for (int i = 1; i < n; i++) {
                    if (sortedStartTimes[i] < sortedEndTimes[i - 1]) {
                        if (result.endsWith("J")) {
                            result += "C";
                            assignment.put(sortedStartTimes[i], "C");
                        } else {
                            result += "J";
                            assignment.put(sortedStartTimes[i], "J");
                        }
                    } else {
                        result += result.substring(result.length() - 1);
                        assignment.put(sortedStartTimes[i], result.substring(result.length() - 1));
                    }
                }

                result = assignment.get(startTimes[0]);
                for (int i = 1; i < n; i++) {
                    result += assignment.get(startTimes[i]);
                }
            }

            int caseNumber = originalT - t;
            w.println("Case #" + caseNumber + ": " + result);
        }

        w.flush();
        w.close();
    }
}