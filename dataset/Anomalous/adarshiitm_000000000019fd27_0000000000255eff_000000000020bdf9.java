import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int activitiesCount = scanner.nextInt();
            System.out.println("Case #" + caseNumber + ": " + assignActivities(activitiesCount, scanner));
        }
    }

    static class Activity {
        int time;
        boolean isStart;
        int index;

        public Activity(int time, boolean isStart, int index) {
            this.time = time;
            this.isStart = isStart;
            this.index = index;
        }
    }

    private static String assignActivities(int activitiesCount, Scanner scanner) {
        List<Activity> activities = new ArrayList<>();
        
        for (int i = 0; i < activitiesCount; i++) {
            activities.add(new Activity(scanner.nextInt(), true, i));
            activities.add(new Activity(scanner.nextInt(), false, i));
        }

        Collections.sort(activities, (a, b) -> {
            if (a.time == b.time) {
                return Boolean.compare(a.isStart, b.isStart);
            }
            return Integer.compare(a.time, b.time);
        });

        char[] schedule = new char[activitiesCount];
        int cameron = -1, jamie = -1;

        for (Activity activity : activities) {
            if (activity.isStart) {
                if (cameron == -1) {
                    cameron = activity.index;
                    schedule[activity.index] = 'C';
                } else if (jamie == -1) {
                    jamie = activity.index;
                    schedule[activity.index] = 'J';
                } else {
                    return "IMPOSSIBLE";
                }
            } else {
                if (cameron == activity.index) {
                    cameron = -1;
                } else if (jamie == activity.index) {
                    jamie = -1;
                }
            }
        }
        return new String(schedule);
    }
}