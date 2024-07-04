import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < testCases; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            int activitiesCount = Integer.parseInt(br.readLine());
            Activity[] activities = new Activity[activitiesCount];
            
            for (int j = 0; j < activitiesCount; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                activities[j] = new Activity(start, end);
            }
            
            Arrays.sort(activities);
            StringBuilder result = new StringBuilder();
            boolean isSolvable = true;
            int cameronEndTime = -1;
            int jamieEndTime = -1;
            
            for (Activity activity : activities) {
                if (cameronEndTime <= activity.start) {
                    result.append("C");
                    cameronEndTime = activity.end;
                } else if (jamieEndTime <= activity.start) {
                    result.append("J");
                    jamieEndTime = activity.end;
                } else {
                    isSolvable = false;
                    break;
                }
            }
            
            if (isSolvable) {
                System.out.print(result.toString());
            } else {
                System.out.print("IMPOSSIBLE");
            }
            
            if (i != testCases - 1) {
                System.out.println();
            }
        }
    }
    
    static class Activity implements Comparable<Activity> {
        int start, end;
        
        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        @Override
        public int compareTo(Activity other) {
            return Integer.compare(this.start, other.start);
        }
    }
}