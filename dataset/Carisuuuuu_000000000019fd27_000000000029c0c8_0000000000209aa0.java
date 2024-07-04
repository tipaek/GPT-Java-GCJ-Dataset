import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    private static final Scanner IN = new Scanner(System.in);
    private static final PrintStream OUT = System.out;
    private static final PrintStream LOG = System.err;

    public static void main(String[] args) {
        int t = IN.nextInt();
        for (int g = 1; g <= t; ++g) {
            int n = IN.nextInt();
            int k = IN.nextInt();
            List<int[]> fills = fillList(n, k);
            if (fills.isEmpty()) {
                OUT.println("Case #" + g + ": IMPOSSIBLE");
                continue;
            }
            LOG.println("Attempting " + fills.size() + " goes");
            boolean done = false;
            for (int[] trace : fills) {
                int[][] grid = new int[n][n];
                boolean[][] selected = new boolean[n][n];
                IntStream.range(0, n)
                        .forEach(i -> {
                            grid[i][i] = trace[i];
                            selected[i][trace[i] - 1] = true;
                        });
                IntStream.range(0, n)
                        .forEach(j -> IntStream.range(j + 1, n)
                                .forEach(i -> find(selected[i], selected[j])
                                        .ifPresent(p -> {
                                            selected[i][p] = true;
                                            selected[j][p] = true;
                                            grid[i][j] = p + 1;
                                            grid[j][i] = p + 1;
                                        })));
                IntStream.range(0, n)
                        .mapToObj(i -> Arrays.stream(grid[i])
                                .mapToObj(String::valueOf)
                                .collect(Collectors.joining(" ")))
                        .forEachOrdered(LOG::println);
                if (IntStream.range(0, n)
                        .flatMap(i -> Arrays.stream(grid[i], i + 1, n))
                        .anyMatch(v -> v == 0)) {
                    continue;
                }
                OUT.println("Case #" + g + ": POSSIBLE");
                IntStream.range(0, n)
                        .mapToObj(i -> Arrays.stream(grid[i])
                                .mapToObj(String::valueOf)
                                .collect(Collectors.joining(" ")))
                        .forEachOrdered(OUT::println);
                done = true;
                break;
            }
            if (!done) {
                OUT.println("Case #" + g + ": IMPOSSIBLE");
            }
        }
    }

    private static List<int[]> fillList(int size, int remain) {
        return IntStream.range(0, size)
                .mapToObj(p -> {
                    int[] values = new int[size];
                    return fill(values, 0, p+1, remain) ? values : null;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private static boolean fill(int[] values, int pos, int value, int remain) {
        if (value == 0) return false;
        if (pos == values.length) return remain == 0;
        values[pos] = value;
        if (!fill(values, pos+1, value, remain-value)) {
           return fill(values, pos, value-1, remain);
        }
        return true;
    }

    private static OptionalInt find(boolean[] horiz, boolean[] vert) {
        LOG.println("H: " + Arrays.toString(horiz));
        LOG.println("V: " + Arrays.toString(vert));
        return IntStream.range(0, horiz.length)
                .filter(p -> !horiz[p] && !vert[p])
                .peek(p -> LOG.println("P: " + (p+1)))
                .findAny();
    }
}