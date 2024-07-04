import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            Interval[] intervals = new Interval[N];
            for (int i = 0; i < N; i++) {
                intervals[i] = new Interval(scanner.nextInt(), scanner.nextInt());
            }
            System.out.println(String.format("Case #%d: %s", t + 1, assignTasks(intervals)));
        }
    }

    private static String assignTasks(Interval[] intervals) {
        Deque<Character> available = new ArrayDeque<>(Arrays.asList('J', 'C'));
        Deque<Character> busy = new ArrayDeque<>();

        List<Event> events = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            events.add(new Event(i, intervals[i].start, true));
            events.add(new Event(i, intervals[i].end, false));
        }
        events.sort(Comparator.comparingInt((Event e) -> e.time).thenComparing(e -> !e.isStart));

        char[] assignees = new char[intervals.length];
        for (Event event : events) {
            if (event.isStart) {
                if (available.isEmpty()) return "IMPOSSIBLE";
                char assigned = available.pop();
                busy.push(assigned);
                assignees[event.index] = assigned;
            } else {
                busy.remove(assignees[event.index]);
                available.push(assignees[event.index]);
            }
        }

        return new String(assignees);
    }

    private static class Event {
        int index;
        int time;
        boolean isStart;

        Event(int index, int time, boolean isStart) {
            this.index = index;
            this.time = time;
            this.isStart = isStart;
        }
    }

    private static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}