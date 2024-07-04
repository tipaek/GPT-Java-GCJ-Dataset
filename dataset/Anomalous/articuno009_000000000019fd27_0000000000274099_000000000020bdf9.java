import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 0; t < testCases; t++) {
            int activitiesCount = Integer.parseInt(scanner.nextLine());
            Map<Integer, Integer> activityTimes = new TreeMap<>();
            Map<Integer, String> activityAssignments = new LinkedHashMap<>();

            for (int j = 0; j < activitiesCount; j++) {
                String[] input = scanner.nextLine().split(" ");
                int startTime = Integer.parseInt(input[0]);
                int endTime = Integer.parseInt(input[1]);
                activityTimes.put(startTime, endTime);
                activityAssignments.put(startTime, input[1]);
            }

            int cameronEndTime = -1;
            int jamieEndTime = -1;
            String result = "";

            for (Map.Entry<Integer, Integer> entry : activityTimes.entrySet()) {
                int startTime = entry.getKey();
                int endTime = entry.getValue();

                if (startTime >= cameronEndTime) {
                    cameronEndTime = endTime;
                    activityAssignments.put(startTime, "C");
                } else if (startTime >= jamieEndTime) {
                    jamieEndTime = endTime;
                    activityAssignments.put(startTime, "J");
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }

            if (!result.equals("IMPOSSIBLE")) {
                StringBuilder schedule = new StringBuilder();
                for (String assigned : activityAssignments.values()) {
                    schedule.append(assigned);
                }
                result = schedule.toString();
            }

            System.out.println("Case #" + (t + 1) + ": " + result);
        }

        scanner.close();
    }
}