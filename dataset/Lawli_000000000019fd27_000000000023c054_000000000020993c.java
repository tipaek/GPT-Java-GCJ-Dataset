import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        int expectedSum = 2 * (n + 1) - ((n % 2) == 0 ? 0 : n/2 + 1);
        int expectedEvenSum = 0;
        for(int i = 1; i <= n; ++i) {
            if((i % 2) == 0) {
                expectedEvenSum += i;
            }
        }

        int trace = 0;
        int repeatedRows = 0;
        int repeatedColumns = 0;

        for(int i = 0; i < n; ++i) {
            int rowIndex = i*n;

            int rowSum = 0;
            int rowEvenSum = 0;

            for(int j = 0; j < n; ++j, ++rowIndex) {
                int element = matrix[rowIndex];

                if(i == j) {
                    trace += element;
                }
                rowSum += element;
                rowEvenSum += (element % 2) == 0 ? element : 0;
            }

            if(expectedSum != rowSum || expectedEvenSum != rowEvenSum) {
                ++repeatedRows;
            }

            int columnSum = 0;
            int columnEvenSum = 0;

            for(int columnIndex = i; columnIndex < n*n; columnIndex += n) {
                int element = matrix[columnIndex];

                columnSum += element;
                columnEvenSum += (element % 2) == 0 ? element : 0;
            }

            if(expectedSum != columnSum || expectedEvenSum != columnEvenSum) {
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
