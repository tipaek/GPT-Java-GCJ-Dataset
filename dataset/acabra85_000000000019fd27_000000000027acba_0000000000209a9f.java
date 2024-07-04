
import java.io.*;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
    private final static String RESULT = "%sCase #%d: %s";

    private final Solution.Help help;

    static class Help {
        final BufferedReader bf;
        final PrintWriter out;
        StringTokenizer tokenizer;

        public Help(BufferedReader bf, PrintWriter out) {
            this.bf = bf;
            this.out = out;
        }

        public int nInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nDouble() throws IOException {
            return Double.parseDouble(next());
        }

        String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(bf.readLine());
            }
            return tokenizer.nextToken();
        }

        public void close() throws IOException {
            bf.close();
            out.flush();
        }
    }

    public static Solution ofConsole() {
        return new Solution(System.in, new OutputStreamWriter(System.out));
    }

    public static Solution ofTestFile(String fileName) {
        InputStream resourceAsStream = Solution.class.getClassLoader().getResourceAsStream(fileName);
        return new Solution(resourceAsStream, new OutputStreamWriter(System.out));
    }

    public Solution(InputStream in, OutputStreamWriter iOut) {
        this.help = new Solution.Help(new BufferedReader(new InputStreamReader(in)), new PrintWriter(iOut));
    }

    public static void main(String... args) throws Exception {
        new Solution(System.in, new OutputStreamWriter(System.out)).read();
    }

    public void read() throws Exception {
        int testCases = help.nInt();
        for (int i = 1; i <= testCases; i++) {
            String result = solveCase(help.next());
            help.out.printf(RESULT, i == 1 ? "" : "\n", i, result);
            help.out.flush();
        }
        help.close();
    }

    protected static String solveCase(String S1) {
        char[] S = S1.toCharArray();
        StringBuilder result = new StringBuilder();
        AtomicInteger open = new AtomicInteger(0);
        if (S[0] > 0) {
            append(open, result, S[0] - '0', S[0]);
        }
        char last = S[0];
        char curr;
        for (int i = 1; i < S.length; i++) {
            curr = S[i];
            if (last == curr) {
                result.append(curr);
            } else if (last > curr) {
                close(open, result, last - curr, curr);
            } else {
                append(open, result, curr - last, curr);
            }
            last = curr;
        }
        close(open, result, open.get(), '\0');
        return result.toString();
    }

    private static void close(AtomicInteger open, StringBuilder result, int diff, char curr) {
        for (int i = 0; i < diff; i++) {
            result.append(")");
            open.decrementAndGet();
        }
        if ('\0' != curr) {
            result.append(curr);
        }
    }

    private static void append(AtomicInteger open, StringBuilder result, int diff, char curr) {
        for (int i = 0; i < diff; ++i) {
            result.append("(");
            open.incrementAndGet();
        }
        result.append(curr);
    }
}