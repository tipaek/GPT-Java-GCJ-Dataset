import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Vestigium {

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            for (int row = 0; row < matrixSize; row++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean hasRowDuplicate = false;
                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt();
                    if (!rowSet.add(value)) {
                        hasRowDuplicate = true;
                    }
                    matrix[row][col] = value;
                    if (row == col) {
                        trace += value;
                    }
                }
                if (hasRowDuplicate) {
                    duplicateRows++;
                }
            }

            for (int col = 0; col < matrixSize; col++) {
                Set<Integer> colSet = new HashSet<>();
                boolean hasColDuplicate = false;
                for (int row = 0; row < matrixSize; row++) {
                    int value = matrix[row][col];
                    if (!colSet.add(value)) {
                        hasColDuplicate = true;
                    }
                }
                if (hasColDuplicate) {
                    duplicateColumns++;
                }
            }

            System.out.println(trace + " " + duplicateRows + " " + duplicateColumns);
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