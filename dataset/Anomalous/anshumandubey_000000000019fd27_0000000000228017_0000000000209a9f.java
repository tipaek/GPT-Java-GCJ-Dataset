import java.io.*;

public class Solution {
    static InputReader sc;
    static OutputWriter out;

    public static void main(String[] args) throws IOException {
        sc = new InputReader();
        out = new OutputWriter();
        int testCases = sc.nextInt();
        for (int t = 0; t < testCases; t++) {
            String s = sc.readLine();
            StringBuilder s1 = new StringBuilder(s.length() * 10);
            for (int i = 0; i < Character.getNumericValue(s.charAt(0)); i++) {
                s1.append('(');
            }
            s1.append(s.charAt(0));
            for (int i = 1; i < s.length(); i++) {
                char c = s.charAt(i);
                char c0 = s.charAt(i - 1);
                if (c > c0) {
                    for (int j = 0; j < (c - c0); j++) {
                        s1.append('(');
                    }
                } else if (c < c0) {
                    for (int j = 0; j < (c0 - c); j++) {
                        s1.append(')');
                    }
                }
                s1.append(c);
            }
            for (int i = 0; i < Character.getNumericValue(s.charAt(s.length() - 1)); i++) {
                s1.append(')');
            }
            out.println("Case #" + (t + 1) + ": " + s1.toString());
        }
        out.close();
    }

    static class OutputWriter {
        private final OutputStream outputStream;

        public OutputWriter() {
            this.outputStream = new BufferedOutputStream(System.out);
        }

        public void print(Object object) throws IOException {
            outputStream.write(object.toString().getBytes());
        }

        public void println() throws IOException {
            outputStream.write("\n".getBytes());
        }

        public void println(Object object) throws IOException {
            outputStream.write((object.toString() + "\n").getBytes());
        }

        public void close() throws IOException {
            outputStream.flush();
            outputStream.close();
        }
    }

    static class InputReader {
        private final int BUFFER_SIZE = 1 << 16;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public InputReader() {
            this.din = new DataInputStream(System.in);
            this.buffer = new byte[BUFFER_SIZE];
            this.bufferPointer = this.bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[128];
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
}