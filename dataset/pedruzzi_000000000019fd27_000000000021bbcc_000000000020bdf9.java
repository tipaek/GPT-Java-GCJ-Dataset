import java.util.*;
import java.util.stream.Collector;
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
        final int length;
        Character assignee;

        public Event(int id, int minute, int isStart, int length) {
            this.id = id;
            this.minute = minute;
            this.isStart = isStart;
            this.length = length;
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

        public int getLength() {
            return length;
        }

        public Character getAssignee() {
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
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int length = end - start;
            events.add(new Event(i, start, 1, length));
            events.add(new Event(i, end, 0, length));
        }

        events.sort(Comparator
                .comparingInt(Event::getMinute)
                .thenComparing(Event::getIsStart)
                .thenComparing(Event::getLength));

        char[] assignees = new char[N];

        Queue<Character> freeAgents = new ArrayDeque<>();
        freeAgents.offer('C');
        freeAgents.offer('J');

        for (Event event : events) {
            if (event.isStart == 0) {
                char assignee = assignees[event.id];
                if (assignee != 0) {
                    freeAgents.offer(assignee);
                }
            } else {
                if (freeAgents.isEmpty()) {
                    return "IMPOSSIBLE";
                }
                if (event.length != 0) {
                    event.assignee = freeAgents.remove();
                } else {
                    event.assignee = freeAgents.element();
                }
                assignees[event.id] = event.assignee;
            }
        }

        return new String(assignees);
    }
}
