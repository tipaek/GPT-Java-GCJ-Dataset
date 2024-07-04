import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            int numberOfEvents = scanner.nextInt();
            List<Event> events = new ArrayList<>();
            List<Event> cameronSchedule = new ArrayList<>();
            List<Event> jamieSchedule = new ArrayList<>();
            StringBuilder result = new StringBuilder();

            for (int eventIndex = 0; eventIndex < numberOfEvents; eventIndex++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                events.add(new Event(start, end));
            }

            for (Event event : events) {
                if (isAvailable(cameronSchedule, event)) {
                    cameronSchedule.add(event);
                    result.append("C");
                } else if (isAvailable(jamieSchedule, event)) {
                    jamieSchedule.add(event);
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + caseIndex + ": " + result);
        }
    }

    private static class Event {
        int start;
        int end;

        Event(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static boolean isAvailable(List<Event> schedule, Event newEvent) {
        for (Event event : schedule) {
            if (eventsOverlap(event, newEvent)) {
                return false;
            }
        }
        return true;
    }

    private static boolean eventsOverlap(Event event1, Event event2) {
        return !(event1.end <= event2.start || event2.end <= event1.start);
    }
}