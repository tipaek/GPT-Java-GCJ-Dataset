import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Set;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Liavontsi Brechka
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Indicium solver = new Indicium();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class Indicium {
        InputReader in;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            this.in = in;

            int n = in.nextInt();
            int k = in.nextInt();

            int mod = k % n;
            int div = k / n;
            int[] diag = new int[n];
            int[][] grid;

            if (mod == 0) {
                Arrays.fill(diag, div);

                grid = gridWithDiag(diag);
                if (!isValidDiag(grid)) throw new RuntimeException("Unexpected diag");
            } else if (mod == n - 1) {
                Arrays.fill(diag, div + 1);
                diag[0] = div - 1;
                diag[n - 1] = div + 2;

                grid = gridWithDiag(diag);
                if (!isValidDiag(grid)) {
                    out.printf("Case #%d: IMPOSSIBLE\n", testNumber);
                    return;
                }
            } else if (mod == 1) {
                Arrays.fill(diag, div);
                diag[0] = div - 1;
                diag[n - 1] = div + 2;

                grid = gridWithDiag(diag);
                if (!isValidDiag(grid)) {
                    out.printf("Case #%d: IMPOSSIBLE\n", testNumber);
                    return;
                }
            } else {
                Arrays.fill(diag, div);
                for (int i = n - 1; i >= 0 && mod > 0; i--) {
                    diag[i]++;
                    mod--;
                }

                grid = gridWithDiag(diag);
                if (!isValidDiag(grid)) throw new RuntimeException("Unexpected diag");
            }

            fillIn(grid, getFillInOrder(diag));
            if (!isValid(grid)) {
                throw new RuntimeException("Unexpected grid");
            }

            out.printf("Case #%d: POSSIBLE\n%s", testNumber, getString(grid));
        }

        private int[][] gridWithDiag(int[] diag) {
            int[][] grid = new int[diag.length][diag.length];

            for (int i = 0; i < diag.length; i++) {
                Arrays.fill(grid[i], -1);
            }

            for (int i = 0; i < diag.length; i++) {
                grid[i][i] = diag[i];
            }

            return grid;
        }

        private void fillIn(int[][] grid, int[] order) {
            int n = grid.length;

            Set<Integer>[] row = new Set[n];
            Set<Integer>[] col = new Set[n];
            int[][] colLeft = new int[n][n];

            for (int i = 0; i < n; i++) {
                row[i] = new HashSet<>();
                col[i] = new HashSet<>();
            }

            for (int j = n - 1; j >= 0; j--) {
                for (int i = 0; i < n; i++) {
                    if (grid[i][j] == -1) colLeft[i][j]++;
                    else {
                        row[i].add(grid[i][j]);
                        col[j].add(grid[i][j]);
                    }

                    if (j < n - 1) colLeft[i][j] += colLeft[i][j + 1];
                }
            }

            for (int nextNumberI = 0; nextNumberI < n; nextNumberI++) {
                int nextNumber = order[nextNumberI];

                for (int j = 0; j < n; j++) {
                    if (col[j].contains(nextNumber)) continue;

                    int targetRow = -1;
                    int targetRowSpace = Integer.MAX_VALUE;

                    for (int i = 0; i < n; i++) {
                        if (grid[i][j] == -1 && !row[i].contains(nextNumber) && colLeft[i][j] < targetRowSpace) {
                            targetRow = i;
                            targetRowSpace = colLeft[i][j];
                        }
                    }

                    if (targetRow != -1) {
                        grid[targetRow][j] = nextNumber;
                        row[targetRow].add(nextNumber);
                        col[j].add(nextNumber);
                    }
                }
            }
        }

        private int[] getFillInOrder(int[] diag) {
            int n = diag.length;
            Set<Integer> set = new HashSet<>(n);

            int nextIndex = 0;
            int[] order = new int[n];
            for (int i = n - 1; i >= 0; i--) {
                if (!set.contains(diag[i])) {
                    set.add(diag[i]);
                    order[nextIndex++] = diag[i];
                }
            }

            for (int i = 1; i <= n; i++) {
                if (!set.contains(i)) {
                    set.add(i);
                    order[nextIndex++] = i;
                }
            }

            return order;
        }

        private boolean isValidDiag(int[][] grid) {
            int n = grid.length;
            for (int i = 0; i < n; i++) {
                if (grid[i][i] <= 0 || grid[i][i] > n) return false;
            }

            return true;
        }

        private boolean isValid(int[][] grid) {
            int n = grid.length;

            Set<Integer>[] row = new Set[n];
            Set<Integer>[] col = new Set[n];
            for (int i = 0; i < n; i++) {
                row[i] = new HashSet<>();
                col[i] = new HashSet<>();
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (row[i].contains(grid[i][j]) || col[j].contains(grid[i][j]) || grid[i][j] <= 0 || grid[j][j] > n)
                        return false;
                    row[i].add(grid[i][j]);
                    col[j].add(grid[i][j]);
                }
            }

            return true;
        }

        private String getString(int[][] grid) {
            int n = grid.length;
            StringBuilder res = new StringBuilder();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    res.append(grid[i][j]).append(j < n - 1 ? ' ' : '\n');
                }
            }

            return res.toString();
        }

    }

    static class InputReader {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(readLine());
            }
            return tokenizer.nextToken();
        }

        public String readLine() {
            String line;
            try {
                line = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return line;
        }

    }
}

