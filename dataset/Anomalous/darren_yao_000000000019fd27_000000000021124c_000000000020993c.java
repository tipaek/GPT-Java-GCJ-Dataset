import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        private String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
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
    }

    private static InputReader inputReader = new InputReader(System.in);
    private static PrintWriter outputWriter = new PrintWriter(System.out);

    public static void main(String[] args) {
        int testCases = inputReader.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = inputReader.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = inputReader.nextInt();
                }
            }
            int trace = calculateTrace(matrix, n);
            int repeatedRows = countRepeatedRows(matrix, n);
            int repeatedCols = countRepeatedCols(matrix, n);
            outputWriter.println(String.format("Case #%d: %d %d %d", testCase, trace, repeatedRows, repeatedCols));
        }
        outputWriter.close();
    }

    private static int calculateTrace(int[][] matrix, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRepeatedRows(int[][] matrix, int n) {
        int repeatedRows = 0;
        for (int i = 0; i < n; i++) {
            HashSet<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < n; j++) {
                uniqueElements.add(matrix[i][j]);
            }
            if (uniqueElements.size() < n) {
                repeatedRows++;
            }
        }
        return repeatedRows;
    }

    private static int countRepeatedCols(int[][] matrix, int n) {
        int repeatedCols = 0;
        for (int i = 0; i < n; i++) {
            HashSet<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < n; j++) {
                uniqueElements.add(matrix[j][i]);
            }
            if (uniqueElements.size() < n) {
                repeatedCols++;
            }
        }
        return repeatedCols;
    }
}

/**
*                _        _                 _                                                
*               | |      | |               | |                                               
*   ___ ___   __| | ___  | |__  _   _    __| | __ _ _ __ _ __ ___ _ __     _   _  __ _  ___  
*  / __/ _ \ / _` |/ _ \ | '_ \| | | |  / _` |/ _` | '__| '__/ _ \ '_ \   | | | |/ _` |/ _ \ 
* | (_| (_) | (_| |  __/ | |_) | |_| | | (_| | (_| | |  | | |  __/ | | |  | |_| | (_| | (_) |
*  \___\___/ \__,_|\___| |_.__/ \__, |  \__,_|\__,_|_|  |_|  \___|_| |_|   \__, |\__,_|\___/ 
*                                __/ |                               ______ __/ |            
*                               |___/                               |______|___/             
 */