import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Parenting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int numActivities = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            
            for (int i = 0; i < numActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(start, end, i));
            }
            
            String result = assignActivities(activities);
            System.out.println("Case #" + caseNum + ": " + result);
        }
        
        scanner.close();
    }

    private static String assignActivities(List<Activity> activities) {
        Collections.sort(activities);
        String[] assignments = new String[activities.size()];
        int cEnd = 0, jEnd = 0;
        
        for (Activity activity : activities) {
            if (activity.start >= cEnd) {
                assignments[activity.index] = "C";
                cEnd = activity.end;
            } else if (activity.start >= jEnd) {
                assignments[activity.index] = "J";
                jEnd = activity.end;
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (String assignment : assignments) {
            result.append(assignment);
        }
        
        return result.toString();
    }

    static class Activity implements Comparable<Activity> {
        int start;
        int end;
        int index;

        Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Activity other) {
            return Integer.compare(this.start, other.start);
        }
    }
}