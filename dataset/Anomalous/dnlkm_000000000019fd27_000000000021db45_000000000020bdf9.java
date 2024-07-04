import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            Event[] events = new Event[n * 2];
            char[] schedule = new char[n];

            for (int i = 0; i < n; i++) {
                events[i * 2] = new Event(i, scanner.nextInt(), 1);
                events[i * 2 + 1] = new Event(i, scanner.nextInt(), -1);
            }

            Arrays.sort(events);

            int cameron = -1;
            int jamie = -1;

            boolean possible = true;

            for (Event event : events) {
                if (event.delta > 0) {
                    if (cameron == -1) {
                        schedule[event.index] = 'C';
                        cameron = event.index;
                    } else if (jamie == -1) {
                        schedule[event.index] = 'J';
                        jamie = event.index;
                    } else {
                        System.out.printf("Case #%d: IMPOSSIBLE\n", t);
                        possible = false;
                        break;
                    }
                } else {
                    if (cameron == event.index) {
                        cameron = -1;
                    } else {
                        jamie = -1;
                    }
                }
            }

            if (possible) {
                System.out.printf("Case #%d: %s\n", t, new String(schedule));
            }
        }

        scanner.close();
    }

    static class Event implements Comparable<Event> {
        int index;
        int time;
        int delta;

        Event(int index, int time, int delta) {
            this.index = index;
            this.time = time;
            this.delta = delta;
        }

        @Override
        public int compareTo(Event other) {
            if (this.time == other.time) {
                return this.delta - other.delta;
            }
            return this.time - other.time;
        }
    }
}