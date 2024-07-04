import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        MatrixSolver solver = new MatrixSolver();
        solver.solve(1, in, out);
        out.close();
    }
}

class MatrixSolver {
    public void solve(int testNumber, InputReader sc, PrintWriter out) {
        int t = sc.nextInt();
        for (int test = 1; test <= t; test++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            HashSet<Integer>[] rowSets = new HashSet[n];
            HashSet<Integer>[] colSets = new HashSet[n];
            for (int i = 0; i < n; i++) {
                rowSets[i] = new HashSet<>();
                colSets[i] = new HashSet<>();
            }
            int trace = 0;
            HashSet<Integer> duplicateRows = new HashSet<>();
            HashSet<Integer> duplicateCols = new HashSet<>();
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (!rowSets[i].add(matrix[i][j])) {
                        duplicateRows.add(i);
                    }
                    if (!colSets[j].add(matrix[i][j])) {
                        duplicateCols.add(j);
                    }
                }
            }
            out.println("Case #" + test + ": " + trace + " " + duplicateRows.size() + " " + duplicateCols.size());
        }
    }
}

class InputReader {
    private BufferedReader br;
    private StringTokenizer st;

    public InputReader(InputStream inputStream) {
        br = new BufferedReader(new InputStreamReader(inputStream));
    }

    public String next() {
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
}