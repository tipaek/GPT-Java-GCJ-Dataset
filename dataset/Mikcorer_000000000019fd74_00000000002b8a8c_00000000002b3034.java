import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        new Solution().go();
    }

    PrintWriter out;
    Reader in;
    BufferedReader br;

    Solution() throws IOException {

        try {

            //br = new BufferedReader( new FileReader("input.txt") );
            //in = new Reader("input.txt");
            in = new Reader("input.txt");
            out = new PrintWriter( new BufferedWriter(new FileWriter("output.txt")) );
        }
        catch (Exception e) {

            //br = new BufferedReader( new InputStreamReader( System.in ) );
            in = new Reader();
            out = new PrintWriter( new BufferedWriter(new OutputStreamWriter(System.out)) );
        }
    }

    void go() throws Exception {

        int t = in.nextInt();
        int c = 1;
        //int t = 1;
        while (t > 0) {
            out.print("Case #" + c + ": ");
            c++;
            solve();
            t--;
        }

        out.flush();
        out.close();
    }


    int inf = 2000000000;
    int mod = 1000000007;
    double eps = 0.000000001;

    int n;
    int m;

    void solve() throws IOException {

        int n = in.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            a[i] = s;
        }

        StringBuilder ans = new StringBuilder();

        String pref = "";
        String suf = "";

        for (int i = 0; i < n; i++) {
            int pos = 0;
            String s = a[i];
            while (s.charAt(pos) != '*') pos++;
            if (pos > 0 && pos > pref.length()) pref = s.substring(0, pos);

            pos = s.length() - 1;
            while (s.charAt(pos) != '*') pos--;
            if (pos < s.length() - 1 && s.length() - pos - 1 > suf.length()) suf = s.substring(pos + 1);
        }

        //System.err.println(pref + " " + suf);

        boolean ok = true;
        for (int i = 0; i < n; i++) {
            String s = a[i];
            int pos = 0;
            int len = s.length();
            while (s.charAt(pos) != '*') {
                ok &= pref.charAt(pos) == s.charAt(pos);
                pos++;
            }

            pos = len - 1;
            int sufPos = suf.length() - 1;
            while (s.charAt(pos) != '*') {
                ok &= suf.charAt(sufPos) == s.charAt(pos);
                pos--;
                sufPos--;
            }
        }

        if (ok) {
            out.println(pref + suf);
        } else {
            out.println("*");
        }
    }

    class Pair implements Comparable<Pair> {

        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int compareTo(Pair p) {
            if (a != p.a)
                return Integer.compare(a, p.a);
            else
                return Integer.compare(b, p.b);
        }
    }

    class Item {

        int a;
        int b;
        int c;

        Item(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

    }


    class Reader {

        BufferedReader  br;
        StringTokenizer tok;

        Reader(String file) throws IOException {
            br = new BufferedReader( new FileReader(file) );
        }

        Reader() throws IOException {
            br = new BufferedReader( new InputStreamReader(System.in) );
        }

        String next() throws IOException {

            while (tok == null || !tok.hasMoreElements())
                tok = new StringTokenizer(br.readLine());
            return tok.nextToken();
        }

        int nextInt() throws NumberFormatException, IOException {
            return Integer.valueOf(next());
        }

        long nextLong() throws NumberFormatException, IOException {
            return Long.valueOf(next());
        }

        double nextDouble() throws NumberFormatException, IOException {
            return Double.valueOf(next());
        }


        String nextLine() throws IOException {
            return br.readLine();
        }

    }

    static class InputReader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public InputReader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public InputReader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }

}