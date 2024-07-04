import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        new Solution().execute();
    }

    private BufferedReader reader;
    private StringTokenizer tokenizer;
    private PrintWriter writer;
    private boolean endOfFile = false;

    private void execute() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        process();
        writer.close();
    }

    private String nextToken() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (Exception e) {
                endOfFile = true;
                return "0";
            }
        }
        return tokenizer.nextToken();
    }

    private int nextInt() {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() {
        return Long.parseLong(nextToken());
    }

    private double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    private void process() {
        int testCases = nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            writer.print("Case #" + testCase + ": ");
            int n = nextInt();
            int k = nextInt();
            matrix = new int[n][n];
            int[][] result = decompose(n, k, new ArrayList<>());
            if (result == null) {
                writer.println("IMPOSSIBLE");
                continue;
            }
            writer.println("POSSIBLE");
            for (int[] row : result) {
                for (int cell : row) {
                    writer.print(cell + " ");
                }
                writer.println();
            }
        }
    }

    private int[][] decompose(int n, int k, ArrayList<Integer> list) {
        if (list.size() > n) {
            return null;
        }
        if (k == 1 && list.size() == n) {
            return populateMatrix(list);
        }
        for (int i = Math.max(Math.min(n, k), list.isEmpty() ? 0 : list.get(list.size() - 1)); i >= 1; i--) {
            if (k % i == 0) {
                list.add(i);
                int[][] result = decompose(n, k / i, list);
                if (result != null) {
                    return result;
                }
                list.remove(list.size() - 1);
            }
        }
        return null;
    }

    private int[][] matrix;

    private int[][] populateMatrix(ArrayList<Integer> list) {
        HashSet<Integer>[] rows = new HashSet[matrix.length];
        HashSet<Integer>[] columns = new HashSet[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
        }
        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(matrix[i], 0);
            int value = list.get(i);
            matrix[i][i] = value;
            rows[i].add(value);
            columns[i].add(value);
        }
        return depthFirstSearch(rows, columns, 0, 0);
    }

    private int[][] depthFirstSearch(HashSet<Integer>[] rows, HashSet<Integer>[] columns, int row, int col) {
        if (row >= matrix.length) {
            return matrix;
        }
        if (col >= matrix[row].length) {
            return depthFirstSearch(rows, columns, row + 1, 0);
        }
        if (matrix[row][col] > 0) {
            return depthFirstSearch(rows, columns, row, col + 1);
        }
        for (int value = 1; value <= matrix.length; value++) {
            if (rows[row].contains(value) || columns[col].contains(value)) {
                continue;
            }
            matrix[row][col] = value;
            rows[row].add(value);
            columns[col].add(value);
            int[][] result = depthFirstSearch(rows, columns, row, col + 1);
            if (result != null) {
                return result;
            }
            rows[row].remove(value);
            columns[col].remove(value);
            matrix[row][col] = 0;
        }
        return null;
    }
}