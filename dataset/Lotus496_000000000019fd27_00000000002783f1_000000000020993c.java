import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    /**
     * @param args the command line arguments
     */
    private static boolean hasDuplicatesInRow(int[][] matrix, int row) {
        int n = matrix.length;
        int[] tally = new int[n];
        for (int i = 0; i < n; i++) {
            tally[matrix[row][i]-1]++;
        }
        for (int i = 0; i < n; i++) {
            if (tally[i] == 0) return true;
        }
        return false;
    }
    private static boolean hasDuplicatesInCol(int[][] matrix, int col) {
        int n = matrix.length;
        int[] tally = new int[n];
        for (int i = 0; i < n; i++) {
            tally[matrix[i][col]-1]++;
        }
        for (int i = 0; i < n; i++) {
            if (tally[i] == 0) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int t = scanner.nextInt();
        for (int k = 0; k < t; k++) {
            
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int rowCount = 0;
            int colCount = 0;
            int traceVal = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            for (int i = 0; i < n; i++) {
                traceVal += matrix[i][i];                                    
            }
            for (int i = 0; i < n; i++) {
                if (hasDuplicatesInRow(matrix,i)) rowCount++;
            }
            for (int i = 0; i < n; i++) {
                if (hasDuplicatesInCol(matrix,i)) colCount++;    
            }

            String result = "" + traceVal + " " + rowCount + " " + colCount;
            System.out.println("Case #" + (k+1) + ": " + result);        
        }
                
    }
        static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
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
    }

}
