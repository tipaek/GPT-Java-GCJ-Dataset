import java.io.*;
import java.util.*;

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

    private static OutputStreamWriter getWriter(boolean isInteractiveMode, Process process) {
        if (isInteractiveMode) {
            return new OutputStreamWriter(process.getOutputStream());
        } else {
            return new OutputStreamWriter(System.out);
        }
    }

    private final Scanner in;
    private final PrintWriter out;

    private JavaSolution(Scanner in, PrintWriter out) {
        this.in = in;
        this.out = out;
    }

    private static class Cell {
        final int row;
        final int col;
        final int value;

        Cell(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }

    private long calculate(int rows, int cols, int[][] grid) {
        boolean[][] removed = new boolean[rows][cols];
        boolean[][] newRemoved = new boolean[rows][cols];
        long result = 0;

        while (true) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (!removed[i][j]) {
                        result += grid[i][j];
                    }
                    int diff = calculateDifference(i, j, rows, cols, grid, removed);
                    if (diff < 0) {
                        newRemoved[i][j] = true;
                    }
                }
            }

            boolean noChange = true;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (newRemoved[i][j] && !removed[i][j]) {
                        removed[i][j] = true;
                        noChange = false;
                    }
                }
            }
            if (noChange) break;
        }
        return result;
    }

    private int calculateDifference(int i, int j, int rows, int cols, int[][] grid, boolean[][] removed) {
        int diff = 0;
        diff += calculateDirectionalDifference(i, j, -1, 0, rows, cols, grid, removed); // up
        diff += calculateDirectionalDifference(i, j, 1, 0, rows, cols, grid, removed); // down
        diff += calculateDirectionalDifference(i, j, 0, -1, rows, cols, grid, removed); // left
        diff += calculateDirectionalDifference(i, j, 0, 1, rows, cols, grid, removed); // right
        return diff;
    }

    private int calculateDirectionalDifference(int i, int j, int di, int dj, int rows, int cols, int[][] grid, boolean[][] removed) {
        int newRow = i + di;
        int newCol = j + dj;
        while (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
            if (!removed[newRow][newCol]) {
                return grid[i][j] - grid[newRow][newCol];
            }
            newRow += di;
            newCol += dj;
        }
        return 0;
    }

    private void run() {
        int rows = in.nextInt();
        int cols = in.nextInt();
        int[][] grid = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = in.nextInt();
            }
        }
        out.println(calculate(rows, cols, grid));
    }
}