import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();
        for (int n = 0; n < numCases; n++) {
            int activities = input.nextInt();
            
            List<Activity> cameron = new ArrayList<>(activities);
            List<Activity> jamie = new ArrayList<>(activities);
            
            StringBuilder sb = new StringBuilder();
            boolean isImpossible = false;
            for (int i = 0; i < activities; i++) {
                int start = input.nextInt();
                int end = input.nextInt();
                
                Activity activity = new Activity(start, end);
                
                if (cameron.isEmpty() || addActivityToList(activity, cameron)) {
                    sb.append('C');
                } else if (jamie.isEmpty() || addActivityToList(activity, jamie)) {
                    sb.append('J');
                } else {
                    isImpossible = true;
                    break;
                }
            }
            
            System.out.printf("Case #%d: ", n + 1);
            if (isImpossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(sb.toString());    
            }
        }
        input.close();
    }
    
    static boolean addActivityToList(Activity activity, List<Activity> activityList) {
        for (int i = 0; i < activityList.size(); i++) {
            Activity element = activityList.get(i);
            if (activity.getStart() < element.getStart() && activity.getEnd() <= element.getStart()) {
                activityList.add(i, activity);
                return true;
            }
        }
        if (activityList.isEmpty() || activityList.get(activityList.size() - 1).getEnd() <= activity.getStart()) {
            activityList.add(activity);
            return true;
        }
        return false;
    }
    
    static class Activity {
        private final int start;
        private final int end;
        
        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        int getStart() {
            return this.start;
        }
        
        int getEnd() {
            return this.end;
        }
    }
}