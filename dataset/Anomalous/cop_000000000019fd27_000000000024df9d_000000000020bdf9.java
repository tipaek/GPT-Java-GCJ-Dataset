import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        class Event {
            private final int start;
            private final int end;
            private char member;

            public Event(int start, int end) {
                this.start = start;
                this.end = end;
            }
        }

        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int totalCases = scanner.nextInt();
            Comparator<Event> eventComparator = Comparator.comparingInt((Event e) -> e.start).thenComparingInt(e -> e.end);

            for (int caseIndex = 0; caseIndex < totalCases; caseIndex++) {
                int eventCount = scanner.nextInt();
                List<Event> events = new ArrayList<>();
                List<Event> sortedEvents = new ArrayList<>();

                for (int i = 0; i < eventCount; i++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();
                    Event event = new Event(start, end);
                    events.add(event);
                    sortedEvents.add(event);
                }

                sortedEvents.sort(eventComparator);

                Event cameron = null;
                Event jamie = null;
                boolean isPossible = true;

                for (Event event : sortedEvents) {
                    if (cameron == null || cameron.end <= event.start) {
                        cameron = event;
                        event.member = 'C';
                    } else if (jamie == null || jamie.end <= event.start) {
                        jamie = event;
                        event.member = 'J';
                    } else {
                        isPossible = false;
                        break;
                    }
                }

                StringBuilder result = new StringBuilder();
                if (!isPossible) {
                    result.append("IMPOSSIBLE");
                } else {
                    for (Event event : events) {
                        result.append(event.member);
                    }
                }

                System.out.format("Case #%d: %s\n", caseIndex + 1, result);
            }
        }
    }
}