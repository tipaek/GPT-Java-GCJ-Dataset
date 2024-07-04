import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) break;
            inputs.add(line);
        }

        if (inputs.isEmpty()) return;

        int caseCount = Integer.parseInt(inputs.get(0).trim());
        int index = 1;

        for (int i = 1; i <= caseCount; i++) {
            int intervalCount = Integer.parseInt(inputs.get(index).trim());
            List<Interval> intervals = new ArrayList<>(intervalCount);

            for (int j = 0; j < intervalCount; j++) {
                String[] parts = inputs.get(index + j + 1).split("\\s+");
                intervals.add(new Interval(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])));
            }

            String result = assignIntervals(intervals);
            System.out.println(String.format("Case #%d: %s", i, result));
            index += intervalCount + 1;
        }
    }

    private static String assignIntervals(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(i -> i.start));
        StringBuilder result = new StringBuilder();
        Map<Character, Interval> assignedIntervals = new HashMap<>();
        assignedIntervals.put('C', null);
        assignedIntervals.put('J', null);

        for (Interval interval : intervals) {
            if (canAssign(assignedIntervals.get('C'), interval)) {
                result.append('C');
                assignedIntervals.put('C', interval);
            } else if (canAssign(assignedIntervals.get('J'), interval)) {
                result.append('J');
                assignedIntervals.put('J', interval);
            } else {
                return "IMPOSSIBLE";
            }
        }
        return result.toString();
    }

    private static boolean canAssign(Interval assignedInterval, Interval newInterval) {
        return assignedInterval == null || newInterval.start >= assignedInterval.end;
    }

    private static class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}