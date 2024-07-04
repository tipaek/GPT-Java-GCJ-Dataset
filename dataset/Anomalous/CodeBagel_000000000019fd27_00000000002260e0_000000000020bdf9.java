import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();

        for (int i = 1; i <= numberOfCases; i++) {
            int eventCount = scanner.nextInt();
            List<Event> events = new ArrayList<>();
            List<Event> cameronSchedule = new ArrayList<>();
            List<Event> jamieSchedule = new ArrayList<>();
            StringBuilder result = new StringBuilder();

            for (int j = 0; j < eventCount; j++) {
                events.add(new Event(scanner.nextInt(), scanner.nextInt()));
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

            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static class Event {
        int start;
        int finish;

        Event(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }

    private static boolean isAvailable(List<Event> schedule, Event event) {
        for (Event scheduledEvent : schedule) {
            if (isOverlapping(scheduledEvent, event)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isOverlapping(Event e1, Event e2) {
        return (e1.start < e2.finish && e2.start < e1.finish);
    }
}