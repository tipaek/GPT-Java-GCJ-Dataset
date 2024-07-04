import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static class Event {
        int id;
        boolean isBegin;

        public Event(int id, boolean isBegin) {
            this.id = id;
            this.isBegin = isBegin;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Event event = (Event) o;
            return id == event.id &&
                    isBegin == event.isBegin;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, isBegin);
        }
    }

    static void addBinding(Map<Integer, Set<Event>> m, int k, Event e) {
        if (m.containsKey(k)) {
            m.get(k).add(e);
        } else {
            HashSet<Event> events = new HashSet<>();
            m.put(k, events);
            events.add(e);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            Map<Integer, Set<Event>> sweepLine = new TreeMap<>();
            char[] out = new char[n];
            for (int j = 0; j < n; j++) {
                String[] event = reader.readLine().split(" ");
                addBinding(sweepLine, Integer.parseInt(event[0]), new Event(j, true));
                addBinding(sweepLine, Integer.parseInt(event[1]), new Event(j, false));
            }
            int cameron = -1, jamie = -1;
            boolean isPossible = true;
            for (Map.Entry<Integer, Set<Event>> entry : sweepLine.entrySet()) {
                if (!isPossible)
                    break;
                Set<Event> events = entry.getValue();
                for (Event event : events) {
                    if (!event.isBegin) {
                        if (event.id == cameron)
                            cameron = -1;
                        else
                            jamie = -1;
                    }
                }
                for (Event event : events) {
                    if (event.isBegin) {
                        if (cameron == -1) {
                            cameron = event.id;
                            out[event.id] = 'C';
                        } else if (jamie == -1) {
                            jamie = event.id;
                            out[event.id] = 'J';
                        } else
                            isPossible = false;
                    }
                }
            }
            if (isPossible)
                System.out.println(String.format("Case #%d: %s", i + 1, new String(out)));
            else
                System.out.println(String.format("Case #%d: IMPOSSIBLE", i + 1));
        }
    }
}
