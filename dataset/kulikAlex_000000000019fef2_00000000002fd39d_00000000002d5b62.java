import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.util.TreeMap;
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
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        A solver = new A();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class A {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int X = in.nextInt();
            int Y = in.nextInt();
            long m = (Math.abs(X) + Math.abs(Y));
            if (m % 2 == 0) {
                out.println("Case #" + testNumber + ": IMPOSSIBLE");
            } else {
                TreeSet<Long> steps = new TreeSet<>();
                long l = 1;
                for (; l <= m; l *= 2) ;
                for (long l2 = 1; l2 < l; l2 *= 2) {
                    steps.add(l2);
                }
                long x = X;
                long y = Y;
                TreeMap<Long, Character> ans = new TreeMap<>();
                while (x != 0 || y != 0) {
                    long s = steps.last();
                    steps.remove(s);
                    if (Math.abs(x) > Math.abs(y)) {
                        if (x > 0) {
                            x -= s;
                            ans.put(s, 'E');
                        } else {
                            x += s;
                            ans.put(s, 'W');
                        }
                    } else {
                        if (y > 0) {
                            y -= s;
                            ans.put(s, 'N');
                        } else {
                            y += s;
                            ans.put(s, 'S');
                        }
                    }
                }
                StringBuilder sb = new StringBuilder();
                for (long v : ans.keySet()) {
                    sb.append(ans.get(v));
                }
                out.println("Case #" + testNumber + ": " + sb);
            }
        }

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

