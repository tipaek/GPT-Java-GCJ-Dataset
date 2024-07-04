import java.util.*;

public class Solution {
    
    static class Activity {
        int begin;
        int end;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        
        for (int test = 1; test <= tests; test++) {
            int nActivities = scanner.nextInt();
            Activity[] activities = new Activity[nActivities];
            
            for (int i = 0; i < nActivities; i++) {
                activities[i] = new Activity();
                activities[i].begin = scanner.nextInt();
                activities[i].end = scanner.nextInt();
            }
            
            Arrays.sort(activities, (a1, a2) -> {
                if (a1.begin != a2.begin) {
                    return Integer.compare(a1.begin, a2.begin);
                }
                return Integer.compare(a1.end, a2.end);
            });
            
            int cEnd = -1;
            int jEnd = -1;
            boolean impossible = false;
            StringBuilder schedule = new StringBuilder();
            
            for (Activity activity : activities) {
                if (cEnd <= activity.begin) {
                    schedule.append("C");
                    cEnd = activity.end;
                } else if (jEnd <= activity.begin) {
                    schedule.append("J");
                    jEnd = activity.end;
                } else {
                    impossible = true;
                    break;
                }
            }
            
            String result = impossible ? "IMPOSSIBLE" : schedule.toString();
            System.out.println("Case #" + test + ": " + result);
        }
        
        scanner.close();
    }
}