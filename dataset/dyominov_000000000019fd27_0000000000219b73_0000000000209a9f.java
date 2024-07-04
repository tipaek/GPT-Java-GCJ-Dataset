import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Actual solution is at the top
 *
 * @author dyominov
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        OutputStream outputStream = System.out;
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(outputStream);
        Solver solver = new Solver();
        solver.solve(1, in, out);
        out.close();
    }


    static class Solver {
        static int count = 0;

        public void solve(int testNumber, FastReader in, PrintWriter out) throws IOException {
            int test = in.nextInt();
            for (int t = 1; t <= test; ++t) {
                String s = in.next();
                StringBuilder res = new StringBuilder();
                int prev = s.charAt(0) - '0';
                for (int j = 0; j < prev; ++j) {
                    res.append('(');
                }
                res.append(prev);
                for (int i = 1; i < s.length(); ++i) {
                    int curr = s.charAt(i) - '0';
                    if (prev == curr) {
                        res.append((int) curr);
                        prev = curr;
                        continue;
                    } else if (prev > curr) {
                        for (int j = 0; j < prev - curr; ++j) {
                            res.append(')');
                        }
                    } else {
                        for (int j = 0; j < curr - prev; ++j) {
                            res.append('(');
                        }
                    }
                    res.append(curr);
                    prev = curr;
                }
                for (int j = 0; j < prev; ++j) {
                    res.append(')');
                }
                out.println("Case #" + t + ": " + res);
            }

        }
    }

    static class FastReader implements AutoCloseable {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        @Override
        public void close() throws Exception {

        }
    }
}