import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (FastReader in = new FastReader(); PrintWriter out = new PrintWriter(System.out)) {
            new Solver().solve(in, out);
        }
    }
}

class Solver {
    public void solve(FastReader in, PrintWriter out) throws IOException {
        int testCases = in.nextInt();
        for (int t = 1; t <= testCases; ++t) {
            String s = in.next();
            StringBuilder result = new StringBuilder();
            int previousDigit = s.charAt(0) - '0';
            result.append("(".repeat(previousDigit)).append(previousDigit);

            for (int i = 1; i < s.length(); ++i) {
                int currentDigit = s.charAt(i) - '0';
                if (previousDigit < currentDigit) {
                    result.append("(".repeat(currentDigit - previousDigit));
                } else if (previousDigit > currentDigit) {
                    result.append(")".repeat(previousDigit - currentDigit));
                }
                result.append(currentDigit);
                previousDigit = currentDigit;
            }
            result.append(")".repeat(previousDigit));
            out.println("Case #" + t + ": " + result);
        }
    }
}

class FastReader implements AutoCloseable {
    private final BufferedReader br;
    private StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
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

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    @Override
    public void close() throws Exception {
        br.close();
    }
}