import java.util.*;
import java.io.*;

public class Solution {

    private static StringBuilder result;

    private static void findSolution(String testValue) {
        result = new StringBuilder();
        for (char c : testValue.toCharArray()) {
            result.append(c == 'S' ? 'E' : 'S');
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {
            int size = in.nextInt();
            int trace = 0, dupRows = 0, dupCols = 0;
            int[][] matrix = new int[size][size];
            boolean[] rowHasDuplicate = new boolean[size];
            boolean[] colHasDuplicate = new boolean[size];

            for (int r = 0; r < size; r++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();

                for (int c = 0; c < size; c++) {
                    matrix[r][c] = in.nextInt();
                    if (r == c) {
                        trace += matrix[r][c];
                    }

                    if (!rowSet.add(matrix[r][c])) {
                        rowHasDuplicate[r] = true;
                    }

                    if (!colSet.add(matrix[c][r])) {
                        colHasDuplicate[c] = true;
                    }
                }
            }

            for (boolean hasDup : rowHasDuplicate) {
                if (hasDup) dupRows++;
            }

            for (boolean hasDup : colHasDuplicate) {
                if (hasDup) dupCols++;
            }

            System.out.println("Case #" + i + ": " + trace + " " + dupRows + " " + dupCols);
        }
    }
}