import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {

        class Event {
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

        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int totalCases = scanner.nextInt();
            Comparator<Event> eventComparator = Comparator.comparingInt(Event::getStart).thenComparingInt(Event::getEnd);

            for (int caseNumber = 1; caseNumber <= totalCases; caseNumber++) {
                int numberOfEvents = scanner.nextInt();
                List<Event> events = new ArrayList<>();

                for (int j = 0; j < numberOfEvents; j++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();
                    events.add(new Event(start, end));
                }

                events.sort(eventComparator);

                Event cameron = null;
                Event jamie = null;
                StringBuilder schedule = new StringBuilder();

                for (Event event : events) {
                    if (cameron == null || cameron.getEnd() <= event.getStart()) {
                        cameron = event;
                        schedule.append('C');
                    } else if (jamie == null || jamie.getEnd() <= event.getStart()) {
                        jamie = event;
                        schedule.append('J');
                    } else {
                        schedule.setLength(0);
                        schedule.append("IMPOSSIBLE");
                        break;
                    }
                }

                System.out.format("Case #%d: %s\n", caseNumber, schedule.toString());
            }
        }
    }
}