import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCases = sc.nextInt();

        for (int caseIndex = 0; caseIndex < numCases; caseIndex++) {
            int numEvents = sc.nextInt();
            List<int[]> events = new ArrayList<>();
            for (int i = 0; i < numEvents; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                events.add(new int[]{start, end});
            }

            EventScheduler scheduler = new EventScheduler(events);
            String result = scheduler.scheduleEvents();

            System.out.println("Case #" + (caseIndex + 1) + ": " + result);
        }
    }
}

class EventScheduler {
    private List<int[]> events;
    private boolean[] scheduleCameron;
    private boolean[] scheduleJamie;

    public EventScheduler(List<int[]> events) {
        this.events = events;
        this.scheduleCameron = new boolean[1440];
        this.scheduleJamie = new boolean[1440];
    }

    public String scheduleEvents() {
        List<EventWithIndex> sortedEvents = sortEvents(events);
        char[] results = new char[events.size()];

        for (EventWithIndex event : sortedEvents) {
            int start = event.start;
            int end = event.end;
            int index = event.index;

            if (canSchedule(scheduleCameron, start, end)) {
                markSchedule(scheduleCameron, start, end);
                results[index] = 'C';
            } else if (canSchedule(scheduleJamie, start, end)) {
                markSchedule(scheduleJamie, start, end);
                results[index] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(results);
    }

    private boolean canSchedule(boolean[] schedule, int start, int end) {
        for (int time = start; time < end; time++) {
            if (schedule[time]) {
                return false;
            }
        }
        return true;
    }

    private void markSchedule(boolean[] schedule, int start, int end) {
        for (int time = start; time < end; time++) {
            schedule[time] = true;
        }
    }

    private List<EventWithIndex> sortEvents(List<int[]> events) {
        List<EventWithIndex> eventList = new ArrayList<>();
        for (int i = 0; i < events.size(); i++) {
            eventList.add(new EventWithIndex(events.get(i)[0], events.get(i)[1], i));
        }
        eventList.sort((e1, e2) -> Integer.compare(e1.start, e2.start));
        return eventList;
    }

    private static class EventWithIndex {
        int start;
        int end;
        int index;

        EventWithIndex(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}