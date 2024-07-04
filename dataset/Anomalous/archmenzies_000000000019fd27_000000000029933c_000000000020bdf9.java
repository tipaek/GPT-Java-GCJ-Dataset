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
                int N = Integer.parseInt(inputReader.readLine());
                TreeSet<Event> orderedEvents = new TreeSet<>();

                for (int n = 0; n < N; n++) {
                    String[] times = inputReader.readLine().split(" ");
                    int start = Integer.parseInt(times[0]);
                    int end = Integer.parseInt(times[1]);
                    orderedEvents.add(new Event(n, start, end));
                }

                char[] output = new char[N];
                int camFree = 0, jamieFree = 0;
                boolean possible = true;

                while (!orderedEvents.isEmpty()) {
                    Event nextEvent = orderedEvents.pollFirst();
                    if (camFree <= nextEvent.start) {
                        camFree = nextEvent.end;
                        output[nextEvent.index] = 'C';
                    } else if (jamieFree <= nextEvent.start) {
                        jamieFree = nextEvent.end;
                        output[nextEvent.index] = 'J';
                    } else {
                        possible = false;
                        break;
                    }
                }

                if (possible) {
                    System.out.printf("Case #%d: %s%n", t, new String(output));
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