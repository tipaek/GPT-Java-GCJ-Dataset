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
        ESAbATAd solver = new ESAbATAd();
        solver.solve(1, in, out);
        out.close();
    }

    static class ESAbATAd {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int caseCount = in.nextInt();
            int bitCount = in.nextInt();

            if (bitCount != 10) {
                throw new RuntimeException("Uh-oh, I can only handle 10 bits!");
            }

            for (int caseId = 1; caseId <= caseCount; caseId++) {
                StringBuilder output = new StringBuilder();

                for (int i = 1; i <= 10; i++) {
                    out.println(i);
                    out.flush();
                    output.append(in.nextInt());
                }

                out.println(output.toString());
                out.flush();

                String answer = in.next();

                if (answer.equals("N")) {
                    throw new RuntimeException("Ouch");
                }
            }
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

