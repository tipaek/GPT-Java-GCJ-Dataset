import java.io.*;
import java.util.Scanner;

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

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the newline after the integer input
        for (int z = 0; z < t; z++) {
            String s = sc.nextLine();
            StringBuilder ans = new StringBuilder(100);

            int[] stack = new int[s.length()];
            int countOfBrackets = 0;

            for (int i = 0; i < s.length(); i++) {
                int currentDigit = Character.getNumericValue(s.charAt(i));
                stack[i] = currentDigit;

                if (i == 0) {
                    appendBrackets(ans, currentDigit, '(', countOfBrackets);
                    ans.append(currentDigit);
                    countOfBrackets += currentDigit;
                } else {
                    int previousDigit = stack[i - 1];
                    if (currentDigit < previousDigit) {
                        appendBrackets(ans, previousDigit - currentDigit, ')', countOfBrackets);
                        countOfBrackets -= (previousDigit - currentDigit);
                    } else if (currentDigit > previousDigit) {
                        appendBrackets(ans, currentDigit - previousDigit, '(', countOfBrackets);
                        countOfBrackets += (currentDigit - previousDigit);
                    }
                    ans.append(currentDigit);
                }
            }

            appendBrackets(ans, countOfBrackets, ')', countOfBrackets);

            System.out.println("Case #" + (z + 1) + ": " + ans);
        }
    }

    private static void appendBrackets(StringBuilder sb, int count, char bracket, int countOfBrackets) {
        for (int j = 0; j < count; j++) {
            sb.append(bracket);
        }
    }
}