import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanner.nextInt();

        for (int testCase = 1; testCase <= numberOfTestCases; ++testCase) {
            int numberOfActivities = scanner.nextInt();
            List<TimeDuration> activities = new ArrayList<>(numberOfActivities);
            List<Character> assignments = new ArrayList<>(numberOfActivities);
            Map<Character, List<TimeDuration>> scheduleMap = new HashMap<>();

            for (int i = 0; i < numberOfActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new TimeDuration(start, end));
            }

            List<TimeDuration> sortedActivities = new ArrayList<>(activities);
            sortedActivities.sort(Comparator.comparingInt(a -> a.begin));

            for (int i = 0; i < sortedActivities.size(); i++) {
                TimeDuration currentActivity = sortedActivities.get(i);
                char assignedPerson;

                if (i > 0) {
                    TimeDuration previousActivity = sortedActivities.get(i - 1);
                    char previousPerson = assignments.get(i - 1);

                    if (previousActivity.end > currentActivity.begin) {
                        assignedPerson = previousPerson == 'C' ? 'J' : 'C';
                    } else {
                        assignedPerson = previousPerson;
                    }
                } else {
                    assignedPerson = 'C';
                }

                scheduleMap.computeIfAbsent(assignedPerson, k -> new ArrayList<>()).add(currentActivity);
                assignments.add(assignedPerson);
            }

            List<Character> finalAssignments = new ArrayList<>(numberOfActivities);
            for (TimeDuration activity : activities) {
                int index = sortedActivities.indexOf(activity);
                finalAssignments.add(assignments.get(index));
            }

            boolean conflictC = hasConflict(scheduleMap.get('C'));
            boolean conflictJ = hasConflict(scheduleMap.get('J'));

            if (conflictC || conflictJ) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                StringBuilder resultBuilder = new StringBuilder();
                for (char assignment : finalAssignments) {
                    resultBuilder.append(assignment);
                }
                System.out.println("Case #" + testCase + ": " + resultBuilder.toString());
            }
        }
    }

    private static boolean hasConflict(List<TimeDuration> activities) {
        if (activities == null || activities.size() <= 1) {
            return false;
        }
        for (int i = 0; i < activities.size() - 1; i++) {
            if (activities.get(i).end > activities.get(i + 1).begin) {
                return true;
            }
        }
        return false;
    }

    private static class TimeDuration {
        int begin;
        int end;

        public TimeDuration(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TimeDuration that = (TimeDuration) o;
            return begin == that.begin && end == that.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(begin, end);
        }
    }
}