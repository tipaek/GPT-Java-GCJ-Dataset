import java.io.*;
import java.util.*;

public class Solution {

    public static ScannerWrapper scanner = new ScannerWrapper();
    public static OutputWriter outputWriter = new OutputWriter();

    public static void main(String[] args) throws IOException {
        int testCaseCount = scanner.nextInt();
        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            long L = scanner.nextLong();
            long R = scanner.nextLong();

            boolean swapped = false;
            if (R < L) {
                long temp = L;
                L = R;
                R = temp;
                swapped = true;
            }

            long difference = R - L;
            long n = calculateN(difference);
            long remainingR = R - (n * (n + 1)) / 2;
            long x1 = calculateX(remainingR, n);
            long x2 = calculateX(L, n + 1);
            long answer = n + x1 + x2;

            long remainingLeft = L - (n * x2 + x2 * (x2 + 1));
            long remainingRight = remainingR - (n * x1 + x1 * x1);

            if (swapped) {
                long temp = remainingLeft;
                remainingLeft = remainingRight;
                remainingRight = temp;
            }

            System.out.println("Case #" + testCase + ": " + answer + " " + remainingLeft + " " + remainingRight);
        }
    }

    public static long calculateN(long difference) {
        double t = (Math.sqrt(8 * difference + 1) - 1) / 2.0;
        return (long) Math.floor(t);
    }

    public static long calculateX(long value, long n) {
        double t = (Math.sqrt(4 * value + n * n) - n) / 2.0;
        return (long) Math.floor(t);
    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter() {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) writer.print(' ');
                writer.print(objects[i]);
            }
        }

        public void println(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

        public void flush() {
            writer.flush();
        }
    }

    static class ScannerWrapper {
        private final InputStream inputStream;
        private final byte[] buffer;
        private int currentIndex;
        private int totalBytesRead;

        public ScannerWrapper() {
            inputStream = System.in;
            buffer = new byte[1024];
            currentIndex = 0;
            totalBytesRead = 0;
        }

        private int read() throws IOException {
            if (totalBytesRead < 0) throw new InputMismatchException();
            if (currentIndex >= totalBytesRead) {
                currentIndex = 0;
                totalBytesRead = inputStream.read(buffer);
                if (totalBytesRead <= 0) return -1;
            }
            return buffer[currentIndex++];
        }

        public int nextInt() throws IOException {
            int number = 0;
            int n = read();
            while (isWhitespace(n)) n = read();
            int sign = 1;
            if (n == '-') {
                sign = -1;
                n = read();
            }
            while (!isWhitespace(n)) {
                if (n >= '0' && n <= '9') {
                    number = number * 10 + (n - '0');
                    n = read();
                } else throw new InputMismatchException();
            }
            return sign * number;
        }

        public long nextLong() throws IOException {
            long number = 0;
            int n = read();
            while (isWhitespace(n)) n = read();
            int sign = 1;
            if (n == '-') {
                sign = -1;
                n = read();
            }
            while (!isWhitespace(n)) {
                if (n >= '0' && n <= '9') {
                    number = number * 10 + (n - '0');
                    n = read();
                } else throw new InputMismatchException();
            }
            return sign * number;
        }

        private boolean isWhitespace(int n) {
            return n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1;
        }
    }
}