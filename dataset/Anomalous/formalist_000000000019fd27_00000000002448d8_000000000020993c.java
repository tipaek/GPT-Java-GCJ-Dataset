import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        VestigiumSolver solver = new VestigiumSolver();
        solver.solve(1, in, out);
        out.close();
    }
}

class VestigiumSolver {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int t = in.nextInt();
        int caseNumber = 0;
        
        while (t-- > 0) {
            caseNumber++;
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            int rowRepeats = 0, colRepeats = 0, trace = 0;
            
            for (int i = 0; i < n; i++) {
                int[] rowCount = new int[n];
                boolean rowValid = true;
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = in.nextInt();
                    rowCount[matrix[i][j] - 1]++;
                    if (rowCount[matrix[i][j] - 1] > 1) {
                        rowValid = false;
                    }
                }
                if (!rowValid) rowRepeats++;
            }
            
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }
            
            for (int i = 0; i < n; i++) {
                int[] colCount = new int[n];
                boolean colValid = true;
                for (int j = 0; j < n; j++) {
                    colCount[matrix[j][i] - 1]++;
                    if (colCount[matrix[j][i] - 1] > 1) {
                        colValid = false;
                    }
                }
                if (!colValid) colRepeats++;
            }
            
            out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}

class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

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