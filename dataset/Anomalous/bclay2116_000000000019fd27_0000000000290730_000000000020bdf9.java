import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < testCases; i++) {
            int activitiesCount = Integer.parseInt(scanner.nextLine());
            List<Activity> activities = new ArrayList<>();

            for (int j = 0; j < activitiesCount; j++) {
                String[] times = scanner.nextLine().split(" ");
                activities.add(new Activity(Integer.parseInt(times[0]), Integer.parseInt(times[1]), j));
            }

            activities.sort(Comparator.comparingInt(a -> a.start));
            List<Activity> ongoingActivities = new ArrayList<>();
            StringBuilder caseResult = new StringBuilder();

            for (Activity activity : activities) {
                ongoingActivities.removeIf(a -> a.end <= activity.start);

                if (ongoingActivities.size() > 1) {
                    caseResult.append("IMPOSSIBLE");
                    break;
                }

                if (ongoingActivities.isEmpty()) {
                    activity.person = "J";
                } else {
                    activity.person = ongoingActivities.get(0).person.equals("J") ? "C" : "J";
                }

                ongoingActivities.add(activity);
            }

            if (caseResult.length() == 0) {
                activities.sort(Comparator.comparingInt(a -> a.order));
                for (Activity activity : activities) {
                    caseResult.append(activity.person);
                }
            }

            result.append("Case #").append(i + 1).append(": ").append(caseResult).append("\n");
        }

        System.out.print(result);
    }

    static class Activity {
        int start;
        int end;
        int order;
        String person;

        Activity(int start, int end, int order) {
            this.start = start;
            this.end = end;
            this.order = order;
        }
    }
}