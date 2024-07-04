import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static final int MAX = 105;

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int t = reader.nextInt();
        boolean[][] used = new boolean[MAX][MAX];
        int[][] matrix = new int[MAX][MAX];
        int testCaseNumber = 0;

        while (t-- > 0) {
            testCaseNumber++;
            int n = reader.nextInt();
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    used[i][j] = false;
                    matrix[i][j] = reader.nextInt();
                }
            }

            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            // Check for row duplicates
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    int element = matrix[i][j];
                    if (used[i][element]) {
                        rowDuplicates++;
                        break;
                    }
                    used[i][element] = true;
                }
            }

            // Reset the used array
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    used[i][j] = false;
                }
            }

            // Check for column duplicates
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    int element = matrix[j][i];
                    if (used[element][i]) {
                        colDuplicates++;
                        break;
                    }
                    used[element][i] = true;
                }
            }

            // Calculate the trace
            for (int i = 1; i <= n; i++) {
                trace += matrix[i][i];
            }

            System.out.println("Case #" + testCaseNumber + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }

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
}