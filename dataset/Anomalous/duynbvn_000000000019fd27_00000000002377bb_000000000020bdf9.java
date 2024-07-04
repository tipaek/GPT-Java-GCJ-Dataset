import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int activityCount = scanner.nextInt();
            List<Activity> activities = new ArrayList<>(activityCount);
            List<Character> assignments = new ArrayList<>(activityCount);
            Map<Character, List<Activity>> scheduleMap = new HashMap<>();

            for (int i = 0; i < activityCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(start, end));
            }

            List<Activity> originalActivities = new ArrayList<>(activities);
            activities.sort(Comparator.comparingInt(a -> a.start));

            for (int i = 0; i < activities.size(); i++) {
                Activity current = activities.get(i);
                char assignedPerson;

                if (i > 0) {
                    Activity previous = activities.get(i - 1);
                    char previousPerson = assignments.get(i - 1);
                    assignedPerson = (previous.end > current.start) ? (previousPerson == 'C' ? 'J' : 'C') : previousPerson;
                } else {
                    assignedPerson = 'C';
                }

                scheduleMap.computeIfAbsent(assignedPerson, k -> new ArrayList<>()).add(current);
                assignments.add(assignedPerson);
            }

            List<Character> finalAssignments = new ArrayList<>(activityCount);
            for (Activity activity : originalActivities) {
                int index = activities.indexOf(activity);
                finalAssignments.add(originalActivities.indexOf(activity), assignments.get(index));
            }

            boolean impossibleC = isScheduleImpossible(scheduleMap.get('C'));
            boolean impossibleJ = isScheduleImpossible(scheduleMap.get('J'));

            if (impossibleC || impossibleJ) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                StringBuilder resultBuilder = new StringBuilder();
                finalAssignments.forEach(resultBuilder::append);
                System.out.println("Case #" + testCase + ": " + resultBuilder.toString());
            }
        }
    }

    private static boolean isScheduleImpossible(List<Activity> activities) {
        if (activities != null && activities.size() > 1) {
            for (int i = 0; i < activities.size() - 1; i++) {
                if (activities.get(i).end > activities.get(i + 1).start) {
                    return true;
                }
            }
        }
        return false;
    }

    private static class Activity {
        int start;
        int end;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Activity activity = (Activity) obj;
            return start == activity.start && end == activity.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }
}