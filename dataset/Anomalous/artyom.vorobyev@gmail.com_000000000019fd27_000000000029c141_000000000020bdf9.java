import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        
        for (int i = 0; i < numberOfCases; i++) {
            int numberOfIntervals = scanner.nextInt();
            List<Event> events = new ArrayList<>();
            
            for (int j = 1; j <= numberOfIntervals; j++) {
                events.add(new Event(scanner.nextInt(), j));
                events.add(new Event(scanner.nextInt(), -j));
            }
            
            events.sort(new EventComparator());
            System.out.println(processEvents(events));
        }
    }

    public static String processEvents(List<Event> events) {
        StringBuilder result = new StringBuilder();
        Map<Integer, Character> activeEvents = new HashMap<>();
        Set<Character> availableExecutors = new HashSet<>(Arrays.asList('C', 'J'));
        
        for (Event event : events) {
            if (event.id < 0) {
                // Closing event
                char executor = activeEvents.remove(-event.id);
                availableExecutors.add(executor);
            } else {
                // Opening event
                if (availableExecutors.isEmpty()) {
                    return "IMPOSSIBLE";
                }
                char executor = availableExecutors.iterator().next();
                result.append(executor);
                availableExecutors.remove(executor);
                activeEvents.put(event.id, executor);
            }
        }
        
        return result.toString();
    }
}

class Event {
    public int time;
    public int id;

    public Event(int time, int id) {
        this.time = time;
        this.id = id;
    }
}

class EventComparator implements Comparator<Event> {
    @Override
    public int compare(Event e1, Event e2) {
        if (e1.time != e2.time) {
            return Integer.compare(e1.time, e2.time);
        }
        // If times are equal, prioritize closing events
        return Integer.compare(e2.id, e1.id);
    }
}