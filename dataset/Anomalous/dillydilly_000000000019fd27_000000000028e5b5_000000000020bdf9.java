import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            List<Activity> activities = readActivities(scanner);
            String result = assignActivities(activities);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static List<Activity> readActivities(Scanner scanner) {
        int numberOfActivities = scanner.nextInt();
        List<Activity> activities = new ArrayList<>();
        
        for (int i = 0; i < numberOfActivities; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            activities.add(new Activity(i, start, end));
        }
        
        return activities;
    }

    private static String assignActivities(List<Activity> activities) {
        Collections.sort(activities);
        char[] assignments = new char[activities.size()];
        int endC = 0, endJ = 0;
        
        for (Activity activity : activities) {
            if (activity.start >= endC) {
                assignments[activity.index] = 'C';
                endC = activity.end;
            } else if (activity.start >= endJ) {
                assignments[activity.index] = 'J';
                endJ = activity.end;
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        return new String(assignments);
    }

    private static class Activity implements Comparable<Activity> {
        int index;
        int start;
        int end;

        Activity(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Activity other) {
            return Integer.compare(this.start, other.start);
        }
    }
}