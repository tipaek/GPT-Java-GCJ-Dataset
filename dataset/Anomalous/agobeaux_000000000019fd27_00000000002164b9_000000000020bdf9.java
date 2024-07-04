import java.util.*;

public class Solution {

    private static class Event implements Comparable<Event> {
        int index;
        int time;
        boolean isStart;

        public Event(int index, int time, boolean isStart) {
            this.index = index;
            this.time = time;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Event other) {
            if (this.time == other.time) {
                return Boolean.compare(this.isStart, other.isStart);
            }
            return Integer.compare(this.time, other.time);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int activities = scanner.nextInt();
            PriorityQueue<Event> eventsQueue = new PriorityQueue<>(activities * 2);
            for (int i = 0; i < activities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                eventsQueue.add(new Event(i, start, true));
                eventsQueue.add(new Event(i, end, false));
            }

            int ongoingActivities = 0;
            boolean isImpossible = false;
            char[] schedule = new char[activities];
            boolean cameronBusy = false, jamieBusy = false;

            while (!eventsQueue.isEmpty() && !isImpossible) {
                Event event = eventsQueue.poll();
                if (event.isStart) {
                    ongoingActivities++;
                    if (ongoingActivities > 2) {
                        isImpossible = true;
                        break;
                    } else {
                        if (!cameronBusy) {
                            schedule[event.index] = 'C';
                            cameronBusy = true;
                        } else {
                            schedule[event.index] = 'J';
                            jamieBusy = true;
                        }
                    }
                } else {
                    ongoingActivities--;
                    if (schedule[event.index] == 'C') {
                        cameronBusy = false;
                    } else {
                        jamieBusy = false;
                    }
                }
            }

            if (isImpossible) {
                System.out.printf("Case #%d: IMPOSSIBLE%n", t);
            } else {
                System.out.printf("Case #%d: %s%n", t, new String(schedule));
            }
        }
    }
}