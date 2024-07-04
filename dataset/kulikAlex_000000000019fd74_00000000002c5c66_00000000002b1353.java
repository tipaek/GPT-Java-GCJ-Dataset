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
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        B solver = new B();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class B {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int N = in.nextInt();
            out.println("Case #" + testNumber + ":");
            int lvl = 1;
            long sum = 0;
            while (true) {
                long dif = (1L << lvl) + (1L << (lvl - 1));
                if (sum + dif > N) {
                    break;
                }
                sum += dif;
                for (int i = 1; i <= lvl; i++) {
                    out.println(lvl + " " + i);
                }
                for (int i = lvl + 1; i > 0; i--) {
                    out.println((lvl + 1) + " " + i);
                }
                lvl += 2;
            }
            while (sum < N) {
                if (sum + lvl - 1 <= N) {
                    out.println(lvl + " " + 2);
                    sum += lvl - 1;
                } else {
                    sum++;
                    out.println(lvl + " " + 1);
                }
                lvl++;
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

