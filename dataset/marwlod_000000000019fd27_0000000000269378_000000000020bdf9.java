import java.io.*;
import java.util.*;

public class Solution {
    private static class Event {
        private final int start;
        private final int end;
        private final int index;
        private char owner;

        public Event(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        private int getIndex() {
            return index;
        }

        private boolean overlaps(Event other) {
            return !(this.end <= other.start || other.end <= this.start);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = scanner.nextInt();
        for (int t = 1; t <= tests; ++t) {
            int eventsNum = scanner.nextInt();
            Event[] events = new Event[eventsNum];
            for (int e = 0; e < eventsNum; e++) {
                events[e] = new Event(scanner.nextInt(), scanner.nextInt(), e);
            }
            Arrays.sort(events, Comparator
                    .comparingInt((Event e) -> e.start)
                    .thenComparingInt(e -> e.end));
            List<Event> overlapping = new ArrayList<>();
            List<Event> nonOverlapping = new ArrayList<>();
            nonOverlapping.add(events[0]);
            events[0].owner = 'C';
            int curr = 0;
            for (int e = 1; e < eventsNum; e++) {
                if (nonOverlapping.get(curr).overlaps(events[e])) {
                    events[e].owner = 'J';
                    overlapping.add(events[e]);
                } else {
                    events[e].owner = 'C';
                    nonOverlapping.add(events[e]);
                    curr++;
                }
            }
            boolean impossible = false;
            for (int e = 1; e < overlapping.size(); e++) {
                if (overlapping.get(e-1).overlaps(overlapping.get(e))) {
                    impossible = true;
                    break;
                }
            }
            if (impossible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                Arrays.sort(events, Comparator.comparingInt(Event::getIndex));
                StringBuilder sb = new StringBuilder();
                for (int e = 0; e < eventsNum; e++) {
                    sb.append(events[e].owner);
                }
                System.out.println("Case #" + t + ": " + sb.toString());
            }
        }
    }
}