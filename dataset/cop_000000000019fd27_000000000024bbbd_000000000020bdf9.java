import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

            public Event(int start, int end) {
                this.start = start;
                this.end = end;
            }

            public int getStart() {
                return start;
            }

            public int getEnd() {
                return end;
            }
        }

        try (Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int total = scan.nextInt();
            final Comparator<Event> sortByStartEndAsc = Comparator.comparing((Event event) -> event.start).thenComparing(event -> event.end);

            for (int i = 0; i < total; i++) {
                int n = scan.nextInt();

                List<Event> events = new ArrayList<>();

                for (int j = 0; j < n; j++) {
                    int start = scan.nextInt();
                    int end = scan.nextInt();
                    events.add(new Event(start, end));
                }

                events.sort(sortByStartEndAsc);

                Event cameron = null;
                Event jamie = null;
                StringBuilder buf = new StringBuilder();

                for (Event event : events) {
                    if (cameron == null || cameron.end <= event.start) {
                        cameron = event;
                        buf.append('C');
                    } else if (jamie == null || jamie.end <= event.start) {
                        jamie = event;
                        buf.append('J');
                    } else {
                        buf.setLength(0);
                        buf.append("IMPOSSIBLE");
                        break;
                    }
                }

                System.out.format("Case #%d: %s\n", i + 1, buf);
            }
        }
    }

}
