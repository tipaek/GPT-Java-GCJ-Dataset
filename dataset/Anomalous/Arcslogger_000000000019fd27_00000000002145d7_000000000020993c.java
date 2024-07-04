import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int T = reader.nextInt();
        
        for (int t = 0; t < T; t++) {
            int N = reader.nextInt();
            int[][] matrix = new int[N][N];
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = reader.nextInt();
                }
            }
            
            int trace = 0;
            int rowCount = 0;
            int colCount = 0;
            
            for (int i = 0; i < N; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();
                boolean rowDuplicate = false;
                boolean colDuplicate = false;
                
                for (int j = 0; j < N; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowDuplicate = true;
                    }
                    if (!colSet.add(matrix[j][i])) {
                        colDuplicate = true;
                    }
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
                
                if (rowDuplicate) {
                    rowCount++;
                }
                if (colDuplicate) {
                    colCount++;
                }
            }
            
            System.out.println("Case #" + (t + 1) + ": " + trace + " " + rowCount + " " + colCount);
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