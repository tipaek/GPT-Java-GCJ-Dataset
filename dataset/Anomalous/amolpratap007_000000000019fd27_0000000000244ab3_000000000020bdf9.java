import java.io.*;
import java.util.*;

public class Solution implements Runnable {

    static class Pair implements Comparable<Pair> {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.second != other.second) {
                return Integer.compare(other.second, this.second);
            }
            return Integer.compare(this.first, other.first);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair pair = (Pair) obj;
            return first == pair.first && second == pair.second;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }

    public static class Triplet implements Comparable<Triplet> {
        int first;
        int second;
        int third;

        Triplet(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        @Override
        public int compareTo(Triplet other) {
            return Integer.compare(this.second, other.second);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Triplet triplet = (Triplet) obj;
            return first == triplet.first && second == triplet.second && third == triplet.third;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second, third);
        }
    }

    public static void main(String[] args) throws Exception {
        new Thread(null, new Solution(), "Solution", 1 << 27).start();
    }

    @Override
    public void run() {
        try {
            InputReader in = new InputReader(System.in);
            PrintWriter out = new PrintWriter(System.out);
            int t = in.nextInt();
            for (int q = 1; q <= t; q++) {
                out.print("Case #" + q + ": ");
                int n = in.nextInt();
                int[] start = new int[n + 1];
                int[] end = new int[n + 1];
                int[] events = new int[1500];
                for (int i = 1; i <= n; i++) {
                    start[i] = in.nextInt();
                    end[i] = in.nextInt();
                    events[start[i]]++;
                    events[end[i]]--;
                }
                int[] assignment = new int[n + 1];
                int ongoingEvents = 0;
                boolean impossible = false;
                for (int i = 0; i < 1500; i++) {
                    ongoingEvents += events[i];
                    if (ongoingEvents > 2) {
                        impossible = true;
                        break;
                    }
                }
                if (impossible) {
                    out.println("IMPOSSIBLE");
                } else {
                    PriorityQueue<Triplet> pq = new PriorityQueue<>();
                    for (int i = 1; i <= n; i++) {
                        pq.add(new Triplet(i, start[i], end[i]));
                    }
                    int lastEnd = 0;
                    for (int i = 1; i <= n; i++) {
                        Triplet current = pq.poll();
                        if (current.second >= lastEnd) {
                            assignment[current.first] = 1;
                            lastEnd = current.third;
                        } else {
                            assignment[current.first] = 0;
                        }
                    }
                    for (int i = 1; i <= n; i++) {
                        out.print(assignment[i] == 0 ? "C" : "J");
                    }
                    out.println();
                }
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class InputReader {
        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                res = res * 10 + c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String nextLine() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
    }
}