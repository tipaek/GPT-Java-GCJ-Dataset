import java.io.PrintStream;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PrintStream output = System.out;
    private static final PrintStream errorLog = System.err;

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] traceArray = new int[n];
            
            boolean isFilled = fillTrace(traceArray, 0, n, k);
            if (!isFilled) {
                output.println("Case #" + caseNumber + ": IMPOSSIBLE");
                continue;
            }
            
            int[][] grid = new int[n][n];
            boolean[][] rowSelected = new boolean[n][n];
            boolean[][] columnSelected = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                grid[i][i] = traceArray[i];
                rowSelected[i][traceArray[i] - 1] = true;
                columnSelected[i][traceArray[i] - 1] = true;
            }

            for (int j = 0; j < n; j++) {
                for (int i = j + 1; i < n; i++) {
                    findUnselected(rowSelected[i], columnSelected[j]).ifPresent(p -> {
                        rowSelected[i][p] = true;
                        columnSelected[j][p] = true;
                        grid[i][j] = p + 1;
                        grid[j][i] = p + 1;
                    });
                }
            }

            boolean isPossible = Arrays.stream(grid)
                                       .flatMapToInt(Arrays::stream)
                                       .allMatch(value -> value != 0);

            if (!isPossible) {
                output.println("Case #" + caseNumber + ": IMPOSSIBLE");
                continue;
            }

            output.println("Case #" + caseNumber + ": POSSIBLE");
            Arrays.stream(grid)
                  .map(row -> Arrays.stream(row)
                                    .mapToObj(String::valueOf)
                                    .collect(Collectors.joining(" ")))
                  .forEach(output::println);
        }
    }

    private static boolean fillTrace(int[] values, int position, int value, int remaining) {
        if (position == values.length && remaining == 0) return true;
        if (values.length - position > remaining) return false;
        
        values[position] = value;
        if (!fillTrace(values, position + 1, value, remaining - value)) {
            return fillTrace(values, position, value - 1, remaining);
        }
        return true;
    }

    private static OptionalInt findUnselected(boolean[] row, boolean[] column) {
        return IntStream.range(0, row.length)
                        .filter(index -> !row[index] && !column[index])
                        .findAny();
    }
}