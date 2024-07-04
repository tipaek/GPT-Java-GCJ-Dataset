import java.io.*;
import java.util.Scanner;

public class Solution {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Scanner INPUT = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    private static final int MOD = (int) (1e9 + 7);
    private static final Reader READER = new Reader();
    private static final PrintWriter OUTPUT = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        int testCases = INPUT.nextInt();
        int caseNumber = 1;
        while (testCases > 0) {
            OUTPUT.print("Case #" + caseNumber + ": ");
            processTestCase();
            testCases--;
            caseNumber++;
        }
        OUTPUT.flush();
        OUTPUT.close();
        SCANNER.close();
        INPUT.close();
        READER.close();
    }

    private static void processTestCase() throws IOException {
        char[] characters = INPUT.next().toCharArray();
        int openParentheses = 0;
        for (char character : characters) {
            int digit = character - '0';
            if (digit > openParentheses) {
                for (int j = openParentheses; j < digit; j++) {
                    OUTPUT.print('(');
                }
                openParentheses = digit;
            } else if (digit < openParentheses) {
                for (int j = openParentheses; j > digit; j--) {
                    OUTPUT.print(')');
                }
                openParentheses = digit;
            }
            OUTPUT.print(character);
        }
        while (openParentheses > 0) {
            OUTPUT.print(')');
            openParentheses--;
        }
        OUTPUT.println();
    }

    static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    static class Reader {
        private static final int BUFFER_SIZE = 1 << 16;
        private final DataInputStream dataInputStream;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            dataInputStream = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String fileName) throws IOException {
            dataInputStream = new DataInputStream(new FileInputStream(fileName));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64];
            int count = 0, character;
            while ((character = read()) != -1) {
                if (character == '\n') break;
                buf[count++] = (byte) character;
            }
            return new String(buf, 0, count);
        }

        public int nextInt() throws IOException {
            int result = 0;
            byte character = read();
            while (character <= ' ') character = read();
            boolean negative = (character == '-');
            if (negative) character = read();
            do {
                result = result * 10 + character - '0';
            } while ((character = read()) >= '0' && character <= '9');
            return negative ? -result : result;
        }

        public long nextLong() throws IOException {
            long result = 0;
            byte character = read();
            while (character <= ' ') character = read();
            boolean negative = (character == '-');
            if (negative) character = read();
            do {
                result = result * 10 + character - '0';
            } while ((character = read()) >= '0' && character <= '9');
            return negative ? -result : result;
        }

        public double nextDouble() throws IOException {
            double result = 0, divisor = 1;
            byte character = read();
            while (character <= ' ') character = read();
            boolean negative = (character == '-');
            if (negative) character = read();
            do {
                result = result * 10 + character - '0';
            } while ((character = read()) >= '0' && character <= '9');
            if (character == '.') {
                while ((character = read()) >= '0' && character <= '9') {
                    result += (character - '0') / (divisor *= 10);
                }
            }
            return negative ? -result : result;
        }

        private void fillBuffer() throws IOException {
            bytesRead = dataInputStream.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (dataInputStream != null) dataInputStream.close();
        }
    }
}