import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author bhavy seth
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        matcdjam solver = new matcdjam();
        solver.solve(1, in, out);
        out.close();
    }

    static class matcdjam {
        public void solve(int testNumber, InputReader sc, PrintWriter out) {
            int t = sc.nextInt();
            int test = 0;
            while (t-- > 0) {
                test++;
                int n = sc.nextInt();
                int a[][] = new int[n][n];
                HashSet<Integer> rowset[] = new HashSet[n + 1];
                HashSet<Integer> colset[] = new HashSet[n + 1];
                for (int i = 0; i <= n; i++) {
                    rowset[i] = new HashSet<>();
                    colset[i] = new HashSet<>();
                }
                HashSet<Integer> totalrows = new HashSet<>();
                HashSet<Integer> totalcol = new HashSet<>();
                int trace = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        a[i][j] = sc.nextInt();
                        if (i == j)
                            trace += a[i][j];
                        if (rowset[a[i][j]].contains(i)) {
                            totalrows.add(i);
                        }
                        if (colset[a[i][j]].contains(j)) {
                            totalcol.add(j);
                        }
                        rowset[a[i][j]].add(i);
                        colset[a[i][j]].add(j);
                    }
                }
                out.println("Case #" + test + ": " + trace + " " + totalrows.size() + " " + totalcol.size());
            }
        }

    }

    static class InputReader {
        BufferedReader br;
        StringTokenizer st;

        public InputReader(InputStream inputStream) {
            br = new BufferedReader(new
                    InputStreamReader(inputStream));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

