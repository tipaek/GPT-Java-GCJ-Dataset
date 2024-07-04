import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int activityCount = scanner.nextInt();
            List<Activity> activities = new ArrayList<>(activityCount);
            List<Character> schedule = new ArrayList<>(activityCount);
            Map<Character, List<Activity>> assignmentMap = new HashMap<>();

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
                    char previousPerson = schedule.get(i - 1);

                    if (previous.end > current.start) {
                        assignedPerson = (previousPerson == 'C') ? 'J' : 'C';
                    } else {
                        assignedPerson = previousPerson;
                    }
                } else {
                    assignedPerson = 'C';
                }

                assignmentMap.computeIfAbsent(assignedPerson, k -> new ArrayList<>()).add(current);
                schedule.add(assignedPerson);
            }

            List<Character> finalSchedule = new ArrayList<>(activityCount);
            for (Activity activity : originalActivities) {
                int index = activities.indexOf(activity);
                finalSchedule.add(originalActivities.indexOf(activity), schedule.get(index));
            }

            boolean conflictC = checkConflict(assignmentMap.get('C'));
            boolean conflictJ = checkConflict(assignmentMap.get('J'));

            if (conflictC || conflictJ) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                for (char c : finalSchedule) {
                    result.append(c);
                }
                System.out.println("Case #" + t + ": " + result.toString());
            }
        }
    }

    private static boolean checkConflict(List<Activity> activities) {
        if (activities == null || activities.size() <= 1) {
            return false;
        }

        activities.sort(Comparator.comparingInt(a -> a.start));
        for (int i = 0; i < activities.size() - 1; i++) {
            if (activities.get(i).end > activities.get(i + 1).start) {
                return true;
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