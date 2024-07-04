import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Interval {
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
        return "Interval{" + "start=" + start + ", end=" + end + '}';
    }
}

public class ScheduleSolver {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());
        StringBuilder output = new StringBuilder();

        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            Map<String, List<Interval>> assignments = new HashMap<>();
            assignments.put("C", new ArrayList<>());
            assignments.put("J", new ArrayList<>());
            StringBuilder schedule = new StringBuilder();

            int taskCount = Integer.parseInt(scanner.nextLine());
            for (int taskIndex = 0; taskIndex < taskCount; taskIndex++) {
                String[] input = scanner.nextLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                Interval interval = new Interval(start, end);

                if (!hasConflict(assignments.get("C"), interval)) {
                    schedule.append("C");
                    assignments.get("C").add(interval);
                } else if (!hasConflict(assignments.get("J"), interval)) {
                    schedule.append("J");
                    assignments.get("J").add(interval);
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            output.append("Case #").append(caseIndex + 1).append(": ").append(schedule).append("\n");
        }

        System.out.print(output);
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