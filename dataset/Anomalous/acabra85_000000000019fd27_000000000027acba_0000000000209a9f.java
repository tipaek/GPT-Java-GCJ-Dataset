import java.io.*;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
    private static final String RESULT_FORMAT = "%sCase #%d: %s";

    private final Helper helper;

    static class Helper {
        private final BufferedReader reader;
        private final PrintWriter writer;
        private StringTokenizer tokenizer;

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

    public static Solution fromConsole() {
        return new Solution(System.in, new OutputStreamWriter(System.out));
    }

    public static Solution fromTestFile(String fileName) {
        InputStream resourceStream = Solution.class.getClassLoader().getResourceAsStream(fileName);
        return new Solution(resourceStream, new OutputStreamWriter(System.out));
    }

    public Solution(InputStream inputStream, OutputStreamWriter outputStreamWriter) {
        this.helper = new Helper(new BufferedReader(new InputStreamReader(inputStream)), new PrintWriter(outputStreamWriter));
    }

    public static void main(String... args) throws Exception {
        new Solution(System.in, new OutputStreamWriter(System.out)).processInput();
    }

    public void processInput() throws Exception {
        int testCases = helper.nextInt();
        for (int i = 1; i <= testCases; i++) {
            String result = solveCase(helper.nextToken());
            helper.writer.printf(RESULT_FORMAT, i == 1 ? "" : "\n", i, result);
            helper.writer.flush();
        }
        helper.close();
    }

    protected static String solveCase(String input) {
        char[] characters = input.toCharArray();
        StringBuilder result = new StringBuilder();
        AtomicInteger openParentheses = new AtomicInteger(0);

        if (characters[0] > 0) {
            addParentheses(openParentheses, result, characters[0] - '0', characters[0]);
        }

        char previousChar = characters[0];
        char currentChar;
        for (int i = 1; i < characters.length; i++) {
            currentChar = characters[i];
            if (previousChar == currentChar) {
                result.append(currentChar);
            } else if (previousChar > currentChar) {
                removeParentheses(openParentheses, result, previousChar - currentChar, currentChar);
            } else {
                addParentheses(openParentheses, result, currentChar - previousChar, currentChar);
            }
            previousChar = currentChar;
        }
        removeParentheses(openParentheses, result, openParentheses.get(), '\0');
        return result.toString();
    }

    private static void removeParentheses(AtomicInteger openParentheses, StringBuilder result, int count, char currentChar) {
        for (int i = 0; i < count; i++) {
            result.append(")");
            openParentheses.decrementAndGet();
        }
        if (currentChar != '\0') {
            result.append(currentChar);
        }
    }

    private static void addParentheses(AtomicInteger openParentheses, StringBuilder result, int count, char currentChar) {
        for (int i = 0; i < count; i++) {
            result.append("(");
            openParentheses.incrementAndGet();
        }
        result.append(currentChar);
    }
}