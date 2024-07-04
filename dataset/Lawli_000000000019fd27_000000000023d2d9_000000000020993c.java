import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[] matrix = new int[n*n];
            for(int j = 0; j < n*n; ++j) {
                matrix[j] = in.nextInt();
            }
            Result result = solve(matrix, n);
            System.out.println("Case #" + i + ": " + result.trace + " " + result.repeatedRows + " " + result.repeatedColumns);
        }
    }

    private static Result solve(int[] matrix, int n) {
        int trace = 0;
        int repeatedRows = 0;
        int repeatedColumns = 0;

        BitSet flags = new BitSet(n);
        boolean foundRepeated;

        for(int i = 0; i < n; ++i) {
            trace += matrix[i*n + i];

            int rowIndex = i*n;

            foundRepeated = false;
            flags.clear();

            for(int j = 0; j < n; ++j, ++rowIndex) {
                int element = matrix[rowIndex];

                if(flags.get(element)) {
                    foundRepeated = true;
                    break;
                }

                flags.set(element);
            }

            if(foundRepeated) {
                ++repeatedRows;
            }

            foundRepeated = false;
            flags.clear();

            for(int columnIndex = i; columnIndex < n*n; columnIndex += n) {
                int element = matrix[columnIndex];

                if(flags.get(element)) {
                    foundRepeated = true;
                    break;
                }

                flags.set(element);
            }

            if(foundRepeated) {
                ++repeatedColumns;
            }
        }

        return new Result(trace, repeatedRows, repeatedColumns);
    }

    private static class Result {
        private final int trace;
        private final int repeatedRows;
        private final int repeatedColumns;

        private Result(int trace, int repeatedRows, int repeatedColumns) {
            this.trace = trace;
            this.repeatedRows = repeatedRows;
            this.repeatedColumns = repeatedColumns;
        }
    }
}
