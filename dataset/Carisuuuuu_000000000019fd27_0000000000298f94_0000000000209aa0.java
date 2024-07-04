import java.io.PrintStream;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;
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
            int[] trace = new int[n];
            boolean fill = fill(trace, 0, n, k);
            if (!fill) {
                OUT.println("Case #" + g + ": IMPOSSIBLE");
                continue;
            }
            int[][] grid = new int[n][n];
            boolean[][] selected = new boolean[n][n];
            IntStream.range(0, n)
                    .forEach(i -> {
                        grid[i][i] = trace[i];
                        selected[i][trace[i]-1] = true;
                    });
            IntStream.range(0, n)
                    .forEach(j -> IntStream.range(j+1, n)
                            .forEach(i -> find(selected[i], selected[j])
                                        .ifPresent(p -> {
                                            selected[i][p] = true;
                                            selected[j][p] = true;
                                            grid[i][j] = p+1;
                                            grid[j][i] = p+1;
                                        })));
            IntStream.range(0, n)
                    .mapToObj(i -> Arrays.stream(grid[i])
                            .mapToObj(String::valueOf)
                            .collect(Collectors.joining(" ")))
                    .forEachOrdered(LOG::println);
            if (IntStream.range(0, n)
                    .flatMap(i -> Arrays.stream(grid[i], i + 1, n))
                    .anyMatch(v -> v == 0)) {
                OUT.println("Case #" + g + ": IMPOSSIBLE");
                continue;
            }
            OUT.println("Case #" + g + ": POSSIBLE");
            IntStream.range(0, n)
                    .mapToObj(i -> Arrays.stream(grid[i])
                            .mapToObj(String::valueOf)
                            .collect(Collectors.joining(" ")))
                    .forEachOrdered(OUT::println);

        }
    }

    private static boolean fill(int[] values, int pos, int value, int remain) {
        if (pos == values.length && remain == 0) return true;
        if (values.length - pos > remain) return false;
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