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
 * @author Jasper van Merle
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        NestingDepth solver = new NestingDepth();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class NestingDepth {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            String line = in.nextLine();
            StringBuilder output = new StringBuilder();

            int currentDepth = 0;

            for (char ch : line.toCharArray()) {
                int requiredDepth = Character.digit(ch, 10);

                if (requiredDepth > currentDepth) {
                    for (int i = currentDepth; i < requiredDepth; i++) {
                        output.append('(');
                        currentDepth++;
                    }
                } else if (requiredDepth < currentDepth) {
                    for (int i = currentDepth; i > requiredDepth; i--) {
                        output.append(')');
                        currentDepth--;
                    }
                }

                output.append(ch);
            }

            for (int i = 0; i < currentDepth; i++) {
                output.append(')');
            }

            out.println(String.format("Case #%s: %s", testNumber, output.toString()));
        }

    }

    static class InputReader {
        private BufferedReader br;
        private StringTokenizer st;

        public InputReader(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            return st.nextToken();
        }

        public String nextLine() {
            String str;

            try {
                str = br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return str;
        }

    }
}

