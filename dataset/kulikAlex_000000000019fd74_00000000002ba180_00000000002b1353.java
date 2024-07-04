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
            int sum = 0;
            int lvl = 1;
            while (sum < N) {
                if (lvl == 1) {
                    out.println("1 1");
                    sum++;
                } else if (sum + lvl - 1 <= N) {
                    out.println(lvl + " " + (lvl - 1));
                    sum += lvl - 1;
                } else {
                    int left = N - sum;
                    for (int i = 0; i < left; i++) {
                        out.println((lvl + i - 1) + " " + (lvl + i - 1));
                    }
                    sum = N;
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

