import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Victor Gil
 *
 * since April 2020
 */
class Solution {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                int size = scanner.nextInt();

                int[][] matrix = new int[size][size];
                for (int row = 0; row < size; row++) {
                    for (int col = 0; col < size; col++) {
                        matrix[row][col] = scanner.nextInt();
                    }
                }

                List<Integer> result = calculate(size, matrix);
                System.out.println("Case #" + testNumber + ": " + result.get(0)
                        + " " + result.get(1) + " " + result.get(2));
            }
        }

    }

    static List<Integer> calculate(int size, int[][] matrix) {
        Set<Integer> rowNums = new HashSet<Integer>();
        List<HashSet<Integer>> colNums = new ArrayList<HashSet<Integer>>();

        boolean[] rows = new boolean[size];
        boolean[] cols = new boolean[size];

        int trace = 0;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (row == col) {
                    trace = trace + matrix[row][col];
                }

                if (col == 0) {
                    rowNums.clear();
                }

                if (!rows[row]) {
                    if (rowNums.contains(matrix[row][col])) {
                        rows[row] = true;
                    } else {
                        rowNums.add(matrix[row][col]);
                    }
                }

                if (row == 0) {
                    HashSet<Integer> colSet = new HashSet<Integer>();
                    colNums.add(colSet);
                }

                if (!cols[col]) {
                    if (colNums.get(col).contains(matrix[row][col])) {
                        cols[col] = true;
                    } else {
                        colNums.get(col).add(matrix[row][col]);
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>(3);
        result.add(trace);

        int dupRows = 0;
        for (int i = 0; i < rows.length; i++) {
            if (rows[i]) {
                dupRows++;
            }
        }
        result.add(dupRows);

        int dupCols = 0;
        for (int i = 0; i < cols.length; i++) {
            if (cols[i]) {
                dupCols++;
            }
        }
        result.add(dupCols);

        return result;
    }
}
