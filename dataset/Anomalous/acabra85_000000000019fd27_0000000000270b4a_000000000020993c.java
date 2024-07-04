import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    private static final String RESULT_TEMPLATE = "%sCase #%d: %d %d %d";

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

    static class Result {
        final int trace;
        final int duplicateRows;
        final int duplicateCols;

        Result(int trace, int duplicateRows, int duplicateCols) {
            this.trace = trace;
            this.duplicateRows = duplicateRows;
            this.duplicateCols = duplicateCols;
        }
    }

    public static Solution createForConsole() {
        return new Solution(System.in, new OutputStreamWriter(System.out));
    }

    public static Solution createForTestFile(String fileName) {
        InputStream resourceStream = Solution.class.getClassLoader().getResourceAsStream(fileName);
        return new Solution(resourceStream, new OutputStreamWriter(System.out));
    }

    public Solution(InputStream input, OutputStreamWriter output) {
        this.helper = new Helper(new BufferedReader(new InputStreamReader(input)), new PrintWriter(output));
    }

    public static void main(String... args) throws Exception {
        new Solution(System.in, new OutputStreamWriter(System.out)).execute();
    }

    public void execute() throws Exception {
        int testCases = helper.nextInt();
        for (int i = 1; i <= testCases; i++) {
            Result result = processCase(helper);
            helper.writer.printf(RESULT_TEMPLATE, i == 1 ? "" : "\n", i, result.trace, result.duplicateRows, result.duplicateCols);
            helper.writer.flush();
        }
        helper.close();
    }

    private Result processCase(Helper helper) throws IOException {
        int size = helper.nextInt();
        int trace = 0;
        int duplicateRows = 0;
        int duplicateCols = 0;

        int[][] matrix = new int[size][size];
        Set<Integer> rowSet = new HashSet<>(size);

        for (int i = 0; i < size; i++) {
            rowSet.clear();
            for (int j = 0; j < size; j++) {
                int value = helper.nextInt();
                if (i == j) {
                    trace += value;
                }
                matrix[i][j] = value;
                rowSet.add(value);
            }
            if (rowSet.size() != size) {
                duplicateRows++;
            }
        }

        Set<Integer> colSet = new HashSet<>(size);
        for (int j = 0; j < size; j++) {
            colSet.clear();
            for (int i = 0; i < size; i++) {
                colSet.add(matrix[i][j]);
            }
            if (colSet.size() != size) {
                duplicateCols++;
            }
        }

        return new Result(trace, duplicateRows, duplicateCols);
    }
}