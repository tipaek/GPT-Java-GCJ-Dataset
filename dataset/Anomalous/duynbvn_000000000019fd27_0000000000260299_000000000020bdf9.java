import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            int numberOfActivities = scanner.nextInt();
            List<TimeInterval> cIntervals = new ArrayList<>(numberOfActivities);
            List<TimeInterval> jIntervals = new ArrayList<>(numberOfActivities);
            StringBuilder result = new StringBuilder();
            boolean isImpossible = false;
            
            for (int i = 0; i < numberOfActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                boolean canAssignToC = isNonOverlapping(start, end, cIntervals);
                
                if (canAssignToC) {
                    cIntervals.add(new TimeInterval(start, end));
                    result.append("C");
                } else {
                    boolean canAssignToJ = isNonOverlapping(start, end, jIntervals);
                    if (canAssignToJ) {
                        jIntervals.add(new TimeInterval(start, end));
                        result.append("J");
                    } else {
                        isImpossible = true;
                    }
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testCase + ": " + result.toString());
            }
        }
    }

    public static boolean isNonOverlapping(int start, int end, List<TimeInterval> intervals) {
        for (TimeInterval interval : intervals) {
            if (start < interval.end && end > interval.start) {
                return false;
            }
        }
        return true;
    }

    public static class TimeInterval {
        int start;
        int end;

        public TimeInterval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}