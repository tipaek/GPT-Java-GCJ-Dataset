import java.io.*;
import java.util.Arrays;

public class Solution {
    private static class Event implements Comparable<Event> {
        public int time;
        public boolean isStart;
        public Responsibility r;

        public Event (int t, boolean start, Responsibility r) {
            time = t;
            isStart = start;
            this.r = r;
        }

        @Override
        public int compareTo(Event other) {
            int res = time - other.time;
            if (res == 0) {
                res = isStart ? 1 : -1;
            }

            return res;
        }
    }

    private static class Responsibility {
        boolean isC;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        int T = Integer.parseInt(line);
        for (int t = 1; t <= T; t++) {
            line = reader.readLine();
            int n = Integer.parseInt(line);
            Event[] events = new Event[n * 2];
            Event[] eventsSorted = new Event[n * 2];
            for (int i = 0; i < n; i++) {
                line = reader.readLine();
                String[] tokens = line.split(" ");
                int start = Integer.parseInt(tokens[0]);
                int end = Integer.parseInt(tokens[1]);

                Responsibility r = new Responsibility();
                events[i * 2] = new Event(start, true, r);
                events[i * 2 + 1] = new Event(end, false, r);
            }

            System.arraycopy(events, 0, eventsSorted, 0, n * 2);

            Arrays.sort(eventsSorted);

            boolean j = false;
            boolean c = false;
            boolean impossible = false;

            StringBuilder sb = new StringBuilder();
            for (Event e : eventsSorted) {
                if (e.isStart) {
                    if (j && c) {
                        impossible = true;
                        System.out.println("Case #" + t + ": IMPOSSIBLE");
                        break;
                    }
                    if (!j) {
                        j = true;
                        e.r.isC = false;
                    } else {
                        c = true;
                        e.r.isC = true;
                    }
                } else {
                    if (e.r.isC) c = false;
                    else j = false;
                }
            }

            if (!impossible) {
                for (int i = 0; i < n; i++) {
                    sb.append(events[i * 2].r.isC ? 'C' : 'J');
                }
                System.out.println("Case #" + t + ": " + sb.toString());
            }
        }

    }
}