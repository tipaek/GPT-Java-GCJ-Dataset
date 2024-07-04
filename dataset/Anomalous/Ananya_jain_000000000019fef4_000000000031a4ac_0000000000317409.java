import java.io.*;
import java.util.*;

public class Solution {
    private static final Scanner SCANNER = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    private static final int MOD = (int) (1e9 + 7);
    private static final int MOD_FFT = 998244353;
    private static final PrintWriter OUTPUT = new PrintWriter(new BufferedOutputStream(System.out));
    private static final Reader READER = new Reader();
    private static final boolean HAS_TEST_CASES = true;
    private static final boolean FAST_IO = false;
    private static final boolean HAS_PRINT = false;
    private static final boolean HAS_BOOLEAN_PRINT = false;

    private int[] level, parent;
    private List<Integer>[] adjacencyList;

    public static void main(String[] args) throws Exception {
        int testCases = HAS_TEST_CASES ? nextInt() : 1;
        for (int i = 0; i < testCases; i++) {
            OUTPUT.print("Case #" + (i + 1) + ": ");
            long result = new Solution().solve();
            if (HAS_PRINT) {
                if (HAS_BOOLEAN_PRINT) {
                    OUTPUT.println(result == 0 ? "no" : "yes");
                } else {
                    OUTPUT.println(result);
                }
            }
        }
        OUTPUT.flush();
    }

    private long solve() throws Exception {
        int x = nextInt();
        int y = nextInt();
        String moves = nextLine().trim();
        for (int i = 0; i < moves.length(); i++) {
            char move = moves.charAt(i);
            switch (move) {
                case 'N': y++; break;
                case 'S': y--; break;
                case 'E': x++; break;
                case 'W': x--; break;
            }
            if (Math.abs(x) + Math.abs(y) <= i + 1) {
                println(i + 1);
                return -1;
            }
        }
        println("IMPOSSIBLE");
        return 1;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static String next() throws Exception {
        return FAST_IO ? READER.next() : SCANNER.next();
    }

    private static int[] nextIntArray(int n) throws Exception {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        return array;
    }

    private static String nextLine() throws Exception {
        return FAST_IO ? READER.readLine() : SCANNER.nextLine();
    }

    private static int nextInt() throws Exception {
        return FAST_IO ? READER.nextInt() : SCANNER.nextInt();
    }

    private static long nextLong() throws Exception {
        return FAST_IO ? READER.nextLong() : SCANNER.nextLong();
    }

    private static double nextDouble() throws Exception {
        return FAST_IO ? READER.nextDouble() : SCANNER.nextDouble();
    }

    private static void print(Object obj) {
        OUTPUT.print(obj);
    }

    private static void println(Object obj) {
        OUTPUT.println(obj);
    }

    private static void println() {
        OUTPUT.println();
    }

    private static void printAndFlush(Object obj) {
        OUTPUT.println(obj);
        OUTPUT.flush();
    }

    static class Reader {
        private static final int BUFFER_SIZE = 1 << 19;
        private final DataInputStream dataInputStream;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;
        private StringTokenizer stringTokenizer;
        private final BufferedReader bufferedReader;

        public Reader() {
            dataInputStream = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }

        public Reader(String fileName) throws IOException {
            dataInputStream = new DataInputStream(new FileInputStream(fileName));
            bufferedReader = new BufferedReader(new FileReader(fileName));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String next() throws Exception {
            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    throw new Exception(e.toString());
                }
            }
            return stringTokenizer.nextToken();
        }

        public String readLine() throws IOException {
            int count = 0, character;
            byte[] buffer = new byte[BUFFER_SIZE];
            while ((character = read()) != -1) {
                if (character == '\n') break;
                buffer[count++] = (byte) character;
            }
            return new String(buffer, 0, count);
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