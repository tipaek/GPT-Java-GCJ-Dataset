
import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    private final static String RESULT = "%sCase #%d: %d %d %d";

    private final Help help;

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

    static class CheckResult {
        final int k,r,c;

        CheckResult(int k, int r, int c) {
            this.k = k;
            this.r = r;
            this.c = c;
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
        for(int i = 1; i <= testCases; i++) {
            CheckResult result = solveCase(help);
            help.out.printf(RESULT, i==1?"":"\n",  i, result.k, result.r, result.c);
            help.out.flush();
        }
        help.close();
    }

    private CheckResult solveCase(Help help) throws IOException {
        int n = help.nInt();
        int k = 0; //trace
        int r = 0;
        int c = 0;
        int curr = -1;
        int[][] matrix = initializeMatrix(n);
        Set<Integer> rowSet = new HashSet<>(n);
        for (int i = 0; i < n; ++i) {
            rowSet.clear();
            for (int j = 0; j < n; ++j) {
                curr = help.nInt();
                if (i==j) {
                    k += curr;
                }
                matrix[i][j] = curr;
                rowSet.add(curr);
            }
            if (n != rowSet.size()) {
                ++r;
            }
        }
        //check columns
        Set<Integer> colSet = rowSet;
        for (int i = 0; i < n; i++) {
            colSet.clear();
            for (int j = 0; j < n; j++) {
                colSet.add(matrix[j][i]);
            }
            if (n != colSet.size()) {
                c++;
            }
        }
        return new CheckResult(k, r, c);
    }

    private int[][] initializeMatrix(int n) {
        int[][] matrix = new int[n][];
        for (int i = 0; i < n; i++) {
            matrix[i] = new int[n];
        }
        return matrix;
    }
}