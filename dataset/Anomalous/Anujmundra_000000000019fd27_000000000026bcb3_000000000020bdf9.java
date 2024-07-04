import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int numActivities = scanner.nextInt();
            int[] activities = new int[numActivities * 2];
            
            for (int j = 0; j < numActivities * 2; j++) {
                activities[j] = scanner.nextInt();
            }
            
            Map<Integer, Integer> activityMap = new HashMap<>();
            for (int j = 0; j < numActivities * 2; j += 2) {
                activityMap.put(activities[j], activities[j + 1]);
            }
            
            TreeMap<Integer, Integer> sortedActivities = new TreeMap<>(activityMap);
            List<Integer> startTimes = new ArrayList<>();
            List<Integer> endTimes = new ArrayList<>();
            
            for (Map.Entry<Integer, Integer> entry : sortedActivities.entrySet()) {
                startTimes.add(entry.getKey());
                endTimes.add(entry.getValue());
            }
            
            StringBuilder schedule = new StringBuilder();
            int count = 0;
            
            for (int j = 0; j < numActivities; j++) {
                if (j == 0) {
                    schedule.append("C");
                    count++;
                } else if (j == 1) {
                    schedule.append("J");
                    count++;
                } else {
                    if (startTimes.get(j) < endTimes.get(0)) {
                        if (startTimes.get(j) > endTimes.get(1)) {
                            endTimes.remove(1);
                            count++;
                            schedule.append("J");
                        }
                    } else {
                        endTimes.remove(0);
                        count++;
                        schedule.append("C");
                    }
                }
            }
            
            if (count == numActivities) {
                System.out.println("Case #" + i + ": " + schedule);
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
        
        scanner.close();
    }
}