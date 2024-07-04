import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();

        for (int i = 0; i < n; i++) {
            int events = stdin.nextInt();
            int cBusyTill = 0;
            int jBusyTill = 0;
            List<Event> eventsTimes = new ArrayList<>();

            System.out.print("Case #" + (i + 1) + ": ");

            for (int j = 0; j < events; j++) {
                int eventStart = stdin.nextInt();
                int eventEnd = stdin.nextInt();
                eventsTimes.add(new Event(eventStart, eventEnd));
            }
            Collections.sort(eventsTimes);

            StringBuilder solution = new StringBuilder();

            for (int j = 0; j < events; j++) {
                int start = eventsTimes.get(j).start;
                int end = eventsTimes.get(j).end;

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
            System.out.println(solution);
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
            } else {
                return Integer.compare(this.end, other.end);
            }
        }
    }
}