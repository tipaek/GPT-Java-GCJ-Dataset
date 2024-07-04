import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();

            List<Event> events = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int s = in.nextInt();
                int e = in.nextInt();

                events.add(new Event(s, 0));
                events.add(new Event(e, 1));
            }

            Collections.sort(events);

            int activeEvents = 0;
            StringBuilder sb = new StringBuilder();
            boolean jill = true;

            boolean impossible = false;
            for (Event e: events) {
                if (e.type == 0) {
                    activeEvents++;

                    if (activeEvents > 2) {
                        impossible = true;
                        break;
                    }
                    else {
                        sb.append(jill ? "J" : "C");
                        jill = !jill;
                    }
                }
                else {
                    activeEvents--;
                }
            }

            if (impossible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
            else {
                System.out.println("Case #" + i + ": " + sb.toString());
            }
        }
    }

    static class Event implements Comparable<Event> {
        int where;
        int type; // 0 start, 1 end

        public Event(int w, int t) {
            where = w;
            type = t;
        }

        @Override
        public int compareTo(Event o) {
            if (this.where == o.where) {
                return this.type > o.type ? -1 : 1;
            }

            return this.where > o.where ? 1 : -1;
        }
    }
}

