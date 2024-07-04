import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author EDGE
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskCodejamB solver = new TaskCodejamB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskCodejamB {
        public void solve(int testNumber, FastReader in, PrintWriter out) {
            int t = in.nextInt();
            int k = 1;
            while (t-- > 0) {
                int ltr = 0;
                int rtl = 0;
                String s = in.nextLine();
                s = '0' + s + '0';
                StringBuilder sb = new StringBuilder();
                char[] st = s.toCharArray();
                int n = s.length();
                char open = '(', close = ')';
                for (int i = 0; i < n - 1; i++) {
                    ltr = st[i] - st[i + 1];
                    rtl = st[i + 1] - st[i];
                    //out.print(ltr+"  ");
                    sb.append(st[i]);
                    for (int j = 1; j <= ltr; j++) {
                        sb.append(close);
                    }

                    for (int j = 1; j <= rtl; j++) {
                        sb.append(open);
                    }


                }


                out.println("Case #" + k + ": " + sb.toString().substring(1));
                out.flush();
                k++;

            }
        }

    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(InputStream inputStream) {
            br = new BufferedReader(new
                    InputStreamReader(inputStream));
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }
}

