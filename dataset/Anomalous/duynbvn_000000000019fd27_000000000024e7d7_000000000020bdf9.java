import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; ++t) {
            int activitiesCount = scanner.nextInt();
            List<TimeSlot> cSchedule = new ArrayList<>(activitiesCount);
            List<TimeSlot> jSchedule = new ArrayList<>(activitiesCount);
            StringBuilder result = new StringBuilder();
            boolean isImpossible = false;
            
            for (int i = 0; i < activitiesCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                
                if (canSchedule(start, end, cSchedule)) {
                    cSchedule.add(new TimeSlot(start, end));
                    result.append("C");
                } else if (canSchedule(start, end, jSchedule)) {
                    jSchedule.add(new TimeSlot(start, end));
                    result.append("J");
                } else {
                    isImpossible = true;
                }
            }
            
            if (isImpossible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + t + ": " + result);
            }
        }
    }

    private static boolean canSchedule(int start, int end, List<TimeSlot> schedule) {
        for (TimeSlot slot : schedule) {
            if ((start < slot.end && end > slot.begin)) {
                return false;
            }
        }
        return true;
    }

    private static class TimeSlot {
        int begin;
        int end;

        TimeSlot(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
    }
}