import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int[][] input = readInput(in);
            String result = solve(input);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static int[][] readInput(Scanner in) {
        int n = in.nextInt();
        int[][] result = new int[n][2];
        for (int i = 0; i < n; i++) {
            result[i][0] = in.nextInt();
            result[i][1] = in.nextInt();
        }
        Arrays.sort(result, Comparator.comparing(t -> t[0]));
        return result;
    }

    public static String solve(int[][] input) {
        int n = input.length;
        int cbusy = -1;
        int jbusy = -1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (cbusy <= input[i][0]) {
                cbusy = -1;
            }
            if (jbusy <= input[i][0]) {
                jbusy = -1;
            }
            if (cbusy == -1) {
                cbusy = input[i][1];
                sb.append('C');
            } else if (jbusy == -1) {
                jbusy = input[i][1];
                sb.append('J');
            } else {
                return "IMPOSSIBLE";
            }
        }
        return sb.toString();
    }
}
