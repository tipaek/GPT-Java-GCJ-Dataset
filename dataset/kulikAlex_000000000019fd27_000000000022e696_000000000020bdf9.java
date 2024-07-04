import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        C solver = new C();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class C {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int N = in.nextInt();
            ArrayList<seg> activities = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                seg cur = new seg();
                cur.start = in.nextInt();
                cur.end = in.nextInt();
                activities.add(cur);
            }
            activities.sort((seg f, seg s) -> f.start - s.start);
            int lastJ = 0, lastC = 0;
            StringBuilder sb = new StringBuilder();
            boolean wrong = false;
            for (seg cur : activities) {
                if (lastJ <= cur.start) {
                    sb.append('J');
                    lastJ = cur.end;
                } else if (lastC <= cur.start) {
                    sb.append('C');
                    lastC = cur.end;
                } else {
                    wrong = true;
                }
            }
            if (wrong) {
                out.println("Case #" + testNumber + ": IMPOSSIBLE");
            } else {
                out.println("Case #" + testNumber + ": " + sb);
            }
        }

    }

    static class seg {
        int start;
        int end;

    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer stt;

        public InputReader(InputStream stream) {

            reader = new BufferedReader(new InputStreamReader(stream));

        }

        public String nextLine() {

            try {

                return reader.readLine();

            } catch (IOException e) {

                return null;

            }

        }

        public String next() {

            while (stt == null || !stt.hasMoreTokens()) {

                stt = new StringTokenizer(nextLine());

            }

            return stt.nextToken();

        }

        public int nextInt() {

            return Integer.parseInt(next());

        }

    }
}

