import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
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
        int[][] result = new int[n][3];
        for (int i = 0; i < n; i++) {
            result[i][0] = in.nextInt();
            result[i][1] = in.nextInt();
            result[i][2] = i;
        }
        Arrays.sort(result, Comparator.comparing(t -> t[0]));
        return result;
    }

    public static String solve(int[][] input) {
        int n = input.length;
        int cbusy = -1;
        int jbusy = -1;
        int[][] results = new int[n][2];
        for (int i = 0; i < n; i++) {
            results[i][1] = input[i][2];
            if (cbusy <= input[i][0]) {
                cbusy = -1;
            }
            if (jbusy <= input[i][0]) {
                jbusy = -1;
            }
            if (cbusy == -1) {
                cbusy = input[i][1];
                results[i][0] = 'C';
            } else if (jbusy == -1) {
                results[i][0] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }
        Arrays.sort(results, Comparator.comparing(t -> t[1]));
        return Arrays.stream(results).map(t -> String.valueOf((char) t[0])).collect(Collectors.joining());
    }
}
