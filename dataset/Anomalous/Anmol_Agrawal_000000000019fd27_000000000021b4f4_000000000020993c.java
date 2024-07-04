import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter w = new PrintWriter(System.out);
        int t = sc.nextInt();
        
        for (int tt = 1; tt <= t; tt++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }
            
            int rowRepeatCount = 0;
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n];
                for (int j = 0; j < n; j++) {
                    if (seen[matrix[i][j] - 1]) {
                        rowRepeatCount++;
                        break;
                    }
                    seen[matrix[i][j] - 1] = true;
                }
            }
            
            int columnRepeatCount = 0;
            for (int j = 0; j < n; j++) {
                boolean[] seen = new boolean[n];
                for (int i = 0; i < n; i++) {
                    if (seen[matrix[i][j] - 1]) {
                        columnRepeatCount++;
                        break;
                    }
                    seen[matrix[i][j] - 1] = true;
                }
            }
            
            w.println("Case #" + tt + ": " + trace + " " + rowRepeatCount + " " + columnRepeatCount);
        }
        w.close();
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