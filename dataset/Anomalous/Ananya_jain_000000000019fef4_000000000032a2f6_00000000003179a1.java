import java.io.*;
import java.util.*;

public class CF {
    static final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static final int MOD = (int) (1e9 + 7);
    static final int MODFFT = 998244353;
    static final Reader reader = new Reader();
    static final PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    int[] level, parent;
    List<Integer>[] adj;

    public static void main(String[] args) throws Exception {
        int testCases = hasTestCases ? readInt() : 1;
        for (int i = 0; i < testCases; i++) {
            out.print("Case #" + (i + 1) + ": ");
            long result = new CF().solve();
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

    static final boolean hasTestCases = true;
    static final boolean fastIO = false;
    static final boolean hasPrint = false;
    static final boolean hasBooleanPrint = false;
    static final int LINE_LENGTH = 1000002;

    private long solve() throws Exception {
        int u = readInt();
        int[] freq = new int[10];
        char[] chars = new char[10];
        String[] ini = new String[10000];
        int[] iniInt = new int[10000];
        String[] inj = new String[10000];
        Arrays.fill(chars, 'q');
        Arrays.fill(freq, 10);

        for (int i = 0; i < 10000; i++) {
            int y = readInt();
            String m = readLine().trim();
            ini[i] = m;
            String n = Integer.toString(y);
            inj[i] = n;
            if (y == -1 || n.length() > m.length()) {
                continue;
            }

            for (char ch : m.toCharArray()) {
                int j = 0;
                while (chars[j] != 'q' && chars[j] != ch) {
                    j++;
                }
                if (chars[j] == 'q') {
                    chars[j] = ch;
                }
            }

            char ch = m.charAt(0);
            int j = 0;
            while (chars[j] != 'q' && chars[j] != ch) {
                j++;
            }
            if (chars[j] == 'q') {
                chars[j] = ch;
            }
            freq[j] = Math.min(freq[j], n.charAt(0) - '0');
        }

        int minIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            if (freq[i] == 10) {
                freq[i] = minIndex++;
            }
        }

        for (int i = 0; i < chars.length; i++) {
            int min = 100, minIdx = -1;
            for (int j = 0; j < chars.length; j++) {
                if (min > freq[j]) {
                    min = freq[j];
                    minIdx = j;
                }
            }
            print(chars[minIdx]);
            freq[minIdx] = 10000;
        }

        return 1;
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static String readString() throws Exception {
        return fastIO ? reader.next() : in.next();
    }

    static int[] readIntArray(int n) throws Exception {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = readInt();
        }
        return array;
    }

    static String readLine() throws Exception {
        return fastIO ? reader.readLine() : in.nextLine();
    }

    static int readInt() throws Exception {
        return fastIO ? reader.nextInt() : in.nextInt();
    }

    static long readLong() throws Exception {
        return fastIO ? reader.nextLong() : in.nextLong();
    }

    static double readDouble() throws Exception {
        return fastIO ? reader.nextDouble() : in.nextDouble();
    }

    static void print(Object obj) {
        out.print(obj);
    }

    static void println(Object obj) {
        out.println(obj);
    }

    static void println() {
        out.println("");
    }

    static void printAndFlush(Object obj) {
        out.println(obj);
        out.flush();
    }

    static class Reader {
        private static final int BUFFER_SIZE = 1 << 19;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;
        private StringTokenizer st;
        private final BufferedReader br;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public Reader(String fileName) throws IOException {
            din = new DataInputStream(new FileInputStream(fileName));
            br = new BufferedReader(new FileReader(fileName));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String next() throws Exception {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new Exception(e.toString());
                }
            }
            return st.nextToken();
        }

        public String nextLine() throws Exception {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                throw new Exception(e.toString());
            }
            return str;
        }

        static final byte[] buf = new byte[LINE_LENGTH];

        public String readLine() throws IOException {
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
}