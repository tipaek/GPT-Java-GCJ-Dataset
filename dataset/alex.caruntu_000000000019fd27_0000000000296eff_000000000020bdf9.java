import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();
        for (int n = 0; n < numCases; n++) {
            String result = processTestCase(input);
            System.out.printf("Case #%d: ", n + 1);
            System.out.println(result);
        }
    }
    
    static String processTestCase(Scanner input) {
        int activities = input.nextInt();
            
        List<Activity> cameron = new ArrayList<Activity>(activities);
        List<Activity> jamie = new ArrayList<Activity>(activities);
            
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < activities;i++) {
            int start = input.nextInt();
            int end = input.nextInt();
                
            Activity activity = new Activity(start, end);
                
            if (addActivityToList(activity, cameron)) {
                sb.append('C');
            } else if (addActivityToList(activity, jamie)) {
                sb.append('J');
            } else {
                return "IMPOSSIBLE";
            }
        }
        return sb.toString();
    }
    
    static boolean addActivityToList(
        Activity activity,
        List<Activity> activityList) {
            
        if (activityList.isEmpty()) {
            activityList.add(activity);
            return true;
        }
        
        int max_elements = activityList.size();
        for (int i = 0;i < max_elements;i++) {
            Activity element = activityList.get(i);
            if (activity.getStart() < element.getStart()) {
                if (activity.getEnd() < element.getEnd()) {
                    if (activity.getEnd() < element.getStart()) {
                        activityList.add(i, activity);
                        return true;
                    }
                }
            }
        }
        if (activityList.get(max_elements - 1).getEnd() <= activity.getStart()) {
            activityList.add(activity);
            return true;
        }
        return false;
    }
    
    static class Activity {
        private int start;
        private int end;
        
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