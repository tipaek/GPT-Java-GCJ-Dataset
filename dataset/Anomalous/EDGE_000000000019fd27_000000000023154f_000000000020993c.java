import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }
}

class Task {
    public void solve(FastReader in, PrintWriter out) {
        int t = in.nextInt();
        int caseNumber = 1;
        while (t-- > 0) {
            int n = in.nextInt();
            long diagSum = 0;
            long expectedXOR = computeXOR(n);
            long[] columnXOR = new long[n];
            long rowMismatchCount = 0;
            long columnMismatchCount = 0;

            for (int i = 0; i < n; i++) {
                long[] row = new long[n];
                for (int j = 0; j < n; j++) {
                    row[j] = in.nextLong();
                    if (i == j) diagSum += row[j];
                }

                long rowXOR = row[0];
                for (int j = 1; j < n; j++) {
                    rowXOR ^= row[j];
                }
                if (rowXOR != expectedXOR) rowMismatchCount++;

                for (int j = 0; j < n; j++) {
                    columnXOR[j] ^= row[j];
                }
            }

            for (long colXOR : columnXOR) {
                if (colXOR != expectedXOR) columnMismatchCount++;
            }

            out.printf("Case #%d: %d %d %d%n", caseNumber++, diagSum, rowMismatchCount, columnMismatchCount);
        }
    }

    private int computeXOR(int n) {
        switch (n % 4) {
            case 0: return n;
            case 1: return 1;
            case 2: return n + 1;
            default: return 0;
        }
    }
}

class FastReader {
    private BufferedReader br;
    private StringTokenizer st;

    public FastReader(InputStream inputStream) {
        br = new BufferedReader(new InputStreamReader(inputStream));
    }

    private String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }
}