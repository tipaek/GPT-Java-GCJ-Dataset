import java.util.*;
import java.io.*;

class MatrixSolver {

    public int[] solve(int[][] matrix, int size) {
        int[] result = new int[3];
        for (int i = 0; i < size; i++) {
            result[0] += matrix[i][i];
        }
        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (rowSet.contains(matrix[i][j])) {
                    result[1]++;
                    break;
                }
                rowSet.add(matrix[i][j]);
            }
        }
        for (int j = 0; j < size; j++) {
            Set<Integer> colSet = new HashSet<>();
            for (int i = 0; i < size; i++) {
                if (colSet.contains(matrix[i][j])) {
                    result[2]++;
                    break;
                }
                colSet.add(matrix[i][j]);
            }
        }
        return result;
    }
}

public class Solution {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader inputReader = new InputReader(inputStream);
        PrintWriter outputWriter = new PrintWriter(outputStream);
        int testCases = inputReader.nextInt();
        MatrixSolver solver = new MatrixSolver();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = inputReader.nextInt();
            int[][] matrix = new int[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = inputReader.nextInt();
                }
            }
            int[] result = solver.solve(matrix, size);
            outputWriter.println("Case #" + testCase + ": " + result[0] + " " + result[1] + " " + result[2]);
        }
        outputWriter.close();
    }

    static class InputReader {
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
}