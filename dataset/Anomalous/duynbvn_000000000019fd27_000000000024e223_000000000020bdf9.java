import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

   public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int activitiesCount = scanner.nextInt();
            List<Interval> cameronSchedule = new ArrayList<>(activitiesCount);
            List<Interval> jamieSchedule = new ArrayList<>(activitiesCount);
            StringBuilder schedule = new StringBuilder();
            boolean isImpossible = false;

            for (int i = 0; i < activitiesCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                
                if (canSchedule(start, end, cameronSchedule)) {
                    cameronSchedule.add(new Interval(start, end));
                    schedule.append("C");
                } else if (canSchedule(start, end, jamieSchedule)) {
                    jamieSchedule.add(new Interval(start, end));
                    schedule.append("J");
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testCase + ": " + schedule.toString());
            }
        }
    }

    public static boolean canSchedule(int start, int end, List<Interval> schedule) {
        for (Interval interval : schedule) {
            if ((start >= interval.start && start < interval.end) || (end > interval.start && end <= interval.end)) {
                return false;
            }
        }
        return true;
    }

    public static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}