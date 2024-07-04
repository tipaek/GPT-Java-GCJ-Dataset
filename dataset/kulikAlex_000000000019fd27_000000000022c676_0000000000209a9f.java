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
            String S = in.next();
            StringBuilder sb = new StringBuilder();
            int bal = 0;
            int ind = 0;
            while (bal != 0 || ind < S.length()) {
                int digit = ind < S.length() ? (S.charAt(ind) - '0') : 0;
                if (digit > bal) {
                    sb.append('(');
                    bal++;
                } else if (digit < bal) {
                    sb.append(')');
                    bal--;
                } else {
                    sb.append(digit);
                    ind++;
                }
            }
            out.println("Case #" + testNumber + ": " + sb);
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

    }
}

