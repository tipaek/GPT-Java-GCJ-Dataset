import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Vestigium {

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = reader.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean hasRowDuplicate = false;
                for (int j = 0; j < n; j++) {
                    int value = reader.nextInt();
                    if (!rowSet.add(value)) {
                        hasRowDuplicate = true;
                    }
                    matrix[i][j] = value;
                    if (i == j) {
                        trace += value;
                    }
                }
                if (hasRowDuplicate) {
                    rowDuplicates++;
                }
            }

            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean hasColDuplicate = false;
                for (int i = 0; i < n; i++) {
                    int value = matrix[i][j];
                    if (!colSet.add(value)) {
                        hasColDuplicate = true;
                    }
                }
                if (hasColDuplicate) {
                    colDuplicates++;
                }
            }

            System.out.println(trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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
}