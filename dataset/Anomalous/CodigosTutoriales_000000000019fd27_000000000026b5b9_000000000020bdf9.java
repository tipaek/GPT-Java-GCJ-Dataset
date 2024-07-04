import java.util.*;

/**
 * Made and solved successfully by the Prodigy Programmer
 * Author: Julian Paniagua
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int numberOfActivities = scanner.nextInt();
            Activity[] activities = new Activity[numberOfActivities];
            char[] assignments = new char[numberOfActivities];
            Arrays.fill(assignments, '@');
            
            for (int i = 0; i < numberOfActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[i] = new Activity(start, end, i);
            }
            
            Arrays.sort(activities, Comparator.comparingInt(a -> a.start));
            
            if (assignActivities(activities, assignments, 'C') && assignActivities(activities, assignments, 'J')) {
                System.out.println("Case #" + t + ": " + new String(assignments));
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean assignActivities(Activity[] activities, char[] assignments, char person) {
        int end = 0;
        
        for (Activity activity : activities) {
            if (assignments[activity.index] == '@' && activity.start >= end) {
                assignments[activity.index] = person;
                end = activity.end;
            }
        }
        
        return !new String(assignments).contains("@");
    }

    static class Activity {
        int start;
        int end;
        int index;

        Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}