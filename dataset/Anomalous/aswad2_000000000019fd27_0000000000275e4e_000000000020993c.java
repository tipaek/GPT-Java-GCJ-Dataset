import java.util.*;
import java.io.*;

public class Vestigium {
    public static void main(String[] args) throws Exception {
        new Vestigium().execute();
    }

    public void execute() throws Exception {
        InputReader input = new InputReader();
        int testCases = input.nextInt();
        for (int t = 0; t < testCases; t++) {
            int n = input.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = input.nextInt();
                }
            }
            int trace = calculateTrace(matrix, n);
            int duplicateRows = countDuplicateRows(matrix, n);
            int duplicateCols = countDuplicateCols(matrix, n);
            System.out.printf("Case #%d: %d %d %d%n", t + 1, trace, duplicateRows, duplicateCols);
        }
    }

    private int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private int countDuplicateRows(int[][] matrix, int size) {
        int duplicateRows = 0;
        for (int i = 0; i < size; i++) {
            if (hasDuplicates(matrix[i])) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private int countDuplicateCols(int[][] matrix, int size) {
        int duplicateCols = 0;
        for (int j = 0; j < size; j++) {
            int[] col = new int[size];
            for (int i = 0; i < size; i++) {
                col[i] = matrix[i][j];
            }
            if (hasDuplicates(col)) {
                duplicateCols++;
            }
        }
        return duplicateCols;
    }

    private boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (set.contains(value)) {
                return true;
            }
            set.add(value);
        }
        return false;
    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader() {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
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
            String line = "";
            try {
                line = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return line;
        }
    }
}