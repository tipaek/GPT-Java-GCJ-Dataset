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
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        MyScanner in = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int t = in.nextInt();
            for (int i = 1; i <= t; i++) {
                StringBuilder sb = new StringBuilder();
                String s = "0" + in.next() + "0";

                for (int j = 1; j < s.length(); j++) {
                    int x = s.charAt(j) - '0';
                    int y = s.charAt(j - 1) - '0';
                    while (x > y) {
                        sb.append('(');
                        x--;
                    }
                    while (y > x) {
                        sb.append(')');
                        y--;
                    }
                    if (j != s.length() - 1)
                        sb.append(s.charAt(j));

                }

                out.printf("Case #%d: %s\n", i, sb.toString());
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

