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
                byte[] output = new byte[N];
                int camFree = 0;
                int jamieFree = 0;

                for (int n = 0; n < N; n++) {
                    String[] times = inputReader.readLine().split(" ");
                    int start = Integer.parseInt(times[0]);
                    int end = Integer.parseInt(times[1]);
                    orderedEvents.add(new Event(n, start, end));
                }

                while (!orderedEvents.isEmpty()) {
                    Event nextEvent = orderedEvents.pollFirst();
                    if (camFree <= nextEvent.start) {
                        camFree = nextEvent.end;
                        output[nextEvent.i] = 'C';
                    } else if (jamieFree <= nextEvent.start) {
                        jamieFree = nextEvent.end;
                        output[nextEvent.i] = 'J';
                    } else {
                        output = "IMPOSSIBLE".getBytes();
                        break;
                    }
                }

                System.out.printf("Case #%d: %s%n", t, new String(output));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Event implements Comparable<Event> {
        final int i, start, end;

        Event(int i, int start, int end) {
            this.i = i;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Event that) {
            return Integer.compare(this.start, that.start);
        }
    }
}