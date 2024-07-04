import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCaseCount = scanner.nextInt();
            for (int testCase = 1; testCase <= testCaseCount; testCase++) {
                int intervalCount = scanner.nextInt();
                List<Interval> intervals = new ArrayList<>();
                for (int i = 0; i < intervalCount; i++) {
                    intervals.add(new Interval(scanner.nextInt(), scanner.nextInt()));
                }
                processIntervals(intervals, testCase);
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    public static void processIntervals(List<Interval> intervals, int testCase) {
        Collections.sort(intervals, Comparator.comparingInt(Interval::getStartTime));
        
        StringBuilder schedule = new StringBuilder("J");
        Map<Character, Integer> endTimeMap = new HashMap<>();
        endTimeMap.put('J', intervals.get(0).getEndTime());

        for (int i = 1; i < intervals.size(); i++) {
            Interval currentInterval = intervals.get(i);
            if (endTimeMap.get('J') <= currentInterval.getStartTime()) {
                schedule.append('J');
                endTimeMap.put('J', currentInterval.getEndTime());
            } else if (endTimeMap.getOrDefault('C', Integer.MAX_VALUE) <= currentInterval.getStartTime()) {
                schedule.append('C');
                endTimeMap.put('C', currentInterval.getEndTime());
            } else {
                schedule = new StringBuilder("IMPOSSIBLE");
                break;
            }
        }

        System.out.println("Case #" + testCase + ": " + schedule);
    }
}

class Interval {
    private final int startTime;
    private final int endTime;

    public Interval(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }
}