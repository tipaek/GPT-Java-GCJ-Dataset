import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.TreeSet;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Jeel Vaishnav
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        SquareDance solver = new SquareDance();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class SquareDance {
        int[] removed;
        long[] values;

        public void solve(int testNumber, InputReader sc, PrintWriter out) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int n = r * c;

            long mat[][] = new long[r][c];
            long sum = 0;
            values = new long[n];
            for (int i = 0; i < r; ++i) {
                for (int j = 0; j < c; ++j) {
                    mat[i][j] = sc.nextInt();
                    sum += mat[i][j];
                    values[i * c + j] = mat[i][j];
                }
            }


            TreeSet<Integer> rowSet[] = new TreeSet[r];
            for (int i = 0; i < r; ++i) {
                rowSet[i] = new TreeSet<>();
                for (int j = 0; j < c; ++j) {
                    rowSet[i].add(i * c + j);
                }
            }

            TreeSet<Integer> colSet[] = new TreeSet[c];
            for (int j = 0; j < c; ++j) {
                colSet[j] = new TreeSet<>();
                for (int i = 0; i < r; ++i)
                    colSet[j].add(i * c + j);
            }

            long ans = 0;
            removed = new int[n];
            long step = 1;
            while (true) {
                ArrayList<Integer> indices = new ArrayList<>();
                for (int i = 0; i < r; ++i) {
                    for (int j = 0; j < c; ++j) {
                        int ind = i * c + j;
                        if (removed[ind] == 0) {
                            long curV = 0;

                            if (rowSet[i].lower(ind) != null) {
                                curV += values[ind];
                                curV -= values[rowSet[i].lower(ind)];
                            }
                            if (rowSet[i].higher(ind) != null) {
                                curV += values[ind];
                                curV -= values[rowSet[i].higher(ind)];
                            }
                            if (colSet[j].lower(ind) != null) {
                                curV += values[ind];
                                curV -= values[colSet[j].lower(ind)];
                            }
                            if (colSet[j].higher(ind) != null) {
                                curV += values[ind];
                                curV -= values[colSet[j].higher(ind)];
                            }

                            if (curV < 0) {
                                removed[ind] = 1;
                                ans += step * values[ind];
                                indices.add(ind);
                            }
                        }
                    }
                }

                if (indices.size() == 0)
                    break;

                for (int ind : indices) {
                    int i = ind / c;
                    int j = ind % c;

                    colSet[j].remove(ind);
                    rowSet[i].remove(ind);
                }

                step++;
            }

            for (int i = 0; i < n; ++i) {
//            out.println(i + " " + removed[i] + " " + ans + " " + step + " " + values[i]);
                if (removed[i] == 0)
                    ans += step * values[i];
            }

            out.println("Case #" + testNumber + ": " + ans);
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

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

        public int nextInt() {
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
            }
            while (!isSpaceChar(c));

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
            }
            while (!isSpaceChar(c));

            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
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
}

