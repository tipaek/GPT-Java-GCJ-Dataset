import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        StringBuilder result = new StringBuilder();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            Event[] events = new Event[n];
            char[] schedule = new char[n];
            int endJ = 0, endC = 0;

            for (int j = 0; j < n; j++) {
                events[j] = new Event(scanner.nextInt(), scanner.nextInt(), j);
            }

            Arrays.sort(events, Comparator.comparingInt(event -> event.start));

            boolean isPossible = true;
            for (Event event : events) {
                if (Math.min(endJ, endC) > event.start) {
                    isPossible = false;
                    break;
                }
                if (endJ <= endC) {
                    schedule[event.index] = 'J';
                    endJ = event.end;
                } else {
                    schedule[event.index] = 'C';
                    endC = event.end;
                }
            }

            if (isPossible) {
                result.append("Case #").append(t).append(": ").append(new String(schedule)).append("\n");
            } else {
                result.append("Case #").append(t).append(": IMPOSSIBLE\n");
            }
        }
        System.out.print(result);
    }

    static class Event {
        final int start;
        final int end;
        final int index;

        public Event(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}