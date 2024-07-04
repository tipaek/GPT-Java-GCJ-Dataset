
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            char[] result = new char[N];
            List<CalendarEvent> events = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                CalendarEvent e = new CalendarEvent();
                e.startTime = in.nextInt();
                e.endTime = in.nextInt();
                e.order = j;
                events.add(e);
            }

            Collections.sort(events);
            int clast = -1, jlast = -1;

            boolean impossible = false;
            for (CalendarEvent e : events) {
                if (clast <= e.startTime) {
                    clast = e.endTime;
                    result[e.order] = 'C';
                } else if (jlast <= e.startTime) {
                    jlast = e.endTime;
                    result[e.order] = 'J';
                } else {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                    impossible = true;
                    break;
                }
            }
            
            if (!impossible)
                System.out.println("Case #" + i + ": " + String.valueOf(result));
        }
    }
}

class CalendarEvent implements Comparable<CalendarEvent> {
    public int startTime = 0, endTime = 0, order = -1;

    @Override
    public int compareTo(CalendarEvent o) {
        return startTime - o.startTime;
    }
}