import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author iavanish
 */
public class Solution {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        OversizedPancakeChoppers solver = new OversizedPancakeChoppers();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class OversizedPancakeChoppers {

        public void solve(int testNumber, FastReader in, PrintWriter out) {
            int n = in.nextInt();
            int d = in.nextInt();

            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextLong();
            }

            if (d == 2) {
                int result = 1;
                for (int i = 0; i < n; i++) {
                    for (int j = i + 1; j < n; j++) {
                        if (a[i] == a[j]) {
                            result = 0;
                            break;
                        }
                    }
                }
                out.printf("Case #%d: %d\n", testNumber, result);
            } else if (d == 3) {
                int result = 2;
                for (int i = 0; i < n; i++) {
                    for (int j = i + 1; j < n; j++) {
                        if (a[i] * 2 == a[j] || a[j] * 2 == a[i]) {
                            result = 1;
                            break;
                        }
                    }
                }
                for (int i = 0; i < n; i++) {
                    for (int j = i + 1; j < n; j++) {
                        for (int k = j + 1; k < n; k++) {
                            if (a[i] == a[j] && a[j] == a[k]) {
                                result = 0;
                                break;
                            }
                        }
                    }
                }
                out.printf("Case #%d: %d\n", testNumber, result);
            } else {
                out.printf("Case #%d: %d\n", testNumber, 1);
            }
        }

    }

    static class FastReader {

        private final int BUFFER_SIZE = 1 << 16;
        private final int STRING_BUFFER_SIZE = 10000000;
        private final InputStream inputStream;
        private final byte[] buffer;
        private int bufferPointer;
        private int bytesRead;

        public FastReader() {
            this.inputStream = new DataInputStream(System.in);
            this.buffer = new byte[BUFFER_SIZE];
            this.bufferPointer = bytesRead = 0;
        }

        public FastReader(InputStream inputStream) {
            this.inputStream = inputStream;
            this.buffer = new byte[BUFFER_SIZE];
            this.bufferPointer = bytesRead = 0;
        }

        public FastReader(String fileName) {
            try {
                this.inputStream = new DataInputStream(new FileInputStream(fileName));
                this.buffer = new byte[BUFFER_SIZE];
                this.bufferPointer = bytesRead = 0;
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        public String next() {
            byte[] buffer = new byte[STRING_BUFFER_SIZE];
            int count = 0;
            int c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    break;
                }
                buffer[count++] = (byte) c;
            }
            return new String(buffer, 0, count);
        }

        public int nextInt() {
            int nextInt = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean negative = (c == '-');
            if (negative) {
                c = read();
            }
            do {
                nextInt = nextInt * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (negative) {
                return -nextInt;
            }
            return nextInt;
        }

        public long nextLong() {
            long nextLong = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean negative = (c == '-');
            if (negative) {
                c = read();
            }
            do {
                nextLong = nextLong * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (negative) {
                return -nextLong;
            }
            return nextLong;
        }

        private void fillBuffer() {
            try {
                bytesRead = inputStream.read(buffer, bufferPointer = 0, BUFFER_SIZE);
                if (bytesRead == -1) {
                    buffer[0] = -1;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        private byte read() {
            if (bufferPointer == bytesRead) {
                fillBuffer();
            }
            return buffer[bufferPointer++];
        }

    }

}

