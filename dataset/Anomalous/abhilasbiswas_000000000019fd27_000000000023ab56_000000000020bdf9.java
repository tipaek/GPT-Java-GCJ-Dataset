import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = input.nextInt();
        for (int i = 1; i <= T; i++) {
            String result = processTestCase(input);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String processTestCase(Scanner input) {
        boolean[] c = new boolean[1441];
        boolean[] j = new boolean[1441];
        StringBuilder result = new StringBuilder();

        int n = input.nextInt();
        int[][] intervals = new int[n][2];

        for (int i = 0; i < n; i++) {
            intervals[i][0] = input.nextInt();
            intervals[i][1] = input.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (tryAssign(c, start, end)) {
                result.append("C");
            } else if (tryAssign(j, start, end)) {
                result.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return result.toString();
    }

    public static boolean tryAssign(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i]) {
                for (int j = start; j < i; j++) {
                    schedule[j] = false;
                }
                return false;
            }
            schedule[i] = true;
        }
        return true;
    }
}