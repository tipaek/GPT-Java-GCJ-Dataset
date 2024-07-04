import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int activitiesCount = scanner.nextInt();
            List<TimeSlot> cameronActivities = new ArrayList<>();
            List<TimeSlot> jamieActivities = new ArrayList<>();
            StringBuilder schedule = new StringBuilder();
            boolean isImpossible = false;
            
            for (int i = 0; i < activitiesCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                
                if (canSchedule(start, end, cameronActivities)) {
                    cameronActivities.add(new TimeSlot(start, end));
                    schedule.append("C");
                } else if (canSchedule(start, end, jamieActivities)) {
                    jamieActivities.add(new TimeSlot(start, end));
                    schedule.append("J");
                } else {
                    isImpossible = true;
                    break;
                }
            }
            
            if (isImpossible) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNum + ": " + schedule.toString());
            }
        }
    }
    
    private static boolean canSchedule(int start, int end, List<TimeSlot> activities) {
        for (TimeSlot slot : activities) {
            if (start < slot.end && end > slot.begin) {
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