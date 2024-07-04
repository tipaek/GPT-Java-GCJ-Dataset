import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            solver.solve(i + 1, in, out);
        }
        out.close();
    }

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int sum = in.nextInt();
            int[][] res = new int[n][n];

            if(generateN(n, sum, 0, new int[n][n], res)){
                out.println("Case #" + testNumber + ": POSSIBLE");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        out.print(res[i][j] + " ");
                    }
                    out.println();
                }
                return;
            };

            out.println("Case #" + testNumber + ": IMPOSSIBLE");
        }

        public boolean solvePuzzle(int[][] dp, int n, int x, int y, int[][] res){

            if(x == n) return true;
            if(y == n) return solvePuzzle(dp, n, x + 1, 0, res);
            if(x == y) return solvePuzzle(dp, n, x, y + 1, res);


            for(int i = 1; i <= n; i++){
                dp[x][y] = i;
                if(checkHorizontal(dp, n, x) && checkVertical(dp, n, y)){
                    if(solvePuzzle(dp, n, x, y + 1, res)){
                        for(int ii = 0; ii < n; ii++){
                            for(int jj = 0; jj < n; jj++){
                                res[ii][jj] = dp[ii][jj];
                            }
                        }
                        return true;
                    }
                }
                dp[x][y] = 0;
            }

            return false;
        }


        public boolean  generateN(int n, int sum, int x, int[][] dp, int[][] res){
                if(x == n){
                    if(sum == 0) {
                        return solvePuzzle(dp, n, 0, 0, res);
                    }
                    return false;
                }

                for(int i = 1; i <= n; i++){
                    dp[x][x] = i;
                    if(generateN(n, sum - i, x + 1, dp, res)) return true;
                    dp[x][x] = 0;
                }

                 return false;
        }

        public boolean checkHorizontal(int[][] dp, int n, int x){
            Set<Integer> set = new HashSet<>();

            for(int i = 0; i < n; i++){
                if(dp[x][i] == 0) continue;
                if(!set.add(dp[x][i])) return false;
            }
            return true;
        }


        public boolean checkVertical(int[][] dp, int n, int y){
            Set<Integer> set = new HashSet<>();

            for(int i = 0; i < n; i++){
                if(dp[i][y] == 0) continue;
                if(!set.add(dp[i][y])) return false;
            }
            return true;
        }

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