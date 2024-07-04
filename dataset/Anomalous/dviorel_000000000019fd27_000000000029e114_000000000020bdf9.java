import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int activityCount = scanner.nextInt();
            StringBuilder schedule = new StringBuilder();
            List<Interval> cameronSchedule = new ArrayList<>();
            List<Interval> jamieSchedule = new ArrayList<>();
            boolean isImpossible = false;
            
            for (int i = 0; i < activityCount; i++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                Interval currentInterval = new Interval(startTime, endTime);
                
                if (currentInterval.canBeInserted(cameronSchedule)) {
                    cameronSchedule.add(currentInterval);
                    schedule.append("C");
                } else if (currentInterval.canBeInserted(jamieSchedule)) {
                    jamieSchedule.add(currentInterval);
                    schedule.append("J");
                } else {
                    isImpossible = true;
                }
            }
            
            if (isImpossible) {
                schedule = new StringBuilder("IMPOSSIBLE");
            }
            
            System.out.printf("Case #%d: %s%n", testCase, schedule.toString());
        }
        
        scanner.close();
    }

    static class Interval {
        int start;
        int end;
        
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        boolean canBeInserted(List<Interval> intervals) {
            for (Interval interval : intervals) {
                if (!doNotOverlap(this, interval)) {
                    return false;
                }
            }
            return true;
        }

        private boolean doNotOverlap(Interval interval1, Interval interval2) {
            return interval1.end <= interval2.start || interval1.start >= interval2.end;
        }
    }
}