import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int N = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            
            for (int i = 0; i < N; i++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt(), i));
            }
            
            String result = assignActivities(activities, N);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
        
        scanner.close();
    }

    public static String assignActivities(List<Activity> activities, int N) {
        Collections.sort(activities);
        String[] schedule = new String[N];
        List<Activity> cSchedule = new ArrayList<>();
        List<Activity> jSchedule = new ArrayList<>();
        
        for (Activity activity : activities) {
            if (cSchedule.isEmpty() || activity.start >= cSchedule.get(cSchedule.size() - 1).end) {
                cSchedule.add(activity);
                schedule[activity.index] = "C";
            } else if (jSchedule.isEmpty() || activity.start >= jSchedule.get(jSchedule.size() - 1).end) {
                jSchedule.add(activity);
                schedule[activity.index] = "J";
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        return String.join("", schedule);
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