//package CodeJam.Qualification2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        int t = in.NI();
        for (int z=1;z<=t;z++) {
            int n = in.NI();
            int[][] input = new int[n][n];
            for (int i=0;i<n;i++) for (int j=0;j<n;j++) input[i][j] = in.NI();
            int tsum = 0; for (int i=0;i<n;i++) tsum += input[i][i];
            int rc = 0; int cc = 0;

            for (int i=0;i<n;i++) {
                int[] hash = new int[n+1];
                Arrays.fill(hash, 0);
                for (int j=0;j<n;j++) hash[input[i][j]]++;
                for (int j=1;j<=n;j++) if (hash[j]>1) { rc++; break; }
            }

            for (int j=0;j<n;j++) {
                int[] hash = new int[n+1];
                Arrays.fill(hash, 0);
                for (int i=0;i<n;i++) hash[input[i][j]]++;
                for (int i=1;i<=n;i++) if (hash[i]>1) { cc++; break; }
            }

            out.printf("Case #"+z+": " + tsum + " " + rc + " " + cc + "\n");

        }
        out.close();
    }

    static InputStream inputStream = System.in;
    static OutputStream outputStream = System.out;
    static InputReader in = new InputReader(inputStream);
    static PrintWriter out = new PrintWriter(outputStream);

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

        public int NI() {
            return Integer.parseInt(next());
        }

        public long NL() {
            return Long.parseLong(next());
        }

    }

}
