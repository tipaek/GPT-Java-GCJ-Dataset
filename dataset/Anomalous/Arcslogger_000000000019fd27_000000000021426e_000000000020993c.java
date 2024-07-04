import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class MatrixAnalysis {

    public static void main(String[] args) {
        FastReader reader = new FastReader();

        int testCases = reader.nextInt();
        for (int t = 0; t < testCases; t++) {
            int size = reader.nextInt();
            int[][] matrix = new int[size][size];

            int trace = 0, duplicateRows = 0, duplicateCols = 0;

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = reader.nextInt();
                }
            }

            for (int i = 0; i < size; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();
                boolean rowHasDuplicates = false, colHasDuplicates = false;

                for (int j = 0; j < size; j++) {
                    if (!rowSet.add(matrix[i][j]) && !rowHasDuplicates) {
                        duplicateRows++;
                        rowHasDuplicates = true;
                    }
                    if (!colSet.add(matrix[j][i]) && !colHasDuplicates) {
                        duplicateCols++;
                        colHasDuplicates = true;
                    }
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + trace + " " + duplicateRows + " " + duplicateCols);
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