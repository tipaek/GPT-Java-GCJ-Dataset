import java.util.*;

class Event implements Comparable<Event> {
    public final int start;
    public final int end;

    public Event(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Event otherEvent) {
        return Integer.compare(this.start, otherEvent.start);
    }
}

public class Solution {
    private void solve(int caseNo, List<Event> events) {
        PriorityQueue<Event> eventQueue = new PriorityQueue<>(events);
        int cameronEnd = 0;
        int jamieEnd = 0;
        StringBuilder schedule = new StringBuilder();
        
        while (!eventQueue.isEmpty()) {
            Event currentEvent = eventQueue.poll();
            if (cameronEnd <= currentEvent.start) {
                cameronEnd = currentEvent.end;
                schedule.append('C');
            } else if (jamieEnd <= currentEvent.start) {
                jamieEnd = currentEvent.end;
                schedule.append('J');
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE%n", caseNo);
                return;
            }
        }
        
        System.out.printf("Case #%d: %s%n", caseNo, schedule.toString());
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            int numEvents = scanner.nextInt();
            List<Event> events = new ArrayList<>();
            
            for (int j = 0; j < numEvents; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                events.add(new Event(start, end));
            }
            
            solve(i + 1, events);
        }
        
        scanner.close();
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}