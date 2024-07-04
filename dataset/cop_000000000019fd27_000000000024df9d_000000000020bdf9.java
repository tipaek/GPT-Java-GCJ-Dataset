import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 04.04.2020
 */
public class Solution {

    public static void main(String... args) throws IOException {

        final class Event {

            private final int start;
            private final int end;
            private char member;

            public Event(int start, int end) {
                this.start = start;
                this.end = end;
            }

        }

        try (Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int total = scan.nextInt();
            final Comparator<Event> sortByStartEndAsc = Comparator.comparingInt((Event one) -> one.start).thenComparingInt(one -> one.end);

            for (int i = 0; i < total; i++) {
                int n = scan.nextInt();

                List<Event> events = new ArrayList<>();
                List<Event> sortedEvents = new ArrayList<>();

                for (int j = 0; j < n; j++) {
                    int start = scan.nextInt();
                    int end = scan.nextInt();
                    Event event = new Event(start, end);
                    events.add(event);
                    sortedEvents.add(event);
                }

                sortedEvents.sort(sortByStartEndAsc);

                Event cameron = null;
                Event jamie = null;

                for (Event event : sortedEvents) {
                    if (cameron == null || cameron.end <= event.start) {
                        cameron = event;
                        event.member = 'C';
                    } else if (jamie == null || jamie.end <= event.start) {
                        jamie = event;
                        event.member = 'J';
                    } else {
                        sortedEvents = Collections.emptyList();
                        break;
                    }
                }

                StringBuilder buf = new StringBuilder();

                if (sortedEvents.isEmpty())
                    buf.append("IMPOSSIBLE");
                else {
                    for (Event event : events)
                        buf.append(event.member);
                }

                System.out.format("Case #%d: %s\n", i + 1, buf);
            }
        }
    }

}
