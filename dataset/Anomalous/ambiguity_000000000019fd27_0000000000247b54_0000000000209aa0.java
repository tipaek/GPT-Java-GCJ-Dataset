import java.util.*;
import java.io.*;

class Solution {

    public int[][] solve(int n, int k) {
        int[][] res = new int[n][n];
        List<Integer> els = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            if (i != k) {
                els.add(i);
            }
        }
        
        Collections.sort(els);
        
        for (int i = 0; i < n; i++) {
            res[i][i] = k;
            for (int j = 0, idx = n - i - 1; j < i; j++, idx++) {
                res[i][j] = els.get(idx);
            }
            for (int j = i + 1, idx = 0; j < n; j++, idx++) {
                res[i][j] = els.get(idx);
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        int tests = in.nextInt();
        Solution sol = new Solution();
        
        for (int t = 1; t <= tests; t++) {
            int n = in.nextInt();
            int k = in.nextInt();
            out.print("Case #" + t + ": ");
            
            if (k % n != 0) {
                out.println("IMPOSSIBLE");
            } else {
                out.println("POSSIBLE");
                int[][] res = sol.solve(n, k / n);
                for (int[] row : res) {
                    for (int j = 0; j < n; j++) {
                        out.print(row[j]);
                        if (j < n - 1) {
                            out.print(" ");
                        }
                    }
                    out.println();
                }
            }
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