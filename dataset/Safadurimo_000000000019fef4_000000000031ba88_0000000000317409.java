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
        OverexcitedFan solver = new OverexcitedFan();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class OverexcitedFan {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int x = in.nextInt();
            int xx = x;
            int y = in.nextInt();
            String m = in.next();
            int time = Math.abs(x);
            for (int i = 0; i < m.length() && x != 0; i++) {
                char c = m.charAt(i);
                if (c == 'N') y++;
                else y--;

                if (x > 0) x--;
                else x++;
            }
            boolean succ = y == 0 && x == 0;
            for (int i = xx; i < m.length() && !succ; i++) {
                time++;
                char c = m.charAt(i);
                if (c == 'N') y++;
                else y--;
                if (Math.abs(y) <= 1) {
                    succ = true;
                } else {
                    if (y > 0) y--;
                    else y++;
                }
            }
            if (!succ)
                out.printf("Case #%d: IMPOSSIBLE\n", testNumber);
            else out.printf("Case #%d: %d\n", testNumber, time);
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

