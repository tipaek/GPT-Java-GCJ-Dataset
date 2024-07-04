import java.util.*;
import java.io.*;

class Solution {

    public int[] solve(int[][] mat, int n) {
        int[] result = new int[3];
        
        // Calculate the sum of the main diagonal
        for (int i = 0; i < n; i++) {
            result[0] += mat[i][i];
        }

        // Count rows with duplicate elements
        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!rowSet.add(mat[i][j])) {
                    result[1]++;
                    break;
                }
            }
        }

        // Count columns with duplicate elements
        for (int j = 0; j < n; j++) {
            Set<Integer> colSet = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (!colSet.add(mat[i][j])) {
                    result[2]++;
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        int testCases = in.nextInt();
        Solution solver = new Solution();

        while (testCases-- > 0) {
            int n = in.nextInt();
            int[][] mat = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = in.nextInt();
                }
            }
            int[] result = solver.solve(mat, n);
            out.println(result[0] + " " + result[1] + " " + result[2]);
        }

        out.close();
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
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
}