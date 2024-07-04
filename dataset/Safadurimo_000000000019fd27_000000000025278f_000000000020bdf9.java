import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        MyScanner in = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int t = in.nextInt();
            for (int i = 1; i <= t; i++) {
                int n = in.nextInt();
                Intervall[] ivalls = new Intervall[n];
                for (int j = 0; j < n; j++) {
                    ivalls[j] = new Intervall(in.nextInt(), in.nextInt(), j);
                }
                Arrays.sort(ivalls);
                StringBuilder res = new StringBuilder();
                int c = 0;
                int j = 0;
                boolean imp = false;
                char[] res_arr = new char[n];
                for (int k = 0; k < n; k++) {
                    if (ivalls[k].left >= c) {
                        c = ivalls[k].right;
                        res_arr[ivalls[k].i] = 'C';

                    } else if (ivalls[k].left >= j) {
                        j = ivalls[k].right;
                        res_arr[ivalls[k].i] = 'J';
                    } else {
                        imp = true;
                        break;
                    }
                }
                String r = imp ? "IMPOSSIBLE" : new String(res_arr);
                out.printf("Case #%d: %s\n", i, r);
            }
        }

        class Intervall implements Comparable {
            int left;
            int right;
            int i;

            public Intervall(int left, int right, int i) {
                this.left = left;
                this.right = right;
                this.i = i;
            }

            public int compareTo(Object o) {
                return Integer.valueOf(left).compareTo(Integer.valueOf(((Intervall) o).left));
            }

        }

    }

    static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
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

