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
		
		public String toString () {
			return String.format("[%d,%d]", this.start, this.end);
		}
		
		public boolean isSooner (TimeSlot ts) {
			return (this.start <= ts.start && this.end <= ts.start);
		}
		
		public boolean isLater (TimeSlot ts) {
			return (this.start >= ts.end && this.end >= ts.end);
		}
		
		public boolean overlaps (TimeSlot ts) {
			return ( this.start < ts.end && this.end > ts.start );
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
		
		public void remove (TimeSlot ts) {
			agenda.remove(ts);
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
			Agenda jamie = new Agenda();
			Agenda cameron = new Agenda();
			List<TimeSlot> slotsList = new LinkedList<TimeSlot>();
			for (int s = 0; s < slots; s++) {
				slotsList.add(new TimeSlot(in.nextInt(),in.nextInt()));
			}
			String res = bestAssignment(slotsList,0,jamie,cameron, "");

			System.out.println("Case #" + test + ": " + res);
		}
			
		in.close();
	}

	private String bestAssignment(List <TimeSlot> slotsList, int pos, Agenda jamie, Agenda cameron, String previous) {
		if (pos == slotsList.size() ) {
			return previous;
		} else {
			String res = "IMPOSSIBLE";
			TimeSlot currentSlot = slotsList.get(pos);
			if (jamie.add(currentSlot)) {
				res = bestAssignment(slotsList, pos+1, jamie, cameron, previous + "J");
				if (!res.equals("IMPOSSIBLE")) {
					return res;
				}
				jamie.remove(currentSlot);
			}

			if (cameron.add(currentSlot)) {
				res = bestAssignment(slotsList, pos+1, jamie, cameron, previous + "C");
				if (!res.equals("IMPOSSIBLE")) {
					return res;
				}
				cameron.remove(currentSlot);
			}
			return res;
		}
	}
		

}
