import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int[][] input = readInput(in);
            int[] result = solve(input);
            System.out.println("Case #" + i + ": " + result[0] + " " + result[1] + " " + result[2]);
        }
    }
    public static int[][] readInput(Scanner in) {
        int n = in.nextInt();
        int [][] result = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                result[i][j] = in.nextInt();
            }
        }
        return result;
    }
    public static int[] solve(int[][] input) {
        int k = 0, r = 0, c = 0;
        int n = input.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    k += input[i][j];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[n];
            for (int j = 0; j < n; j++) {
                if (seen[input[i][j] - 1]) {
                    r++;
                    break;
                } else {
                    seen[input[i][j] - 1] = true;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            boolean[] seen = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (seen[input[i][j] - 1]) {
                    c++;
                    break;
                } else {
                    seen[input[i][j] - 1] = true;
                }
            }
        }
        return new int[] { k, r, c };
    }
}
