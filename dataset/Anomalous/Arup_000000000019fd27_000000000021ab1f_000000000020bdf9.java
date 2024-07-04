import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            Event[] events = new Event[n];
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                events[i] = new Event(start, end, i);
            }
            Arrays.sort(events);

            char[] result = new char[n];
            boolean isPossible = true;
            int cEndTime = 0, jEndTime = 0;

            for (Event event : events) {
                if (event.start >= cEndTime) {
                    result[event.id] = 'C';
                    cEndTime = event.end;
                } else if (event.start >= jEndTime) {
                    result[event.id] = 'J';
                    jEndTime = event.end;
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.println("Case #" + t + ": " + new String(result));
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}

class Event implements Comparable<Event> {
    int start;
    int end;
    int id;

    public Event(int start, int end, int id) {
        this.start = start;
        this.end = end;
        this.id = id;
    }

    @Override
    public int compareTo(Event other) {
        if (this.end != other.end) {
            return Integer.compare(this.end, other.end);
        }
        return Integer.compare(this.id, other.id);
    }
}