import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            
            for (int j = 0; j < n; j++) {
                startTimes[j] = scanner.nextInt();
                endTimes[j] = scanner.nextInt();
            }
            
            String result = scheduleActivities(startTimes, endTimes);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static String scheduleActivities(int[] startTimes, int[] endTimes) {
        List<Activity> activities = createActivities(startTimes, endTimes);
        int endTimeCameron = 0;
        int endTimeJamie = 0;
        
        for (Activity activity : activities) {
            if (activity.start >= endTimeCameron) {
                activity.assignedPerson = "C";
                endTimeCameron = activity.end;
            } else if (activity.start >= endTimeJamie) {
                activity.assignedPerson = "J";
                endTimeJamie = activity.end;
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        activities.sort(Comparator.comparingInt(Activity::getIndex));
        return activities.stream().map(Activity::getAssignedPerson).collect(Collectors.joining());
    }

    private static List<Activity> createActivities(int[] startTimes, int[] endTimes) {
        List<Activity> activities = new ArrayList<>();
        
        for (int i = 0; i < startTimes.length; i++) {
            activities.add(new Activity(startTimes[i], endTimes[i], i));
        }
        
        activities.sort(Comparator.comparingInt(Activity::getStart));
        return activities;
    }

    static class Activity {
        int start;
        int end;
        int index;
        String assignedPerson;

        public Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        public int getStart() {
            return start;
        }

        public int getIndex() {
            return index;
        }

        public String getAssignedPerson() {
            return assignedPerson;
        }
    }
}