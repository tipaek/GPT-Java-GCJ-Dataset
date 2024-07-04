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
public class Main {
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
            long L = in.nextLong();
            long R = in.nextLong();
            long n = 0;
            while (true) {
                if (R > L) {
                    if (R >= (n + 1)) {
                        n++;
                        R -= n;
                    } else {
                        break;
                    }
                } else {
                    if (L >= (n + 1)) {
                        n++;
                        L -= n;
                    } else {
                        break;
                    }
                }
            }
            out.println("Case #" + testNumber + ": " + n + " " + L + " " + R);
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

        public long nextLong() {

            return Long.parseLong(next());

        }

    }
}

