import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            int numberOfActivities = scanner.nextInt();
            List<TimeSlot> cTimeSlots = new ArrayList<>();
            List<TimeSlot> jTimeSlots = new ArrayList<>();
            StringBuilder result = new StringBuilder();
            boolean isImpossible = false;
            
            for (int i = 0; i < numberOfActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                
                if (canSchedule(start, end, cTimeSlots)) {
                    cTimeSlots.add(new TimeSlot(start, end));
                    result.append('C');
                } else if (canSchedule(start, end, jTimeSlots)) {
                    jTimeSlots.add(new TimeSlot(start, end));
                    result.append('J');
                } else {
                    isImpossible = true;
                    break;
                }
            }
            
            if (isImpossible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testCase + ": " + result.toString());
            }
        }
    }

    private static boolean canSchedule(int start, int end, List<TimeSlot> timeSlots) {
        for (TimeSlot slot : timeSlots) {
            if ((start >= slot.start && start < slot.end) || (end > slot.start && end <= slot.end)) {
                return false;
            }
        }
        return true;
    }

    private static class TimeSlot {
        int start;
        int end;

        TimeSlot(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}