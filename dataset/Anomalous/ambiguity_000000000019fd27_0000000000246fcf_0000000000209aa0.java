import java.util.*;
import java.io.*;

class SolutionHelper {

    public int[][] generateMatrix(int n, int k) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i][i] = k;
        }
        
        List<Integer> elements = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i != k) {
                elements.add(i);
            }
        }
        Collections.sort(elements);
        
        for (int i = 0; i < n; i++) {
            for (int ii = 0, idx = n - i - 1; ii < i; ii++, idx++) {
                matrix[i][ii] = elements.get(idx);
            }
            for (int ii = i + 1, idx = 0; ii < n; ii++, idx++) {
                matrix[i][ii] = elements.get(idx);
            }
        }
        
        return matrix;
    }
}

public class MainSolution {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        
        int testCases = in.nextInt();
        SolutionHelper helper = new SolutionHelper();
        
        for (int t = 1; t <= testCases; t++) {
            int n = in.nextInt();
            int k = in.nextInt();
            
            out.print("Case #" + t + ": ");
            
            if (k % n != 0) {
                out.println("IMPOSSIBLE");
            } else {
                out.println("POSSIBLE");
                int[][] result = helper.generateMatrix(n, k / n);
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        out.print(result[i][j]);
                        if (j < n - 1) {
                            out.print(" ");
                        }
                    }
                    out.println();
                }
            }
        }
        
        out.close();
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
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
    }
}