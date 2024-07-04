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
            int eventCount = scanner.nextInt();
            Event[] events = new Event[eventCount];
            Map<Event, Integer> eventIndexMap = new HashMap<>();

            for (int i = 0; i < eventCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                Event event = new Event(start, end);
                events[i] = event;
                eventIndexMap.put(event, i);
            }

            Arrays.sort(events, new EventComparator());

            List<Integer> cIndices = new ArrayList<>();
            List<Integer> jIndices = new ArrayList<>();
            cIndices.add(0);
            jIndices.add(1);

            boolean isPossible = true;

            for (int i = 2; i < eventCount; i++) {
                if (events[jIndices.get(jIndices.size() - 1)].end <= events[i].start) {
                    jIndices.add(i);
                } else if (events[cIndices.get(cIndices.size() - 1)].end <= events[i].start) {
                    cIndices.add(i);
                } else {
                    System.out.println("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                char[] result = new char[eventCount];
                for (int index : cIndices) {
                    result[eventIndexMap.get(events[index])] = 'C';
                }
                for (int index : jIndices) {
                    result[eventIndexMap.get(events[index])] = 'J';
                }
                System.out.println(new String(result));
            }
        }
    }
}