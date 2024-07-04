import java.util.*;
import java.io.*;

public class Solution {
    private static final String OUTPUT_FORMAT = "Case #%d: %s";
    private static final String SEPARATOR = " ";
    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    private static final String CAMERON = "C";
    private static final String JAMIE = "J";
    
    private static final class ActivityPeriod implements Comparable<ActivityPeriod> {
        public final int start;
        public final int end;
        
        public ActivityPeriod(String startStr, String endStr) {
            this.start = Integer.parseInt(startStr.trim());
            this.end = Integer.parseInt(endStr.trim());
        }
        
        @Override
        public int compareTo(ActivityPeriod other) {
            return Integer.compare(this.start, other.start);
        }
        
        @Override
        public String toString() {
            return "ActivityPeriod{" + "start=" + start + ", end=" + end + '}';
        }
        
        public boolean overlapsWith(ActivityPeriod other) {
            return other.start < this.end;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numTestCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int testCase = 1; testCase <= numTestCases; testCase++) {
            int numActivities = scanner.nextInt();
            scanner.nextLine();
            
            List<ActivityPeriod> activities = new ArrayList<>();
            for (int i = 0; i < numActivities; i++) {
                String[] times = scanner.nextLine().split(SEPARATOR);
                activities.add(new ActivityPeriod(times[0], times[1]));
            }
            
            Collections.sort(activities);
            StringBuilder result = new StringBuilder();
            Map<String, Stack<ActivityPeriod>> assignedActivities = new HashMap<>();
            assignedActivities.put(CAMERON, new Stack<>());
            assignedActivities.put(JAMIE, new Stack<>());
            
            String lastAssigned = CAMERON;
            assignedActivities.get(lastAssigned).push(activities.get(0));
            result.append(lastAssigned);
            
            for (int i = 1; i < activities.size(); i++) {
                ActivityPeriod currentActivity = activities.get(i);
                ActivityPeriod lastActivity = assignedActivities.get(lastAssigned).pop();
                
                if (!lastActivity.overlapsWith(currentActivity)) {
                    assignedActivities.get(lastAssigned).push(currentActivity);
                    result.append(lastAssigned);
                } else {
                    assignedActivities.get(lastAssigned).push(lastActivity);
                    String nextAvailable = getNextAvailableParent(lastAssigned, currentActivity, assignedActivities);
                    
                    if (nextAvailable == null) {
                        result = new StringBuilder(IMPOSSIBLE);
                        break;
                    }
                    
                    assignedActivities.get(nextAvailable).push(currentActivity);
                    lastAssigned = nextAvailable;
                    result.append(nextAvailable);
                }
            }
            
            System.out.println(String.format(OUTPUT_FORMAT, testCase, result.toString()));
        }
    }
    
    private static String getNextAvailableParent(String currentParent, ActivityPeriod nextActivity, Map<String, Stack<ActivityPeriod>> assignedActivities) {
        String nextParent = null;
        
        for (Map.Entry<String, Stack<ActivityPeriod>> entry : assignedActivities.entrySet()) {
            String parent = entry.getKey();
            Stack<ActivityPeriod> activities = entry.getValue();
            
            if (!activities.isEmpty()) {
                ActivityPeriod lastActivity = activities.pop();
                if (nextActivity.start < lastActivity.end) {
                    activities.push(lastActivity);
                }
            }
            
            if (nextParent == null && !parent.equals(currentParent) && activities.isEmpty()) {
                nextParent = parent;
            }
        }
        
        return nextParent;
    }
}