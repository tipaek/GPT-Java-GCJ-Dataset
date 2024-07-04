import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Nikita Mikhailov
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskE solver = new TaskE();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskE {
        int n;
        int requiredValue = -1;
        boolean requiredFound = false;
        int caseNum = -1;
        TreeSet<Integer> validResults = new TreeSet<>();

        void generate(int pos, HashSet<Integer> columnChoices[], HashSet<Integer> rowChoices[], int[][] matrix) {
            if (this.requiredFound) {
                return;
            }
            int n = this.n;
            int x = pos % n;
            int y = pos / n;

            if (pos >= n * n) {
                register(matrix);
                return;
            }

            for (Integer tryThis : (HashSet<Integer>) columnChoices[x].clone()) {
                if (!rowChoices[y].contains(tryThis)) {
                    continue;
                }

                columnChoices[x].remove(tryThis);
                rowChoices[y].remove(tryThis);

                matrix[x][y] = tryThis;

                generate(pos + 1, columnChoices, rowChoices, matrix);

                columnChoices[x].add(tryThis);
                rowChoices[y].add(tryThis);
            }


        }

        void register(int[][] matrix) {
            int n = this.n;
            int res = 0;
            for (int i = 0; i < n; i++) {
                res += matrix[i][i];

//            for (int j = 0; j < n; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
            }
//        System.out.println();
//        System.out.println(res);
//        System.out.println();

            if (res == this.requiredValue) {
                System.out.println("Case #" + this.caseNum + ": POSSIBLE");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(matrix[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.flush();
                this.requiredFound = true;
            }

            this.validResults.add(res);

        }

        void genStart() {
            HashSet<Integer> col[] = new HashSet[this.n];
            HashSet<Integer> row[] = new HashSet[this.n];
            int[][] matrix = new int[n][n];

            int n = this.n;
            for (int i = 0; i < n; i++) {
                col[i] = new HashSet<>();
                row[i] = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    col[i].add(j + 1);
                    row[i].add(j + 1);
                }
            }

            generate(0, col, row, matrix);
        }

        public void solve(int testNumber, FastScanner in, PrintWriter out) {

            int n = in.readInt();
            int k = in.readInt();
            this.n = n;

            this.requiredFound = false;
            this.caseNum = testNumber;
            this.requiredValue = k;
            this.genStart();
            if (!this.requiredFound) {
                System.out.println("Case #" + testNumber + ": IMPOSSIBLE");
            }
            if (true) {
                return;
            }

            if (n >= 4 && k == (n + 1) * n / 2) {
                out.println("Case #" + testNumber + ": POSSIBLE");

                int ks = 2;
                if (n % 2 == 0) {
                    ks++;
                }
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        int val = (n - i + j * ks) % n;
                        out.print((val + 1) + " ");
                    }
                    out.println();
                }

                return;
            }

            if (k % n != 0) {
                out.println("Case #" + testNumber + ": IMPOSSIBLE");
                return;
            }

            out.println("Case #" + testNumber + ": POSSIBLE");

            int st = k / n - 1;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int val = (st + i - j + 10 * n) % n;
                    out.print((val + 1) + " ");
                }
                out.println();
            }
        }

    }

    static class FastScanner {
        private StringTokenizer st;
        private BufferedReader in;

        public FastScanner(final InputStream in) {
            this.in = new BufferedReader(new InputStreamReader(in));
        }

        public String readToken() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(in.readLine());
                } catch (final IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int readInt() {
            return Integer.parseInt(readToken());
        }

        public String next() {
            return readToken();
        }

    }
}

