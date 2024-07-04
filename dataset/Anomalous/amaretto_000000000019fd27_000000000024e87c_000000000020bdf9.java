import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int test = 1; test <= testCases; test++) {
            int n = scanner.nextInt();
            int cameronEnd = 0, jamieEnd = 0;
            boolean possible = true;
            char[] schedule = new char[n];
            Activity[] activities = new Activity[n];
            
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[i] = new Activity(start, end, i);
            }
            
            Arrays.sort(activities, Comparator.comparingInt(a -> a.end));
            
            for (Activity activity : activities) {
                if (activity.start >= cameronEnd) {
                    schedule[activity.index] = 'C';
                    cameronEnd = activity.end;
                } else if (activity.start >= jamieEnd) {
                    schedule[activity.index] = 'J';
                    jamieEnd = activity.end;
                } else {
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                System.out.println("Case #" + test + ": " + new String(schedule));
            } else {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
            }
        }
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