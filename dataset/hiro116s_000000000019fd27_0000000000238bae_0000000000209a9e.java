import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Arrays;
import java.io.IOException;
import java.util.Set;
import java.io.InputStream;
import java.io.FileInputStream;
import java.util.HashSet;

public class Solution {
    InputStream is;

    int __t__ = 1;
    int __f__ = 0;
    int __FILE_DEBUG_FLAG__ = __f__;
    String __DEBUG_FILE_NAME__ = "src/C1";

    FastScanner in;
    PrintWriter out;

    class Bits {
        final int[] a;

        public Bits(int[] a) {
            this.a = a;
        }

        private Bits complement() {
            int n = a.length;
            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                res[i] = a[i] == -1 ? -1 : a[i] ^ 1;
            }
            return new Bits(res);
        }

        private Bits reverse() {
            int n = a.length;
            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                res[i] = a[n-i-1];
            }
            return new Bits(res);
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Bits bits = (Bits) o;
            return Arrays.equals(a, bits.a);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(a);
        }

        @Override
        public String toString() {
            return Arrays.toString(a);
        }

        public String toAnswer() {
            String res = "";
            for (int i = 0; i < a.length; i++) {
                res += a[i];
            }
            return res;
        }

        public int countRevealed() {
            int res = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] != -1) res++;
            }
            return res;
        }
    }

    public void solve() {
        int T = in.nextInt();
        int B = in.nextInt();

        for (int __times = 1; __times <= T; __times++) {
            Set<Bits> res = new HashSet<>();
            int[] initialArray = new int[B];
            Arrays.fill(initialArray, -1);
            for (int i = 1; i <= 5; i++) {
                System.out.println(i);
                initialArray[i - 1] = in.nextInt();
            }
            for (int i = B - 4; i <= B; i++) {
                System.out.println(i);
                initialArray[i - 1] = in.nextInt();
            }
            res.add(new Bits(initialArray));
            main:
            for (int i = 11; i <= 150; i++) {
                if (i % 10 == 1) {
                    if (res.size() != 1) {
                        throw new RuntimeException("?");
                    }
                    Bits bits = res.iterator().next();
                    res.add(bits.reverse());
                    res.add(bits.complement());
                    res.add(bits.reverse().complement());
                }
                if (i % 10 == 1 || i % 10 == 2) {
                    int[][] cnt = new int[B][3];
                    for (Bits bits : res) {
                        for (int j = 0; j < B; j++) {
                            cnt[j][bits.a[j]+1]++;
                        }
                    }
                    int idx = 0;
                    for (int j = 1; j < B; j++) {
                        if (cnt[j][0] > 0) continue;
                        int cur = Math.min(cnt[idx][1], cnt[idx][2]);
                        int next = Math.min(cnt[j][1], cnt[j][2]);
                        if (next > cur) {
                            idx = j;
                        }
                    }
                    System.out.println(idx + 1);
                    int next = in.nextInt();
                    Set<Bits> newRes = new HashSet<>();
                    for (Bits bits : res) {
                        if (bits.a[idx] == next) {
                            newRes.add(bits);
                        }
                    }
                    res = newRes;
                } else if (res.size() == 1) {
                    Bits bits = res.iterator().next();
                    int bcnt = bits.countRevealed();
                    if (bcnt == B) {
                        System.out.println(bits.toAnswer());
                        String s = in.next();
                        if (s.equals("N")) {
                            throw new RuntimeException(bits.toAnswer());
                        } else {
                            System.err.println("Correct answer!: " + bits.toAnswer());
                        }
                        break main;
                    } else if (bcnt % 2 == 0) {
                        for (int j = 0; j < B; j++) {
                            if (bits.a[j] == -1) {
                                System.out.println(j + 1);
                                bits.a[j] = in.nextInt();
                                break;
                            }
                        }
                    } else if (bcnt % 2 == 1) {
                        for (int j = B - 1; j >= 0; j--) {
                            if (bits.a[j] == -1) {
                                System.out.println(j + 1);
                                bits.a[j] = in.nextInt();
                                break;
                            }
                        }
                    } else {
                        throw new RuntimeException("??");
                    }
                } else {
                    throw new RuntimeException("??");
                }
            }
        }
        System.exit(0);
    }

    public void run() {
        if (__FILE_DEBUG_FLAG__ == __t__) {
            try {
                is = new FileInputStream(__DEBUG_FILE_NAME__);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("FILE_INPUT!");
        } else {
            is = System.in;
        }
        in = new FastScanner(is);
        out = new PrintWriter(System.out);

        solve();
    }

    public static void main(final String[] args) {
        new Solution().run();
    }
}


class FastScanner {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;

    public FastScanner(InputStream stream) {
        this.stream = stream;
        // stream = new FileInputStream(new File("dec.in"));
    }

    int read() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public boolean isEndline(int c) {
        return c == '\n' || c == '\r' || c == -1;
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public int[] nextIntArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = nextInt();

        return array;
    }

    public int[][] nextIntMap(int n, int m) {
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = nextIntArray(m);
        }
        return map;
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public long[] nextLongArray(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; i++)
            array[i] = nextLong();

        return array;
    }

    public long[][] nextLongMap(int n, int m) {
        long[][] map = new long[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = nextLongArray(m);
        }
        return map;
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public double[] nextDoubleArray(int n) {
        double[] array = new double[n];
        for (int i = 0; i < n; i++)
            array[i] = nextDouble();

        return array;
    }

    public double[][] nextDoubleMap(int n, int m) {
        double[][] map = new double[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = nextDoubleArray(m);
        }
        return map;
    }

    public String next() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    public String[] nextStringArray(int n) {
        String[] array = new String[n];
        for (int i = 0; i < n; i++)
            array[i] = next();

        return array;
    }

    public String nextLine() {
        int c = read();
        while (isEndline(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isEndline(c));
        return res.toString();
    }

    public int[][] nextPackedIntArrays(int packN, int size) {
        int[][] res = new int[packN][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < packN; j++) {
                res[j][i] = nextInt();
            }
        }
        return res;
    }
}
