import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();

        for (int i = 0; i < n; i++) {
            int events = stdin.nextInt();
            int cBusyTill = 0;
            int jBusyTill = 0;
            List<Event> eventList = new ArrayList<>();

            for (int j = 0; j < events; j++) {
                int eventStart = stdin.nextInt();
                int eventEnd = stdin.nextInt();
                eventList.add(new Event(eventStart, eventEnd));
            }
            Collections.sort(eventList);

            StringBuilder solution = new StringBuilder();

            for (Event event : eventList) {
                int start = event.start;
                int end = event.end;

                if (cBusyTill <= start) {
                    cBusyTill = end;
                    solution.append('C');
                } else if (jBusyTill <= start) {
                    jBusyTill = end;
                    solution.append('J');
                } else {
                    solution = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + solution);
        }

        stdin.close();
    }

    public static class Event implements Comparable<Event> {
        int start;
        int end;

        public Event(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Event other) {
            if (this.start != other.start) {
                return Integer.compare(this.start, other.start);
            }
            return Integer.compare(this.end, other.end);
        }
    }
}