import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.math.*;

public class Solution {
    static FastScanner in;
    static FastPrinter out;
    public static void main(String[] uselessScrub) throws Exception {
        in = new FastScanner();
        out = new FastPrinter();

        int t=in.nextInt(); int b=in.nextInt();
        for (int i=1; i<=t; i++) {
            solve(b);
        }

        out.close();
    }

    public static void solve(int b) throws Exception {
        System.out.println("\n"+1);
        in.nextInt();
        int[] bits = new int[b+1];
        Arrays.fill(bits, -1);

        LinkedList<Integer> same=new LinkedList<>(), dif=new LinkedList<>();

        for (int i=1; i<=5; i++) {
            System.out.println(i);
            bits[i]=in.nextInt();
            System.out.println(b+1-i);
            bits[b+1-i]=in.nextInt();
            if (bits[i]==bits[b+1-i]) same.add(i);
            else dif.add(i);
        }
        if (b==10) {
            if (same.size() > 0) {
                System.out.println(same.peek());
                if (in.nextInt() != bits[same.peek()]) {
                    for (int i : same) {
                        bits[i] = 1 - bits[i];
                        bits[b + 1 - i] = 1 - bits[b + 1 - i];
                    }
                }
            } else {
                System.out.println(1);
                in.nextInt();
            }

            if (dif.size() > 0) {
                System.out.println(dif.peek());
                if (in.nextInt() != bits[dif.peek()]) {
                    for (int i : dif) {
                        bits[i] = 1 - bits[i];
                        bits[b + 1 - i] = 1 - bits[b + 1 - i];
                    }
                }
            } else {
                System.out.println(1);
                in.nextInt();
            }
            String s="";
            for (int i=1; i<=b; i++) s+=bits[i];
            System.out.println(s);
            if (in.next().equals("N")) System.exit(0);
            return;
        }

        int cur=6;
        while (cur<=b/2) {
            // update
            if (same.size() > 0) {
                System.out.println(same.peek());
                if (in.nextInt() != bits[same.peek()]) {
                    for (int i : same) {
                        bits[i] = 1 - bits[i];
                        bits[b + 1 - i] = 1 - bits[b + 1 - i];
                    }
                }
            } else {
                System.out.println(1);
                in.nextInt();
            }

            if (dif.size() > 0) {
                System.out.println(dif.peek());
                if (in.nextInt() != bits[dif.peek()]) {
                    for (int i : dif) {
                        bits[i] = 1 - bits[i];
                        bits[b + 1 - i] = 1 - bits[b + 1 - i];
                    }
                }
            } else {
                System.out.println(1);
                in.nextInt();
            }

            for (int i=cur; i<=cur+3 && i<=b/2; i++) {
                System.out.println(i);
                bits[i]=in.nextInt();
                System.out.println(b+1-i);
                bits[b+1-i]=in.nextInt();
                if (bits[i]==bits[b+1-i]) same.add(i);
                else dif.add(i);
            }
            cur+=4;
        }
        String s="";
        for (int i=1; i<=b; i++) s+=bits[i];
        System.out.println(s);
        if (in.next().equals("N")) System.exit(0);
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
            for (int i=0; i<n; i++) for (int j=0; j<m; j++) arr[i][j]=nextInt();
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

