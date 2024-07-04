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
    public int compareTo(Event otherEvent) {
	return this.start - otherEvent.start;
    }
}

public class Solution {
    private void solve(int caseNo, List<Event> events) {
	PriorityQueue<Event> pq = new PriorityQueue<>(events);
	int cameronEnd = 0;
	int jamieEnd = 0;
	char[] assignment = new char[events.size()];
	while (!pq.isEmpty()) {
	    Event next = pq.poll();
	    if (cameronEnd <= next.start) {
		cameronEnd = next.end;
		assignment[next.id] = 'C';
	    } else if (jamieEnd <= next.start) {
		jamieEnd = next.end;
		assignment[next.id] = 'J';
	    } else {
		System.out.println(String.format("Case #%d: IMPOSSIBLE",
						 caseNo));
		return;
	    }
	}
	System.out.println(String.format("Case #%d: %s",
					 caseNo, new String(assignment)));
    }
    public void run() {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        for (int i = 0; i < testcases; i++) {
            int N = sc.nextInt();
	    List<Event> events = new ArrayList<>();
            for (int j = 0; j < N; j++) {
		int start = sc.nextInt();
		int end = sc.nextInt();
		events.add(new Event(j, start, end));
            }
            this.solve(i + 1, events);
        }
    }
    public static void main(String args[]) throws Exception {
        new Solution().run();
    }

}
