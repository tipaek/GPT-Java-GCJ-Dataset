import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.function.*;

class Solution {

    private static BigInteger sumN(BigInteger n) {
        return n.multiply(n.add(BigInteger.ONE)).shiftRight(1);
    }

    public void solve(DataReader dr, PrintWriter pw) {
        BigInteger l = dr.nextBig();
        BigInteger r = dr.nextBig();
        boolean lbig = l.compareTo(r) >= 0;

        BinarySearchDiscrete<BigInteger> bs = new BinarySearchDiscrete<>(new BigIntAlgebra());
        BigInteger dif = l.subtract(r).abs();
        Predicate<BigInteger> p = x -> sumN(x).compareTo(dif) <= 0;
        BigInteger max = bs.findUpperBound(BigInteger.ZERO, p);
        BigInteger a = bs.findLast(BigInteger.ZERO, max, p);

        if (lbig) {
            l = l.subtract(sumN(a));
        } else {
            r = r.subtract(sumN(a));
        }
        lbig = l.compareTo(r) >= 0;
        if (!lbig) {
            BigInteger t = l;
            l = r;
            r = t;
        }
        BigInteger l1 = l;
        BigInteger r1 = r;
        Predicate<BigInteger> p2 = x -> {
            BigInteger t = x.multiply(x.add(a).add(BigInteger.ONE));
            return t.subtract(x).compareTo(l1) <= 0 && t.compareTo(r1) <= 0;
        };
        max = bs.findUpperBound(BigInteger.ZERO, p2);
        BigInteger k = bs.findLast(BigInteger.ZERO, max, p2);
        BigInteger t1 = k.multiply(k.add(a).add(BigInteger.ONE));
        l = l.subtract(t1.subtract(k));
        r = r.subtract(t1);
        BigInteger n = a.add(k.shiftLeft(1));
        if (n.compareTo(l) < 0) {
            n = n.add(BigInteger.ONE);
            l = l.subtract(n);
        }
        if (!lbig) {
            BigInteger t = l;
            l = r;
            r = t;
        }
        pw.println(n + " " + l + " " + r);
    }

    public static void main(String... args) {
        DataReader dr = new DataReader();
        try (PrintWriter pw = new PrintWriter(System.out)) {
            int t = dr.nextInt();
            dr.nextLine();

            for (int i = 1; i <= t; ++i) {
                pw.print("Case #" + i + ": ");
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

        public DataReader(Supplier<String> sup) {
            this.sup = sup;
        }

        public DataReader(BufferedReader br) {
            this(() -> {
                try {
                    return br.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        public DataReader(InputStream is) {
            this(new BufferedReader(new InputStreamReader(is)));
        }

        public DataReader(File f) {
            this(fileStream(f));
        }

        public DataReader() {
            this(System.in);
        }

        private static InputStream fileStream(File f) {
            try {
                return new FileInputStream(f);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
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
            int old = k;
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
            String s = k == 0 ? line : line.substring(k);
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
            List<String> l = new ArrayList<>();
            while (hasNextLine()) {
                l.add(nextLine());
            }
            return l;
        }

        public String[] lineArray(int n) {
            String[] a = new String[n];
            for (int i = 0; i < n; ++i) {
                a[i] = nextLine();
            }
            return a;
        }

        public List<String> lineList(int n) {
            List<String> l = new ArrayList<>(n);
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

        public BigInteger nextBig() {
            return new BigInteger(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public static int[] parseIntArray(String s, String sep) {
            String[] a = s.split(sep);
            int n = a.length;
            int[] b = new int[n];
            for (int i = 0; i < n; ++i) {
                b[i] = Integer.parseInt(a[i]);
            }
            return b;
        }

        public static int[] parseIntArray(String s) {
            return parseIntArray(s, " ");
        }

        public int[] intArray(String sep) {
            return parseIntArray(nextLine(), sep);
        }

        public int[] intArray() {
            return intArray(" ");
        }

        public static long[] parseLongArray(String s, String sep) {
            String[] a = s.split(sep);
            int n = a.length;
            long[] b = new long[n];
            for (int i = 0; i < n; ++i) {
                b[i] = Long.parseLong(a[i]);
            }
            return b;
        }

        public static long[] parseLongArray(String s) {
            return parseLongArray(s, " ");
        }

        public long[] longArray(String sep) {
            return parseLongArray(nextLine(), sep);
        }

        public long[] longArray() {
            return longArray(" ");
        }

        public void read(int[] a) {
            for (int i = 0; i < a.length; ++i) {
                a[i] = nextInt();
            }
        }

        public int[][] intArray2(int rows, String sep) {
            int[][] a = new int[rows][];
            for (int i = 0; i < rows; ++i) {
                a[i] = intArray(sep);
            }
            return a;
        }

        public int[][] intArray2(int rows) {
            return intArray2(rows, " ");
        }

        public static <T> List<T> parseList(String s, String sep, Function<String, T> f) {
            String[] a = s.split(sep);
            int n = a.length;
            List<T> l = new ArrayList<>(n);
            for (String value : a) {
                l.add(f.apply(value));
            }
            return l;
        }

        public static List<Integer> parseIntList(String s, String sep) {
            return parseList(s, sep, Integer::parseInt);
        }

        public static List<Integer> parseIntList(String s) {
            return parseIntList(s, " ");
        }

        public <T> List<T> list(String sep, Function<String, T> f) {
            return parseList(nextLine(), sep, f);
        }

        public List<Integer> intList(String sep) {
            return list(sep, Integer::parseInt);
        }

        public List<Integer> intList() {
            return intList(" ");
        }
    }

    static class BinarySearchDiscrete<T> {
        private final DiscreteSearchableAlgebra<T> alg;

        public BinarySearchDiscrete(DiscreteSearchableAlgebra<T> alg) {
            this.alg = alg;
        }

        public T findFirst(T min, T max, Predicate<T> p) {
            if (p.test(min)) {
                return min;
            }
            if (!p.test(max)) {
                return null;
            }
            T x = min;
            T y = max;
            while (true) {
                T h = alg.mid(x, y);
                if (p.test(h)) {
                    if (y.equals(h)) {
                        break;
                    }
                    y = h;
                } else {
                    if (x.equals(h)) {
                        break;
                    }
                    x = h;
                }
            }
            return y;
        }

        public T findLast(T min, T max, Predicate<T> p) {
            if (p.test(max)) {
                return max;
            }
            if (!p.test(min)) {
                return null;
            }
            T x = min;
            T y = max;
            while (true) {
                T h = alg.mid(x, y);
                if (p.test(h)) {
                    if (x.equals(h)) {
                        break;
                    }
                    x = h;
                } else {
                    if (y.equals(h)) {
                        break;
                    }
                    y = h;
                }
            }
            return x;
        }

        public T find(T min, T max, Predicate<T> p) {
            boolean t = p.test(min);
            if (t == p.test(max)) {
                return null;
            }
            return t ? findLast(min, max, p) : findFirst(min, max, p);
        }

        public T find0(T min, T max, Function<T, T> f) {
            T zero = alg.getZero();
            int x = alg.compare(f.apply(min), zero);
            if (x * alg.compare(f.apply(max), zero) > 0) {
                return null;
            }
            Predicate<T> p = x < 0 ? y -> alg.compare(f.apply(y), zero) >= 0
                    : y -> alg.compare(f.apply(y), zero) <= 0;
            return findFirst(min, max, p);
        }

        public T findUpperBound(T min, Predicate<T> p) {
            boolean b = p.test(min);
            T d = alg.getOne();
            while (true) {
                T max = alg.add(min, d);
                if (p.test(max) != b) {
                    return max;
                }
                d = alg.dbl(d);
            }
        }
    }

    interface DiscreteSearchableAlgebra<T> extends DiscreteAlgebra<T>, SearchableAlgebra<T> {
    }

    interface SearchableAlgebra<T> extends Algebra<T> {
        T mid(T x, T y);
        T getOne();
        T dbl(T x);
    }

    interface Algebra<T> {
        T getZero();
        boolean isZero(T x);
        int compare(T x, T y);
        T add(T x, T y);

        default T min(T x, T y) {
            return compare(x, y) < 0 ? x : y;
        }

        default T max(T x, T y) {
            return compare(x, y) > 0 ? x : y;
        }

        default boolean isDiscrete() {
            return false;
        }
    }

    interface DiscreteAlgebra<T> extends Algebra<T> {
        @Override
        default boolean isDiscrete() {
            return true;
        }

        T next(T x);
        T prev(T x);
    }

    static class BigIntAlgebra implements CompAlgebra<BigInteger>, DiscreteSearchableAlgebra<BigInteger>,
            ModuloAlgebra<BigInteger>, DiscreteArithAlgebra<BigInteger> {
        @Override
        public BigInteger getZero() {
            return BigInteger.ZERO;
        }

        @Override
        public boolean isZero(BigInteger x) {
            return x.signum() == 0;
        }

        @Override
        public BigInteger getOne() {
            return BigInteger.ONE;
        }

        @Override
        public BigInteger add(BigInteger x, BigInteger y) {
            return x.add(y);
        }

        @Override
        public BigInteger subtract(BigInteger x, BigInteger y) {
            return x.subtract(y);
        }

        @Override
        public BigInteger mid(BigInteger x, BigInteger y) {
            return x.add(y).shiftRight(1);
        }

        @Override
        public BigInteger dbl(BigInteger x) {
            return x.shiftLeft(1);
        }

        @Override
        public BigInteger multiply(BigInteger x, BigInteger y) {
            return x.multiply(y);
        }

        @Override
        public BigInteger divide(BigInteger x, BigInteger y) {
            return x.divide(y);
        }

        @Override
        public BigInteger floorDiv(BigInteger x, BigInteger y) {
            if (x.signum() * y.signum() >= 0) {
                return x.divide(y);
            }
            BigInteger[] qr = x.divideAndRemainder(y);
            return qr[1].signum() == 0 ? qr[0] : qr[0].subtract(BigInteger.ONE);
        }

        @Override
        public BigInteger roundDiv(BigInteger x, BigInteger y, Rounding r, boolean symmetric) {
            if (y.signum() < 0) {
                return roundDiv(x.negate(), y.negate(), r, symmetric);
            }
            if (x.signum() < 0 && symmetric) {
                return roundDiv(x.negate(), y, r, symmetric).negate();
            }
            BigInteger[] a = x.divideAndRemainder(y);
            if (a[1].signum() == 0) {
                return a[0];
            }
            if (a[1].signum() < 0) {
                switch (r) {
                    case DOWN:
                        return a[0].subtract(BigInteger.ONE);
                    case UP:
                        return a[0];
                    case HALF_UP:
                        return a[1].negate().shiftLeft(1).compareTo(y) >= 0 ? a[0] : a[0].subtract(BigInteger.ONE);
                    default:
                        throw new RuntimeException(r + " not handled");
                }
            }
            switch (r) {
                case DOWN:
                    return a[0];
                case UP:
                    return a[0].add(BigInteger.ONE);
                case HALF_UP:
                    return a[1].shiftLeft(1).compareTo(y) >= 0 ? a[0].add(BigInteger.ONE) : a[0];
                default:
                    throw new RuntimeException(r + " not handled");
            }
        }

        @Override
        public BigInteger mod(BigInteger x, BigInteger y) {
            return x.remainder(y);
        }

        @Override
        public BigInteger floorMod(BigInteger x, BigInteger y) {
            if (x.signum() * y.signum() >= 0) {
                return x.remainder(y);
            }
            BigInteger[] qr = x.divideAndRemainder(y);
            return qr[1].signum() == 0 ? qr[1] : qr[1].add(y);
        }

        @Override
        public BigInteger[] divMod(BigInteger x, BigInteger y) {
            return x.divideAndRemainder(y);
        }

        @Override
        public BigInteger[] floorDivMod(BigInteger x, BigInteger y) {
            BigInteger[] qr = x.divideAndRemainder(y);
            if (x.signum() * y.signum() >= 0 || qr[1].signum() == 0) {
                return qr;
            }
            qr[0] = qr[0].subtract(BigInteger.ONE);
            qr[1] = qr[1].add(y);
            return qr;
        }

        @Override
        public BigInteger negate(BigInteger x) {
            return x.negate();
        }

        @Override
        public BigInteger[] makeArray(int n) {
            return new BigInteger[n];
        }

        @Override
        public BigInteger abs(BigInteger x) {
            return x.abs();
        }

        @Override
        public int signum(BigInteger x) {
            return x.signum();
        }

        @Override
        public BigInteger inc(BigInteger x) {
            return x.add(BigInteger.ONE);
        }

        @Override
        public BigInteger dec(BigInteger x) {
            return x.subtract(BigInteger.ONE);
        }

        @Override
        public BigInteger valueOf(int x) {
            return BigInteger.valueOf(x);
        }

        @Override
        public boolean hasInverses() {
            return false;
        }
    }

    interface ModuloAlgebra<T> extends NegativeAlgebra<T> {
        T mod(T x, T y);
        T[] divMod(T x, T y);
        T floorMod(T x, T y);
        T[] floorDivMod(T x, T y);
    }

    interface NegativeAlgebra<T> extends ArithAlgebra<T> {
        T abs(T x);
        int signum(T x);
    }

    interface ArithAlgebra<T> extends Algebra<T> {
        T getOne();
        T subtract(T x, T y);
        T multiply(T x, T y);
        T divide(T x, T y);
        T floorDiv(T x, T y);
        T roundDiv(T x, T y, Rounding r, boolean symmetric);
        T negate(T x);
        T[] makeArray(int n);
        T inc(T x);
        T dec(T x);
        T valueOf(int x);
        boolean hasInverses();
    }

    enum Rounding {
        DOWN, UP, HALF_UP;
    }

    interface CompAlgebra<T extends Comparable<T>> extends Algebra<T> {
        @Override
        default int compare(T x, T y) {
            return x.compareTo(y);
        }
    }

    interface DiscreteArithAlgebra<T> extends ArithAlgebra<T>, DiscreteAlgebra<T> {
        @Override
        default T next(T x) {
            return inc(x);
        }

        @Override
        default T prev(T x) {
            return dec(x);
        }
    }
}