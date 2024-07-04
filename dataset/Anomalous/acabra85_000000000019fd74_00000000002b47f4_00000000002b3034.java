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

        private String nextToken() throws IOException {
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

    public Solution(InputStream input, OutputStreamWriter output) {
        this.helper = new Helper(new BufferedReader(new InputStreamReader(input)), new PrintWriter(output));
    }

    public static Solution fromTestFile(String fileName) {
        InputStream resourceStream = Solution.class.getClassLoader().getResourceAsStream(fileName);
        return new Solution(resourceStream, new OutputStreamWriter(System.out));
    }

    private static final String RESULT_TEMPLATE = "%sCase #%d: %s";

    public static void main(String... args) throws Exception {
        new Solution(System.in, new OutputStreamWriter(System.out)).process();
    }

    public void process() throws Exception {
        int testCases = helper.nextInt();
        for (int i = 0; i < testCases; i++) {
            System.out.print(String.format(RESULT_TEMPLATE, i > 0 ? "\n" : "", i + 1, computeResult(helper)));
            helper.writer.flush();
        }
        helper.close();
    }

    private String computeResult(Helper helper) throws IOException {
        int n = helper.nextInt();
        String[] patterns = new String[n];
        for (int i = 0; i < n; i++) {
            patterns[i] = helper.nextToken();
        }
        return findSolution(patterns, patterns[0].indexOf('*'));
    }

    private String findSolution(String[] patterns, int starIndex) {
        if (starIndex == 0) {
            if (patterns.length == 1) {
                return patterns[0].substring(1);
            } else {
                String pattern = patterns[0].substring(1);
                for (int i = 1; i < patterns.length - 1; i++) {
                    pattern = matchPatterns(pattern, patterns[i].substring(1));
                    if (pattern == null) {
                        return "*";
                    }
                }
                return pattern;
            }
        }
        return "*";
    }

    private String matchPatterns(String pattern1, String pattern2) {
        return pattern1.contains(pattern2) || pattern2.contains(pattern1) ? 
               (pattern1.length() > pattern2.length() ? pattern1 : pattern2) : null;
    }
}