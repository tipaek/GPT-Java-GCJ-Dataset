import javax.xml.bind.SchemaOutputResolver;
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(
                new BufferedReader(
                        new InputStreamReader(System.in)));
//        Scanner in = new Scanner(new File("input.txt"));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        Solution solution = new Solution();
        for (int i = 1; i <= t; ++i) {

            int N = in.nextInt();
            int[][] matrix = createMatrix(N, in);
            Results results = solution.process(matrix);
            System.out.println("Case #" + i + ": " + results.k + " " + results.r+ " " + results.c);
        }
    }

    private Results process(int[][] matrix) {
        int trace = 0;
        int repeatRows = 0;
        int repeatColumns = 0;
        boolean[] checkColumns = new boolean[matrix.length];
        List<Set<Integer>> list = new LinkedList();

        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> row = new HashSet();
            int repeat = 0;
            for (int j = 0 ; j < matrix[i].length; j++) {
                if (i == 0) {
                    list.add(new HashSet());
                }
                Set<Integer> column = list.get(j);
                if (!checkColumns[j] && column.contains(matrix[i][j])) {
                    checkColumns[j] = true;
                }

                if (row.contains(matrix[i][j])) {
                    repeat++;
                }

                if (i == j) {
                    trace += matrix[i][j];
                }
                row.add(matrix[i][j]);
                column.add(matrix[i][j]);
            }

            if (repeat > 0) {
                repeatRows++;
            }
        }
        repeatColumns = checkRepeatColumns(checkColumns);

        return new Results(trace, repeatRows, repeatColumns);
    }

    private int checkRepeatColumns(boolean[] checkColumns) {
        int count = 0;
        for (boolean checkColumn : checkColumns) {
            if (checkColumn) {
                count++;
            }
        }
        return count;
    }

    private static int[][] createMatrix(int N, Scanner in) {
        int[][] matrix = new int[N][N];

        for (int i = 0 ; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        return matrix;
    }

    class Results {
        int k; // trace of the matrix
        int r; // number of rows
        int c; // number of columns
        Results(int k, int r, int c) {
            this.k = k;
            this.r = r;
            this.c = c;
        }
    }
}
