import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static InputStream inputStream;
    static PrintWriter out;
    static InputReader in;
    static int test;

    static void solve() throws Exception {
        String str = in.next();
        StringBuilder result = new StringBuilder();

        int currentLevel = 0;

        for (int i = 0; i < str.length(); i++) {
            int nextLevel = str.charAt(i) - '0';
            result.append(addBraces(nextLevel - currentLevel)).append(str.charAt(i));
            currentLevel = nextLevel;
        }
        result.append(addBraces(-currentLevel));
        out.println(result);
    }

    static StringBuilder addBraces(int n) {
        StringBuilder result = new StringBuilder();
        char brace = n > 0 ? '(' : ')';
        for (int i = 0; i < Math.abs(n); i++) {
            result.append(brace);
        }
        return result;
    }

    static void printCase() {
        out.print("Case #" + test + ": ");
    }

    public static void main(String[] args) {
        try {
            inputStream = System.in;
            out = new PrintWriter(System.out);
            in = new InputReader(inputStream);

            int tests = in.nextInt();
            for (test = 1; test <= tests; test++) {
                printCase();
                solve();
            }
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    String str = reader.readLine();
                    if (str == null) {
                        return "";
                    } else {
                        tokenizer = new StringTokenizer(str);
                    }
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
}