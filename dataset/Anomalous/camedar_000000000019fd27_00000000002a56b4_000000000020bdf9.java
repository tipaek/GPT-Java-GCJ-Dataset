import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    public static boolean isOverlapped(List<Integer> ranges, int from, int until) {
        for (int i = 0; i < ranges.size(); i += 2) {
            if ((from > ranges.get(i) && from < ranges.get(i + 1)) || (until > ranges.get(i) && until < ranges.get(i + 1))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String... args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
            List<Integer> cameronSchedule = new ArrayList<>();
            List<Integer> jaimieSchedule = new ArrayList<>();
            StringBuilder scheduleResult = new StringBuilder();
            int activityCount = scanner.nextInt();
            scanner.nextLine();

            for (int activityIndex = 0; activityIndex < activityCount; activityIndex++) {
                String[] timeRange = scanner.nextLine().split(" ");
                int startTime = Integer.parseInt(timeRange[0]);
                int endTime = Integer.parseInt(timeRange[1]);

                if (!isOverlapped(cameronSchedule, startTime, endTime)) {
                    cameronSchedule.add(startTime);
                    cameronSchedule.add(endTime);
                    scheduleResult.append('C');
                } else if (!isOverlapped(jaimieSchedule, startTime, endTime)) {
                    jaimieSchedule.add(startTime);
                    jaimieSchedule.add(endTime);
                    scheduleResult.append('J');
                } else {
                    scheduleResult = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + caseIndex + ": " + scheduleResult.toString());
        }
    }
}