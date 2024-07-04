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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interval interval = (Interval) o;
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

public class Scheduler {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = Integer.parseInt(scanner.nextLine());
        StringBuilder resultBuilder = new StringBuilder();

        for (int caseIndex = 0; caseIndex < numberOfCases; ++caseIndex) {
            Map<String, List<Interval>> scheduleMap = new HashMap<>();
            scheduleMap.putIfAbsent("C", new ArrayList<>());
            scheduleMap.putIfAbsent("J", new ArrayList<>());
            StringBuilder assignmentBuilder = new StringBuilder();

            int numberOfIntervals = Integer.parseInt(scanner.nextLine());
            for (int intervalIndex = 0; intervalIndex < numberOfIntervals; ++intervalIndex) {
                String line = scanner.nextLine();
                int[] times = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
                Interval interval = new Interval(times[0], times[1]);

                if (!hasConflict(scheduleMap.get("C"), interval)) {
                    assignmentBuilder.append("C");
                    scheduleMap.get("C").add(interval);
                } else if (!hasConflict(scheduleMap.get("J"), interval)) {
                    assignmentBuilder.append("J");
                    scheduleMap.get("J").add(interval);
                } else {
                    assignmentBuilder = new StringBuilder("IMPOSSIBLE");
                    while (++intervalIndex < numberOfIntervals) scanner.nextLine();
                    break;
                }
            }
            resultBuilder.append("Case #").append(caseIndex + 1).append(": ").append(assignmentBuilder.toString()).append("\n");
        }

        System.out.print(resultBuilder.toString());
        scanner.close();
    }

    static boolean hasConflict(List<Interval> intervals, Interval newInterval) {
        for (Interval interval : intervals) {
            if (newInterval.getStart() >= interval.getEnd() || newInterval.getEnd() <= interval.getStart()) {
                continue;
            }
            return true;
        }
        return false;
    }
}