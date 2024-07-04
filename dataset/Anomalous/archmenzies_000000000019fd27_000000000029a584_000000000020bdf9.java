import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        try (BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(inputReader.readLine());

            for (int t = 1; t <= testCases; t++) {
                int N = Integer.parseInt(inputReader.readLine());
                TreeSet<Event> events = new TreeSet<>();

                for (int i = 0; i < N; i++) {
                    String[] times = inputReader.readLine().split(" ");
                    int start = Integer.parseInt(times[0]);
                    int end = Integer.parseInt(times[1]);
                    events.add(new Event(i, start, end));
                }

                char[] schedule = new char[N];
                int camFree = 0, jamieFree = 0;
                boolean possible = true;

                for (Event event : events) {
                    if (camFree <= event.start) {
                        camFree = event.end;
                        schedule[event.index] = 'C';
                    } else if (jamieFree <= event.start) {
                        jamieFree = event.end;
                        schedule[event.index] = 'J';
                    } else {
                        possible = false;
                        break;
                    }
                }

                System.out.printf("Case #%d: %s\n", t, possible ? new String(schedule) : "IMPOSSIBLE");
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