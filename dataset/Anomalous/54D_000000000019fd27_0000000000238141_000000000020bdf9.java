import java.util.*;

public class Solution {

    static boolean isTimeSlotAvailable(int[] calendar, int start, int end) {
        for (int i = start; i < end; i++) {
            if (calendar[i] == 1) {
                return false;
            }
        }
        return true;
    }

    static void markTimeSlot(int[] calendar, int start, int end) {
        for (int i = start; i < end; i++) {
            calendar[i] = 1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int caseIndex = 0; caseIndex < t; caseIndex++) {
            int[] C = new int[1440];
            int[] J = new int[1440];
            boolean impossible = false;
            int e = scanner.nextInt();
            
            Map<Integer, int[]> eventTimes = new HashMap<>();
            Map<Integer, String> eventAssignments = new LinkedHashMap<>();
            Map<Integer, Integer> eventLengths = new HashMap<>();
            
            for (int i = 0; i < e; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                eventTimes.put(i, new int[]{start, end});
                eventAssignments.put(i, "X");
                eventLengths.put(i, end - start);
            }
            
            List<Map.Entry<Integer, Integer>> eventLengthEntries = new ArrayList<>(eventLengths.entrySet());
            eventLengthEntries.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
            
            for (Map.Entry<Integer, Integer> entry : eventLengthEntries) {
                int eventID = entry.getKey();
                int[] times = eventTimes.get(eventID);
                int start = times[0];
                int end = times[1];
                
                if (isTimeSlotAvailable(C, start, end)) {
                    markTimeSlot(C, start, end);
                    eventAssignments.put(eventID, "C");
                } else if (isTimeSlotAvailable(J, start, end)) {
                    markTimeSlot(J, start, end);
                    eventAssignments.put(eventID, "J");
                } else {
                    impossible = true;
                    break;
                }
            }
            
            String order = impossible ? "IMPOSSIBLE" : String.join("", eventAssignments.values());
            System.out.printf("Case #%d: %s%n", caseIndex + 1, order);
        }
        
        scanner.close();
    }
}