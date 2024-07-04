import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Number of test cases

        for (int testCase = 1; testCase <= t; ++testCase) {
            int n = in.nextInt(); // Number of events
            Event[] events = new Event[2 * n];

            for (int i = 0; i < n; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                events[2 * i] = new Event(start, true, i);
                events[2 * i + 1] = new Event(end, false, i);
            }

            solve(testCase, n, events);
        }
    }

    private static boolean isJAssigned;
    private static boolean isCAssigned;

    private static void solve(int testCase, int n, Event[] events) {
        Arrays.sort(events, new EventComparator());

        char[] schedule = new char[n];
        isJAssigned = false;
        isCAssigned = false;
        int activeJobs = 0;

        for (Event event : events) {
            if (!event.start) {
                activeJobs--;
                if (schedule[event.id] == 'C') {
                    isCAssigned = false;
                } else {
                    isJAssigned = false;
                }
            } else {
                activeJobs++;
                if (activeJobs == 1 || activeJobs == 2) {
                    schedule[event.id] = assignNextPerson();
                } else {
                    schedule = null;
                    break;
                }
            }
        }

        String result = (schedule == null) ? "IMPOSSIBLE" : new String(schedule);
        System.out.println("Case #" + testCase + ": " + result);
    }

    private static char assignNextPerson() {
        if (!isCAssigned) {
            isCAssigned = true;
            return 'C';
        } else if (!isJAssigned) {
            isJAssigned = true;
            return 'J';
        }
        return 'N';
    }

    static class Event {
        int time;
        boolean start;
        int id;

        public Event(int time, boolean start, int id) {
            this.time = time;
            this.start = start;
            this.id = id;
        }
    }

    static class EventComparator implements Comparator<Event> {
        @Override
        public int compare(Event e1, Event e2) {
            if (e1.time != e2.time) {
                return Integer.compare(e1.time, e2.time);
            }
            return Boolean.compare(e1.start, e2.start);
        }
    }
}