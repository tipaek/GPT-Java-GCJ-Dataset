import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();
        for (int t = 1; t <= testCaseCount; t++) {
            int activityCount = scanner.nextInt();
            int[][] activities = new int[activityCount][2];
            for (int i = 0; i < activityCount; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
            }
            String result = assignActivities(activities);
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static String assignActivities(int[][] activities) {
        char[] schedule = new char[activities.length];
        PriorityQueue<Event> events = new PriorityQueue<>();

        for (int i = 0; i < activities.length; i++) {
            events.add(new Event(i, activities[i][0], false));
            events.add(new Event(i, activities[i][1], true));
        }

        boolean isCameronBusy = false;
        boolean isJamieBusy = false;

        while (!events.isEmpty()) {
            Event event = events.poll();

            if (!event.isEnd && isCameronBusy && isJamieBusy) {
                return "IMPOSSIBLE";
            }

            if (event.isEnd) {
                if (schedule[event.index] == 'C') {
                    isCameronBusy = false;
                } else {
                    isJamieBusy = false;
                }
            } else {
                if (isCameronBusy) {
                    schedule[event.index] = 'J';
                    isJamieBusy = true;
                } else {
                    schedule[event.index] = 'C';
                    isCameronBusy = true;
                }
            }
        }
        return new String(schedule);
    }

    private static class Event implements Comparable<Event> {
        int index;
        int time;
        boolean isEnd;

        public Event(int index, int time, boolean isEnd) {
            this.index = index;
            this.time = time;
            this.isEnd = isEnd;
        }

        @Override
        public int compareTo(Event other) {
            if (this.time != other.time) {
                return Integer.compare(this.time, other.time);
            }
            return Boolean.compare(!this.isEnd, !other.isEnd);
        }

        @Override
        public String toString() {
            return "Event{" +
                    "index=" + index +
                    ", time=" + time +
                    ", isEnd=" + isEnd +
                    '}';
        }
    }
}