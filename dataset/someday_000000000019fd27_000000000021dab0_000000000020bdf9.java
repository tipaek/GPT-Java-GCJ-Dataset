import java.util.*;
import java.io.*;

public class Solution {
    public static Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int t = scanner.nextInt();

        for (int i = 1; i <= t; ++i) {
            int n = scanner.nextInt();
            Event[] events = new Event[n];
            for (int j = 0; j < n; ++j) {
                events[j] = new Event(j, scanner.nextInt(), scanner.nextInt());
            }
            System.out.println("Case #" + i + ": " + getSchedule(events));
        }

        scanner.close();
    }

    public static String getSchedule(Event[] events) {
        Arrays.sort(events);

        char[] schedule = new char[events.length];
        Event cameronsLast = null;
        Event jamiesLast = null;

        for (Event event : events) {
            if (cameronsLast == null || !cameronsLast.hasConflictWith(event)) {
                schedule[event.index] = 'C';
                cameronsLast = event;
                continue;
            }

            if (jamiesLast == null || !jamiesLast.hasConflictWith(event)) {
                schedule[event.index] = 'J';
                jamiesLast = event;
                continue;
            }

            return "IMPOSSIBLE";
        }

        return new String(schedule);
    }
}

class Event implements Comparable<Event> {
    int index;
    int start;
    int end;

    public Event(int index, int start, int end) {
        this.index = index;
        this.start = start;
        this.end = end;
    }

    public boolean hasConflictWith(Event event) {
        return this.end > event.start;
    }

    @Override
    public int compareTo(Event event) {
        return this.start - event.start != 0 ? this.start - event.start : event.end - this.end;
    }
}