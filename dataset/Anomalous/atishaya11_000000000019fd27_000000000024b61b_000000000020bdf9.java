import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            Activity[] activities = new Activity[n];
            
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[i] = new Activity(start, end, i);
            }
            
            Arrays.sort(activities, (a, b) -> {
                if (a.start == b.start) {
                    return Integer.compare(a.end, b.end);
                }
                return Integer.compare(a.start, b.start);
            });

            char[] schedule = new char[n];
            boolean isImpossible = false;
            int endC = 0;
            int endJ = 0;
            
            for (Activity activity : activities) {
                if (endC <= activity.start) {
                    schedule[activity.index] = 'C';
                    endC = activity.end;
                } else if (endJ <= activity.start) {
                    schedule[activity.index] = 'J';
                    endJ = activity.end;
                } else {
                    isImpossible = true;
                    break;
                }
            }
            
            String result = isImpossible ? "IMPOSSIBLE" : new String(schedule);
            System.out.printf("Case #%d: %s\n", t, result);
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