import java.io.*;
import java.util.*;

public class Solution {

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
            if (neg) return -ret;
            return ret;
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
            if (neg) return -ret;
            return ret;
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
            if (neg) return -ret;
            return ret;
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

    static int gcd(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        if (a == b) return a;
        if (a > b) return gcd(a - b, b);
        return gcd(a, b - a);
    }

    public static class Task {
        int start;
        int end;

        public Task(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int sortByStart(Task t1, Task t2) {
        if (t1.start != t2.start) return t1.start - t2.start;
        return t1.end - t2.end;
    }

    public static boolean taskMerge(Task t1, Task t2) {
        if (t2.start > t1.start && t2.end < t1.end) return true;
        if (t2.start > t1.start && t2.start < t1.end) return true;
        if (t2.start < t1.start && t2.end > t1.end) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        Reader r = new Reader();
        int t = r.nextInt();
        int caseNumber = 0;

        while (t-- > 0) {
            caseNumber++;
            int n = r.nextInt();
            Task c = new Task(0, 0);
            Task j = new Task(0, 0);
            HashMap<Integer, Task> tasks = new HashMap<>();

            for (int i = 0; i < n; i++) {
                int start = r.nextInt();
                int end = r.nextInt();
                tasks.put(i + 1, new Task(start, end));
            }

            int[] indices = new int[n];
            for (int i = 0; i < n; i++) {
                indices[i] = i + 1;
            }

            Arrays.sort(indices, (i1, i2) -> sortByStart(tasks.get(i1), tasks.get(i2)));

            int count = 1;
            HashMap<Integer, Character> result = new HashMap<>();
            result.put(indices[0], 'C');
            c.start = tasks.get(indices[0]).start;
            c.end = tasks.get(indices[0]).end;

            for (int i = 1; i < n; i++) {
                if (tasks.get(indices[i]).start >= c.end) {
                    c.start = tasks.get(indices[i]).start;
                    c.end = tasks.get(indices[i]).end;
                    result.put(indices[i], 'C');
                    count++;
                } else if (tasks.get(indices[i]).start >= j.end) {
                    j.start = tasks.get(indices[i]).start;
                    j.end = tasks.get(indices[i]).end;
                    result.put(indices[i], 'J');
                    count++;
                }
            }

            System.out.print("Case #" + caseNumber + ": ");
            if (count == n) {
                for (int i = 0; i < n; i++) {
                    System.out.print(result.get(indices[i]));
                }
                System.out.println();
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}