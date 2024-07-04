import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int matrix[][] = new int[n][n];
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    matrix[x][y] = in.nextInt();
                }
            }
            int result[] = checkValidity(matrix);
            System.out.println("Case #" + i + ": " + result[0] + " " + result[1] + " " + result[2] );
        }
    }

    private static int[] checkValidity(int[][] matrix) {
        int trace = 0;
        List<Set<Integer>> cols = new ArrayList<>();
        List<Set<Integer>> rows = new ArrayList<>();
        int rowCount[] = new int[matrix.length];
        int colCount[] = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            cols.add(new HashSet<Integer>());
            rows.add(new HashSet<Integer>());
            rowCount[i] = 0;
            colCount[i] = 0;
        }


        for (int r = 0; r < matrix.length; r++) {
            Set<Integer> rowSet = rows.get(r);
            for (int i = 0; i < matrix.length; i++) {
                int c = matrix[r][i];
                if (r == i) {
                    trace += c;
                }
                Set<Integer> colSet = cols.get(i);


                if (rowSet.contains(c)) {
                    rowCount[r] = 1;
                } else {
                    rowSet.add(c);
                }

                if (colSet.contains(c)) {
                    colCount[i] = 1;
                } else {
                    colSet.add(c);
                }
            }
        }

        int dupRows = 0, dupCols = 0;

        for(int v : rowCount) {
            dupRows += v;
        }

        for(int v : colCount) {
            dupCols += v;
        }
        return new int[]{ trace, dupRows, dupCols};
    }
}
  