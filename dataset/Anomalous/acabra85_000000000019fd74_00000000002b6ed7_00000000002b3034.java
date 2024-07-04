import java.io.*;
import java.util.StringTokenizer;

class Solution {
    private final Helper helper;

    static class Helper {
        final BufferedReader reader;
        final PrintWriter writer;
        StringTokenizer tokenizer;

        public Helper(BufferedReader reader, PrintWriter writer) {
            this.reader = reader;
            this.writer = writer;
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(nextToken());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(nextToken());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(nextToken());
        }

        String nextToken() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public void close() throws IOException {
            reader.close();
            writer.flush();
        }
    }

    public Solution(InputStream in, OutputStreamWriter out) {
        this.helper = new Helper(new BufferedReader(new InputStreamReader(in)), new PrintWriter(out));
    }

    public static Solution fromTestFile(String fileName) {
        InputStream resourceStream = Solution.class.getClassLoader().getResourceAsStream(fileName);
        return new Solution(resourceStream, new OutputStreamWriter(System.out));
    }

    private static final String RESULT_FORMAT = "%sCase #%d: %s";

    public static void main(String... args) throws Exception {
        new Solution(System.in, new OutputStreamWriter(System.out)).execute();
    }

    public void execute() throws Exception {
        int testCases = helper.nextInt();
        for (int i = 0; i < testCases; i++) {
            System.out.print(String.format(RESULT_FORMAT, i > 0 ? "\n" : "", i + 1, getResult(helper)));
            helper.writer.flush();
        }
        helper.close();
    }

    private String getResult(Helper helper) throws IOException {
        int n = helper.nextInt();
        String[] patterns = new String[n];
        for (int i = 0; i < n; i++) {
            patterns[i] = helper.nextToken();
        }
        return solve(patterns, patterns[0].indexOf('*'));
    }

    private String solve(String[] patterns, int starIndex) {
        if (starIndex == 0) {
            if (patterns.length == 1) {
                return patterns[0].substring(1);
            } else {
                String pattern = patterns[0].substring(1);
                for (int i = 1; i < patterns.length; i++) {
                    pattern = match(pattern, patterns[i].substring(1));
                    if (pattern == null) {
                        return "*";
                    }
                }
                return pattern;
            }
        }
        return "*";
    }

    private String match(String sub1, String sub2) {
        if (sub1.equals(sub2)) return sub1;
        String larger = sub1.length() > sub2.length() ? sub1 : sub2;
        String smaller = sub1 == larger ? sub2 : sub1;
        return larger.endsWith(smaller) ? larger : null;
    }
}