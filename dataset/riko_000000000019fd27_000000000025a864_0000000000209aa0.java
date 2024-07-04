import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
        Task2020QE solver = new Task2020QE();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class Task2020QE {
        public void solve(int testNumber, FastReader in, PrintWriter out) {
        /*if (testNumber ==1) {
            random(out);
            out.flush();
        } else {
            System.exit(1);
        }*/
            int n = in.nextInt();
            int k = in.nextInt();
            int[][] res = solveMeSimple(n, k);
            out.print("Case #" + testNumber + ": ");
            printAnswer(res, out);
        }

        private int[][] solveMeSimple(int n, int k) {
            int[][] res = new int[n][n];
            boolean isOk = backtrack(res, 0, 0, k);
            return isOk ? res : null;
        }

        private boolean backtrack(int[][] a, int posRow, int posCol, int k) {
            if (posCol == a.length) {
                return getTrace(a) == k;
            }

            if (posRow == a.length) {
                return backtrack(a, 0, posCol + 1, k);
            } else {
                for (int i = 1; i <= a.length; i++) {
                    if (!isPossible(a, posRow, posCol, i))
                        continue;
                    a[posRow][posCol] = i;
                    if (backtrack(a, posRow + 1, posCol, k))
                        return true;
                    a[posRow][posCol] = 0;
                }

                return false;
            }

        }

        private int getTrace(int[][] a) {
            int trace = 0;
            for (int i = 0; i < a.length; i++)
                trace += a[i][i];
            return trace;
        }

        private boolean isPossible(int[][] a, int posRow, int posCol, int val) {
            if (a[posRow][posCol] != 0)
                return false;
            for (int i = 0; i < a.length; i++) {
                if (i != posCol && a[posRow][i] == val) {
                    return false;
                }
            }
            for (int i = 0; i < a.length; i++) {
                if (i != posRow && a[i][posCol] == val) {
                    return false;
                }
            }
            return true;
        }

        private void printAnswer(int[][] res, PrintWriter out) {
            //d("res = " + (res==null? null : stringMe(res)));
            if (res != null) {
                out.println("POSSIBLE");
                out.println(stringMe(res));
            } else {
                out.println("IMPOSSIBLE");
            }
        }

        private static String stringMe(int[][] a, int maxI, int maxJ) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < Math.min(maxI, a.length); i++) {
                for (int j = 0; j < Math.min(maxJ, a[i].length); j++) {
                    if (j > 0)
                        res.append(" ");
                    res.append(a[i][j]);
                }
                res.append("\n");
            }
            return res.toString();
        }

        private static String stringMe(int[][] a) {
            return stringMe(a, Integer.MAX_VALUE, Integer.MAX_VALUE);
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

    }
}

