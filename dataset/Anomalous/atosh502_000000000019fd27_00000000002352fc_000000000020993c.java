import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Vestigium {

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();
        int matrixSize;
        int[][] matrix = new int[100][100];
        
        for (int testCase = 1; testCase <= testCases; ++testCase) {
            matrixSize = reader.nextInt();

            for (int i = 0; i < matrixSize; ++i) {
                for (int j = 0; j < matrixSize; ++j) {
                    matrix[i][j] = reader.nextInt();
                }
            }

            // Calculate the trace of the matrix
            int trace = 0;
            for (int i = 0; i < matrixSize; ++i) {
                trace += matrix[i][i];
            }

            int expectedXor = 0;
            for (int i = 1; i <= matrixSize; ++i) {
                expectedXor ^= i;
            }

            // Count rows with duplicates
            int duplicateRows = 0;
            for (int i = 0; i < matrixSize; ++i) {
                int rowXor = 0;
                for (int j = 0; j < matrixSize; ++j) {
                    rowXor ^= matrix[i][j];
                }
                if (rowXor != expectedXor) {
                    duplicateRows++;
                }
            }

            // Count columns with duplicates
            int duplicateColumns = 0;
            for (int i = 0; i < matrixSize; ++i) {
                int colXor = 0;
                for (int j = 0; j < matrixSize; ++j) {
                    colXor ^= matrix[j][i];
                }
                if (colXor != expectedXor) {
                    duplicateColumns++;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
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