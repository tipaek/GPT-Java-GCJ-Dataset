import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static final Scanner sc = new Scanner(System.in);
    static final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static final int MOD = 1000000007;
    static final Reader reader = new Reader();
    static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        int testCases = in.nextInt();
        for (int i = 1; i <= testCases; i++) {
            out.print("Case #" + i + ": ");
            handleTestCase();
        }
        out.flush();
        out.close();
        sc.close();
        in.close();
        reader.close();
    }

    private static void handleTestCase() throws IOException {
        int n = in.nextInt();
        Activity[] activities = new Activity[n];
        for (int i = 0; i < n; i++) {
            activities[i] = new Activity(in.nextInt(), in.nextInt(), i);
        }

        Arrays.sort(activities, (a1, a2) -> a1.start != a2.start ? a1.start - a2.start : a1.end - a2.end);

        Activity cameron = null, jamie = null;
        for (Activity activity : activities) {
            if (cameron == null || activity.start >= cameron.end) {
                activity.assignedTo = 'C';
                cameron = activity;
            } else if (jamie == null || activity.start >= jamie.end) {
                activity.assignedTo = 'J';
                jamie = activity;
            } else {
                out.println("IMPOSSIBLE");
                return;
            }
        }

        char[] result = new char[n];
        for (Activity activity : activities) {
            result[activity.index] = activity.assignedTo;
        }
        out.println(new String(result));
    }

    static class Activity {
        int start, end, index;
        char assignedTo;

        Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    static class Reader {
        private static final int BUFFER_SIZE = 1 << 16;
        private final DataInputStream din;
        private final byte[] buffer;
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
            if (din == null) return;
            din.close();
        }
    }
}