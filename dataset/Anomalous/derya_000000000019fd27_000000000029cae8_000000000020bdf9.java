import java.util.*;
import java.io.*;

public class Solution {
    private static final PrintStream OUTPUT = System.out;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numActivities = Integer.parseInt(scanner.nextLine());

            Activity[] activities = new Activity[numActivities];
            Event[] events = new Event[numActivities * 2];

            for (int i = 0; i < numActivities; i++) {
                String[] times = scanner.nextLine().split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);

                events[i * 2] = new Event(start, true, i);
                events[i * 2 + 1] = new Event(end, false, i);
                activities[i] = new Activity(start, end);
            }

            Arrays.sort(events, (e1, e2) -> {
                if (e1.time == e2.time) {
                    return Boolean.compare(e1.isStart, e2.isStart);
                }
                return Integer.compare(e1.time, e2.time);
            });

            boolean isImpossible = false;
            boolean cameronFree = true, jamieFree = true;

            for (Event event : events) {
                if (event.isStart) {
                    if (cameronFree) {
                        cameronFree = false;
                        activities[event.index].assignedTo = 'C';
                    } else if (jamieFree) {
                        jamieFree = false;
                        activities[event.index].assignedTo = 'J';
                    } else {
                        isImpossible = true;
                        break;
                    }
                } else {
                    if (activities[event.index].assignedTo == 'C') {
                        cameronFree = true;
                    } else if (activities[event.index].assignedTo == 'J') {
                        jamieFree = true;
                    }
                }
            }

            OUTPUT.printf("Case #%d: %s%n", testCase, isImpossible ? "IMPOSSIBLE" : getSchedule(activities));
        }
    }

    private static String getSchedule(Activity[] activities) {
        StringBuilder schedule = new StringBuilder();
        for (Activity activity : activities) {
            schedule.append(activity.assignedTo);
        }
        return schedule.toString();
    }

    static class Activity {
        int start, end;
        char assignedTo;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static class Event {
        int time;
        boolean isStart;
        int index;

        Event(int time, boolean isStart, int index) {
            this.time = time;
            this.isStart = isStart;
            this.index = index;
        }
    }
}