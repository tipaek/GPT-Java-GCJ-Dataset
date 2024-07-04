import java.util.*;
import java.util.stream.Collectors;

class Event {
    int[] interval = new int[2];
    Character assignment;
    int originalOrder;

    public Character getAssignment() {
        return assignment;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCasesNumber = in.nextInt();
        for (int testCase = 1; testCase <= testCasesNumber; testCase++) {
            int eventsNumber = in.nextInt();
            List<Event> events = new ArrayList<>();
            for (int i = 0; i < eventsNumber; i++) {
                Event event = new Event();
                events.add(event);
                event.interval[0] = in.nextInt();
                event.interval[1] = in.nextInt();
                event.originalOrder = i;
            }
            System.out.println(String.format("Case #%s: %s", testCase, makeASchedule(events)));
        }
    }

    public static String makeASchedule(List<Event> events) {
        events.sort(Comparator.comparingInt(event -> event.interval[0]));
        int cEndTime = 0;
        int jEndTime = 0;
        for (int i = 0; i < events.size(); i++) {
            Event event = events.get(i);
            if (cEndTime <= event.interval[0]) {
                event.assignment = 'C';
                cEndTime = event.interval[1];
            } else if (jEndTime <= event.interval[0]) {
                event.assignment = 'J';
                jEndTime = event.interval[1];
            } else {
                return "IMPOSSIBLE";
            }
        }
        events.sort(Comparator.comparingInt(event -> event.originalOrder));
        return events.stream().map(Event::getAssignment).map(Object::toString).collect(Collectors.joining(""));
    }
}