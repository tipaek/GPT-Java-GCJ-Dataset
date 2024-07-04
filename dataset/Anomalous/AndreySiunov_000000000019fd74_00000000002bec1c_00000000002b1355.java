import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        JavaSolution.main(args);
    }
}

class JavaSolution {
    public static void main(String[] args) throws IOException {
        boolean isDebugMode = Arrays.asList(args).contains("DEBUG_MODE");
        boolean isInteractiveMode = Arrays.asList(args).contains("INTERACTIVE_MODE");

        Process process = null;
        if (isInteractiveMode) {
            process = Runtime.getRuntime().exec("python3 local_testing_tool.py 2");
        }

        try (Reader reader = getReader(isInteractiveMode, isDebugMode, process);
             OutputStreamWriter writer = getWriter(isInteractiveMode, process)) {

            long startTime = System.nanoTime();
            try (Scanner scanner = new Scanner(new BufferedReader(reader));
                 PrintWriter out = new PrintWriter(new BufferedWriter(writer))) {

                int testCases = scanner.nextInt();
                JavaSolution solution = new JavaSolution(scanner, out);
                for (int i = 0; i < testCases; i++) {
                    out.printf("Case #%d: ", i + 1);
                    solution.run();
                }
            } finally {
                if (isDebugMode) {
                    long endTime = System.nanoTime();
                    System.out.printf(">> Execution time: %.6f\n", (endTime - startTime) / 1_000_000_000.0);
                    System.out.flush();
                }
            }
        } finally {
            if (process != null) {
                process.destroy();
            }
        }
    }

    private static Reader getReader(boolean isInteractiveMode, boolean isDebugMode, Process process) throws IOException {
        if (isInteractiveMode) {
            return new BufferedReader(new InputStreamReader(process.getInputStream()));
        } else if (isDebugMode) {
            return new FileReader("input.txt");
        } else {
            return new InputStreamReader(System.in);
        }
    }

    private static OutputStreamWriter getWriter(boolean isInteractiveMode, Process process) throws IOException {
        if (isInteractiveMode) {
            return new OutputStreamWriter(process.getOutputStream());
        } else {
            return new OutputStreamWriter(System.out);
        }
    }

    private Scanner in;
    private PrintWriter out;

    private JavaSolution(Scanner in, PrintWriter out) {
        this.in = in;
        this.out = out;
    }

    private static class Cell {
        int row;
        int col;
        int value;

        public Cell(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }

    private void run() {
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = in.nextInt();
            }
        }

        int[][] left = new int[n][m];
        int[][] right = new int[n][m];
        int[][] up = new int[n][m];
        int[][] down = new int[n][m];
        int[][] delta = new int[n][m];
        TreeSet<Cell> cells = new TreeSet<>(Comparator.comparingInt((Cell c) -> c.value)
                .thenComparingInt(c -> c.row)
                .thenComparingInt(c -> c.col));

        long currentSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                left[i][j] = j - 1;
                right[i][j] = j + 1;
                up[i][j] = i - 1;
                down[i][j] = i + 1;

                delta[i][j] = 0;
                if (j > 0) delta[i][j] += grid[i][j] - grid[i][j - 1];
                if (j + 1 < m) delta[i][j] += grid[i][j] - grid[i][j + 1];
                if (i > 0) delta[i][j] += grid[i][j] - grid[i - 1][j];
                if (i + 1 < n) delta[i][j] += grid[i][j] - grid[i + 1][j];
                cells.add(new Cell(i, j, delta[i][j]));

                currentSum += grid[i][j];
            }
        }

        long result = 0;
        while (true) {
            result += currentSum;
            List<Cell> toRemove = new ArrayList<>();
            for (Cell cell : cells) {
                if (cell.value < 0) {
                    toRemove.add(cell);
                } else {
                    break;
                }
            }
            if (toRemove.isEmpty()) break;

            for (Cell cell : toRemove) {
                cells.remove(cell);
                int i = cell.row;
                int j = cell.col;
                currentSum -= grid[i][j];

                updateNeighbor(cells, left, right, delta, grid, i, j, i, left[i][j], m, true);
                updateNeighbor(cells, left, right, delta, grid, i, j, i, right[i][j], m, false);
                updateNeighbor(cells, up, down, delta, grid, i, j, up[i][j], j, n, true);
                updateNeighbor(cells, up, down, delta, grid, i, j, down[i][j], j, n, false);
            }
        }
        out.println(result);
    }

    private void updateNeighbor(TreeSet<Cell> cells, int[][] primary, int[][] secondary, int[][] delta,
                                int[][] grid, int i, int j, int ni, int nj, int limit, boolean isPrimary) {
        if (ni >= 0 && ni < limit) {
            cells.remove(new Cell(ni, nj, delta[ni][nj]));
            if (isPrimary) {
                secondary[ni][nj] = secondary[i][j];
                delta[ni][nj] -= grid[ni][nj] - grid[i][j];
                if (secondary[ni][nj] < limit) {
                    delta[ni][nj] += grid[ni][nj] - grid[ni][secondary[ni][nj]];
                }
            } else {
                primary[ni][nj] = primary[i][j];
                delta[ni][nj] -= grid[ni][nj] - grid[i][j];
                if (primary[ni][nj] >= 0) {
                    delta[ni][nj] += grid[ni][nj] - grid[primary[ni][nj]][nj];
                }
            }
            cells.add(new Cell(ni, nj, delta[ni][nj]));
        }
    }
}