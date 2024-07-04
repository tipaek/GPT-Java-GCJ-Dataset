import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int totalTests = scanner.nextInt();
        
        for (int t = 1; t <= totalTests; ++t) {
            int n = scanner.nextInt();
            Activity[] activities = new Activity[n];
            
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[i] = new Activity(start, end, i);
            }
            
            Arrays.sort(activities, Comparator.comparingInt(a -> a.start));
            
            int[] cameron = new int[]{-1, -1};
            int[] jamie = new int[]{-1, -1};
            char[] result = new char[n];
            boolean possible = true;
            
            for (Activity act : activities) {
                if (cameron[1] <= act.start) {
                    cameron = new int[]{act.start, act.end};
                    result[act.index] = 'C';
                } else if (jamie[1] <= act.start) {
                    jamie = new int[]{act.start, act.end};
                    result[act.index] = 'J';
                } else {
                    possible = false;
                    break;
                }
            }
            
            System.out.println("Case #" + t + ": " + (possible ? new String(result) : "IMPOSSIBLE"));
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