import java.util.*;
import java.io.*;

class Solution {

    public int[] solve(int[][] mat, int n) {
        int[] res = new int[3];
        for (int i = 0; i < n; i++) {
            res[0] += mat[i][i];
        }
        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (rowSet.contains(mat[i][j])) {
                    res[1]++;
                    break;
                }
                rowSet.add(mat[i][j]);
            }
        }
        for (int j = 0; j < n; j++) {
            Set<Integer> colSet = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (colSet.contains(mat[i][j])) {
                    res[2]++;
                    break;
                }
                colSet.add(mat[i][j]);
            }
        }
        return res;
    }

}

public class MainClass {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        int testCases = in.nextInt();
        Solution solution = new Solution();
        while (testCases-- > 0) {
            int n = in.nextInt();
            int[][] mat = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = in.nextInt();
                }
            }
            int[] result = solution.solve(mat, n);
            out.println(result[0] + " " + result[1] + " " + result[2]);
        }
        out.close();
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

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