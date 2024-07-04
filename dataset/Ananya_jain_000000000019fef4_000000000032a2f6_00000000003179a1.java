import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.Vector;
import java.util.stream.Collectors;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.pow;
import static java.lang.Math.abs;
import static java.util.Arrays.sort;
import static java.util.Arrays.parallelSort;
import static java.util.Arrays.binarySearch;

public class cf {
    static final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static final int mod = (int) (1e9 + 7);
    static final int modfft = 998244353;
    static final Reader r = new Reader();
    static final PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    int[] level, p;
    Vector<Integer>[] adj;

    public static void main(final String[] args) throws Exception {
        final int testcases = hasTestCases ? ni() : 1;
        for (int i = 0; i < testcases; i++) {
            out.print("Case #" + (i + 1) + ": ");
            final long an = new cf().solve();
            if (hasPrint)
                if (hasBooleanPrint)
                    out.println(an == 0 ? "no" : "yes");
                else
                    out.println(an);
        }
        out.flush();
    }

    static final boolean hasTestCases = true, fastIO = false;
    static final boolean hasPrint = false, hasBooleanPrint = false;
    static final int lineLength = 1000002;

    private long solve() throws Exception {
        int u = ni();
        int[] f=new int[10];
        char[] c=new char[10];
        String[] ini=new String[10000];
        int[] inii=new int[10000];
        String[] inj=new String[10000];
        Arrays.fill(c, 'q');
        Arrays.fill(f, 10);
        for (int i = 0; i < 10000; i++) {
            int y = ni();
            String m = nln().trim();
            ini[i]=m;
            String n=Integer.toString(y);
            inj[i]=n;
            if (y==-1) {
                continue;
            }    
            if (n.length()>m.length()) {
                continue;
            }
            int ii=0;
            char ch;
            for (int jj = 0; jj < m.length(); jj++) {
                ch=m.charAt(jj);
                int j=0;
                while (c[j]!='q'&&c[j]!=ch) {
                    j++;
                }
                if(c[j]=='q')
                    c[j]=ch;
            }
            ch=m.charAt(ii);
                int j=0;
                while (c[j]!='q'&&c[j]!=ch) {
                    j++;
                }
                if(c[j]=='q')
                    c[j]=ch;
                f[j]=min(f[j],n.charAt(0)-'0');

        }                   
        int mi=0;
        for (int i = 0; i < c.length; i++) {
            if(f[i]==10) {f[i]=mi;
            mi++;}
        }
        for (int i = 0; i < c.length; i++) {
            int min = 100,mini=-1;
            for (int j = 0; j < c.length; j++) {
                if (min>f[j]) {
                    min=f[j];
                    mini=j;
                }
            }
            p(c[mini]);
            f[mini]=10000;
        }
        
        return 1;
    }

    static int gcd(final int a, final int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static String n() throws Exception {
        return fastIO ? r.next() : in.next();
    }

    static int[] na(final int n) throws Exception {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = ni();
        }
        return a;
    }

    static String nln() throws Exception {
        return fastIO ? r.readLine() : in.nextLine();
    }

    static int ni() throws Exception {
        return fastIO ? r.nextInt() : in.nextInt();
    }

    static long nl() throws Exception {
        return fastIO ? r.nextLong() : in.nextLong();
    }

    static double nd() throws Exception {
        return fastIO ? r.nextDouble() : in.nextDouble();
    }

    static void p(final Object o) {
        out.print(o);
    }

    static void pn(final Object o) {
        out.println(o);
    }

    static void pn() {
        out.println("");
    }

    static void pni(final Object o) {
        out.println(o);
        out.flush();
    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 19;
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

        public Reader(final String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            br = new BufferedReader(new FileReader(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String next() throws Exception {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (final IOException e) {
                    throw new Exception(e.toString());
                }
            }
            return st.nextToken();
        }

        public String nextLine() throws Exception {
            String str = "";
            try {
                str = br.readLine();
            } catch (final IOException e) {
                throw new Exception(e.toString());
            }
            return str;
        }

        static final byte[] buf = new byte[lineLength];

        public String readLine() throws IOException {
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            final boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            final boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            final boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }

}