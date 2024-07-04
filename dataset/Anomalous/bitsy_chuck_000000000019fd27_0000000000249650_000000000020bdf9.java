import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

class Solution {
    static class Reader {
        private static final int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String fileName) throws IOException {
            din = new DataInputStream(new FileInputStream(fileName));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64];
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return neg ? -ret : ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return neg ? -ret : ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
            return neg ? -ret : ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din != null) din.close();
        }
    }

    static class Interval {
        int start, end;

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "start: " + start + "  end: " + end;
        }
    }

    public static class SortByEnd implements Comparator<Interval> {
        @Override
        public int compare(Interval i1, Interval i2) {
            return Integer.compare(i1.end, i2.end);
        }
    }

    public static class SortByStart implements Comparator<Interval> {
        @Override
        public int compare(Interval i1, Interval i2) {
            return Integer.compare(i1.start, i2.start);
        }
    }

    public static void main(String[] args) throws IOException {
        Reader in = new Reader();
        int testCases = in.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = in.nextInt();
            ArrayList<Interval> intervals = new ArrayList<>();
            ArrayList<Integer> index = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = in.nextInt();
                index.add(start);
                int end = in.nextInt();
                intervals.add(new Interval(start, end));
            }

            intervals.sort(new SortByStart());

            int cs = 0, ce = 0, js = 0, je = 0;
            boolean isImpossible = false;
            char[] schedule = new char[n];
            schedule[index.indexOf(intervals.get(0).start)] = 'C';
            index.set(index.indexOf(intervals.get(0).start), -1);
            cs = intervals.get(0).start;
            ce = intervals.get(0).end;

            for (int i = 1; i < intervals.size(); i++) {
                int start = intervals.get(i).start;
                int end = intervals.get(i).end;
                int idx = index.indexOf(start);
                index.set(idx, -1);

                if (ce <= start) {
                    schedule[idx] = 'C';
                    cs = start;
                    ce = end;
                } else if (je <= start) {
                    schedule[idx] = 'J';
                    js = start;
                    je = end;
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", testCase);
            } else {
                System.out.printf("Case #%d: %s\n", testCase, new String(schedule));
            }
        }
    }
}