import java.util.*;

public class Solution {

    public static class Event {
        int start;
        int end;

        public Event(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class EventComparator implements Comparator<Event> {
        @Override
        public int compare(Event a, Event b) {
            return Integer.compare(a.start, b.start);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            System.out.print("Case #" + t + ": ");
            int numEvents = scanner.nextInt();
            Event[] events = new Event[numEvents];
            Map<Event, Integer> eventIndexMap = new HashMap<>();

            for (int i = 0; i < numEvents; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                Event event = new Event(start, end);
                events[i] = event;
                eventIndexMap.put(event, i);
            }

            Arrays.sort(events, new EventComparator());

            List<Integer> cameron = new ArrayList<>();
            List<Integer> jamie = new ArrayList<>();
            cameron.add(0);
            jamie.add(1);

            boolean isPossible = true;

            for (int i = 2; i < numEvents; i++) {
                if (events[jamie.get(jamie.size() - 1)].end <= events[i].start) {
                    jamie.add(i);
                } else if (events[cameron.get(cameron.size() - 1)].end <= events[i].start) {
                    cameron.add(i);
                } else {
                    System.out.println("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                char[] schedule = new char[numEvents];
                for (int index : cameron) {
                    schedule[eventIndexMap.get(events[index])] = 'C';
                }
                for (int index : jamie) {
                    schedule[eventIndexMap.get(events[index])] = 'J';
                }
                System.out.println(new String(schedule));
            }
        }
    }
}