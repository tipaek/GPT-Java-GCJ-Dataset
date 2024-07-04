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
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                events[i * 2] = new Event(i, start, true);
                events[i * 2 + 1] = new Event(i, end, false);
            }

            Arrays.sort(events);

            int cIndex = -1;
            int jIndex = -1;
            boolean isPossible = true;

            for (Event event : events) {
                if (event.isStart) {
                    if (cIndex == -1) {
                        schedule[event.index] = 'C';
                        cIndex = event.index;
                    } else if (jIndex == -1) {
                        schedule[event.index] = 'J';
                        jIndex = event.index;
                    } else {
                        System.out.printf("Case #%d: IMPOSSIBLE\n", t);
                        isPossible = false;
                        break;
                    }
                } else {
                    if (cIndex == event.index) {
                        cIndex = -1;
                    } else if (jIndex == event.index) {
                        jIndex = -1;
                    }
                }
            }

            if (isPossible) {
                System.out.printf("Case #%d: ", t);
                System.out.println(new String(schedule));
            }
        }
        scanner.close();
    }

    static class Event implements Comparable<Event> {
        int index;
        int time;
        boolean isStart;

        Event(int index, int time, boolean isStart) {
            this.index = index;
            this.time = time;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Event other) {
            if (this.time == other.time) {
                return this.isStart ? -1 : 1;
            }
            return this.time - other.time;
        }
    }
}