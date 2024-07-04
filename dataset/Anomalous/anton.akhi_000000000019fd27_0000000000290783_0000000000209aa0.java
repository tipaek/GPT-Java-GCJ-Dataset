import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private BufferedReader br;
    private StringTokenizer st;
    private PrintWriter out;
    private boolean eof = false;

    private void run() {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    private String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                eof = true;
                return "0";
            }
        }
        return st.nextToken();
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

    private void solve() {
        int testCount = nextInt();
        for (int test = 1; test <= testCount; test++) {
            out.print("Case #" + test + ": ");
            int n = nextInt();
            int k = nextInt();
            int[][] result = findSolution(n, k, new ArrayList<>());
            if (result == null) {
                out.println("IMPOSSIBLE");
            } else {
                out.println("POSSIBLE");
                for (int[] row : result) {
                    for (int value : row) {
                        out.print(value + " ");
                    }
                    out.println();
                }
            }
        }
    }

    private int[][] findSolution(int n, int k, List<Integer> list) {
        if (list.size() > n) {
            return null;
        }
        if (k == 1 && list.size() == n) {
            return fillMatrix(list);
        }
        for (int i = Math.max(Math.min(n, k), list.isEmpty() ? 0 : list.get(list.size() - 1)); i >= 1; i--) {
            if (k % i == 0) {
                list.add(i);
                int[][] matrix = findSolution(n, k / i, list);
                if (matrix != null) {
                    return matrix;
                }
                list.remove(list.size() - 1);
            }
        }
        return null;
    }

    private int[][] matrix;

    private int[][] fillMatrix(List<Integer> list) {
        if (matrix == null) {
            matrix = new int[list.size()][list.size()];
        }
        Set<Integer>[] rows = new HashSet[matrix.length];
        Set<Integer>[] columns = new HashSet[matrix.length];
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

    private int[][] depthFirstSearch(Set<Integer>[] rows, Set<Integer>[] columns, int i, int j) {
        if (i >= matrix.length) {
            return matrix;
        }
        if (j >= matrix[i].length) {
            return depthFirstSearch(rows, columns, i + 1, 0);
        }
        if (matrix[i][j] > 0) {
            return depthFirstSearch(rows, columns, i, j + 1);
        }
        for (int value = 1; value <= matrix.length; value++) {
            if (rows[i].contains(value) || columns[j].contains(value)) {
                continue;
            }
            matrix[i][j] = value;
            rows[i].add(value);
            columns[j].add(value);
            int[][] result = depthFirstSearch(rows, columns, i, j + 1);
            if (result != null) {
                return result;
            }
            rows[i].remove(value);
            columns[j].remove(value);
            matrix[i][j] = 0;
        }
        return null;
    }
}