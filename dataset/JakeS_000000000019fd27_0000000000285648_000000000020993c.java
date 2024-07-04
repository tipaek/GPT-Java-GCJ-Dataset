package book.boot;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class test {
    public static void main(String... args) {
        int tests = Integer.parseInt(args[0]);
        int test = 1;
        int position = 1;

        while (test <= tests) {
            int marixSize = Integer.parseInt(args[position++]);

            int[][] matrix = new int[marixSize][marixSize];
            for (int i = 0; i < marixSize; i++) {
                for (int j = 0; j < marixSize; j++) {
                    matrix[i][j] = Integer.parseInt(args[position++]);
                }
            }

            count(test++, matrix);
        }
    }

    private static void count(int test, int[][] matrix) {
        int rowCount = 0;
        int traceSum = 0;
        int columnCount = 0;

        Set<Integer> rows = new HashSet();
        Map<Integer, Set<Integer>> columns = new HashMap();
        for (int i = 0; i < matrix.length; i++) {
            traceSum += matrix[i][i];
            for (int j = 0; j < matrix.length; j++) {
                rows.add(matrix[i][j]);
                (columns.computeIfAbsent(i, k -> new HashSet())).add(matrix[j][i]);
            }
            if (rows.size() < matrix.length) {
                rowCount++;
            }
        }

        for (Set<Integer> column : columns.values()) {
            if (column.size() < matrix.length) {
                columnCount ++;
            }
        }
        System.out.println("Case #" + test + ": " + traceSum + " " + rowCount + " " + columnCount);
    }
}
