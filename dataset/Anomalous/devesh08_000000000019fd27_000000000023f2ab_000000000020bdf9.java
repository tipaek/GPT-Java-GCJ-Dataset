import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            List<Integer>[] cameron = new ArrayList[2];
            List<Integer>[] jamie = new ArrayList[2];
            for (int i = 0; i < 2; i++) {
                cameron[i] = new ArrayList<>();
                jamie[i] = new ArrayList<>();
            }

            StringBuilder result = new StringBuilder();
            outerLoop:
            for (int i = 0; i < n; i++) {
                int start = intervals[i][0];
                int end = intervals[i][1];
                boolean assigned = false;

                if (canAssign(cameron, start, end)) {
                    cameron[0].add(start);
                    cameron[1].add(end);
                    result.append("C");
                    assigned = true;
                }

                if (!assigned && canAssign(jamie, start, end)) {
                    jamie[0].add(start);
                    jamie[1].add(end);
                    result.append("J");
                    assigned = true;
                }

                if (!assigned) {
                    result = new StringBuilder("IMPOSSIBLE");
                    break outerLoop;
                }
            }

            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static boolean canAssign(List<Integer>[] schedule, int start, int end) {
        for (int j = 0; j < schedule[0].size(); j++) {
            if ((end > schedule[0].get(j) && start < schedule[1].get(j)) ||
                (start < schedule[1].get(j) && end > schedule[0].get(j))) {
                return false;
            }
        }
        return true;
    }
}