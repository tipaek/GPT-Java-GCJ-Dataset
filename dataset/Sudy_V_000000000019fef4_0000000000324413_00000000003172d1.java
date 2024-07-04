import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class Solution {
    static FastScanner in;
    static FastPrinter out;

    public static void main(String[] args) throws Exception {
        in = new FastScanner();
        out = new FastPrinter();
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            out.println("Case #" + i + ": " + solve());
        }
        out.close();

    }

    public static long solve() throws Exception {
        int n = in.nextInt();
        int d = in.nextInt();
        if (n == 1) {
            in.nextInt();
            return d - 1;
        }
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
        }
        LinkedHashMap<Long, Long> check = new LinkedHashMap<>();
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            if (!check.containsKey(a[i])) {
                check.put(a[i], (long) 1);
            } else {
                long x = check.get(a[i]);
                check.put(a[i], x + 1);
            }
        }
        long max = 0;
        long key = 0;
        HashSet<Long> h = new HashSet<>();
        for (int i = 0; i < check.size(); i++) {
            long x = check.get(a[i]);
            h.add(x);
            if (x > max) {
                max = x;
                key = i;
            }
        }
        if (h.size() == 1) {
            max = check.get(a[0]);
            key = 0;
        }
        if (max >= d) {
            return 0;
        } else {
            long diff = d - max;
            if (key != a.length - 1) {
                for (long i = a.length - 1; i > key; i--) {
                    if (i == 1) {
                        if (diff == 1) {
                            return diff;
                        } else {
                            return diff - 1;
                        }
                    }
                    long div = a[(int)i] / (a[(int) key]);
                    if (div >= diff) {
                        if (diff == 1) {
                            return diff;
                        } else {
                            return diff - 1;
                        }
                    } else{
                        diff -= div;
                    }
                }
            } else {
                boolean works = false;
                while (!works) {
                    key -= 1;
                    for (long i = a.length - 1; i > key; i--) {
                        if  (i == 1) {
                            if (diff == 1) {
                                return diff;
                            } else {
                                return diff - 1;
                            }
                        }
                        long div = a[(int)i] / (a[(int) key]);
                        if (div >= diff) {
                            if (diff == 1) {
                                return diff;
                            } else {
                                return diff - 1;
                            }
                        } else{
                            diff -= div;
                        }
                    }
                }
            }
            return -1;
        }
    }

    public static int[] shifter(char curr, int x, int y) throws Exception {
        if (curr == 'N') {
            y += 1;
        } else if (curr == 'S') {
            y -= 1;
        } else if (curr == 'W') {
            x -= 1;
        } else if (curr == 'E') {
            x += 1;
        }
        int[] a = {x, y};
        return a;
    }
// int x = in.nextInt();
//        int y = in.nextInt();
//        boolean negX = false;
//        boolean negY = false;
//        if (x < 0) {
//            negX = true;
//        }
//        if (y < 0) {
//            negY = true;
//        }
//        x = Math.abs(x);
//        y = Math.abs(y);
//        ArrayList<Integer> vals = new ArrayList<>();
//        ArrayList<Integer> vals2 = new ArrayList<>();
//        int sumX = 0;
//        int sumY = 0;
//        if(log2(x) %1  == 0 && log2(y) %1 == 0){
//            return "IMPOSSIBLE";
//        }
//        for (int i = 0; i < 30; i++) {
//            vals2.add(((int) Math.pow(2, i)));
//            vals.add(((int) Math.pow(2, i)));
//        }
//        solver(x);

    static ArrayList<Integer> solver(long x) {
        ArrayList<Integer> q = new ArrayList<Integer>();
        ArrayList<Integer> ans = new ArrayList<Integer>();

        while (x > 0) {
            q.add((int) x % 2);
            x = x / 2;
        }

        for (int i = 0; i < q.size(); i++) {
            if (q.get(i) == 1) {
                ans.add(i);
            }
        }
        if (ans.size() == 0) {
            return null;
        }
        return ans;
    }

    public static void print2D(int mat[][]) {
        for (int[] row : mat)
            System.out.println(Arrays.toString(row));
    }

    public static double log2(int x) {
        return (int) (Math.log(x) / Math.log(2) + 1e-10);
    }


    public static String addChar(String str, char ch, int position) {
        StringBuilder sb = new StringBuilder(str);
        sb.insert(position, ch);
        return sb.toString();
    }

    private static class FastPrinter {
        static final char ENDL = '\n';
        StringBuilder buf;
        PrintWriter pw;

        public FastPrinter() {
            buf = new StringBuilder();
            pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        }

        public FastPrinter(OutputStream stream) {
            buf = new StringBuilder();
            pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(stream)));
        }

        public FastPrinter(String fileName) throws Exception {
            buf = new StringBuilder();
            pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
        }

        public FastPrinter(StringBuilder buf) {
            this.buf = buf;
        }

        public void print(int a) {
            buf.append(a);
        }

        public void print(long a) {
            buf.append(a);
        }

        public void print(char a) {
            buf.append(a);
        }

        public void print(char[] a) {
            buf.append(a);
        }

        public void print(double a) {
            buf.append(a);
        }

        public void print(String a) {
            buf.append(a);
        }

        public void print(Object a) {
            buf.append(a.toString());
        }

        public void println() {
            buf.append(ENDL);
        }

        public void println(int a) {
            buf.append(a);
            buf.append(ENDL);
        }

        public void println(long a) {
            buf.append(a);
            buf.append(ENDL);
        }

        public void println(char a) {
            buf.append(a);
            buf.append(ENDL);
        }

        public void println(char[] a) {
            buf.append(a);
            buf.append(ENDL);
        }

        public void println(double a) {
            buf.append(a);
            buf.append(ENDL);
        }

        public void println(String a) {
            buf.append(a);
            buf.append(ENDL);
        }

        public void println(Object a) {
            buf.append(a.toString());
            buf.append(ENDL);
        }

        public void close() {
            pw.print(buf);
            pw.close();
        }

        public void flush() {
            pw.print(buf);
            pw.flush();
            buf.setLength(0);
        }

    }

    private static class FastScanner {
        final private int BUFFER_SIZE = 1 << 10;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastScanner() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public FastScanner(InputStream stream) {
            din = new DataInputStream(stream);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public FastScanner(String fileName) throws IOException {
            Path p = Paths.get(fileName);
            buffer = Files.readAllBytes(p);
            bytesRead = buffer.length;
        }

        int[] nextIntArray(int N) throws IOException {
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) arr[i] = nextInt();
            return arr;
        }

        int[][] nextDoubleIntArray(int n, int m) throws IOException {
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) arr[i][j] = nextInt();
            return arr;
        }

        String nextLine() throws IOException {
            int c = read();
            while (c != -1 && isEndline(c))
                c = read();
            if (c == -1) {
                return null;
            }
            StringBuilder res = new StringBuilder();
            do {
                if (c >= 0) {
                    res.appendCodePoint(c);
                }
                c = read();
            } while (!isEndline(c));
            return res.toString();
        }

        boolean isEndline(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        String next() throws Exception {
            int c = readOutSpaces();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg) return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg) return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
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

            if (neg) return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }

        private int readOutSpaces() throws IOException {
            while (true) {
                if (bufferPointer == bytesRead) fillBuffer();
                int c = buffer[bufferPointer++];
                if (!isSpaceChar(c)) {
                    return c;
                }
            }
        }

        public void close() throws IOException {
            if (din == null) return;
            din.close();
        }
    }
}

