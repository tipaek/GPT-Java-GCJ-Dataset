import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        
        int T = sc.nextInt(); // read the number of test cases
        
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int duplicateRows = 0, duplicateCols = 0;
            Map<Integer, Integer> rowMap = new HashMap<>();
            Map<Integer, Integer> colMap = new HashMap<>();
            
            // Read matrix and check for duplicate rows
            for (int row = 0; row < n; row++) {
                String[] line = sc.nextLine().trim().split("\\s+");
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = Integer.parseInt(line[col]);
                    rowMap.merge(matrix[row][col], 1, Integer::sum);
                }
                if (rowMap.size() != n) {
                    duplicateRows++;
                }
                rowMap.clear();
            }
            
            // Check for duplicate columns
            for (int col = 0; col < n; col++) {
                for (int row = 0; row < n; row++) {
                    colMap.merge(matrix[row][col], 1, Integer::sum);
                }
                if (colMap.size() != n) {
                    duplicateCols++;
                }
                colMap.clear();
            }
            
            // Calculate the trace of the matrix
            int trace = 0;
            for (int diag = 0; diag < n; diag++) {
                trace += matrix[diag][diag];
            }
            
            out.println("Case #" + (i + 1) + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
        
        out.close();
    }
    
    public static class MyScanner {
        private BufferedReader br;
        private StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        private String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
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