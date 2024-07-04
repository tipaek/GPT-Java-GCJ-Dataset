import java.io.*;
import java.util.*;

class Vestiguim {
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

    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = reader.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    int value = reader.nextInt();
                    matrix[i][j] = value;
                    if (rowSet.contains(value)) {
                        rowHasDuplicate = true;
                    }
                    rowSet.add(value);
                    if (i == j) {
                        trace += value;
                    }
                }
                if (rowHasDuplicate) {
                    rowDuplicates++;
                }
            }

            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean colHasDuplicate = false;
                for (int i = 0; i < n; i++) {
                    int value = matrix[i][j];
                    if (colSet.contains(value)) {
                        colHasDuplicate = true;
                    }
                    colSet.add(value);
                }
                if (colHasDuplicate) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}