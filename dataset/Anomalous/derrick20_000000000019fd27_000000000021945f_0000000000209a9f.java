import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int T = sc.nextInt();
        int testCase = 1;
        while (T-- > 0) {
            char[] s = sc.next().toCharArray();
            int[] arr = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                arr[i] = Character.getNumericValue(s[i]);
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr[0]; i++) {
                sb.append('(');
            }
            sb.append(arr[0]);

            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > arr[i - 1]) {
                    for (int j = 0; j < arr[i] - arr[i - 1]; j++) {
                        sb.append('(');
                    }
                } else {
                    for (int j = 0; j < arr[i - 1] - arr[i]; j++) {
                        sb.append(')');
                    }
                }
                sb.append(arr[i]);
            }
            for (int i = 0; i < arr[arr.length - 1]; i++) {
                sb.append(')');
            }

            out.printf("Case #%d: %s\n", testCase++, sb.toString());
        }
        out.close();
    }

    static class FastScanner {
        private final int BUFFER_SIZE = 1 << 16;
        private final char NULL_CHAR = (char) 0;
        private byte[] buffer = new byte[BUFFER_SIZE];
        private int bufferId = 0, bufferSize = 0;
        private char currentChar = NULL_CHAR;
        private double counter = 1;
        private BufferedInputStream in;

        public FastScanner() {
            in = new BufferedInputStream(System.in, BUFFER_SIZE);
        }

        public FastScanner(String fileName) {
            try {
                in = new BufferedInputStream(new FileInputStream(new File(fileName)), BUFFER_SIZE);
            } catch (Exception e) {
                in = new BufferedInputStream(System.in, BUFFER_SIZE);
            }
        }

        private char getChar() {
            while (bufferId == bufferSize) {
                try {
                    bufferSize = in.read(buffer);
                } catch (Exception e) {
                    return NULL_CHAR;
                }
                if (bufferSize == -1) return NULL_CHAR;
                bufferId = 0;
            }
            return (char) buffer[bufferId++];
        }

        public int nextInt() {
            return (int) nextLong();
        }

        public int[] nextInts(int N) {
            int[] result = new int[N];
            for (int i = 0; i < N; i++) {
                result[i] = (int) nextLong();
            }
            return result;
        }

        public long[] nextLongs(int N) {
            long[] result = new long[N];
            for (int i = 0; i < N; i++) {
                result[i] = nextLong();
            }
            return result;
        }

        public long nextLong() {
            counter = 1;
            boolean negative = false;
            if (currentChar == NULL_CHAR) currentChar = getChar();
            while (currentChar < '0' || currentChar > '9') {
                if (currentChar == '-') negative = true;
                currentChar = getChar();
            }
            long result = 0;
            while (currentChar >= '0' && currentChar <= '9') {
                result = (result << 3) + (result << 1) + currentChar - '0';
                counter *= 10;
                currentChar = getChar();
            }
            return negative ? -result : result;
        }

        public double nextDouble() {
            double current = nextLong();
            return currentChar != '.' ? current : current + nextLong() / counter;
        }

        public String next() {
            StringBuilder result = new StringBuilder();
            while (currentChar <= 32) currentChar = getChar();
            while (currentChar > 32) {
                result.append(currentChar);
                currentChar = getChar();
            }
            return result.toString();
        }

        public String nextLine() {
            StringBuilder result = new StringBuilder();
            while (currentChar <= 32) currentChar = getChar();
            while (currentChar != '\n') {
                result.append(currentChar);
                currentChar = getChar();
            }
            return result.toString();
        }

        public boolean hasNext() {
            if (currentChar > 32) return true;
            while (true) {
                currentChar = getChar();
                if (currentChar == NULL_CHAR) return false;
                else if (currentChar > 32) return true;
            }
        }
    }
}