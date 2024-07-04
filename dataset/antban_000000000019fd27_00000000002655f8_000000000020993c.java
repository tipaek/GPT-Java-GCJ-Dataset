import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static class Result {
        int diagonal;
        int repeatedRows;
        int repeatedCols;

        public Result(int diagonal, int repeatedRows, int repeatedCols) {
            this.diagonal = diagonal;
            this.repeatedRows = repeatedRows;
            this.repeatedCols = repeatedCols;
        }
    }

    public static Result getSolution(int dimension, int[] values) {
        int diagonal = 0;
        for (int i = 0; i < dimension; ++i) {
            diagonal += values[i + dimension * i];
        }
        int rows = 0;
        int cols = 0;
        final Set<Integer> rowContent = new HashSet<>();
        final Set<Integer> colContent = new HashSet<>();
        for (int i = 0; i < dimension; ++i) {
            rowContent.clear();
            colContent.clear();
            boolean colFound = false;
            boolean rowFound = false;
            for (int j = 0; j < dimension; ++j) {
                if (!rowContent.add(values[dimension * i + j])) {
                    rowFound = true;
                }
                if (!colContent.add(values[dimension * j + i])) {
                    colFound = true;
                }
                if (rowFound && colFound) {
                    break;
                }
            }
            if (rowFound) {
                rows += 1;
            }
            if (colFound) {
                cols += 1;
            }
        }
        return new Result(diagonal, rows, cols);
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int testCount = scanner.nextInt();
        for (int test = 1; test <= testCount; test++) {
            final int dimension = scanner.nextInt();
            final int[] items = new int[dimension*dimension];
            for (int i = 0; i < items.length; ++i) {
                items[i] = scanner.nextInt();
            }
            final Result result = getSolution(dimension, items);
            System.out.println("Case #" + test  + ": " + result.diagonal + " " + result.repeatedRows + " " + result.repeatedCols);
        }
    }

}