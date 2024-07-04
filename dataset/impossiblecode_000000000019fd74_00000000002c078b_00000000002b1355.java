import java.util.*;
import java.io.*;
import java.nio.file.*;

public class Solution {
    static FastScanner in;
    static FastPrinter out;
    static int[][] g, ppr, ppc, apr, apc;
    static int r, c;
    static LinkedList<int[]> q, q2;
    static long ans;
    static boolean[][] removed;
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
        r=in.nextInt(); c=in.nextInt();
        g = new int[r][c];
        for (int i=0; i<r; i++) for (int j=0; j<c; j++) g[i][j]=in.nextInt();

        ppr=new int[r][c]; ppc=new int[r][c]; apr=new int[r][c]; apc=new int[r][c];
        removed=new boolean[r][c];
        ans=0;

        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                if (j<c-1) apr[i][j]=j+1;
                else apr[i][c-1]=-1;
                if (j>0) ppr[i][j]=j-1;
                else ppr[i][0]=-1;
            }
        }
        for (int i=0; i<c; i++) {
            for (int j=0; j<r; j++) {
                if (j<r-1) apc[j][i]=j+1;
                else apc[r-1][i]=-1;
                if (j>0) ppc[j][i]=j-1;
                else ppc[0][i]=-1;
            }
        }
        q = new LinkedList<>(); q2=new LinkedList<>();
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                if (shouldremove(i, j)) {
                    q.add(new int[] {i, j, 1});
                    ans+=g[i][j];
                    q2.add(new int[] {i, j});
                }
            }
        }
        for (int[] i:q2) {
            remove(i[0], i[1]);
        }
        q2.clear();
        if (q.isEmpty()) {
            for (int i=0; i<r; i++) {
                for (int j=0; j<c; j++) {
                    if (!removed[i][j]) ans+=g[i][j];
                }
            }
            return ans;
        }

        int cround=1;
        while (!q.isEmpty()) {
            int[] cur=q.poll();
            if (cur[2]>cround) {
                cround=cur[2];
                for (int[] i:q2) {
                    remove(i[0], i[1]);
                }
                q2.clear();
            }
            update(cur[0], cur[1], cur[2]);
        }
        cround++;
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                if (!removed[i][j]) ans+=g[i][j]*cround;
            }
        }

        return ans;
    }

    public static void update(int a, int b, int c) {
        if (ppc[a][b]!=-1 && shouldremove(ppc[a][b], b)) {
            q.add(new int[] {ppc[a][b], b, c+1});
            ans+=g[ppc[a][b]][b]*(c+1);
            q2.add(new int[] {ppc[a][b], b});
            //remove(ppc[a][b], b);
        }
        if (ppr[a][b]!=-1 && shouldremove(a, ppr[a][b])) {
            q.add(new int[] {a, ppr[a][b], c+1});
            ans+=g[a][ppr[a][b]]*(c+1);
            q2.add(new int[] {a, ppr[a][b]});
            //remove(a, ppr[a][b]);
        }
        if (apc[a][b]!=-1 && shouldremove(apc[a][b], b)) {
            q.add(new int[] {apc[a][b], b, c+1});
            ans+=g[apc[a][b]][b]*(c+1);
            q2.add(new int[] {apc[a][b], b});
            //remove(apc[a][b], b);
        }
        if (apr[a][b]!=-1 && shouldremove(a,apr[a][b])) {
            q.add(new int[] {a, apr[a][b], c+1});
            ans+=g[a][apr[a][b]]*(c+1);
            q2.add(new int[] {a, apr[a][b]});
            //remove(a,apr[a][b]);
        }
    }

    public static boolean shouldremove(int a, int b) {
        double sum=0, n=0;
        if (ppc[a][b]!=-1) {
            n++; sum+=g[ppc[a][b]][b];
        }
        if (ppr[a][b]!=-1) {
            n++; sum+=g[a][ppr[a][b]];
        }
        if (apc[a][b]!=-1) {
            n++; sum+=g[apc[a][b]][b];
        }
        if (apr[a][b]!=-1) {
            n++; sum+=g[a][apr[a][b]];
        }
        return g[a][b]<sum/n;
    }

    public static void remove(int a, int b) {
        removed[a][b]=true;
        if (ppc[a][b]!=-1) apc[ppc[a][b]][b] = apc[a][b];
        if (apc[a][b]!=-1) ppc[apc[a][b]][b] = ppc[a][b];
        if (ppr[a][b]!=-1) apr[a][ppr[a][b]] = apr[a][b];
        if (apr[a][b]!=-1) ppr[a][apr[a][b]] = ppr[a][b];
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

