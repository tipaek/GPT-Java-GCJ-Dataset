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
            return id == event.id && isBegin == event.isBegin;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, isBegin);
        }
    }

    static void addBinding(Map<Integer, Set<Event>> map, int key, Event event) {
        map.computeIfAbsent(key, k -> new HashSet<>()).add(event);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            Map<Integer, Set<Event>> sweepLine = new TreeMap<>();
            char[] output = new char[n];

            for (int j = 0; j < n; j++) {
                String[] eventDetails = reader.readLine().split(" ");
                int start = Integer.parseInt(eventDetails[0]);
                int end = Integer.parseInt(eventDetails[1]);

                addBinding(sweepLine, start, new Event(j, true));
                addBinding(sweepLine, end, new Event(j, false));
            }

            int cameron = -1, jamie = -1;
            boolean possible = true;

            for (Map.Entry<Integer, Set<Event>> entry : sweepLine.entrySet()) {
                if (!possible) break;
                Set<Event> events = entry.getValue();

                for (Event event : events) {
                    if (!event.isBegin) {
                        if (event.id == cameron) {
                            cameron = -1;
                        } else if (event.id == jamie) {
                            jamie = -1;
                        }
                    }
                }

                for (Event event : events) {
                    if (event.isBegin) {
                        if (cameron == -1) {
                            cameron = event.id;
                            output[event.id] = 'C';
                        } else if (jamie == -1) {
                            jamie = event.id;
                            output[event.id] = 'J';
                        } else {
                            possible = false;
                        }
                    }
                }
            }

            if (possible) {
                System.out.printf("Case #%d: %s%n", i + 1, new String(output));
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE%n", i + 1);
            }
        }
    }
}