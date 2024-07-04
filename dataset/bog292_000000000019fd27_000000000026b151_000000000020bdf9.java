import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int nr = 1; nr <= t; ++nr) {
            int n = in.nextInt();

            Event[] events = new Event[2 * n];

            for (int i = 0; i < n; i++) {
                int start = in.nextInt();
                Event startEvent = new Event(start, true);
                startEvent.id = i;
                events[i * 2] = startEvent;

                int end = in.nextInt();
                Event endEvent = new Event(end, false);
                endEvent.id = i;
                events[i * 2 + 1] = endEvent;
            }

            solve(nr, n, events);
        }
    }

    private static boolean j;
    private static boolean c;

    private static void solve(int testNr, int n, Event[] events) {
        Arrays.sort(events, new SortByType());
        Arrays.sort(events, new SortByTime());
        
        char[] solution = new char[n];

        j = false;
        c = false;

        int jobs = 0;
        for (int i = 0; i < events.length; i++) {
            if (!events[i].start) {
                jobs--;

                if (solution[events[i].id] == 'C') {
                    c = false;
                } else {
                    j = false;
                }
            } else {
                jobs++;

                if (jobs == 1) {
                    solution[events[i].id] = nextPerson();
                } else if (jobs == 2) {
                    solution[events[i].id] = nextPerson();
                } else if (jobs > 2) {
                    solution = null;
                    break;
                }
            }
        }

        String solutionString;
        if (solution == null) {
            solutionString = "IMPOSSIBLE";
        } else {
            solutionString = String.valueOf(solution);
        }

        System.out.println("Case #" + testNr + ": " + solutionString);

    }

    private static char nextPerson() {
        if (!c) {
            c = true;
            return 'C';
        }

        if (!j) {
            j = true;
            return 'J';
        }

        return 'N';
    }

    static class Event {
        int time;
        boolean start;
        int id;

        public Event(int time, boolean start) {
            this.time = time;
            this.start = start;
        }
    }

    static class SortByType implements Comparator<Event> {
        @Override
        public int compare(Event event1, Event event2) {
            return Boolean.compare(event1.start, event2.start);
        }
    }

    static class SortByTime implements Comparator<Event> {
        @Override
        public int compare(Event event1, Event event2) {
            return event1.time - event2.time;
        }
    }
}
