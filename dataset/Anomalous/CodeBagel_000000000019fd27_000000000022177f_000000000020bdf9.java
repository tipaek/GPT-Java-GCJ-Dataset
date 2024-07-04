import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
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

            System.out.println("Case #" + caseNumber + ": " + result);
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

    private static boolean isAvailable(List<Event> schedule, Event potentialEvent) {
        for (Event event : schedule) {
            if ((event.start < potentialEvent.start && potentialEvent.start < event.finish) ||
                (event.start < potentialEvent.finish && potentialEvent.finish < event.finish)) {
                return false;
            }
        }
        return true;
    }
}