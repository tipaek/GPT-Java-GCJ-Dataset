import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = in.nextInt();
        StringBuilder sb;

        for (int test = 1; test <= testCount; test++) {
            int totalEvents = in.nextInt();
            Event[] events = new Event[totalEvents];
            char[] solution = new char[totalEvents];

            for (int event = 0; event < totalEvents; event++) {
                int start = in.nextInt();
                int end = in.nextInt();
                events[event] = new Event(start, end, event);
            }

            Arrays.sort(events, Comparator.comparingInt(e -> e.start));

            boolean cameronWorking = false;
            int cameronEnd = 0;
            boolean jamieWorking = false;
            int jamieEnd = 0;
            boolean impossible = false;

            for (Event event : events) {
                if (cameronEnd <= event.start) {
                    cameronWorking = true;
                    cameronEnd = event.end;
                    solution[event.index] = 'C';
                } else if (jamieEnd <= event.start) {
                    jamieWorking = true;
                    jamieEnd = event.end;
                    solution[event.index] = 'J';
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + test + ": " + new String(solution));
            }
        }
        in.close();
    }

    static class Event {
        int start;
        int end;
        int index;

        Event(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}