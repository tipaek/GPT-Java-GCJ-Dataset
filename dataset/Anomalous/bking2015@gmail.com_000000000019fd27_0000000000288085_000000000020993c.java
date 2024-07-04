import java.io.*;
import java.util.*;

class SolutionGCJ {

    public void solve(FastReader in, PrintWriter out) {
        int testCases = in.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int N = in.nextInt();
            int[][] matrix = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }

            int trace = 0;
            for (int i = 0; i < N; i++) {
                trace += matrix[i][i];
            }

            int rowFailures = 0;
            Set<Integer> seen = new HashSet<>();
            for (int i = 0; i < N; i++) {
                seen.clear();
                for (int j = 0; j < N; j++) {
                    seen.add(matrix[i][j]);
                }
                if (seen.size() != N) {
                    rowFailures++;
                }
            }

            int colFailures = 0;
            for (int j = 0; j < N; j++) {
                seen.clear();
                for (int i = 0; i < N; i++) {
                    seen.add(matrix[i][j]);
                }
                if (seen.size() != N) {
                    colFailures++;
                }
            }

            out.printf("Case #%d: %d %d %d%n", testCase, trace, rowFailures, colFailures);
        }
    }
}

public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        new SolutionGCJ().solve(in, out);
        out.flush();
        out.close();
    }
}

class FastReader {
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
            System.exit(0);
        }
        return str;
    }
}