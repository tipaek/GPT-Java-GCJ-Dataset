import java.util.*;

public class Solution {

    static class Event {
        int start;
        int end;
        char assign;
        int order;

        public Event(int start, int end, char assign, int order) {
            this.start = start;
            this.end = end;
            this.assign = assign;
            this.order = order;
        }
    }

    public static void solve(int caseNumber, int numEvents, Event[] events) {
        boolean isPossible = assignTasks(numEvents, events);
        String schedule;

        if (!isPossible) {
            schedule = "IMPOSSIBLE";
        } else {
            Arrays.sort(events, Comparator.comparingInt(event -> event.order));
            StringBuilder scheduleBuilder = new StringBuilder();
            for (Event event : events) {
                scheduleBuilder.append(event.assign);
            }
            schedule = scheduleBuilder.toString();
        }

        System.out.println("Case #" + caseNumber + ": " + schedule);
    }

    public static boolean assignTasks(int numEvents, Event[] events) {
        Arrays.sort(events, Comparator.comparingInt(event -> event.start));
        int endC = -1;
        int endJ = -1;

        for (Event event : events) {
            if (event.start >= endC) {
                endC = event.end;
                event.assign = 'C';
            } else if (event.start >= endJ) {
                endJ = event.end;
                event.assign = 'J';
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int numEvents = scanner.nextInt();
            Event[] events = new Event[numEvents];

            for (int i = 0; i < numEvents; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                events[i] = new Event(start, end, 'X', i);
            }

            solve(caseNumber, numEvents, events);
        }
    }
}