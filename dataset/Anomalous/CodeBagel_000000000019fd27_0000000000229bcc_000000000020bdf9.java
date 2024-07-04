import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();

        for (int i = 1; i <= cases; ++i) {
            int eventCount = in.nextInt();
            List<Event> events = new ArrayList<>();
            char[] order = new char[eventCount];
            Arrays.fill(order, '_');

            for (int j = 0; j < eventCount; j++) {
                events.add(new Event(in.nextInt(), in.nextInt()));
            }

            Event jamieEvent = null;
            Event camEvent = null;
            String res = "";

            outerLoop:
            for (int j = 0; j <= 1440; j++) {
                if (jamieEvent != null && jamieEvent.finish == j) {
                    jamieEvent = null;
                }
                if (camEvent != null && camEvent.finish == j) {
                    camEvent = null;
                }

                for (int k = 0; k < events.size(); k++) {
                    Event event = events.get(k);
                    if (event.start == j) {
                        if (camEvent == null) {
                            camEvent = event;
                            order[k] = 'C';
                        } else if (jamieEvent == null) {
                            jamieEvent = event;
                            order[k] = 'J';
                        } else {
                            res = "IMPOSSIBLE";
                            break outerLoop;
                        }
                    }
                }
            }

            if (!res.equals("IMPOSSIBLE")) {
                res = new String(order);
            }

            System.out.println("Case #" + i + ": " + res);
        }
    }

    private static class Event {
        public int start;
        public int finish;

        public Event(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }
}