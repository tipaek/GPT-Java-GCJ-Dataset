import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner scanner = new FastScanner(inputStream);
        PrintWriter writer = new PrintWriter(outputStream);
        NestingDepthSolver solver = new NestingDepthSolver();
        solver.solve(scanner, writer);
        writer.close();
    }
}

class NestingDepthSolver {
    public void solve(FastScanner scanner, PrintWriter writer) {
        int numTests = scanner.nextInt();
        for (int test = 1; test <= numTests; test++) {
            char[] sequence = scanner.next().toCharArray();
            writer.printf("Case #%d: %s\n", test, computeNestingDepth(sequence));
        }
    }

    private String computeNestingDepth(char[] sequence) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (int i = 0; i <= sequence.length; i++) {
            int targetDepth = i < sequence.length ? sequence[i] - '0' : 0;

            while (currentDepth < targetDepth) {
                result.append("(");
                currentDepth++;
            }

            while (currentDepth > targetDepth) {
                result.append(")");
                currentDepth--;
            }

            if (i < sequence.length) {
                result.append(sequence[i]);
            }
        }

        return result.toString();
    }
}

class FastScanner {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public FastScanner(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
}