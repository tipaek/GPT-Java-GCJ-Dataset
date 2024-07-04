import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {

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

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int testCases = sc.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            // Read matrix and calculate trace and row duplicates
            for (int i = 0; i < n; i++) {
                HashMap<Integer, Boolean> rowCheck = new HashMap<>();
                boolean rowHasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (rowCheck.containsKey(matrix[i][j])) {
                        rowHasDuplicate = true;
                    } else {
                        rowCheck.put(matrix[i][j], true);
                    }
                }
                if (rowHasDuplicate) {
                    rowDuplicates++;
                }
            }

            // Calculate column duplicates
            for (int j = 0; j < n; j++) {
                HashMap<Integer, Boolean> colCheck = new HashMap<>();
                boolean colHasDuplicate = false;
                for (int i = 0; i < n; i++) {
                    if (colCheck.containsKey(matrix[i][j])) {
                        colHasDuplicate = true;
                        break;
                    } else {
                        colCheck.put(matrix[i][j], true);
                    }
                }
                if (colHasDuplicate) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}