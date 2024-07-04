import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {

            InputReader in = new InputReader(System.in);
            PrintWriter out = new PrintWriter(System.out);
            NestingDepth solver = new NestingDepth();
            int testCount = Integer.parseInt(in.next());
            for (int i = 1; i <= testCount; i++)
                solver.solve(i, in, out);
            out.close();

    }

    static class NestingDepth {

        void solve(int testNumber, InputReader in, PrintWriter out) {

            String line = in.next();
            StringBuilder sb = new StringBuilder();

            int prev = 0;

            for (int i = 0; i < line.length(); i++) {
                int curr = line.charAt(i) - '0';

                if (curr == prev) {
                    sb.append(curr);
                } else if (curr > prev) {
                    sb.append(stringOfN('(', curr - prev));
                    sb.append(curr);
                } else {
                    sb.append(stringOfN(')', prev - curr));
                    sb.append(curr);
                }

                prev = curr;
            }

            sb.append(stringOfN(')', prev));

            out.printf("Case #%d: %s", testNumber, sb.toString());
            out.println();
        }

        String stringOfN(char c, int n) {
            char[] arr = new char[n];
            Arrays.fill(arr, c);
            return String.valueOf(arr);
        }
    }

    static class InputReader {
        BufferedReader br;
        StringTokenizer st;

        InputReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }

        String next() {
            return nextToken();
        }

        public String nextToken() {
            while (st == null || !st.hasMoreTokens()) {
                String line;
                try {
                    line = br.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (line == null) {
                    return null;
                }
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }
    }
}
