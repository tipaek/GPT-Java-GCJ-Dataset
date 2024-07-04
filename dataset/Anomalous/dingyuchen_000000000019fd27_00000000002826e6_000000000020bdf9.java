import java.util.*;

class Event implements Comparable<Event> {
    public final int id;
    public final int start;
    public final int end;

    public Event(int id, int start, int end) {
        this.id = id;
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Event other) {
        return Integer.compare(this.start, other.start);
    }
}

public class Solution {
    private void solve(int caseNo, List<Event> events) {
        PriorityQueue<Event> eventQueue = new PriorityQueue<>(events);
        int cameronEnd = 0;
        int jamieEnd = 0;
        char[] assignments = new char[events.size()];

        while (!eventQueue.isEmpty()) {
            Event currentEvent = eventQueue.poll();
            if (cameronEnd <= currentEvent.start) {
                cameronEnd = currentEvent.end;
                assignments[currentEvent.id] = 'C';
            } else if (jamieEnd <= currentEvent.start) {
                jamieEnd = currentEvent.end;
                assignments[currentEvent.id] = 'J';
            } else {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", caseNo));
                return;
            }
        }
        System.out.println(String.format("Case #%d: %s", caseNo, new String(assignments)));
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            int eventCount = scanner.nextInt();
            List<Event> events = new ArrayList<>();
            for (int j = 0; j < eventCount; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                events.add(new Event(j, start, end));
            }
            solve(i + 1, events);
        }
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}