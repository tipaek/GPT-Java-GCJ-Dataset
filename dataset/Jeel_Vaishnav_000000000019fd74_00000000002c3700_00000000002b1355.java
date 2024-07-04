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
        long[] a;
        int[] removed;
        int[] segTree;
        long[] values;

        void buildSegTree(int low, int high, int pos) {
            if (low == high) {
                segTree[pos] = low;
                return;
            }

            int mid = (low + high) >> 1;
            buildSegTree(low, mid, 2 * pos + 1);
            buildSegTree(mid + 1, high, 2 * pos + 2);
            segTree[pos] = segTree[2 * pos + 2];
        }

        void updateSegTree(int low, int high, int pos, int ind, long val) {
            if (low > ind || high < ind)
                return;

            if (low == high) {
                a[ind] += val;
                return;
            }

            int mid = (low + high) >> 1;
            updateSegTree(low, mid, 2 * pos + 1, ind, val);
            updateSegTree(mid + 1, high, 2 * pos + 2, ind, val);
            int ind1 = segTree[2 * pos + 1];
            int ind2 = segTree[2 * pos + 2];

            if (a[ind1] < a[ind2])
                segTree[pos] = ind1;
            else
                segTree[pos] = ind2;
        }

        public void solve(int testNumber, InputReader sc, PrintWriter out) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int n = r * c;

            int mat[][] = new int[r][c];
            values = new long[n];
            for (int i = 0; i < r; ++i) {
                for (int j = 0; j < c; ++j) {
                    mat[i][j] = sc.nextInt();
                    values[i * c + j] = mat[i][j];
                }
            }

            a = new long[n];
            segTree = new int[4 * n];
            buildSegTree(0, n - 1, 0);

            for (int i = 0; i < r; ++i) {
                for (int j = 0; j < c; ++j) {
                    int count = 0;

                    if (i - 1 >= 0) {
                        updateSegTree(0, n - 1, 0, (i - 1) * c + j, -mat[i][j]);
                        count++;
                    }
                    if (i + 1 < r) {
                        updateSegTree(0, n - 1, 0, (i + 1) * c + j, -mat[i][j]);
                        count++;
                    }
                    if (j - 1 >= 0) {
                        updateSegTree(0, n - 1, 0, i * c + j - 1, -mat[i][j]);
                        count++;
                    }
                    if (j + 1 < c) {
                        updateSegTree(0, n - 1, 0, i * c + j + 1, -mat[i][j]);
                        count++;
                    }

                    updateSegTree(0, n - 1, 0, i * c + j, count * mat[i][j]);
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
            while (a[segTree[0]] < 0) {
                ArrayList<Integer> indices = new ArrayList<>();
                while (a[segTree[0]] < 0) {
                    indices.add(segTree[0]);
                    removed[segTree[0]] = 1;
                    updateSegTree(0, n - 1, 0, segTree[0], (long) 1e16);
                }

                for (int ind : indices) {
                    int i = ind / c;
                    int j = ind % c;

                    if (rowSet[i].higher(ind) != null) {
                        updateSegTree(0, n - 1, 0, rowSet[i].higher(ind), mat[i][j]);
                    }
                    if (rowSet[i].lower(ind) != null) {
                        updateSegTree(0, n - 1, 0, rowSet[i].lower(ind), mat[i][j]);
                    }
                    if (colSet[j].higher(ind) != null) {
                        updateSegTree(0, n - 1, 0, colSet[j].higher(ind), mat[i][j]);
                    }
                    if (colSet[j].lower(ind) != null) {
                        updateSegTree(0, n - 1, 0, colSet[j].lower(ind), mat[i][j]);
                    }
                }

                for (int ind : indices) {
                    int i = ind / c;
                    int j = ind % c;

                    rowSet[i].remove(ind);
                    colSet[j].remove(ind);
                    ans += step * mat[i][j];
                }

                for (int ind : indices) {
                    int i = ind / c;
                    int j = ind % c;

                    if (rowSet[i].higher(ind) != null && rowSet[i].lower(ind) != null) {
                        int l1 = rowSet[i].lower(ind);
                        int l2 = rowSet[i].higher(ind);

                        updateSegTree(0, n - 1, 0, l1, -values[l2]);
                        updateSegTree(0, n - 1, 0, l2, -values[l1]);
                    } else if (rowSet[i].higher(ind) != null) {
                        int l = rowSet[i].higher(ind);
                        updateSegTree(0, n - 1, 0, l, -values[l]);
                    } else if (rowSet[i].lower(ind) != null) {
                        int l = rowSet[i].lower(ind);
                        updateSegTree(0, n - 1, 0, l, -values[l]);
                    }

                    if (colSet[j].higher(ind) != null && colSet[j].lower(ind) != null) {
                        int l1 = colSet[j].lower(ind);
                        int l2 = colSet[j].higher(ind);

                        updateSegTree(0, n - 1, 0, l1, -values[l2]);
                        updateSegTree(0, n - 1, 0, l2, -values[l1]);
                    } else if (colSet[j].higher(ind) != null) {
                        int l = colSet[j].higher(ind);
                        updateSegTree(0, n - 1, 0, l, -values[l]);
                    } else if (colSet[j].lower(ind) != null) {
                        int l = colSet[j].lower(ind);
                        updateSegTree(0, n - 1, 0, l, -values[l]);
                    }

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

