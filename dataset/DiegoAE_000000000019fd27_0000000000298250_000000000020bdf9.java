import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	
	static class Event implements Comparable<Event> {
		int time;
		int id;
		public Event(int t, int id) {
			this.time = t;
			this.id = id;
		}
		@Override
		public int compareTo(Event o) {
			if (this.time != o.time)
				return Integer.compare(time, o.time);
			return Integer.compare(id, o.id);
		}
		public String toString() {
			return String.format("(%d, %d)", this.time, this.id);
		}
	}
	
	static ArrayList<Event> events;
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			events = new ArrayList<Event>();
			for(int i = 1; i <= N; i++) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				events.add(new Event(s, i));
				events.add(new Event(e, -i));
			}
			Collections.sort(events);
			LinkedList<Integer> available = new LinkedList<Integer>();
			available.add(0);
			available.add(1);
			int[] assignments = new int[N + 1];
			boolean impossible = false;
			for(Event e: events) {
				if (e.id < 0)
					available.add(assignments[-e.id]);
				else {
					if (available.isEmpty()) {
						impossible = true;
						break;
					}
					int c = available.pop();
					assignments[e.id] = c;
				}
			}
			System.out.print("Case #" + t + ": ");
			if (impossible)
				System.out.print("IMPOSSIBLE");
			else {
				for(int i = 1; i <= N; i++)
					System.out.print(assignments[i] == 0 ? 'C' : 'J');
			}
			System.out.println();
		}
		sc.close();
	}

}
