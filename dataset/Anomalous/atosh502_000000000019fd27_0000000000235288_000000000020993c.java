import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();
        int size;
        int[][] matrix = new int[100][100];
        
        for (int t = 1; t <= testCases; ++t) {
            size = reader.nextInt();

            for (int i = 0; i < size; ++i) {
                for (int j = 0; j < size; ++j) {
                    matrix[i][j] = reader.nextInt();
                }
            }

            // Calculate the trace of the matrix
            int trace = 0;
            for (int i = 0; i < size; ++i) {
                trace += matrix[i][i];
            }

            // Calculate XOR from 1 to n
            int xorValue = 0;
            for (int i = 1; i <= size; ++i) {
                xorValue ^= i;
            }

            // Count rows with duplicates
            int duplicateRows = 0;
            for (int i = 0; i < size; ++i) {
                int rowXor = 0;
                for (int j = 0; j < size; ++j) {
                    rowXor ^= matrix[i][j];
                }
                if (rowXor != xorValue) {
                    duplicateRows++;
                }
            }

            // Count columns with duplicates
            int duplicateColumns = 0;
            for (int i = 0; i < size; ++i) {
                int colXor = 0;
                for (int j = 0; j < size; ++j) {
                    colXor ^= matrix[j][i];
                }
                if (colXor != xorValue) {
                    duplicateColumns++;
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }

    // FastReader class
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