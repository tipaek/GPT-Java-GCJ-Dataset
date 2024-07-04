import java.io.*;
import java.util.*;

public class CodeJam {
    public static void main(String[] args) throws IOException {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        
        int T = sc.nextInt(); // read input as integer

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int rowDuplicates = 0, colDuplicates = 0;
            HashMap<Integer, Integer> rowMap = new HashMap<>();
            HashMap<Integer, Integer> colMap = new HashMap<>();

            for (int j = 0; j < n; j++) {
                String[] line = sc.nextLine().trim().split("\\s+");
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = Integer.parseInt(line[k]);
                    rowMap.put(matrix[j][k], rowMap.getOrDefault(matrix[j][k], 0) + 1);
                }
                if (rowMap.size() != n) {
                    rowDuplicates++;
                }
                rowMap.clear();
            }

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    colMap.put(matrix[k][j], colMap.getOrDefault(matrix[k][j], 0) + 1);
                }
                if (colMap.size() != n) {
                    colDuplicates++;
                }
                colMap.clear();
            }

            int trace = 0;
            for (int l = 0; l < n; l++) {
                trace += matrix[l][l];
            }
            out.println("Case #" + (i + 1) + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }

        out.close();
    }

    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
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