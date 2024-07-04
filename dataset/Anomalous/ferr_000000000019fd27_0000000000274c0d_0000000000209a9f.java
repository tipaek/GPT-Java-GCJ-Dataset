import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public final class Solution implements Runnable {

    public String solveCase() {
        String input = next();
        StringBuilder result = new StringBuilder();
        int depth = 0;

        for (char character : input.toCharArray()) {
            if (character == '(') {
                depth++;
            } else if (character == ')') {
                depth--;
                if (depth < 0) {
                    result.append('(');
                    depth++;
                }
            } else {
                int value = Character.getNumericValue(character);
                while (value != depth) {
                    if (value > depth) {
                        result.append('(');
                        depth++;
                    } else {
                        result.append(')');
                        depth--;
                    }
                }
            }
            result.append(character);
        }

        while (depth > 0) {
            result.append(')');
            depth--;
        }

        return result.toString();
    }

    public void solve() {
        int testCases = nextInt();
        for (int i = 0; i < testCases; ++i) {
            String answer = solveCase();
            output.printf("Case #%d: %s\n", i + 1, answer);
        }
    }

    private static final String FILENAME = "A";
    private static final boolean FROM_CONSOLE = true;

    public void run() {
        try {
            if (!FROM_CONSOLE) {
                input = new BufferedReader(new FileReader(FILENAME + ".in"));
                output = new PrintWriter(FILENAME + ".out");
            } else {
                input = new BufferedReader(new InputStreamReader(System.in));
                output = new PrintWriter(System.out);
            }
            tokenizer = new StringTokenizer("");
            long startTime = System.currentTimeMillis();
            solve();
            // output.printf("\nWorking time: %d ms\n", System.currentTimeMillis() - startTime);
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private StringTokenizer tokenizer;
    private BufferedReader input;
    private PrintWriter output;

    private boolean hasNext() {
        try {
            while (!tokenizer.hasMoreTokens()) {
                String line = input.readLine();
                if (line == null) {
                    return false;
                }
                tokenizer = new StringTokenizer(line);
            }
            return tokenizer.hasMoreTokens();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String next() {
        return hasNext() ? tokenizer.nextToken() : null;
    }

    private int nextInt() {
        return Integer.parseInt(next());
    }

    private BigInteger nextBigInteger() {
        return new BigInteger(next());
    }

    private long nextLong() {
        return Long.parseLong(next());
    }

    private double nextDouble() {
        return Double.parseDouble(next());
    }

    public static void main(String[] args) {
        new Thread(new Solution()).start();
    }
}