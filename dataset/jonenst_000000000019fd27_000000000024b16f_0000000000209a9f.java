import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            int[] input = readInput(in);
            String result = solve(input);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static int[] readInput(Scanner in) {
        return in.nextLine().chars().map(c -> c - '0').toArray();
    }

    public static String solve(int[] input) {
        int cur = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            if (cur < input[i]) {
                for (int j = 0; j < (input[i] - cur); j++) {
                    sb.append('(');
                }
            } else if (cur > input[i]) {
                for (int j = 0; j < (cur - input[i]); j++) {
                    sb.append(')');
                }
            }
            cur = input[i];
            sb.append((char) (input[i] + '0'));
        }
        if (cur > 0) {
            for (int j = 0; j < cur; j++) {
                sb.append(')');
            }
        }
        return sb.toString();
    }
}
