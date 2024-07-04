import java.util.*;
import java.io.*;

class Event implements Comparable<Event> {
    int time;
    int task;
    boolean isEnd;
    Event (int time, int task, boolean isEnd) { this.time = time; this.task = task; this.isEnd = isEnd; }

    @Override
    public int compareTo(Event o) {
        return time - o.time;
    }
}

public class Solution {

    public static void main(final String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        final char[] PT = { 'C', 'J' };

        for (int caseNumber = 1; caseNumber <= t; ++caseNumber) {
            final int n = in.nextInt();

            final ArrayList<Event> events = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                events.add(new Event(in.nextInt(), i, false));
                events.add(new Event(in.nextInt(), i, true));
            }
            Collections.sort(events);

            final int[] partners = new int[2];
            StringBuilder s = new StringBuilder();
            for (Event e: events) {
                if (!e.isEnd) {
                    if (partners[0] == 0) {
                        partners[0] = e.task;
                        s.append(PT[0]);
                    } else if (partners[1] == 0) {
                        partners[1] = e.task;
                        s.append(PT[1]);
                    } else {
                        s = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                } else {
                    if (partners[0] == e.task) partners[0] = 0;
                    if (partners[1] == e.task) partners[1] = 0;
                }
            }
            System.out.println("Case #" + caseNumber + ": " + s.toString());
        }
    }
}