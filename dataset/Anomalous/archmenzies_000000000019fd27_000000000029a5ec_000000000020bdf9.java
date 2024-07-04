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
                    int[] times = Arrays.stream(inputReader.readLine().split(" "))
                                        .mapToInt(Integer::parseInt)
                                        .toArray();
                    orderedEvents.add(new Event(n, times[0], times[1]));
                }

                char[] output = new char[N];
                int camFree = 0, jamieFree = 0;
                boolean possible = true;

                for (Event event : orderedEvents) {
                    if (camFree <= event.start) {
                        camFree = event.end;
                        output[event.index] = 'C';
                    } else if (jamieFree <= event.start) {
                        jamieFree = event.end;
                        output[event.index] = 'J';
                    } else {
                        possible = false;
                        break;
                    }
                }

                System.out.printf("Case #%d: %s\n", t, possible ? new String(output) : "IMPOSSIBLE");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Event implements Comparable<Event> {
        final int index, start, end;

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