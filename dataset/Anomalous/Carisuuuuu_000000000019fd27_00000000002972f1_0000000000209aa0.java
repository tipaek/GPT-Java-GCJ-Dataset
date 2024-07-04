import java.io.PrintStream;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final PrintStream OUT_STREAM = System.out;
    private static final PrintStream ERROR_STREAM = System.err;

    public static void main(String[] args) {
        int testCases = SCANNER.nextInt();
        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            int size = SCANNER.nextInt();
            int targetTrace = SCANNER.nextInt();
            int[] traceArray = new int[size];
            boolean isFilled = fillTrace(traceArray, 0, size, targetTrace);
            
            if (!isFilled) {
                OUT_STREAM.println("Case #" + caseNum + ": IMPOSSIBLE");
                continue;
            }
            
            int[][] matrix = new int[size][size];
            boolean[][] rowSelected = new boolean[size][size];
            boolean[][] colSelected = new boolean[size][size];
            
            IntStream.range(0, size).forEach(i -> {
                matrix[i][i] = traceArray[i];
                rowSelected[i][traceArray[i] - 1] = true;
                colSelected[i][traceArray[i] - 1] = true;
            });
            
            IntStream.range(0, size).forEach(j -> 
                IntStream.range(j + 1, size).forEach(i -> 
                    findAvailable(rowSelected[i], colSelected[j]).ifPresent(p -> {
                        rowSelected[i][p] = true;
                        colSelected[j][p] = true;
                        matrix[i][j] = p + 1;
                        matrix[j][i] = p + 1;
                    })
                )
            );
            
            if (IntStream.range(0, size).flatMap(i -> Arrays.stream(matrix[i], i + 1, size)).anyMatch(v -> v == 0)) {
                OUT_STREAM.println("Case #" + caseNum + ": IMPOSSIBLE");
                continue;
            }
            
            OUT_STREAM.println("Case #" + caseNum + ": POSSIBLE");
            IntStream.range(0, size).mapToObj(i -> 
                Arrays.stream(matrix[i]).mapToObj(String::valueOf).collect(Collectors.joining(" "))
            ).forEachOrdered(OUT_STREAM::println);
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

    private static OptionalInt findAvailable(boolean[] row, boolean[] col) {
        return IntStream.range(0, row.length).filter(p -> !row[p] && !col[p]).findAny();
    }
}