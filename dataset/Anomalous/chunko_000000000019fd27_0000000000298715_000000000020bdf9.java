import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int totalTests = scanner.nextInt();
        
        for (int t = 1; t <= totalTests; ++t) {
            int n = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(start, end));
            }
            
            Collections.sort(activities);
            
            int cameronEnd = -1;
            int jamieEnd = -1;
            StringBuilder result = new StringBuilder();
            
            for (Activity activity : activities) {
                if (activity.start >= cameronEnd) {
                    cameronEnd = activity.end;
                    result.append("C");
                } else if (activity.start >= jamieEnd) {
                    jamieEnd = activity.end;
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            
            System.out.println("Case #" + t + ": " + result.toString());
        }
    }
    
    private static class Activity implements Comparable<Activity> {
        int start;
        int end;
        
        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        @Override
        public int compareTo(Activity other) {
            if (this.start == other.start) {
                return Integer.compare(this.end, other.end);
            }
            return Integer.compare(this.start, other.start);
        }
    }
}