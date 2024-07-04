import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = scanner.nextInt();
            for (int count = 1; count <= t; count++) {
                int n = scanner.nextInt();
                List<Interval> intervals = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    intervals.add(new Interval(scanner.nextInt(), scanner.nextInt()));
                }
                assignIntervals(intervals, count);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void assignIntervals(List<Interval> intervals, int caseNumber) {
        Collections.sort(intervals, (i1, i2) -> Integer.compare(i1.startTime, i2.startTime));

        StringBuilder assignment = new StringBuilder("J");
        Map<Character, Integer> schedule = new HashMap<>();
        schedule.put('J', intervals.get(0).endTime);

        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (schedule.get('J') <= current.startTime) {
                assignment.append('J');
                schedule.put('J', current.endTime);
            } else if (schedule.get('C') == null || schedule.get('C') <= current.startTime) {
                assignment.append('C');
                schedule.put('C', current.endTime);
            } else {
                assignment = new StringBuilder("IMPOSSIBLE");
                break;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + assignment);
    }
}

class Interval {
    int startTime;
    int endTime;

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