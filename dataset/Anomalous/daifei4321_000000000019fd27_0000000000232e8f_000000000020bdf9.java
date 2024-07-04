import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int activitiesCount = scanner.nextInt();
            Activity[] activities = new Activity[activitiesCount];
            
            for (int i = 0; i < activitiesCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[i] = new Activity(start, end, i);
            }
            
            Arrays.sort(activities, (a, b) -> {
                int startComparison = Integer.compare(a.start, b.start);
                return startComparison != 0 ? startComparison : Integer.compare(a.end, b.end);
            });
            
            StringBuilder schedule = new StringBuilder(activitiesCount);
            for (int i = 0; i < activitiesCount; i++) {
                schedule.append(' ');
            }
            
            int cameronEnd = 0, jamieEnd = 0;
            boolean possible = true;
            
            for (Activity activity : activities) {
                if (activity.start >= cameronEnd) {
                    schedule.setCharAt(activity.index, 'C');
                    cameronEnd = activity.end;
                } else if (activity.start >= jamieEnd) {
                    schedule.setCharAt(activity.index, 'J');
                    jamieEnd = activity.end;
                } else {
                    possible = false;
                    break;
                }
            }
            
            if (!possible) {
                System.out.println("CASE #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("CASE #" + (t + 1) + ": " + schedule.toString());
            }
        }
        
        scanner.close();
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