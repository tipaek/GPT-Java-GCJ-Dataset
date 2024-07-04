import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.pow;
import static java.util.Arrays.sort;

class Solution {
    static final Scanner sc = new Scanner(System.in);
    static final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static final int mod = (int) (1e9 + 7);
    static final Reader r = new Reader();
    static final PrintWriter out = new PrintWriter(System.out);
    static int[][] p = new int[500 + 2][500 + 2];

    private static void goku(int[][] p) {
        p[1][1] = 1;
        for (int i = 2; i < 501; i++) {
            for (int j = 1; j <= i; j++) {
                p[i][j] = p[i - 1][j - 1] + p[i - 1][j];
            }
        }
    }

    public static void main(final String[] args) throws IOException 
    {
        int testcases = in.nextInt();
        goku(p);
        for (int i = 0; i < testcases; i++) {
            out.println("Case #" + (i + 1) + ": ");
            long an = extracted(p);
        }
        out.flush();
        out.close();
        sc.close();
    }

    private static long extracted(int[][] p) throws IOException 
    {
        int[][] saxena = new int[500 + 2][500 + 2];
        int n = in.nextInt();
        long s = 0;
        ArrayList<Integer> alr = new ArrayList<>();
        ArrayList<Integer> alc = new ArrayList<>();
        found = false;
        b = false;
        c = false;
        aman(p, saxena, alr, alc, s, n, 1, 1);
        for (int i = 0; i < alr.size(); i++) {
            out.println(alr.get(i) + " " + alc.get(i));
        }

        return 1;
    }

    static boolean found = false, b = false, c = false;

    private static void aman(int[][] p, int[][] saxena, ArrayList<Integer> alr, ArrayList<Integer> alc, long s,
            int n, int i, int j) {
        if (s == n || found) {
            found = true;
            return;
        }
        if (saxena[i][j] == 1 || p[i][j] == 0) {
            return;
        }
        if (s > n || alr.size() > 500) {
            return;
        }
        saxena[i][j] = 1;
        s += p[i][j];
        alr.add(i);
        alc.add(j);
        if (s == n) {
            found = true;
            return;
        }
        if (!b && !found) {
            if (i % 2 == 1) {
                aman(p, saxena, alr, alc, s , n, i + 1, j);
            } else
                aman(p, saxena, alr, alc, s , n, i + 1, j + 1);
        }
        if (!found) {
            if (!c) {
                
                aman(p, saxena, alr, alc, s , n, i, j + 1);
                aman(p, saxena, alr, alc, s , n, i + 1, j + 1);
                aman(p, saxena, alr, alc, s , n, i - 1, j - 1);
                

            } 
        }
        if (!found) {
            alr.remove(alr.size() - 1);
            alc.remove(alc.size() - 1);
        }
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
            final byte[] buf = new byte[64]; 
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