import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int numberOfIntervals = scanner.nextInt();
            List<Interval> intervals = new ArrayList<>();
            
            for (int i = 0; i < numberOfIntervals; i++) {
                intervals.add(new Interval(scanner.nextInt(), scanner.nextInt(), i));
            }
            
            Collections.sort(intervals, (interval1, interval2) -> Integer.compare(interval1.start, interval2.start));
            
            String result = assignTasks(intervals);
            
            if (!result.equals("IMPOSSIBLE")) {
                Collections.sort(intervals, (interval1, interval2) -> Integer.compare(interval1.index, interval2.index));
                StringBuilder scheduleBuilder = new StringBuilder();
                for (Interval interval : intervals) {
                    scheduleBuilder.append(interval.assignedPerson);
                }
                result = scheduleBuilder.toString();
            }
            
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static String assignTasks(List<Interval> intervals) {
        int cameronEndTime = 0;
        int jamieEndTime = 0;
        
        for (Interval interval : intervals) {
            if (interval.start >= cameronEndTime) {
                interval.assignedPerson = "C";
                cameronEndTime = interval.end;
            } else if (interval.start >= jamieEndTime) {
                interval.assignedPerson = "J";
                jamieEndTime = interval.end;
            } else {
                return "IMPOSSIBLE";
            }
        }
        return "";
    }

    private static class Interval {
        int start;
        int end;
        int index;
        String assignedPerson;

        public Interval(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}