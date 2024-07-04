import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = input.nextInt();
        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int numEvents = input.nextInt();

            List<Event> events = new ArrayList<>();
            for (int i = 0; i < numEvents; i++) {
                int start = input.nextInt();
                int end = input.nextInt();
                events.add(new Event(start, end, i));
            }

            Collections.sort(events, Comparator.comparing(Event::getStart));

            char[] chars = new char[numEvents];
            int jEnd = 0, cEnd = 0;
            boolean impossible = false;
            for (Event event : events) {
                if (event.start >= jEnd) {
                    chars[event.index] = 'J';
                    jEnd = event.end;
                } else if (event.start >= cEnd) {
                    chars[event.index] = 'C';
                    cEnd = event.end;
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible)
                System.out.printf("Case #%d: IMPOSSIBLE\n", caseNum);
            else
                System.out.printf("Case #%d: %s\n", caseNum, new String(chars));
        }
    }

    static class Event {

        private final int start;
        private final int end;
        private final int index;

        public Event(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getIndex() {
            return index;
        }
    }
}
