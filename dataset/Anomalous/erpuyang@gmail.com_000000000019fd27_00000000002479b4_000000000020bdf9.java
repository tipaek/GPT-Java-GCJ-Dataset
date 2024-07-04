import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();
        
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            inputs.add(line);
        }

        if (inputs.isEmpty()) {
            return;
        }

        int caseCount = Integer.parseInt(inputs.get(0).trim());

        for (int i = 1, index = 1; i <= caseCount; i++) {
            int intervalCount = Integer.parseInt(inputs.get(index).trim());
            List<Interval> intervals = new ArrayList<>(intervalCount);

            for (int j = 0; j < intervalCount; j++) {
                String[] parts = inputs.get(index + j + 1).split("\\s+");
                intervals.add(new Interval(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), j));
            }

            String result = assignIntervals(intervals);
            System.out.println(String.format("Case #%d: %s", i, result));
            index += intervalCount + 1;
        }
    }

    private static String assignIntervals(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(interval -> interval.start));
        char[] assignments = new char[intervals.size()];
        Map<Character, Interval> lastAssigned = new HashMap<>();
        lastAssigned.put('C', null);
        lastAssigned.put('J', null);

        for (Interval interval : intervals) {
            if (lastAssigned.get('C') != null && interval.start >= lastAssigned.get('C').end) {
                assignments[lastAssigned.get('C').index] = 'C';
                lastAssigned.put('C', null);
            }
            if (lastAssigned.get('J') != null && interval.start >= lastAssigned.get('J').end) {
                assignments[lastAssigned.get('J').index] = 'J';
                lastAssigned.put('J', null);
            }
            if (lastAssigned.get('C') != null && lastAssigned.get('J') != null) {
                return "IMPOSSIBLE";
            }
            lastAssigned.put(lastAssigned.get('C') == null ? 'C' : 'J', interval);
        }

        if (lastAssigned.get('C') != null) {
            assignments[lastAssigned.get('C').index] = 'C';
        }
        if (lastAssigned.get('J') != null) {
            assignments[lastAssigned.get('J').index] = 'J';
        }

        return new String(assignments);
    }

    private static class Interval {
        int start, end, index;
        Interval(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}