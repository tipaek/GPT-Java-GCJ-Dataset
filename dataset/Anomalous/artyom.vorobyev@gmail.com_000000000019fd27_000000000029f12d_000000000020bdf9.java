import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            int intervals = scanner.nextInt();
            List<Event> events = new ArrayList<>();
            
            for (int j = 1; j <= intervals; j++) {
                events.add(new Event(scanner.nextInt(), j));
                events.add(new Event(scanner.nextInt(), -j));
            }
            
            events.sort(new EventComparator());
            System.out.println("Case #" + (i + 1) + ": " + getEventSequence(events));
        }
    }

    private static String getEventSequence(List<Event> events) {
        StringBuilder result = new StringBuilder();
        Character[] sequence = new Character[events.size() / 2];
        Map<Integer, Character> activeEvents = new HashMap<>();
        Set<Character> availableExecutors = new HashSet<>(Arrays.asList('C', 'J'));
        
        for (Event event : events) {
            if (event.id < 0) {
                // Closing event
                Character executor = activeEvents.remove(-event.id);
                availableExecutors.add(executor);
            } else {
                // Opening event
                if (availableExecutors.isEmpty()) {
                    return "IMPOSSIBLE";
                }
                Character executor = availableExecutors.iterator().next();
                sequence[event.id - 1] = executor;
                availableExecutors.remove(executor);
                activeEvents.put(event.id, executor);
            }
        }
        
        for (Character ch : sequence) {
            result.append(ch);
        }
        
        return result.toString();
    }
}

class Event {
    int time;
    int id;

    Event(int time, int id) {
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
        return Integer.compare(e1.id, e2.id);
    }
}