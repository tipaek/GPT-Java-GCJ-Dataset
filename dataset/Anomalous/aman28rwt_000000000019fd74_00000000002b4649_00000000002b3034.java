import java.io.*;
import java.util.*;

public class Solution implements Runnable {
    boolean judge = true;
    FastReader scn;
    PrintWriter out;
    String INPUT = "";

    void solve() {
        int T = scn.nextInt();
        for (int tt = 1; tt <= T; tt++) {
            out.print("Case #" + tt + ": ");

            int n = scn.nextInt();
            char[][] arr = new char[n][];
            for (int i = 0; i < n; i++) {
                arr[i] = scn.next().toCharArray();
            }

            if (n == 1) {
                printWithoutAsterisks(arr[0]);
                out.println();
                continue;
            }

            String commonPrefix = "", commonSuffix = "";
            commonPrefix = new String(arr[0]);
            boolean foundMismatch = false;

            for (int j = 1; j < n; j++) {
                String current = new String(arr[j]);
                if (!commonPrefix.equals(current)) {
                    foundMismatch = true;
                    break;
                } else {
                    commonSuffix = "";
                }
            }

            if (!foundMismatch) {
                printWithoutAsterisks(arr[0]);
                out.println();
                continue;
            }

            int i1 = commonPrefix.indexOf('*');
            int i2 = commonPrefix.indexOf('*');

            String s1 = commonPrefix.substring(0, i1), s2 = commonPrefix.substring(i1 + 1);
            String t1 = commonSuffix.substring(0, i2), t2 = commonSuffix.substring(i2 + 1);

            if (!isValidPrefixSuffix(s1, t1) || !isValidPrefixSuffix(s2, t2)) {
                out.println('*');
                continue;
            }

            String a = s1.length() >= t1.length() ? s1 : t1;
            String b = s2.length() >= t2.length() ? s2 : t2;

            boolean ok = checkAllPatterns(n, arr, a, b);
            out.println(ok ? a + b : "*");
        }
    }

    private void printWithoutAsterisks(char[] arr) {
        for (char c : arr) {
            if (c != '*') {
                out.print(c);
            }
        }
    }

    private boolean isValidPrefixSuffix(String s1, String t1) {
        if (s1.length() >= t1.length()) {
            return s1.substring(0, t1.length()).equals(t1);
        } else {
            return t1.substring(0, s1.length()).equals(s1);
        }
    }

    private boolean checkAllPatterns(int n, char[][] arr, String a, String b) {
        for (int i = 0; i < n; i++) {
            String s = new String(arr[i]);
            int j = s.indexOf('*');
            String s1 = s.substring(0, j), s2 = s.substring(j + 1);

            if (!isValidPrefixSuffix(s1, a) || !isValidPrefixSuffix(s2, b)) {
                return false;
            }

            a = s1.length() >= a.length() ? s1 : a;
            b = s2.length() >= b.length() ? s2 : b;
        }
        return true;
    }

    public void run() {
        long time = System.currentTimeMillis();
        boolean oj = System.getProperty("ONLINE_JUDGE") != null || judge;
        out = new PrintWriter(System.out);
        scn = new FastReader(oj);
        solve();
        out.flush();
        if (!oj) {
            System.out.println(Arrays.deepToString(new Object[]{System.currentTimeMillis() - time + " ms"}));
        }
    }

    public static void main(String[] args) {
        new Thread(null, new Solution(), "Main", 1 << 28).start();
    }

    class FastReader {
        InputStream is;

        public FastReader(boolean onlineJudge) {
            is = onlineJudge ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        }

        public FastReader() {
            is = System.in;
        }

        byte[] inbuf = new byte[1024];
        int lenbuf = 0, ptrbuf = 0;

        int readByte() {
            if (lenbuf == -1)
                throw new InputMismatchException();
            if (ptrbuf >= lenbuf) {
                ptrbuf = 0;
                try {
                    lenbuf = is.read(inbuf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (lenbuf <= 0)
                    return -1;
            }
            return inbuf[ptrbuf++];
        }

        boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        int skip() {
            int b;
            while ((b = readByte()) != -1 && isSpaceChar(b))
                ;
            return b;
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        char nextChar() {
            return (char) skip();
        }

        String next() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!(isSpaceChar(b))) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        String nextLine() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while ((!isSpaceChar(b) || b == ' ')) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        char[] next(int n) {
            char[] buf = new char[n];
            int b = skip(), p = 0;
            while (p < n && !(isSpaceChar(b))) {
                buf[p++] = (char) b;
                b = readByte();
            }
            return n == p ? buf : Arrays.copyOf(buf, p);
        }

        int nextInt() {
            int num = 0, b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
                ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }

            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        long nextLong() {
            long num = 0;
            int b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
                ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }

            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        char[][] nextMatrix(int n, int m) {
            char[][] map = new char[n][];
            for (int i = 0; i < n; i++)
                map[i] = next(m);
            return map;
        }

        int[] nextIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long[] nextLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }

        int[][] next2DInt(int n, int m) {
            int[][] arr = new int[n][];
            for (int i = 0; i < n; i++) {
                arr[i] = nextIntArray(m);
            }
            return arr;
        }

        long[][] next2DLong(int n, int m) {
            long[][] arr = new long[n][];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLongArray(m);
            }
            return arr;
        }

        int[] shuffle(int[] arr) {
            Random r = new Random();
            for (int i = 1, j; i < arr.length; i++) {
                j = r.nextInt(i);
                int c = arr[i];
                arr[i] = arr[j];
                arr[j] = c;
            }
            return arr;
        }

        long[] shuffle(long[] arr) {
            Random r = new Random();
            for (int i = 1, j; i < arr.length; i++) {
                j = r.nextInt(i);
                long c = arr[i];
                arr[i] = arr[j];
                arr[j] = c;
            }
            return arr;
        }

        int[] uniq(int[] arr) {
            Arrays.sort(arr);
            int[] rv = new int[arr.length];
            int pos = 0;
            rv[pos++] = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] != arr[i - 1]) {
                    rv[pos++] = arr[i];
                }
            }
            return Arrays.copyOf(rv, pos);
        }

        long[] uniq(long[] arr) {
            Arrays.sort(arr);
            long[] rv = new long[arr.length];
            int pos = 0;
            rv[pos++] = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] != arr[i - 1]) {
                    rv[pos++] = arr[i];
                }
            }
            return Arrays.copyOf(rv, pos);
        }

        int[] reverse(int[] arr) {
            int l = 0, r = arr.length - 1;
            while (l < r) {
                arr[l] = arr[l] ^ arr[r];
                arr[r] = arr[l] ^ arr[r];
                arr[l] = arr[l] ^ arr[r];
                l++;
                r--;
            }
            return arr;
        }

        long[] reverse(long[] arr) {
            int l = 0, r = arr.length - 1;
            while (l < r) {
                arr[l] = arr[l] ^ arr[r];
                arr[r] = arr[l] ^ arr[r];
                arr[l] = arr[l] ^ arr[r];
                l++;
                r--;
            }
            return arr;
        }
    }
}