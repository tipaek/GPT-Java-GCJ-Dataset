import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        
        for (int i = 0; i < cases; i++) {
            int intervals = scanner.nextInt();
            List<Event> events = new ArrayList<>();
            
            for (int j = 1; j <= intervals; j++) {
                events.add(new Event(scanner.nextInt(), j));
                events.add(new Event(scanner.nextInt(), -j));
            }
            
            events.sort(new EventComparator());
            System.out.println("Case #" + (i + 1) + ": " + determineEventSequence(events));
        }
    }

    public static String determineEventSequence(List<Event> events) {
        StringBuilder result = new StringBuilder();
        Map<Integer, Character> assignedExecutors = new HashMap<>();
        Set<Character> availableExecutors = new HashSet<>(Arrays.asList('C', 'J'));
        
        for (Event event : events) {
            if (event.id < 0) {
                char executor = assignedExecutors.remove(-event.id);
                availableExecutors.add(executor);
            } else {
                if (availableExecutors.isEmpty()) {
                    return "IMPOSSIBLE";
                }
                
                char executor = availableExecutors.iterator().next();
                result.append(executor);
                availableExecutors.remove(executor);
                assignedExecutors.put(event.id, executor);
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
        return Integer.compare(e1.id, e2.id);
    }
}