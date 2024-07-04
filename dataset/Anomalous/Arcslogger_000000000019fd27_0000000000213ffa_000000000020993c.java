import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class MatrixAnalysis {

    public static void main(String[] args) {
        FastReader reader = new FastReader();

        int T = reader.nextInt();
        for (int i = 0; i < T; i++) {
            int N = reader.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0, rowCount = 0, colCount = 0;

            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    matrix[row][col] = reader.nextInt();
                }
            }

            for (int j = 0; j < N; j++) {
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();
                boolean rowDuplicate = false, colDuplicate = false;

                for (int k = 0; k < N; k++) {
                    if (!rowSet.add(matrix[j][k]) && !rowDuplicate) {
                        rowCount++;
                        rowDuplicate = true;
                    }
                    if (!colSet.add(matrix[k][j]) && !colDuplicate) {
                        colCount++;
                        colDuplicate = true;
                    }
                    if (j == k) {
                        trace += matrix[j][k];
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowCount + " " + colCount);
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
                if (st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}