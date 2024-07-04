import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String input = reader.nextLine();
            StringBuilder result = new StringBuilder();
            int depth = 0;

            for (char ch : input.toCharArray()) {
                int currentNum = ch - '0';

                while (depth < currentNum) {
                    result.append('(');
                    depth++;
                }
                while (depth > currentNum) {
                    result.append(')');
                    depth--;
                }
                result.append(currentNum);
            }

            while (depth > 0) {
                result.append(')');
                depth--;
            }

            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    static class FastReader {
        private final int BUFFER_SIZE = 1 << 16;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastReader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public FastReader(String fileName) throws IOException {
            din = new DataInputStream(new FileInputStream(fileName));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String nextLine() throws IOException {
            byte[] buf = new byte[1000];
            int count = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') break;
                buf[count++] = (byte) c;
            }
            return new String(buf, 0, count);
        }

        public int nextInt() throws IOException {
            int result = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean negative = (c == '-');
            if (negative) c = read();
            do {
                result = result * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return negative ? -result : result;
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