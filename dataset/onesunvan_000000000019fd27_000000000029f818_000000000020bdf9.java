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
            System.out.println(String.format("Case #%s: %s", testCase, makeASchedule(events, eventsNumber)));
        }
    }

    public static String makeASchedule(List<Event> events, int eventsNumber) {
        List<Event> conflicted = new ArrayList<>();
        List<Event> assigned = new ArrayList<>();

        boolean isConflictFound;
        do {
            //Find first conflicted pair
            isConflictFound = false;
            {
                int i = 0;
                while (i < events.size() && conflicted.isEmpty()) {
                    int j = 0;
                    while (j < events.size() && conflicted.isEmpty()) {
                        if (i != j && overlap(events.get(i), events.get(j))) {
                            conflicted.add(events.get(i));
                            conflicted.add(events.get(j));
                            isConflictFound = true;
                        }
                        j++;
                    }
                    i++;
                }
            }
            if (!conflicted.isEmpty()) {
                for (Event event : conflicted) {
                    events.remove(event);
                }
                //find all others in conflict to the pair
                Iterator<Event> eventIterator = events.iterator();
                while (eventIterator.hasNext()) {
                    Event event = eventIterator.next();
                    if (conflicted.stream().anyMatch(event1 -> overlap(event1, event))) {
                        conflicted.add(event);
                        eventIterator.remove();
                    }
                }
                //try  to assign conflicted
                conflicted.get(0).assignment = 'J';
                for (int i = 1; i < conflicted.size(); i++) {
                    for (int j = 0; j < i; j++) {
                        if (overlap(conflicted.get(j), conflicted.get(i))) {
                            if (conflicted.get(i).assignment == null) {
                                if (conflicted.get(j).assignment == 'J') {
                                    conflicted.get(i).assignment = 'C';
                                } else {
                                    conflicted.get(i).assignment = 'J';
                                }
                            } else {
                                if (conflicted.get(i).assignment == conflicted.get(j).assignment) {
                                    return "IMPOSSIBLE";
                                }
                            }
                        }
                    }
                }
                assigned.addAll(conflicted);
                conflicted.clear();
            }
        } while (isConflictFound);
        if (!events.isEmpty()) {
            for (Event event : events) {
                event.assignment = 'J';
            }
            assigned.addAll(events);
            events.clear();
        }
        assigned.sort(Comparator.comparingInt(event -> event.originalOrder));
        return assigned.stream().map(Event::getAssignment).map(Object::toString).collect(Collectors.joining(""));
    }

    public static boolean overlap(Event event1, Event event2) {
        return overlap(event1.interval[0], event1.interval[1], event2.interval[0], event2.interval[1]);
    }

    public static boolean overlap(int x1, int x2, int y1, int y2) {
        return x1 < y2 && x2 > y1;
    }
}
