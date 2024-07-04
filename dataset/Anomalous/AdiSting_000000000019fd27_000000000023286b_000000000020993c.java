import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static class FastReader {
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

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        int caseNumber = 1;
        StringBuilder output = new StringBuilder();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            int duplicateRows = 0;
            int duplicateColumns = 0;

            for (int i = 0; i < n; i++) {
                Map<Integer, Integer> rowMap = new HashMap<>();
                for (int j = 0; j < n; j++) {
                    rowMap.put(matrix[i][j], rowMap.getOrDefault(matrix[i][j], 0) + 1);
                }
                if (rowMap.values().stream().anyMatch(count -> count > 1)) {
                    duplicateRows++;
                }
            }

            for (int j = 0; j < n; j++) {
                Map<Integer, Integer> colMap = new HashMap<>();
                for (int i = 0; i < n; i++) {
                    colMap.put(matrix[i][j], colMap.getOrDefault(matrix[i][j], 0) + 1);
                }
                if (colMap.values().stream().anyMatch(count -> count > 1)) {
                    duplicateColumns++;
                }
            }

            output.append(String.format("Case #%d: %d %d %d%n", caseNumber++, trace, duplicateRows, duplicateColumns));
        }

        System.out.print(output);
    }
}