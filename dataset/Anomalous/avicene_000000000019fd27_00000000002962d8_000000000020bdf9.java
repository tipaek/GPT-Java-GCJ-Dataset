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

public class TaskScheduler {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(scanner.nextLine());
        StringBuilder output = new StringBuilder();

        for (int caseIndex = 0; caseIndex < numCases; caseIndex++) {
            Map<String, List<Interval>> schedule = new HashMap<>();
            schedule.put("C", new ArrayList<>());
            schedule.put("J", new ArrayList<>());
            StringBuilder assignment = new StringBuilder();

            int numTasks = Integer.parseInt(scanner.nextLine());
            for (int taskIndex = 0; taskIndex < numTasks; taskIndex++) {
                String[] input = scanner.nextLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                Interval task = new Interval(start, end);

                if (!hasConflict(schedule.get("C"), task)) {
                    assignment.append("C");
                    schedule.get("C").add(task);
                } else if (!hasConflict(schedule.get("J"), task)) {
                    assignment.append("J");
                    schedule.get("J").add(task);
                } else {
                    assignment = new StringBuilder("IMPOSSIBLE");
                    while (++taskIndex < numTasks) scanner.nextLine();
                }
            }
            output.append("Case #").append(caseIndex + 1).append(": ").append(assignment);
            if (caseIndex < numCases - 1) output.append("\n");
        }

        System.out.print(output.toString());
        scanner.close();
    }

    static boolean hasConflict(List<Interval> intervals, Interval newInterval) {
        for (Interval interval : intervals) {
            if (newInterval.getEnd() > interval.getStart() && newInterval.getEnd() <= interval.getEnd()) return true;
            if (newInterval.getStart() >= interval.getStart() && newInterval.getStart() < interval.getEnd()) return true;
        }
        return false;
    }
}