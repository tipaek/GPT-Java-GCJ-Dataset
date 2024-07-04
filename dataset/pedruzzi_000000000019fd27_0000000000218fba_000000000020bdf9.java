import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    static class Test {
        public static void main(String[] args) {
            solve(new Scanner(Solution.class.getResourceAsStream("input.txt")));
        }
    }

    public static void main(String[] args) {
        solve(new Scanner(System.in));
    }

    private static class Event {
        final int id;
        final int minute;
        final int isStart;
        String assignee;

        public Event(int id, int minute, int isStart) {
            this.id = id;
            this.minute = minute;
            this.isStart = isStart;
        }

        public int getMinute() {
            return minute;
        }

        public int getIsStart() {
            return isStart;
        }

        public int getId() {
            return id;
        }

        public String getAssignee() {
            return assignee;
        }

        @Override
        public String toString() {
            return "Event{" +
                    "id=" + id +
                    ", minute=" + minute +
                    ", isStart=" + isStart +
                    ", assignee='" + assignee + '\'' +
                    '}';
        }
    }

    private static void solve(Scanner scanner) {
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            String result = solveCase(scanner);
            System.out.printf("Case #%d: %s\n", t + 1, result);
        }
    }
    private static String solveCase(Scanner scanner) {
        int N = scanner.nextInt();
        List<Event> events = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            events.add(new Event(i, scanner.nextInt(), 1));
            events.add(new Event(i, scanner.nextInt(), 0));
        }

        events.sort(Comparator
                .comparingInt(Event::getMinute)
                .thenComparing(Event::getIsStart));

        int busyAgents = 0;
        for (Event event : events) {
            if (event.isStart == 0) {
                busyAgents--;
            } else {
                busyAgents++;
                if (busyAgents == 3) {
                    return "IMPOSSIBLE";
                }
                event.assignee = busyAgents == 1 ?  "C" : "J";
            }
        }

        return events.stream().filter(e -> e.assignee != null)
                .sorted(Comparator.comparingInt(Event::getId))
                .map(Event::getAssignee)
                .collect(Collectors.joining(""));
    }
}
