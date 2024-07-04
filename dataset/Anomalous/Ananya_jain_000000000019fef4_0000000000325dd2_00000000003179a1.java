import java.io.*;
import java.util.*;

public class Solution {
    static final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static final int MOD = (int) (1e9 + 7);
    static final int MODFFT = 998244353;
    static final Reader reader = new Reader();
    static final PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    int[] level, parent;
    List<Integer>[] adj;

    public static void main(final String[] args) throws Exception {
        final int testcases = hasTestCases ? nextInt() : 1;
        for (int i = 0; i < testcases; i++) {
            out.print("Case #" + (i + 1) + ": ");
            final long result = new Solution().solve();
            if (hasPrint) {
                if (hasBooleanPrint) {
                    out.println(result == 0 ? "no" : "yes");
                } else {
                    out.println(result);
                }
            }
        }
        out.flush();
    }

    static final boolean hasTestCases = true, fastIO = false;
    static final boolean hasPrint = false, hasBooleanPrint = false;
    static final int LINE_LENGTH = 1000002;

    private long solve() throws Exception {
        int u = nextInt();
        int[] frequency = new int[10];
        char[] characters = new char[10];
        Arrays.fill(characters, 'q');
        Arrays.fill(frequency, 10);
        Map<Character, Integer> charMap = new HashMap<>();
        
        for (int i = 0; i < 10000; i++) {
            int y = nextInt();
            String m = nextLine().trim();
            if (y == -1 || Math.log10(y) > m.length()) {
                continue;
            }
            
            for (int j = 0; j < m.length(); j++) {
                char ch = m.charAt(j);
                int k = 0;
                while (characters[k] != 'q' && characters[k] != ch) {
                    k++;
                }
                if (characters[k] == 'q') {
                    characters[k] = ch;
                }
            }
            
            char ch = m.charAt(0);
            while (y > 10) {
                y /= 10;
            }
            int k = 0;
            while (characters[k] != 'q' && characters[k] != ch) {
                k++;
            }
            if (characters[k] == 'q') {
                characters[k] = ch;
            }
            frequency[k] = Math.min(frequency[k], y);
        }

        for (int i = 0; i < characters.length; i++) {
            int min = 100, minIndex = -1;
            for (int j = 0; j < characters.length; j++) {
                if (min > frequency[j]) {
                    min = frequency[j];
                    minIndex = j;
                }
            }
            print(characters[minIndex]);
            frequency[minIndex] = 10000;
        }
        
        return 1;
    }

    static int gcd(final int a, final int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static String next() throws Exception {
        return fastIO ? reader.next() : in.next();
    }

    static int[] nextIntArray(final int n) throws Exception {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        return array;
    }

    static String nextLine() throws Exception {
        return fastIO ? reader.readLine() : in.nextLine();
    }

    static int nextInt() throws Exception {
        return fastIO ? reader.nextInt() : in.nextInt();
    }

    static long nextLong() throws Exception {
        return fastIO ? reader.nextLong() : in.nextLong();
    }

    static double nextDouble() throws Exception {
        return fastIO ? reader.nextDouble() : in.nextDouble();
    }

    static void print(final Object obj) {
        out.print(obj);
    }

    static void println(final Object obj) {
        out.println(obj);
    }

    static void println() {
        out.println();
    }

    static void printAndFlush(final Object obj) {
        out.println(obj);
        out.flush();
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

        public Reader(final String fileName) throws IOException {
            dataInputStream = new DataInputStream(new FileInputStream(fileName));
            bufferedReader = new BufferedReader(new FileReader(fileName));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String next() throws Exception {
            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (final IOException e) {
                    throw new Exception(e.toString());
                }
            }
            return stringTokenizer.nextToken();
        }

        public String readLine() throws IOException {
            int count = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') break;
                buffer[count++] = (byte) c;
            }
            return new String(buffer, 0, count);
        }

        public int nextInt() throws IOException {
            int result = 0;
            byte c = read();
            while (c <= ' ') c = read();
            final boolean negative = (c == '-');
            if (negative) c = read();
            do {
                result = result * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return negative ? -result : result;
        }

        public long nextLong() throws IOException {
            long result = 0;
            byte c = read();
            while (c <= ' ') c = read();
            final boolean negative = (c == '-');
            if (negative) c = read();
            do {
                result = result * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return negative ? -result : result;
        }

        public double nextDouble() throws IOException {
            double result = 0, div = 1;
            byte c = read();
            while (c <= ' ') c = read();
            final boolean negative = (c == '-');
            if (negative) c = read();
            do {
                result = result * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    result += (c - '0') / (div *= 10);
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
            if (dataInputStream != null) {
                dataInputStream.close();
            }
        }
    }
}