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
            List<Character> assignments = new ArrayList<>(activityCount);
            Map<Character, List<Activity>> scheduleMap = new HashMap<>();
            
            for (int i = 0; i < activityCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(start, end));
            }
            
            List<Activity> originalActivities = new ArrayList<>(activities);
            activities.sort(Comparator.comparingInt(activity -> activity.start));
            
            for (int i = 0; i < activities.size(); i++) {
                Activity current = activities.get(i);
                char assignedPerson;
                
                if (i > 0) {
                    Activity previous = activities.get(i - 1);
                    char previousPerson = assignments.get(i - 1);
                    
                    if (previous.end > current.start) {
                        assignedPerson = previousPerson == 'C' ? 'J' : 'C';
                    } else {
                        assignedPerson = previousPerson;
                    }
                } else {
                    assignedPerson = 'C';
                }
                
                scheduleMap.computeIfAbsent(assignedPerson, k -> new ArrayList<>()).add(current);
                assignments.add(assignedPerson);
            }
            
            List<Character> finalAssignments = new ArrayList<>(Collections.nCopies(activityCount, ' '));
            for (int i = 0; i < originalActivities.size(); i++) {
                int index = activities.indexOf(originalActivities.get(i));
                finalAssignments.set(i, assignments.get(index));
            }
            
            if (isOverlapping(scheduleMap.get('C')) || isOverlapping(scheduleMap.get('J'))) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                for (char assignment : finalAssignments) {
                    result.append(assignment);
                }
                System.out.println("Case #" + t + ": " + result.toString());
            }
        }
    }

    private static boolean isOverlapping(List<Activity> activities) {
        if (activities == null || activities.size() <= 1) {
            return false;
        }
        activities.sort(Comparator.comparingInt(activity -> activity.start));
        
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

        public Activity(int start, int end) {
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