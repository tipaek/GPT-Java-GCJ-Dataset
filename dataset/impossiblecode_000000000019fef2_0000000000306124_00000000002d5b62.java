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

    public static String solve() throws Exception {
        int x=in.nextInt(), y=in.nextInt();
        int fx=0, fy=0; if (x<0) {fx=1; x=-x;} if (y<0) {fy=1; y=-y;}
        int ux=(int) Math.pow(2, Math.ceil(Math.log(x)/Math.log(2)));
        int uy=(int) Math.pow(2, Math.ceil(Math.log(y)/Math.log(2)));

        if (((x+y)&(x+y+1))==0) return maker(x, y, fx, fy);

        if (((ux+(ux-x)+y)&(ux+(ux-x)+y+1))==0) return maker(x, ux, y, 0, fx, fy);

        if (((uy+(uy-y)+x)&(uy+(uy-y)+x+1))==0) return maker(y, uy, x, 1, fx, fy);

        if (((2*uy-y+2*ux-x)&(2*uy-y+2*ux-x+1))==0) return maker(x, ux, y, uy, fx, fy, 0);

        return "IMPOSSIBLE";
    }


    public static String maker(int a, int b, int fx, int fy) {
        String ans="";
        for (int i=0; i<=Math.log(Math.max(a, b))/Math.log(2); i++) {
            if ((a>>i & 1) == 1) if (fx==0) ans+="E"; else ans+="W";
            if ((b>>i & 1) == 1) if (fy==0) ans+="N"; else ans+="S";
        }
        return ans;
    }

    public static String maker(int a, int ua, int b, int c, int fx, int fy) {
        String ans="";
        for (int i=0; i<=Math.log(ua)/Math.log(2); i++) {
            if ((ua>>i & 1) == 1)
                if (c==0) if (fx==0) ans+="E"; else ans+="W";
                else if (fy==0) ans+="N"; else ans+="S";
            if (((ua-a)>>i & 1) == 1)
                if (c==0) if (fx==0) ans+="W"; else ans+="E";
                else if (fy==0) ans+="S"; else ans+="N";
            if ((b>>i & 1) == 1)
                if (c==0) if (fy==0) ans+="N"; else ans+="S";
                else if (fx==0) ans+="E"; else ans+="W";
        }
        return ans;
    }

    public static String maker(int a, int ua, int b, int ub, int fx, int fy, int c) {
        String ans="";
        for (int i=0; i<=Math.log(ua)/Math.log(2); i++) {
            if ((ua>>i & 1) == 1) if (fx==0) ans+="E"; else ans+="W";
            if (((ua-a)>>i & 1) == 1) if (fx==0) ans+="W"; else ans+="E";
            if ((ub>>i & 1) == 1) if (fy==0) ans+="N"; else ans+="S";
            if (((ub-b)>>i & 1) == 1) if (fy==0) ans+="S"; else ans+="N";
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

