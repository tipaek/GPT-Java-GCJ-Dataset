import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class Solution {

    private static class Event {
        final int index, start, end;

        Event(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        try (BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(inputReader.readLine());

            for (int t = 1; t <= testCases; t++) {
                int N = Integer.parseInt(inputReader.readLine());
                TreeSet<Event> orderedEvents = new TreeSet<>(Comparator.comparingInt(e -> e.start));
                byte[] output = new byte[N];

                for (int n = 0; n < N; n++) {
                    String[] times = inputReader.readLine().split(" ");
                    int start = Integer.parseInt(times[0]);
                    int end = Integer.parseInt(times[1]);
                    orderedEvents.add(new Event(n, start, end));
                }

                int camFree = 0;
                int jamieFree = 0;
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

                if (!possible) {
                    System.out.printf("Case #%d: IMPOSSIBLE%n", t);
                } else {
                    System.out.printf("Case #%d: %s%n", t, new String(output));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}