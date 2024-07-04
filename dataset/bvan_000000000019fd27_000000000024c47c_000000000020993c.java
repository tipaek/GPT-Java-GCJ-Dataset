import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int tests = scanner.nextInt();
        for (int t = 1; t <= tests; t++) {
            int size = scanner.nextInt();
            int[][] matrix = scanner.nextMatrix(size, size);
            int trace = trace(matrix);
            int rowsWithDuplicates = rowsWithDuplicates(matrix);
            int colsWithDuplicates = colsWithDuplicates(matrix);
            System.out.println(String.format("Case #%d: %d %d %d", t, trace, rowsWithDuplicates, colsWithDuplicates));
        }
    }

    private static int trace(int[][] matrix) {
        int size = matrix.length;

        int res = 0;
        for (int i = 0; i < size; i++) {
            res += matrix[i][i];
        }
        return res;
    }

    private static int rowsWithDuplicates(int[][] matrix) {
        int size = matrix.length;

        int rows = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> unique = new HashSet<>();

            for (int j = 0; j < size; j++) {
                boolean inserted = unique.add(matrix[i][j]);
                if (!inserted) {
                    rows++;
                    break;
                }
            }
        }
        return rows;
    }

    private static int colsWithDuplicates(int[][] matrix) {
        int size = matrix.length;

        int cols = 0;
        for (int j = 0; j < size; j++) {
            Set<Integer> unique = new HashSet<>();

            for (int i = 0; i < size; i++) {
                boolean inserted = unique.add(matrix[i][j]);
                if (!inserted) {
                    cols++;
                    break;
                }
            }
        }
        return cols;
    }
}

class FastScanner {

    private final StreamTokenizer streamTokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public int nextInt()  {
        try {
            streamTokenizer.nextToken();
            return (int) streamTokenizer.nval;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public int[] nextInts(int size) {
        int[] array = new int[size];
        nextInts(array, 0, size);
        return array;
    }

    public void nextInts(int[] array, int from, int to) {
        for (int i = from; i < to; i++) {
            array[i] = nextInt();
        }
    }

    public int[][] nextMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i] = nextInts(cols);
        }
        return matrix;
    }
}
