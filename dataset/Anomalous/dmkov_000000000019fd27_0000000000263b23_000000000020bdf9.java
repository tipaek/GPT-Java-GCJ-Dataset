import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            int activities = scanner.nextInt();
            List<Event> events = new ArrayList<>(2 * activities);
            char[] schedule = new char[activities];

            for (int j = 0; j < activities; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (start == end) {
                    schedule[j] = 'C';
                } else {
                    events.add(new Event(j, start, EventType.START));
                    events.add(new Event(j, end, EventType.END));
                }
            }

            Collections.sort(events);

            int activeTasks = 0;
            boolean possible = true;

            for (Event event : events) {
                if (event.type == EventType.START) {
                    activeTasks++;
                    if (activeTasks == 1) {
                        schedule[event.index] = 'C';
                    } else if (activeTasks == 2) {
                        schedule[event.index] = 'J';
                    } else {
                        possible = false;
                        break;
                    }
                } else {
                    activeTasks--;
                }
            }

            if (possible) {
                System.out.println("Case #" + i + ": " + new String(schedule));
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
    }

    private static class Event implements Comparable<Event> {
        int index;
        int time;
        EventType type;

        Event(int index, int time, EventType type) {
            this.index = index;
            this.time = time;
            this.type = type;
        }

        @Override
        public int compareTo(Event other) {
            if (this.time == other.time) {
                return this.type.compareTo(other.type);
            }
            return Integer.compare(this.time, other.time);
        }
    }

    private enum EventType {
        START, END
    }
}