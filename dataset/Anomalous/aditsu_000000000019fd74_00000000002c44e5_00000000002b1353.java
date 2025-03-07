import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

class Solution {
    public void solve(final DataReader dr, final PrintWriter pw) {
        final int n = dr.nextInt();
        if (n < 32) {
            for (int i = 0; i < n; ++i) {
                pw.println((i + 1) + " 1");
            }
            return;
        }
        final int n1 = n - 31;
        boolean left = true;
        int t = 0;
        for (int i = 0; i < 31; ++i) {
            final int x = 1 << i;
            if ((n1 & x) == 0) {
                pw.println((i + 1) + " " + (left ? 1 : i + 1));
                t++;
            } else {
                for (int j = 0; j <= i; ++j) {
                    pw.println((i + 1) + " " + (left ? j + 1 : i - j + 1));
                }
                t += x;
                left = !left;
            }
        }
        int i = 31;
        while (t < n) {
            pw.println((i + 1) + " " + (left ? 1 : i + 1));
            t++;
            i++;
        }
    }

    public static void main(final String... args) {
        final DataReader dr = new DataReader();
        try (final PrintWriter pw = new PrintWriter(System.out)) {
            final int t = dr.nextInt();
            dr.nextLine();

            for (int i = 1; i <= t; ++i) {
                pw.println("Case #" + i + ":");
                new Solution().solve(dr, pw);
                System.gc();
            }
        }
    }

    static class DataReader {
        private final Supplier<String> sup;
        private String line;
        private int n;
        private int k;
        private boolean started;

        public DataReader(final Supplier<String> sup) {
            this.sup = sup;
        }

        public DataReader(final BufferedReader br) {
            this(() -> {
                try {
                    return br.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        public DataReader(final InputStream is) {
            this(new BufferedReader(new InputStreamReader(is)));
        }

        public DataReader(final File f) {
            this(() -> {
                try {
                    return new BufferedReader(new InputStreamReader(new FileInputStream(f))).readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        public DataReader() {
            this(System.in);
        }

        public static DataReader file(final String fname) {
            return new DataReader(new File(fname));
        }

        private void read() {
            line = sup.get();
            n = line == null ? -1 : line.length();
            k = 0;
        }

        public String next() {
            while (true) {
                if (line == null) {
                    if (started) {
                        throw new NoSuchElementException();
                    }
                    started = true;
                    read();
                    continue;
                }
                while (k < n && line.charAt(k) == ' ') {
                    k++;
                }
                if (k < n) {
                    break;
                }
                read();
            }
            final int old = k;
            while (k < n && line.charAt(k) != ' ') {
                k++;
            }
            return line.substring(old, k);
        }

        public String nextLine() {
            if (line == null) {
                if (started) {
                    throw new NoSuchElementException();
                }
                started = true;
                read();
                if (line == null) {
                    throw new NoSuchElementException();
                }
            }
            final String s = k == 0 ? line : line.substring(k);
            read();
            return s;
        }

        public boolean hasNextLine() {
            if (line != null) {
                return true;
            }
            if (started) {
                return false;
            }
            started = true;
            read();
            return line != null;
        }

        public List<String> allLines() {
            final List<String> l = new ArrayList<>();
            while (hasNextLine()) {
                l.add(nextLine());
            }
            return l;
        }

        public String[] lineArray(final int n) {
            final String[] a = new String[n];
            for (int i = 0; i < n; ++i) {
                a[i] = nextLine();
            }
            return a;
        }

        public List<String> lineList(final int n) {
            final List<String> l = new ArrayList<>(n);
            for (int i = 0; i < n; ++i) {
                l.add(nextLine());
            }
            return l;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public static int[] parseIntArray(final String s, final String sep) {
            final String[] a = s.split(sep);
            final int n = a.length;
            final int[] b = new int[n];
            for (int i = 0; i < n; ++i) {
                b[i] = Integer.parseInt(a[i]);
            }
            return b;
        }

        public static int[] parseIntArray(final String s) {
            return parseIntArray(s, " ");
        }

        public int[] intArray(final String sep) {
            return parseIntArray(nextLine(), sep);
        }

        public int[] intArray() {
            return intArray(" ");
        }

        public static long[] parseLongArray(final String s, final String sep) {
            final String[] a = s.split(sep);
            final int n = a.length;
            final long[] b = new long[n];
            for (int i = 0; i < n; ++i) {
                b[i] = Long.parseLong(a[i]);
            }
            return b;
        }

        public static long[] parseLongArray(final String s) {
            return parseLongArray(s, " ");
        }

        public long[] longArray(final String sep) {
            return parseLongArray(nextLine(), sep);
        }

        public long[] longArray() {
            return longArray(" ");
        }

        public void read(final int[] a) {
            for (int i = 0; i < a.length; ++i) {
                a[i] = nextInt();
            }
        }

        public int[][] intArray2(final int rows, final String sep) {
            final int[][] a = new int[rows][];
            for (int i = 0; i < rows; ++i) {
                a[i] = intArray(sep);
            }
            return a;
        }

        public int[][] intArray2(final int rows) {
            return intArray2(rows, " ");
        }

        public static <T> List<T> parseList(final String s, final String sep, final Function<String, T> f) {
            final String[] a = s.split(sep);
            final int n = a.length;
            final List<T> l = new ArrayList<>(n);
            for (int i = 0; i < n; ++i) {
                l.add(f.apply(a[i]));
            }
            return l;
        }

        public static List<Integer> parseIntList(final String s, final String sep) {
            return parseList(s, sep, Integer::parseInt);
        }

        public static List<Integer> parseIntList(final String s) {
            return parseIntList(s, " ");
        }

        public <T> List<T> list(final String sep, final Function<String, T> f) {
            return parseList(nextLine(), sep, f);
        }

        public List<Integer> intList(final String sep) {
            return list(sep, Integer::parseInt);
        }

        public List<Integer> intList() {
            return intList(" ");
        }
    }
}