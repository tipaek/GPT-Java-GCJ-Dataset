import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int k = 1; k <= T; k++) {
            int N = scanner.nextInt();
            int[][] intervals = new int[N][2];
            List<Integer> cIntervals = new ArrayList<>();
            List<Integer> jIntervals = new ArrayList<>();
            StringBuilder output = new StringBuilder();

            for (int i = 0; i < N; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            for (int i = 0; i < N; i++) {
                int start = intervals[i][0];
                int end = intervals[i][1];

                if (canAddInterval(cIntervals, start, end)) {
                    cIntervals.add(start);
                    cIntervals.add(end);
                    Collections.sort(cIntervals);
                    output.append("C");
                } else if (canAddInterval(jIntervals, start, end)) {
                    jIntervals.add(start);
                    jIntervals.add(end);
                    Collections.sort(jIntervals);
                    output.append("J");
                } else {
                    output.setLength(0);
                    output.append("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + k + ": " + output);
        }
    }

    private static boolean canAddInterval(List<Integer> intervals, int start, int end) {
        if (intervals.isEmpty()) {
            return true;
        }
        for (int i = 0; i < intervals.size(); i += 2) {
            if (end <= intervals.get(i) || start >= intervals.get(i + 1)) {
                continue;
            }
            if (start >= intervals.get(i) && end <= intervals.get(i + 1)) {
                return true;
            }
        }
        return false;
    }
}