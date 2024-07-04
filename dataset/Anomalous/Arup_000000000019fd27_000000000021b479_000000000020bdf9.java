import java.util.*;

public class Scheduler {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int eventCount = scanner.nextInt();
            Event[] events = new Event[eventCount];

            for (int i = 0; i < eventCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                events[i] = new Event(start, end, i);
            }

            Arrays.sort(events);

            char[] result = new char[eventCount];
            boolean isPossible = true;
            int cAvailable = 0, jAvailable = 0;

            for (int i = 0; i < eventCount; i++) {
                if (events[i].start >= cAvailable && (cAvailable >= jAvailable || jAvailable > events[i].start)) {
                    result[events[i].id] = 'C';
                    cAvailable = events[i].end;
                } else if (events[i].start >= jAvailable) {
                    result[events[i].id] = 'J';
                    jAvailable = events[i].end;
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.println("Case #" + caseNum + ": " + new String(result));
            } else {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
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