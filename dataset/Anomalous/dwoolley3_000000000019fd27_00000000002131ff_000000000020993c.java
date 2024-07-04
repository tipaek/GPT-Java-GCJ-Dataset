import java.io.*;
import java.math.*;
import java.util.*;

public class GCJ_2020_QR_A {
    FastReader in;
    PrintWriter out;

    public static void main(String[] args) throws IOException {
        new GCJ_2020_QR_A().run();
    }

    void run() {
        in = new FastReader(System.in);
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    void solve() {
        int T = in.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int n = in.nextInt();
            int duplicateRows = 0, duplicateColumns = 0;
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = in.nextInt();
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() < n) {
                    duplicateRows++;
                }
            }

            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            for (int i = 0; i < n; i++) {
                Set<Integer> columnSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    columnSet.add(matrix[j][i]);
                }
                if (columnSet.size() < n) {
                    duplicateColumns++;
                }
            }

            String result = trace + " " + duplicateRows + " " + duplicateColumns;
            out.println("Case #" + tc + ": " + result);
        }
    }

    class FastReader {
        BufferedReader br;
        StringTokenizer tokenizer;

        public FastReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public FastReader(File file) {
            try {
                br = new BufferedReader(new FileReader(file));
                tokenizer = null;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        private String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public BigInteger nextBigInteger() {
            return new BigInteger(next());
        }

        public BigDecimal nextBigDecimal() {
            return new BigDecimal(next());
        }
    }
}