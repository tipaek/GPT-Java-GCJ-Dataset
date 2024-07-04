import java.io.*;
import java.util.StringTokenizer;

public class Solution {
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
        new Solution(System.in, new OutputStreamWriter(System.out)).processInput();
    }

    public void processInput() throws Exception {
        int testCases = helper.nextInt();
        for (int i = 0; i < testCases; ++i) {
            System.out.print(String.format(RESULT_FORMAT, i > 0 ? "\n" : "", i + 1, processTestCase(helper)));
            helper.writer.flush();
        }
        helper.close();
    }

    private String processTestCase(Helper helper) throws IOException {
        int n = helper.nextInt();
        String[] patterns = new String[n];
        for (int i = 0; i < n; ++i) {
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
                for (int i = 1; i < patterns.length; ++i) {
                    pattern = matchStrings(pattern, patterns[i].substring(1), false);
                    if (pattern == null) {
                        return "*";
                    }
                }
                return pattern;
            }
        } else if (hasOnlyOneWildcard(patterns[0], starIndex)) {
            PatternParts part1 = PatternParts.from(patterns[0], starIndex);
            PatternParts part2;
            for (int i = 1; i < patterns.length; ++i) {
                part2 = PatternParts.from(patterns[i], patterns[i].indexOf('*'));
                String s1 = matchStrings(part1.prefix, part2.prefix, true);
                if (s1 == null) return "*";
                String s2 = matchStrings(part1.suffix, part2.suffix, false);
                if (s2 == null) return "*";
                part1 = new PatternParts(s1, s2);
            }
            return part1.toString();
        }
        return "*";
    }

    private boolean hasOnlyOneWildcard(String s, int starIndex) {
        return s.indexOf('*', starIndex + 1) == -1;
    }

    static class PatternParts {
        final String prefix, suffix;

        PatternParts(String prefix, String suffix) {
            this.prefix = prefix;
            this.suffix = suffix;
        }

        @Override
        public String toString() {
            return prefix + suffix;
        }

        public static PatternParts from(String s, int starIndex) {
            String prefix = s.substring(0, starIndex);
            String suffix = s.substring(starIndex + 1);
            return new PatternParts(prefix, suffix);
        }
    }

    private String matchStrings(String str1, String str2, boolean isPrefix) {
        if (str1.equals(str2)) return str1;
        if (str1.length() == str2.length()) return null;
        String longer = str1.length() > str2.length() ? str1 : str2;
        String shorter = str1.length() > str2.length() ? str2 : str1;
        if (isPrefix) {
            return longer.startsWith(shorter) ? longer : null;
        }
        return longer.endsWith(shorter) ? longer : null;
    }
}