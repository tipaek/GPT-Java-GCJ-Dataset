import java.util.*;
import java.io.*;

public class Solution {
	public class TimeSlot {
		int start, end;
		public TimeSlot (int start, int end) {
			if (start <= end) {
				this.start = start;
				this.end = end;
			} else {
				this.end = start;
				this.start = end;
			}
		}
		
		public boolean isSooner (TimeSlot ts) {
			return (this.start <= ts.start && this.end <= ts.start);
		}
		
		public boolean isLater (TimeSlot ts) {
			return (this.start >= ts.end && this.end >= ts.end);
		}
		
		public boolean overlaps (TimeSlot ts) {
			return ( this.end > ts.start && this.end <= ts.end ) || (this.start >= ts.start && this.start < ts.end);
		}
	}
	public class Agenda {
		LinkedList<TimeSlot> agenda;
		public Agenda() {
			agenda = new LinkedList<TimeSlot> ();
		}
		public boolean add(TimeSlot ts) {
			if (agenda.isEmpty()) {
				agenda.add(ts);
				return true;
			}
			for (int i = 0; i < agenda.size(); i++) {
				if ( ts.isSooner(agenda.get(i)) ) {
					agenda.add(i,ts);
					return true;
				}
				if (ts.overlaps(agenda.get(i))) {
					return false;
				}
			}
			agenda.add(ts);
			return true;
		}
		
	}
	// Try to program this with my daughter jumping over my head!! :D
	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.launch();
	}
	
	public void launch() {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs,
								// strings, chars, etc.
		for (int test = 1; test <= t; ++test) {
			int slots = in.nextInt();
			String res = "";
			Agenda jamie = new Agenda();
			Agenda cameron = new Agenda();
			for (int s = 0; s < slots; s++) {
				TimeSlot slot = new TimeSlot(in.nextInt(),in.nextInt());
				if (jamie.add(slot)) {
					res += "J";
				} else if (cameron.add(slot)) {
					res += "C";
				} else {
					res = "IMPOSSIBLE";
				}
			}
			System.out.println("Case #" + test + ": " + res);
		}
			
		in.close();
	}

}
