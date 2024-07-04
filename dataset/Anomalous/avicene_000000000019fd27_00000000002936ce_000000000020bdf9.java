import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Interval implements Comparable<Interval> {
    private int start;
    private int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public int compareTo(Interval other) {
        return Integer.compare(this.start, other.start);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Interval interval = (Interval) obj;
        return start == interval.start && end == interval.end;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = Integer.parseInt(scanner.nextLine());
        StringBuilder output = new StringBuilder();

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            Map<String, List<Interval>> schedule = new HashMap<>();
            schedule.put("C", new ArrayList<>());
            schedule.put("J", new ArrayList<>());
            StringBuilder assignment = new StringBuilder();

            int numberOfIntervals = Integer.parseInt(scanner.nextLine());
            for (int intervalIndex = 0; intervalIndex < numberOfIntervals; intervalIndex++) {
                String[] tokens = scanner.nextLine().split(" ");
                Interval interval = new Interval(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));

                if (!hasConflict(schedule.get("J"), interval)) {
                    assignment.append("J");
                    schedule.get("J").add(interval);
                } else if (!hasConflict(schedule.get("C"), interval)) {
                    assignment.append("C");
                    schedule.get("C").add(interval);
                } else {
                    assignment = new StringBuilder("IMPOSSIBLE");
                    for (int skip = intervalIndex + 1; skip < numberOfIntervals; skip++) {
                        scanner.nextLine();
                    }
                    break;
                }
            }
            output.append("Case #").append(caseIndex + 1).append(": ").append(assignment).append("\n");
        }

        System.out.print(output.toString());
        scanner.close();
    }

    private static boolean hasConflict(List<Interval> intervals, Interval newInterval) {
        for (Interval interval : intervals) {
            if (newInterval.getStart() < interval.getEnd() && newInterval.getEnd() > interval.getStart()) {
                return true;
            }
        }
        return false;
    }
}