import java.io.*;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Solution {
    class Solver {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n_x = in.readInt();
            int n_y = in.readInt();
            String path = in.readString();
            int[] x = new int[path.length() + 1];
            int[] y = new int[path.length() + 1];
            x[0] = n_x;
            y[0] = n_y;
            for (int i = 0; i < path.length(); i++) {
                if (path.charAt(i) == 'S') {
                    y[i + 1] = y[i] -1;
                    x[i + 1] = x[i];
                }
                if (path.charAt(i) == 'N') {
                    y[i + 1] = y[i] + 1;
                    x[i + 1] = x[i];
                }
                if (path.charAt(i) == 'W') {
                    y[i + 1] = y[i];
                    x[i + 1] = x[i] -1;
                }
                if (path.charAt(i) == 'E') {
                    y[i + 1] = y[i];
                    x[i + 1] = x[i] + 1;
                }
            }
            for (int i = 0; i < x.length; i++) {
                int t = Math.abs(x[i]) + Math.abs(y[i]);
                if (t <= i) {
                    out.printLine(String.format("Case #%d: %s", testNumber, i));
                    return;
                }
            }
            out.printLine(String.format("Case #%d: %s", testNumber, "IMPOSSIBLE"));
        }
    }

    public static void main(String[] args) {
        Solution t = new Solution();
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        try {
            if (IS_LOCAL) {
                String packagePath = ROOT + t.getClass().getCanonicalName().replace("." + t.getClass().getSimpleName(), "")
                        .replace(".", "/");
                String inputFileName = packagePath + "/" + INPUT;
                String outputFileName = packagePath + "/" + OUTPUT;

                File inputFile = new File(inputFileName);
                inputStream = new FileInputStream(inputFile);
                Logger.printfln("Reading from file: %s", inputFile.getAbsolutePath());

                File outputFile = new File(outputFileName);
                outputStream = new FileOutputStream(outputFile, false);
                Logger.printfln("Writing to file: %s", outputFile.getAbsolutePath());
            } else {
                Logger.println("Reading stdin and writing to stdout");
            }
        } catch (IOException e) {
            Logger.println(e.toString());
            Logger.println("Reading stdin and writing to stdout");
        }

        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        Solution solution = new Solution();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++) {
            Logger.printf("\nTest #%d: ", i);
            long start = System.currentTimeMillis();
            solution.new Solver().solve(i, in, out);
            Logger.println(System.currentTimeMillis() - start + "ms");
        }
        out.close();
    }

    public static final boolean IS_LOCAL = false;
    public static String ROOT = "/home/lorderot/projects/algo_problems/src/main/java/";
    public static String INPUT = "input.txt";
    public static String OUTPUT = "output.txt";
}

class IOUtils {
    public static int[] readIntArray(InputReader in, int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++)
            array[i] = in.readInt();
        return array;
    }

    public static long[] readLongArray(InputReader in, int size) {
        long[] array = new long[size];
        for (int i = 0; i < size; i++)
            array[i] = in.readLong();
        return array;
    }

    public static int[][] readIntTable(InputReader in, int rowCount, int columnCount) {
        int[][] table = new int[rowCount][];
        for (int i = 0; i < rowCount; i++)
            table[i] = readIntArray(in, columnCount);
        return table;
    }

    public static BigInteger[] readBigInt(InputReader in, int size) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(in.stream)));
        BigInteger[] arr = new BigInteger[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextBigInteger();
        }
        return arr;
    }

    public static double[] readDoubleArray(InputReader in, int size) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(in.stream)));
        double[] arr = new double[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextDouble();
        }
        return arr;
    }
}

class Pair<U, V> implements Comparable<Pair<U, V>> {
    public final U first;
    public final V second;

    public static <U, V> Pair<U, V> makePair(U first, V second) {
        return new Pair<U, V>(first, second);
    }

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        return !(first != null ? !first.equals(pair.first) : pair.first != null) && !(second != null ? !second.equals(pair.second) : pair.second != null);

    }

    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (second != null ? second.hashCode() : 0);
        return result;
    }

    public String toString() {
        return "(" + first + "," + second + ")";
    }

    public int compareTo(Pair<U, V> o) {
        int value = ((Comparable<U>) first).compareTo(o.first);
        if (value != 0)
            return value;
        return ((Comparable<V>) second).compareTo(o.second);
    }
}

class MiscUtils {
    public static final int[] DX4 = {1, 0, -1, 0};
    public static final int[] DY4 = {0, -1, 0, 1};

}

class GeometryUtils {
    public static double epsilon = 1e-8;

}


class InputReader {

    InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
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

    public int readInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public long readLong() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public String readString() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuffer res = new StringBuffer();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    public static boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public String next() {
        return readString();
    }
}

class OutputWriter {
    private final PrintWriter writer;

    public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public OutputWriter(Writer writer) {
        this.writer = new PrintWriter(writer);
    }

    public void print(Object... objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0)
                writer.print(' ');
            writer.print(objects[i]);
        }
    }

    public void printLine(Object... objects) {
        print(objects);
        writer.println();
    }

    public void close() {
        writer.close();
    }

}

class Logger {

    public static void println(Object o) {
        if (!Solution.IS_LOCAL) {
            return;
        }
        System.err.println(o);
    }

    public static void print(Object o) {
        if (!Solution.IS_LOCAL) {
            return;
        }
        System.err.print(o);
    }

    public static void printf(String s, Object... objects) {
        if (!Solution.IS_LOCAL) {
            return;
        }
        System.err.printf(s, objects);
    }

    public static void printfln(String s, Object... objects) {
        if (!Solution.IS_LOCAL) {
            return;
        }
        System.err.println(String.format(s, objects));
    }
}
