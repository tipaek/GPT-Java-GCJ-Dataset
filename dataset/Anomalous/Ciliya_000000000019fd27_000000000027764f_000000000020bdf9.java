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
            for (int i = 0; i < N; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            String result = assignTasks(intervals, N);
            System.out.println("Case #" + k + ": " + result);
        }
        scanner.close();
    }

    private static String assignTasks(int[][] intervals, int N) {
        List<Integer> cIntervals = new ArrayList<>();
        List<Integer> jIntervals = new ArrayList<>();
        StringBuilder output = new StringBuilder();

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
                return "IMPOSSIBLE";
            }
        }

        return output.toString();
    }

    private static boolean canAddInterval(List<Integer> intervals, int start, int end) {
        if (intervals.isEmpty()) {
            return true;
        }

        for (int i = 0; i < intervals.size(); i += 2) {
            int existingStart = intervals.get(i);
            int existingEnd = intervals.get(i + 1);

            if (end <= existingStart || start >= existingEnd) {
                continue;
            }
            return false;
        }

        return true;
    }
}