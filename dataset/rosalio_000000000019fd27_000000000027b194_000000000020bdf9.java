import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static final char[] names = new char[]{'C', 'J'};
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            List<Activity> activities = new ArrayList<>();
            List<Event> events = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                int start = in.nextInt();
                int end = in.nextInt();

                Event startEvent = new Event(start, true);
                Event endEvent = new Event(end, false);
                events.add(startEvent);
                events.add(endEvent);
                Activity activity = new Activity(i, startEvent, endEvent);
                activities.add(activity);
            }

            String output = getOutput(events, activities);

            System.out.println(String.format("Case #%d: %s", i, output));
        }
    }

    private static String getOutput(List<Event> events, List<Activity> activities) {
        Collections.sort(events, new EventComparator());
        int count = 0;

        for (Event event : events) {
            if (event.isStart) {
                count++;
            } else {
                count--;
            }
            if (count > 2) {
                return IMPOSSIBLE;
            }
        }

        Collections.sort(activities, new ActivityComparator());

        StringBuilder sb = new StringBuilder();
        int ownerIndex = 0;
        Activity first = activities.get(0);
        first.owner = names[ownerIndex];
        for (int i = 1; i < activities.size(); i++) {
            Activity curr = activities.get(i);
            if (first.endEvent.time <= curr.startEvent.time) {
                curr.owner = names[ownerIndex];
                first = curr;
            } else {
                ownerIndex = 1 - ownerIndex;
                curr.owner = names[ownerIndex];
                if (first.endEvent.time > curr.endEvent.time) {
                    first = curr;
                }
            }
        }

        Collections.sort(activities, new ActivityComparatorByIndex());
        for (Activity activity : activities) {
            sb.append(activity.owner);
        }

        return sb.toString();
    }

    private static class Activity {
        Event startEvent;
        Event endEvent;
        int index;
        char owner;

        Activity(int index, Event startEvent, Event endEvent) {
            this.index = index;
            this.startEvent = startEvent;
            this.endEvent = endEvent;
        }
    }

    private static class ActivityComparator implements Comparator<Activity> {
        public int compare(Activity a1, Activity a2) {
            if (a1.startEvent.time != a2.startEvent.time) {
                return a1.startEvent.time - a2.startEvent.time;
            }
            return a1.endEvent.time - a2.endEvent.time;
        }
    }

    private static class ActivityComparatorByIndex implements Comparator<Activity> {
        public int compare(Activity a1, Activity a2) {
            return a1.index - a2.index;
        }
    }
    private static class Event {
        int time;
        boolean isStart;

        Event(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }
    }

    private static class EventComparator implements Comparator<Event> {
        public int compare(Event e1, Event e2) {
            if (e1.time != e2.time) {
                return e1.time - e2.time;
            }
            if (!e1.isStart) {
                return -1;
            }
            return 1;
        }
    }
}
