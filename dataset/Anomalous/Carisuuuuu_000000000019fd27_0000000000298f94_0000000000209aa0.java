import java.io.PrintStream;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final PrintStream OUTPUT = System.out;
    private static final PrintStream LOG = System.err;

    public static void main(String[] args) {
        int testCases = SCANNER.nextInt();
        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            int n = SCANNER.nextInt();
            int k = SCANNER.nextInt();
            int[] trace = new int[n];
            
            if (!fillTrace(trace, 0, n, k)) {
                OUTPUT.println("Case #" + caseNum + ": IMPOSSIBLE");
                continue;
            }

            int[][] grid = new int[n][n];
            boolean[][] selected = new boolean[n][n];

            initializeGridAndSelection(trace, grid, selected, n);

            fillGrid(grid, selected, n);

            if (isGridIncomplete(grid, n)) {
                OUTPUT.println("Case #" + caseNum + ": IMPOSSIBLE");
                continue;
            }

            OUTPUT.println("Case #" + caseNum + ": POSSIBLE");
            printGrid(grid, n);
        }
    }

    private static boolean fillTrace(int[] values, int pos, int value, int remain) {
        if (pos == values.length && remain == 0) return true;
        if (values.length - pos > remain) return false;

        values[pos] = value;
        if (!fillTrace(values, pos + 1, value, remain - value)) {
            return fillTrace(values, pos, value - 1, remain);
        }
        return true;
    }

    private static void initializeGridAndSelection(int[] trace, int[][] grid, boolean[][] selected, int n) {
        IntStream.range(0, n).forEach(i -> {
            grid[i][i] = trace[i];
            selected[i][trace[i] - 1] = true;
        });
    }

    private static void fillGrid(int[][] grid, boolean[][] selected, int n) {
        IntStream.range(0, n).forEach(j -> 
            IntStream.range(j + 1, n).forEach(i -> 
                findAvailableValue(selected[i], selected[j]).ifPresent(p -> {
                    selected[i][p] = true;
                    selected[j][p] = true;
                    grid[i][j] = p + 1;
                    grid[j][i] = p + 1;
                })
            )
        );
    }

    private static OptionalInt findAvailableValue(boolean[] horiz, boolean[] vert) {
        LOG.println("H: " + Arrays.toString(horiz));
        LOG.println("V: " + Arrays.toString(vert));
        return IntStream.range(0, horiz.length)
                .filter(p -> !horiz[p] && !vert[p])
                .peek(p -> LOG.println("P: " + (p + 1)))
                .findAny();
    }

    private static boolean isGridIncomplete(int[][] grid, int n) {
        return IntStream.range(0, n)
                .flatMap(i -> Arrays.stream(grid[i], i + 1, n))
                .anyMatch(v -> v == 0);
    }

    private static void printGrid(int[][] grid, int n) {
        IntStream.range(0, n)
                .mapToObj(i -> Arrays.stream(grid[i])
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" ")))
                .forEachOrdered(OUTPUT::println);
    }
}