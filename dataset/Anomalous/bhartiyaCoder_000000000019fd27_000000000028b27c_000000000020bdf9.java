import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int numActivities = scanner.nextInt();
            Map<Integer, Integer> activityMap = new HashMap<>();
            
            for (int i = 0; i < numActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activityMap.put(start, end);
            }
            
            Map<Integer, Integer> sortedActivities = new TreeMap<>(activityMap);
            int endJ = 0;
            int endC = 0;
            StringBuilder schedule = new StringBuilder();
            
            for (Map.Entry<Integer, Integer> activity : sortedActivities.entrySet()) {
                int start = activity.getKey();
                int end = activity.getValue();
                
                if (endC <= start) {
                    endC = end;
                    schedule.append('C');
                } else if (endJ <= start) {
                    endJ = end;
                    schedule.append('J');
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            
            System.out.println("Case #" + caseNum + ": " + schedule.toString());
        }
    }
}