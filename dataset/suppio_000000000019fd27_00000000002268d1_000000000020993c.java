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

        int[][] m = new int[LIMIT][LIMIT];
        int[] frequency = new int[LIMIT];
        int n;
        int k, r, c;
        boolean badRow;

        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            for (int j = 0; j < LIMIT; j++) {
                Arrays.fill(m[j], 0);
            }

            k = 0;
            r = 0;
            c = 0;
            n = in.nextInt();

            for (int row = 1; row <= n; row++) {
                Arrays.fill(frequency, 0);
                badRow = false;

                for (int col = 1; col <= n; col++) {
                    m[row][col] = in.nextInt();
                    if (row == col) {
                        k += m[row][col];
                    }
                    frequency[m[row][col]]++;
                    if (frequency[m[row][col]] > 1) {
                        badRow = true;
                    }
                }
                if (badRow) {
                    r++;
                }
            }

            for (int col = 1; col <= n; col++) {
                Arrays.fill(frequency, 0);
                for (int val = 1; val <= n; val++) {
                    frequency[m[val][col]]++;
                    if (frequency[m[val][col]] > 1) {
                        c++;
                        break;
                    }
                }
            }

            out.printf("Case #%d: %d %d %d%n", i, k, r, c);
        }
    }
}
