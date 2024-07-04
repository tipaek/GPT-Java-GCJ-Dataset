import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

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
            int t = in.nextInt();
            int[][] m = new int[t][t];
            for(int i = 0; i < t; i++){
                for(int j = 0; j < t; j++){
                    m[i][j] = in.nextInt();
                }
            }
            int k = 0;
            for(int i = 0; i < t; i++){
                    k += m[i][i];
            }

            int r = 0;
            int c = 0;

            for(int i = 0; i < t; i++){
                Set<Integer> row = new HashSet<>();
                Set<Integer> col = new HashSet<>();
                boolean rd = false;
                boolean cd = false;
                for(int j = 0; j < t; j++){
                    if(!row.add(m[i][j])) rd = true;
                    if(!col.add(m[j][i])) cd = true;
                }
                if(rd) r++;
                if(cd) c++;
            }

            out.println("Case #" + testNumber + ": " + k + " " + r + " " + c);
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