import java.util.*;
import java.io.*;

public class Solution {

    public static boolean hasOverlap(List<List<Integer>> schedule, int start, int end) {
        for (List<Integer> activity : schedule) {
            int activityStart = activity.get(0);
            int activityEnd = activity.get(1);

            if ((start >= activityStart && start < activityEnd) || (end > activityStart && end < activityEnd)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();

            List<List<Integer>> cameronSchedule = new ArrayList<>();
            List<List<Integer>> jameySchedule = new ArrayList<>();
            StringBuilder output = new StringBuilder();

            boolean possible = true;

            for (int j = 0; j < n; j++) {
                int activityStart = scanner.nextInt();
                int activityEnd = scanner.nextInt();

                List<Integer> activity = Arrays.asList(activityStart, activityEnd);

                if (!hasOverlap(cameronSchedule, activityStart, activityEnd)) {
                    cameronSchedule.add(activity);
                    output.append("C");
                } else if (!hasOverlap(jameySchedule, activityStart, activityEnd)) {
                    jameySchedule.add(activity);
                    output.append("J");
                } else {
                    output = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + output);
        }
    }
}