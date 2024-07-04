
import java.util.*;
import java.io.*;

class Sol {

    public int[][] solve(int n, int k) {
        int rows = n;
        int cols = n;
        int res[][] = new int[n][n];
        for (int i=0;i<rows;i++) {
            res[i][i] = k;
        }
        List<Integer> els = new ArrayList<>();
        for (int i=1;i<=n;i++) {
            if (i==k) {
                continue;
            }
            els.add(i);
        }
        Collections.sort(els);
        for (int i=0;i<rows;i++) {
            for (int ii=0,idx=rows-i-1;ii<i;ii++,idx++) {
                res[i][ii] = els.get(idx);
            }
            for (int ii=i+1,idx=0;ii<cols;ii++,idx++) {
                res[i][ii] = els.get(idx);
            }
        }
        return res;
    }

}

public class Solution {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        int tests = in.nextInt();
        Sol s = new Sol();
        for (int tt = 1; tt <= tests; tt++) {
            int n = in.nextInt();
            int k = in.nextInt();
            String val = "";
            out.print("Case #" + tt + ": ");
            if (k%n != 0)  {
                out.println("IMPOSSIBLE");
            } else {
                out.println("POSSIBLE");
                int[][] res = s.solve(n, k/n);
                for (int i=0;i<n;i++) {
                    for (int j=0;j<n;j++) {
                        out.print(res[i][j]);
                        if (j < n-1) {
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
