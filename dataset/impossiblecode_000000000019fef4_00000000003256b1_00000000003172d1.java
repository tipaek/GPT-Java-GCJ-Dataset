import java.util.*;
import java.io.*;
import java.nio.file.*;

public class Solution {
    static FastScanner in;
    static FastPrinter out;

    public static void main(String[] uselessScrub) throws Exception {
        in = new FastScanner();
        out = new FastPrinter();

        int t=in.nextInt();
        for (int i=1; i<=t; i++) {
            out.println("Case #"+i+": "+ solve());
        }

        out.close();
    }

    public static long solve() throws Exception {
        int n=in.nextInt(), d=in.nextInt();
        long[] a=new long[n]; for (int i=0; i<n; i++) a[i]=in.nextLong();
        Arrays.sort(a);
        ArrayList<long[]> b = new ArrayList<>(n);
        for (int i=0; i<n;) {
            int j=i+1;
            while (j<n && a[j]==a[i]) j++;
            b.add(new long[] {a[i], j-i});
            i=j;
        }

        long ans=d-1;
        for (int i=0; i<b.size(); i++) {
            long c=b.get(i)[0], slices=b.get(i)[1], cuts=0, non=0;
            if (slices>=d) return 0;
            boolean done=false;

            for (int j=i+1; j<b.size(); j++) {
                long x=b.get(j)[0]/c;
                if (b.get(j)[0]%c!=0) non+=b.get(j)[1]*x;
                else {
                    if (slices+x*b.get(j)[1]>d) {
                        ans=Math.min(ans, cuts+d-slices);
                        done=true;
                        break;
                    } else if (slices+x*b.get(j)[1]==d) {
                        ans=Math.min(ans, cuts+(x-1)*b.get(j)[1]);
                        done=true;
                        break;
                    }
                    slices+=x*b.get(j)[1];
                    cuts+=(x-1)*b.get(j)[1];
                }
            }
            if (done) continue;
            if (slices+non>=d) ans=Math.min(ans, cuts+d-slices);
            else {
                ans=Math.min(ans, cuts+slices*((d-1)/slices));
            }
        }
        return ans;
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

