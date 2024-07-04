import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Eric
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        SquareDance solver = new SquareDance();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class SquareDance {
        int r;
        int c;
        long[][] a;
        boolean[][] done;

        public void solve(int testNumber, FastReader in, PrintWriter out) {
            r = in.nextInt();
            c = in.nextInt();
            a = in.nextMatLong(r, c);
            long res = solveMe();
            out.print("Case #" + testNumber + ": ");
            out.println(res);
        }

        private long solveMe() {
            done = new boolean[r][c];
            long total = 0;
            while (true) {
                boolean[][] willBeDone = new boolean[r][c];
                boolean willFinish = true;
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (!done[i][j]) {
                            total += a[i][j];
                            long otherSkills = 0;
                            long othersNb = 0;
                            for (int k = 0; k < 2; k++) {
                                for (int l = 0; l < 2; l++) {
                                    SquareDance.MyPair next = getNeightbour(i, j, k == 0, l == 0);
                                    if (next != null) {
                                        otherSkills += a[(int) next.first][(int) next.second];
                                        othersNb++;
                                    }
                                }
                            }
                            if (othersNb == 0) {
                                //Avoid checking this one, next time
                            } else {
                                if (otherSkills > othersNb * a[i][j]) {
                                    willBeDone[i][j] = true;
                                    willFinish = false;
                                }
                            }
                        }
                    }
                }
                if (willFinish)
                    break;
                for (int i = 0; i < r; i++)
                    for (int j = 0; j < c; j++)
                        done[i][j] = done[i][j] || willBeDone[i][j];
            }

            return total;
        }

        private SquareDance.MyPair getNeightbour(int i0, int j0, boolean isHori, boolean isLeft) {
            SquareDance.MyPair pair;
            if (isHori) {
                if (isLeft) {
                    int iPos = i0 - 1;
                    while (iPos >= 0 && done[iPos][j0])
                        iPos--;
                    pair = iPos == -1 ? null : new SquareDance.MyPair(iPos, j0);
                } else {
                    int iPos = i0 + 1;
                    while (iPos < r && done[iPos][j0])
                        iPos++;
                    pair = iPos == r ? null : new SquareDance.MyPair(iPos, j0);
                }
            } else {
                if (isLeft) {
                    int jPos = j0 - 1;
                    while (jPos >= 0 && done[i0][jPos])
                        jPos--;
                    pair = jPos == -1 ? null : new SquareDance.MyPair(i0, jPos);
                } else {
                    int jPos = j0 + 1;
                    while (jPos < c && done[i0][jPos])
                        jPos++;
                    pair = jPos == c ? null : new SquareDance.MyPair(i0, jPos);
                }
            }
            return pair;
        }

        public static class MyPair implements Comparable<SquareDance.MyPair> {
            long first;
            long second;

            public MyPair(long first, long second) {
                this.first = first;
                this.second = second;
            }

            public String toString() {
                return "[" + first + ", " + second + "]";
            }

            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                SquareDance.MyPair myPair = (SquareDance.MyPair) o;
                return first == myPair.first &&
                        second == myPair.second;
            }

            public int hashCode() {
                return Objects.hash(first, second);
            }

            public int compareTo(SquareDance.MyPair p2) {
                int res = Long.compare(first, p2.first);
                return res != 0 ? res : Long.compare(second, p2.second);
            }

        }

    }

    static class FastReader {
        public BufferedReader br;
        public StringTokenizer st;
        String context = null;

        public FastReader(InputStream in) {
            this(new InputStreamReader(in));
        }

        public FastReader(InputStreamReader input) {
            br = new BufferedReader(input);
        }

        public String next() {
            if (context != null) {
                System.err.print("[" + context + "] Wait for input ...");
            }
            while (st == null || !st.hasMoreElements()) {
                try {
                    String s = br.readLine();
                    if (s == null)
                        return null;
                    st = new StringTokenizer(s);
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException("Could not read");
                }
            }
            String res = st.nextToken();
            if (context != null) {
                System.err.println("[" + context + "] ... received : " + res);
            }
            return res;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public long[][] nextMatLong(int n, int m) {
            long[][] a = new long[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    a[i][j] = nextLong();
            return a;
        }

    }
}

