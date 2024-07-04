import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

public class Solution {

    public static void main(String[] args) {
        try (BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(inputReader.readLine());

            for (int t = 1; t <= testCases; t++) {
                int numEvents = Integer.parseInt(inputReader.readLine());
                TreeSet<Event> events = new TreeSet<>();

                for (int i = 0; i < numEvents; i++) {
                    int[] times = Arrays.stream(inputReader.readLine().split(" "))
                                        .mapToInt(Integer::parseInt)
                                        .toArray();
                    events.add(new Event(i, times[0], times[1]));
                }

                byte[] schedule = new byte[numEvents];
                int cameronAvailable = 0, jamieAvailable = 0;
                boolean possible = true;

                while (!events.isEmpty()) {
                    Event currentEvent = events.pollFirst();
                    if (cameronAvailable <= currentEvent.start) {
                        cameronAvailable = currentEvent.end;
                        schedule[currentEvent.index] = 'C';
                    } else if (jamieAvailable <= currentEvent.start) {
                        jamieAvailable = currentEvent.end;
                        schedule[currentEvent.index] = 'J';
                    } else {
                        possible = false;
                        break;
                    }
                }

                if (possible) {
                    System.out.printf("Case #%d: %s%n", t, new String(schedule));
                } else {
                    System.out.printf("Case #%d: IMPOSSIBLE%n", t);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Event implements Comparable<Event> {
        final int index;
        final int start;
        final int end;

        public Event(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Event other) {
            return Integer.compare(this.start, other.start);
        }
    }
}