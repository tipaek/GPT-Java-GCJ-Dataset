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
             Writer writer = getWriter(isInteractiveMode, process)) {
            
            long startTime = System.nanoTime();
            try (Scanner scanner = new Scanner(new BufferedReader(reader));
                 PrintWriter printWriter = new PrintWriter(new BufferedWriter(writer))) {
                 
                int testCases = scanner.nextInt();
                JavaSolution solution = new JavaSolution(scanner, printWriter);
                for (int i = 0; i < testCases; i++) {
                    printWriter.printf("Case #%d: ", i + 1);
                    solution.run();
                }
            } finally {
                if (isDebugMode) {
                    long endTime = System.nanoTime();
                    System.out.printf(">> Execution time: %.6f\n", (endTime - startTime) / 1_000_000_000.0);
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

    private static Writer getWriter(boolean isInteractiveMode, Process process) throws IOException {
        if (isInteractiveMode) {
            return new OutputStreamWriter(process.getOutputStream());
        } else {
            return new OutputStreamWriter(System.out);
        }
    }

    private final Scanner scanner;
    private final PrintWriter printWriter;

    private JavaSolution(Scanner scanner, PrintWriter printWriter) {
        this.scanner = scanner;
        this.printWriter = printWriter;
    }

    private static class Cell {
        int row, col, value;

        Cell(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }

    private long runSimulation(int rows, int cols, int[][] grid) {
        boolean[][] removed = new boolean[rows][cols];
        boolean[][] newRemoved = new boolean[rows][cols];
        long totalSum = 0;

        while (true) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (!removed[i][j]) {
                        totalSum += grid[i][j];
                    }
                    int diff = 0;
                    diff += calculateDifference(grid, removed, i, j, -1, 0, rows, cols);
                    diff += calculateDifference(grid, removed, i, j, 1, 0, rows, cols);
                    diff += calculateDifference(grid, removed, i, j, 0, -1, rows, cols);
                    diff += calculateDifference(grid, removed, i, j, 0, 1, rows, cols);

                    if (diff < 0) {
                        newRemoved[i][j] = true;
                    }
                }
            }

            boolean noChanges = true;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (newRemoved[i][j] && !removed[i][j]) {
                        removed[i][j] = true;
                        noChanges = false;
                    }
                }
            }
            if (noChanges) break;
        }
        return totalSum;
    }

    private int calculateDifference(int[][] grid, boolean[][] removed, int row, int col, int rowOffset, int colOffset, int rows, int cols) {
        int diff = 0;
        for (int i = row + rowOffset, j = col + colOffset; i >= 0 && i < rows && j >= 0 && j < cols; i += rowOffset, j += colOffset) {
            if (!removed[i][j]) {
                diff += grid[row][col] - grid[i][j];
                break;
            }
        }
        return diff;
    }

    private void run() {
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] grid = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        printWriter.println(runSimulation(rows, cols, grid));
    }
}