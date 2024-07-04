import java.util.*;
import java.io.*;

class VestigiumSolution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            in.nextLine();
            int[][] input = new int[n][n];

            for(int j = 0; j <n; j++) {
                String rowLine = in.nextLine();
                String[] row = rowLine.split(" ");
                initializeRow(j, input, row);
            }
            int[] result = solve(input, n);
            System.out.println("Case #" + i + ": " + (result[0]) + " " + (result[1]) + " " + (result[2]));
        }
    }

    private static int[] solve(int[][] input, int n) {
        int[] result = new int[3];
        int[] sumRows = new int[input.length];
        int[] sumColumns = new int[input.length];
        int desiredSum = (n * (n+1)) / 2;

        int trace = 0;
        for(int i = 0; i < input.length; i++) {
            for(int j = 0; j < input.length; j++) {
                if(i == j) {
                    trace += input[i][j];
                }

                sumColumns[j] += input[i][j];
                sumRows[i] += input[i][j];
            }
        }
        result[0] = trace;

        for(int i = 0; i < n; i++) {
            if(sumRows[i] != desiredSum) {
                result[1]++;
            }

            if(sumColumns[i] != desiredSum) {
                result[2]++;
            }
        }

        return result;
    }

    private static void initializeRow(int rowNumber, int[][] input, String[] row) {
        for(int i = 0; i < row.length; i++) {
            input[rowNumber][i] = Integer.parseInt(row[i]);
        }
    }
}
