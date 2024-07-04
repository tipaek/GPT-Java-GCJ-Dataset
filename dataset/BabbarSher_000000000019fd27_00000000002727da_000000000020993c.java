import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try(Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
            for (int i = 1; i <= t; ++i) {
                int n = in.nextInt();
                in.nextLine();
                int[][] input = new int[n][n];

                for(int j = 0; j <n*n; j++) {
                    int ele = in.nextInt();
                    input[j/n][j%n] = ele;
                }
                int[] result = solve(input, n);
                System.out.println("Case #" + i + ": " + (result[0]) + " " + (result[1]) + " " + (result[2]));
            }
        };
    }

    private static int[] solve(int[][] input, int n) {
        int[] result = new int[3];

        int trace = 0;
        for(int i = 0; i < input.length; i++) {
            boolean[] values = new boolean[n+1];
            boolean hasRepeated = false;
            for(int j = 0; j < input.length; j++) {
                if(i == j) {
                    trace += input[i][j];
                }

                if(values[input[i][j]]) {
                    hasRepeated = true;
                }
                values[input[i][j]] = true;
            }
            if(hasRepeated) {
                result[1]++;
            }
        }
        result[0] = trace;

        for(int i = 0; i < input.length; i++) {
            boolean[] values = new boolean[n+1];
            boolean hasRepeated = false;
            for(int j = 0; j < input.length; j++) {
                if(values[input[j][i]]) {
                    hasRepeated = true;
                }
                values[input[j][i]] = true;
            }
            if(hasRepeated) {
                result[2]++;
            }
        }

        return result;
    }
}
