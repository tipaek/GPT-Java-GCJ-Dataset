import java.io.PrintStream;
import java.util.*;
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
            List<int[]> possibleTraces = generateTraces(n, k);
            if (possibleTraces.isEmpty()) {
                OUTPUT.println("Case #" + caseNum + ": IMPOSSIBLE");
                continue;
            }
            LOG.println("Attempting " + possibleTraces.size() + " configurations");
            boolean solutionFound = false;
            for (int[] trace : possibleTraces) {
                int[][] grid = new int[n][n];
                boolean[][] used = new boolean[n][n];
                for (int i = 0; i < n; i++) {
                    grid[i][i] = trace[i];
                    used[i][trace[i] - 1] = true;
                }
                for (int i = 0; i < n; i++) {
                    for (int j = i + 1; j < n; j++) {
                        findUnused(used[i], used[j]).ifPresent(p -> {
                            used[i][p] = true;
                            used[j][p] = true;
                            grid[i][j] = p + 1;
                            grid[j][i] = p + 1;
                        });
                    }
                }
                Arrays.stream(grid).map(row -> Arrays.stream(row)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" ")))
                        .forEach(LOG::println);
                if (Arrays.stream(grid).flatMapToInt(Arrays::stream).anyMatch(v -> v == 0)) {
                    continue;
                }
                OUTPUT.println("Case #" + caseNum + ": POSSIBLE");
                Arrays.stream(grid).map(row -> Arrays.stream(row)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" ")))
                        .forEach(OUTPUT::println);
                solutionFound = true;
                break;
            }
            if (!solutionFound) {
                OUTPUT.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }
    }

    private static List<int[]> generateTraces(int size, int targetSum) {
        return IntStream.range(0, size)
                .mapToObj(p -> {
                    int[] values = new int[size];
                    return fillTrace(values, 0, p + 1, targetSum) ? values : null;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private static boolean fillTrace(int[] values, int pos, int value, int remainingSum) {
        if (value == 0) return false;
        if (pos == values.length) return remainingSum == 0;
        values[pos] = value;
        if (!fillTrace(values, pos + 1, value, remainingSum - value)) {
            return fillTrace(values, pos, value - 1, remainingSum);
        }
        return true;
    }

    private static OptionalInt findUnused(boolean[] rowUsed, boolean[] colUsed) {
        LOG.println("Row used: " + Arrays.toString(rowUsed));
        LOG.println("Col used: " + Arrays.toString(colUsed));
        return IntStream.range(0, rowUsed.length)
                .filter(p -> !rowUsed[p] && !colUsed[p])
                .peek(p -> LOG.println("Position: " + (p + 1)))
                .findAny();
    }
}