import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Set;

public class Solution {

    StringBuilder sb;

    public void solve() {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        int t = in.readInt();
        for (int i = 1; i <= t; i++) {

            long x = in.readLong(), y = in.readLong();

            long sum = Math.abs(x) + Math.abs(y);
            long curr = (long) Math.pow(2.0, (int) (Math.sqrt(sum)));
            long totalSumRequired = sum == 1 ? sum : curr + curr - 1;
            sb = new StringBuilder();
            boolean result = dfs(0, 0, x, y, 0, totalSumRequired);
            if ( !result )
                out.printLine("Case #" + i + ": " + "IMPOSSIBLE");
            else
                out.printLine("Case #" + i + ": " + sb.toString());
            out.flush();
        }
    }

    private boolean dfs(long xi, long yi, long x, long y, int i, long totalSum) {

        if ( next(i + 1) - 1 > totalSum )
            return false;
        else if ( next(i + 1) - 1 == totalSum) {
            return xi == x && yi == y;
        }


        boolean result = false;
        sb.append("E");
        result = dfs(xi + next(i + 1), yi, x, y, i + 1, totalSum);
        if ( result )
            return true;
        sb.deleteCharAt(sb.length() - 1);

        sb.append("S");
        result = dfs(xi, yi - next(i + 1), x, y, i + 1, totalSum);
        if ( result )
            return true;
        sb.deleteCharAt(sb.length() - 1);

        sb.append("N");
        result = dfs(xi, yi + next(i + 1), x, y, i + 1, totalSum);
        if ( result )
            return true;
        sb.deleteCharAt(sb.length() - 1);

        sb.append("W");
        result = dfs(xi - next(i + 1), yi, x, y, i + 1, totalSum);
        if ( result )
            return true;
        sb.deleteCharAt(sb.length() - 1);

        return false;
    }

    private long next(int i) {
        return (long) Math.pow(2, i - 1);
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        solver.solve();
    }

    static class InputReader {

        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if ( numChars == -1 )
                throw new InputMismatchException();
            if ( curChar >= numChars ) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if ( numChars <= 0 )
                    return -1;
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if ( c == '-' ) {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if ( c < '0' || c > '9' )
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
            if ( c == '-' ) {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if ( c < '0' || c > '9' )
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
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if ( filter != null )
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if ( i != 0 )
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

        public void flush() {
            writer.flush();
        }

    }

    static class IOUtils {

        public static int[] readIntegerArray(InputReader in, int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = in.readInt();
            }
            return array;
        }

        public static Integer[] readIIntegerArray(InputReader in, int size) {
            Integer[] array = new Integer[size];
            for (int i = 0; i < size; i++) {
                array[i] = in.readInt();
            }
            return array;
        }

        public static long[] readLongArray(InputReader in, int size) {
            long[] array = new long[size];
            for (int i = 0; i < size; i++) {
                array[i] = in.readLong();
            }
            return array;
        }

        public static Long[] readLLongArray(InputReader in, int size) {
            Long[] array = new Long[size];
            for (int i = 0; i < size; i++) {
                array[i] = in.readLong();
            }
            return array;
        }


        public static List<Integer> readIntegerList(InputReader in, int size) {
            List<Integer> set = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                set.add(in.readInt());
            }
            return set;
        }

        public static Set<Integer> readIntegerSet(InputReader in, int size) {
            Set<Integer> set = new HashSet<Integer>();
            for (int i = 0; i < size; i++) {
                set.add(in.readInt());
            }
            return set;
        }
    }
}