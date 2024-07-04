import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = scanner.nextInt();
            for (int caseNumber = 1; caseNumber <= t; caseNumber++) {
                int n = scanner.nextInt();
                List<Interval> intervals = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    intervals.add(new Interval(scanner.nextInt(), scanner.nextInt()));
                }
                processIntervals(intervals, caseNumber);
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    public static void processIntervals(List<Interval> intervals, int caseNumber) {
        intervals.sort(Comparator.comparingInt(Interval::getStartTime));
        StringBuilder result = new StringBuilder("J");
        Map<Character, Integer> endTimes = new HashMap<>();
        endTimes.put('J', intervals.get(0).getEndTime());

        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (endTimes.get('J') <= current.getStartTime()) {
                result.append('J');
                endTimes.put('J', current.getEndTime());
            } else if (endTimes.getOrDefault('C', current.getStartTime()) <= current.getStartTime()) {
                result.append('C');
                endTimes.put('C', current.getEndTime());
            } else {
                result = new StringBuilder("IMPOSSIBLE");
                break;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + result);
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