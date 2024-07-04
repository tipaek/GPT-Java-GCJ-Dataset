import java.util.*;
import java.io.*;

public class Solution {

    public static boolean overlaps(List<List<Integer>> schedule, int start, int end) {
        for (List<Integer> activity : schedule) {
            int activityStart = activity.get(0);
            int activityEnd = activity.get(1);
            
            if ((start >= activityStart && start < activityEnd) || (end > activityStart && end <= activityEnd)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            int n = in.nextInt();
            
            List<List<Integer>> cameronSchedule = new ArrayList<>();
            List<List<Integer>> jameySchedule = new ArrayList<>();
            StringBuilder output = new StringBuilder();
            
            boolean possible = true;
            
            for (int j = 0; j < n; j++) {
                int activityStart = in.nextInt();
                int activityEnd = in.nextInt();
                
                List<Integer> activity = Arrays.asList(activityStart, activityEnd);
                
                if (!overlaps(cameronSchedule, activityStart, activityEnd)) {
                    cameronSchedule.add(activity);
                    output.append("C");
                } else if (!overlaps(jameySchedule, activityStart, activityEnd)) {
                    jameySchedule.add(activity);
                    output.append("J");
                } else {
                    output = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }
            
            System.out.println("Case #" + i + ": " + output.toString());
        }
    }
}