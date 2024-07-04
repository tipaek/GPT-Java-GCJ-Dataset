import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.pow;
import static java.util.Arrays.sort;

public class Solution {
    static final Scanner sc = new Scanner(System.in);
    static final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static final int mod = (int) (1e9 + 7);
    static final Reader r = new Reader();
    static final PrintWriter out = new PrintWriter(System.out);

    public static void main(final String[] args) throws IOException {
        int testcases = in.nextInt();
        int i = 1;
        while (testcases > 0) {
            out.print("Case #" + i + ": ");
            extracted(testcases);
            --testcases;
            i++;
        }
        out.flush();
        out.close();
        sc.close();
        in.close();
        r.close();
    }

    private static void extracted(int t) throws IOException {
        int n = in.nextInt();
        int[] s = new int[n];
        int[] e = new int[n];
        Jam j[] = new Jam[n];
        for (int i = 0; i < e.length; i++) {
            j[i] = new Jam();
            s[i] = in.nextInt();
            j[i].s = s[i];
            e[i] = in.nextInt();
            j[i].e = e[i];
            j[i].i = i;
        }
        Arrays.sort(j, (j1, j2) -> {
            return j1.s - j2.s != 0 ? j1.s - j2.s : j1.e - j2.e;
        });
        Jam C = null, J = null;
        for (int i = 0; i < j.length; i++) {
            if (C == null || j[i].s >= C.e) {
                j[i].c = 'C';
                C = j[i];
            } else if (J == null || j[i].s >= J.e) {
                j[i].c = 'J';
                J = j[i];
            } else {
                out.println("IMPOSSIBLE");
                return;
            }
        }
        char ch[] = new char[n];
        for (int i = 0; i < j.length; i++) {
            ch[j[i].i] = j[i].c;
        }
        for (char d : ch) {
            out.print(d);
        }
        out.println();
    }

    static class Jam {
        int s, e, i;
        char c;
    }

    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(final String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            final byte[] buf = new byte[64]; // line length
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