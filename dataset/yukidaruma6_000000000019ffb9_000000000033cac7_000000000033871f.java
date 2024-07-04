import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        final int tnum = sc.nextInt();
        tc: for (int testCase = 1; testCase <= tnum; testCase++) {
            int c = sc.nextInt();
            int d = sc.nextInt();

            int[][] lat = new int[c-1][2];
            for (int i = 0; i < lat.length; i++) {
                lat[i][0] = i + 1;
                lat[i][1] = -1 * sc.nextInt();
            }

            Arrays.sort(lat, (a, b) -> Integer.compare(a[1], b[1]));

            Node[] tree = new Node[c];
            for (int i = 0; i < tree.length; i++) {
                tree[i] = new Node(i);
            }
            tree[0].lat = 0;

            int[][] connect = new int[d][2];
            for (int i = 0; i < d; i++) {
                int u = sc.nextInt() - 1;
                int v = sc.nextInt() - 1;
                connect[i][0] = u;
                connect[i][1] = v;
                tree[u].addNext(v);
                tree[v].addNext(u);
            }

            int curnum = 0;
            int curlat = 0;
            for (int i = 0; i < lat.length; i++) {
                if(lat[i][1] > curnum){
                    curlat++;
                    curnum = lat[i][1];
                }
                tree[lat[i][0]].lat = curlat;
            }

            System.out.print("Case #" + testCase + ":");
            for (int i = 0; i < connect.length; i++) {
                int mlat = Math.abs(tree[connect[i][0]].lat - tree[connect[i][1]].lat);
                if(mlat == 0) mlat = 100000;
                System.out.print(" " + mlat);
            }
            System.out.println("");
        }
    }

    private static void printAns(int testCase, String ans){
        System.out.println("Case #" + testCase + ": " + ans);
    }

    private static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1024];
        private int ptr = 0;
        private int buflen = 0;

        private boolean hasNextByte() {
            if (ptr < buflen) {
                return true;
            } else {
                ptr = 0;
                try {
                    buflen = in.read(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (buflen <= 0) {
                    return false;
                }
            }
            return true;
        }

        private int readByte() {
            if (hasNextByte())
                return buffer[ptr++];
            else
                return -1;
        }

        private static boolean isPrintableChar(int c) {
            return 33 <= c && c <= 126;
        }

        public boolean hasNext() {
            while (hasNextByte() && !isPrintableChar(buffer[ptr]))
                ptr++;
            return hasNextByte();
        }

        public String next() {
            if (!hasNext())
                throw new NoSuchElementException();
            StringBuilder sb = new StringBuilder();
            int b = readByte();
            while (isPrintableChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public long nextLong() {
            if (!hasNext())
                throw new NoSuchElementException();
            long n = 0;
            boolean minus = false;
            int b = readByte();
            if (b == '-') {
                minus = true;
                b = readByte();
            }
            if (b < '0' || '9' < b) {
                throw new NumberFormatException();
            }
            while (true) {
                if ('0' <= b && b <= '9') {
                    n *= 10;
                    n += b - '0';
                } else if (b == -1 || !isPrintableChar(b)) {
                    return minus ? -n : n;
                } else {
                    throw new NumberFormatException();
                }
                b = readByte();
            }
        }

        public int nextInt() {
            long nl = nextLong();
            if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE)
                throw new NumberFormatException();
            return (int) nl;
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }

}

class Node{
    public int id;
    public ArrayList<Integer> next;
    public int lat;

    public Node(int id){
        this.id = id;
        next = new ArrayList<Integer>();
        lat = -1;
    }

    public void addNext(int nextId){
        next.add(nextId);
    }
}