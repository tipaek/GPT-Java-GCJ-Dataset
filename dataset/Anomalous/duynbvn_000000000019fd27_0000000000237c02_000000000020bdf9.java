import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= numberOfTestCases; ++testCase) {
            int numberOfActivities = scanner.nextInt();
            List<Activity> activities = new ArrayList<>(numberOfActivities);
            List<Character> assignments = new ArrayList<>(numberOfActivities);
            Map<Character, List<Activity>> personActivitiesMap = new HashMap<>();
            
            for (int i = 0; i < numberOfActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(start, end));
            }

            List<Activity> sortedActivities = new ArrayList<>(activities);
            sortedActivities.sort(Comparator.comparingInt(activity -> activity.start));
            
            for (int i = 0; i < sortedActivities.size(); i++) {
                Activity currentActivity = sortedActivities.get(i);
                char assignedPerson;
                
                if (i > 0) {
                    Activity previousActivity = sortedActivities.get(i - 1);
                    char previousPerson = assignments.get(i - 1);
                    assignedPerson = (previousActivity.end > currentActivity.start) ? 
                                      (previousPerson == 'C' ? 'J' : 'C') : previousPerson;
                } else {
                    assignedPerson = 'C';
                }
                
                personActivitiesMap.computeIfAbsent(assignedPerson, k -> new ArrayList<>()).add(currentActivity);
                assignments.add(assignedPerson);
            }

            List<Character> finalAssignments = new ArrayList<>(numberOfActivities);
            for (Activity activity : activities) {
                int index = sortedActivities.indexOf(activity);
                finalAssignments.add(assignments.get(index));
            }

            boolean conflictC = hasConflict(personActivitiesMap.get('C'));
            boolean conflictJ = hasConflict(personActivitiesMap.get('J'));

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

    private static boolean hasConflict(List<Activity> activities) {
        if (activities == null || activities.size() <= 1) {
            return false;
        }
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
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Activity activity = (Activity) o;
            return start == activity.start && end == activity.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }
}