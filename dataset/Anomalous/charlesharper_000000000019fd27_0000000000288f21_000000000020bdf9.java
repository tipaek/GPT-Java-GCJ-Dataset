import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(br.readLine());

        for (int i = 0; i < numCases; i++) {
            int l = Integer.parseInt(br.readLine());
            int[][] intervals = new int[l][2];
            boolean[] cameron = new boolean[1442];
            boolean[] jamie = new boolean[1442];
            StringBuilder output = new StringBuilder();

            for (int k = 0; k < l; k++) {
                String[] input = br.readLine().split(" ");
                intervals[k][0] = Integer.parseInt(input[0]);
                intervals[k][1] = Integer.parseInt(input[1]);
            }

            boolean possible = true;
            for (int k = 0; k < intervals.length; k++) {
                int start = intervals[k][0];
                int end = intervals[k][1];

                if (isAvailable(cameron, start, end)) {
                    mark(cameron, start, end);
                    output.append("C");
                } else if (isAvailable(jamie, start, end)) {
                    mark(jamie, start, end);
                    output.append("J");
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + (i + 1) + ": " + output.toString());
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean isAvailable(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i]) {
                return false;
            }
        }
        return true;
    }

    private static void mark(boolean[] schedule, int start, int end) {
        Arrays.fill(schedule, start, end, true);
    }
}