import java.util.*;

class Interval implements Comparable<Interval> {
    int start;
    int end;
    
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    @Override
    public int compareTo(Interval other) {
        return Integer.compare(this.start, other.start);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            List<Interval> intervals = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                intervals.add(new Interval(scanner.nextInt(), scanner.nextInt()));
            }

            List<Interval> sortedIntervals = new ArrayList<>(intervals);
            Collections.sort(sortedIntervals);

            Map<Interval, Character> assignment = new HashMap<>();
            int maxC = 0, maxJ = 0;
            boolean impossible = false;

            for (Interval interval : sortedIntervals) {
                if (interval.start >= maxC) {
                    assignment.put(interval, 'C');
                    maxC = interval.end;
                } else if (interval.start >= maxJ) {
                    assignment.put(interval, 'J');
                    maxJ = interval.end;
                } else {
                    impossible = true;
                    break;
                }
            }

            StringBuilder result = new StringBuilder();
            if (impossible) {
                result.append("IMPOSSIBLE");
            } else {
                for (Interval interval : intervals) {
                    result.append(assignment.get(interval));
                }
            }

            System.out.println("Case #" + testCase + ": " + result);
        }

        scanner.close();
    }
}