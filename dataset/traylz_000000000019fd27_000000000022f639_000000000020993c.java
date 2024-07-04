
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final int numOfCases = Integer.parseInt(in.readLine());
        for (int i = 0; i < numOfCases; i++) {
            int size = Integer.parseInt(in.readLine());
            int[][] array = new int[size][size];
            for (int j = 0; j < size; j++) {
                String[] vals = in.readLine().split(" ");
                for (int k = 0; k < vals.length; k++) {
                    array[j][k] = Integer.parseInt(vals[k]);
                }

            }
            Result result = solve(array);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static Result solve(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }

        int rowDups = 0;
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> seenNums = new HashSet<Integer>();
            for (int j =0; j < matrix[i].length; j++) {
                int currentNum = matrix[i][j];
                if (seenNums.contains(currentNum)) {
                    rowDups++;
                    break;
                }
                seenNums.add(currentNum);
            }

        }

        int columnDups = 0;
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> seenNums = new HashSet<Integer>();
            for (int j =0; j < matrix[i].length; j++) {
                int currentNum = matrix[j][i];
                if (seenNums.contains(currentNum)) {
                    columnDups++;
                    break;
                }
                seenNums.add(currentNum);
            }
        }

        return new Result(trace, rowDups, columnDups);

    }

    public static class Result {
        public final int trace;
        public final int outOfOrderRows;
        public final int outOfOrderColumns;

        public Result(int trace, int outOfOrderRows, int outOfOrderColumns) {
            this.trace = trace;
            this.outOfOrderRows = outOfOrderRows;
            this.outOfOrderColumns = outOfOrderColumns;
        }

        @Override
        public String toString() {
            return trace + " " + outOfOrderRows + " " + outOfOrderColumns;
        }
    }
}
