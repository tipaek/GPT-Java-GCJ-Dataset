import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    private static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static final int LIMIT = 101;

    public static void main(final String[] args) throws IOException {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);

        int[] rowFrequency = new int[LIMIT];
        int[][] colFrequency = new int[LIMIT][LIMIT];
        int n, v;
        int k, r, c;
        boolean badRow;
        boolean[] badCol = new boolean[LIMIT];

        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            Arrays.fill(rowFrequency, 0);
            for (int j = 0; j < LIMIT; j++) {
                Arrays.fill(colFrequency[j], 0);
            }
            Arrays.fill(badCol, false);

            k = 0;
            r = 0;
            c = 0;

            n = in.nextInt();
            for (int row = 1; row <= n; row++) {
                badRow = false;
                for (int col = 1; col <= n; col++) {
                    v = in.nextInt();
                    if (row == col) {
                        k += v;
                    }
                    rowFrequency[v]++;
                    if (rowFrequency[v] > row) {
                        badRow = true;
                    }
                    colFrequency[col][v]++;
                    if (colFrequency[col][v] > 1) {
                        badCol[col] = true;
                    }
                }
                if (badRow) {
                    r++;
                }
            }

            for (int col = 1; col <= n; col++) {
                if (badCol[col]) {
                    c++;
                }
            }

            out.printf("Case #%d: %d %d %d%n", i, k, r, c);
        }
    }
}
