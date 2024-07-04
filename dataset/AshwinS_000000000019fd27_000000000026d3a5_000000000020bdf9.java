import java.io.*;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Solution {
	
	Scanner sc;

    class TimeSlot{
		int start;
		int end;
		
		public TimeSlot(int s, int e) {
			start = s;
			end = e;
		}
		
		public int hashCode() {
			return start ^ end;
			
		}
		
		public boolean equals(Object anObject) {
			if(!(anObject instanceof TimeSlot)) {
				return false;
			}
			TimeSlot obj = (TimeSlot)anObject;
			return ((start == obj.start) && (end == obj.end));
		}
		
		public boolean isOverlaps(TimeSlot anotherSlot){
			boolean isOverlaps = false;
			isOverlaps = (start > anotherSlot.start && start < anotherSlot.end)
					|| (end > anotherSlot.start && end < anotherSlot.end);
			if((end - start) > (anotherSlot.end - anotherSlot.start)) {
				// current object is bigger timeslot
				isOverlaps = (anotherSlot.start > start && anotherSlot.start < end) 
						|| (anotherSlot.end > start && anotherSlot.end < end);
			} else {
				//anotherSlot is bigger timeslot
				isOverlaps = (start > anotherSlot.start && start < anotherSlot.end)
						|| (end > anotherSlot.start && end < anotherSlot.end);
			}
			return isOverlaps;
		}
	}
	
	public Comparator<TimeSlot> mComparator = new Comparator<TimeSlot>() {

		@Override
		public int compare(TimeSlot o1, TimeSlot o2) {
			if(o1.end <= o2.start) {
				return -1;
			} else if (o1.start >= o2.end) {
				return 1;
			}
			return 0;
		}
		
	};
    
	public static void main(String[] args) {
		new Solution().findOptimisedSolution();
	}
	
	private void findOptimisedSolution() {
		StringBuilder op = new StringBuilder();
		StringBuilder tasksAssign = new StringBuilder(); 
		sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases = sc.nextInt();
		PriorityQueue<TimeSlot> cQueue = new PriorityQueue<TimeSlot>(mComparator);
		PriorityQueue<TimeSlot> jQueue = new PriorityQueue<TimeSlot>(mComparator);
		for (int test = 0; test < testCases; test++) {
			op.append("Case #").append(test+1).append(": ");
			int tasks = sc.nextInt();
			for(int t = 0; t < tasks; t++) {
				TimeSlot slot = new TimeSlot(sc.nextInt(), sc.nextInt());
				String user = assign(slot, cQueue, jQueue);
				if("".equals(user)) {
					//the task cannot be assigned to anyone
					//clear any previous assignments
					tasksAssign.setLength(0);
					tasksAssign.append("IMPOSSIBLE");
					break;
				} else {
					tasksAssign.append(user);
				}
			}
			op.append(tasksAssign);
			System.out.println(op.toString());
			op.setLength(0);
			tasksAssign.setLength(0);
			cQueue.clear();
			jQueue.clear();
		}
		sc.close();
	}
	
	private String assign(TimeSlot slot, PriorityQueue<TimeSlot> c, PriorityQueue<TimeSlot> j) {
		int cDelta = findDelta(slot, c);
		int jDelta = findDelta(slot, j);
		if(-1 == cDelta && -1 == jDelta) {
			//both slots overlap at this time
			return "";
		}
		if(0 == cDelta) {
			c.add(slot);
			return "C";
		} else if(0 == jDelta) {
			j.add(slot);
			return "J";
		} else if(cDelta < jDelta) {
			// adding to C would keep larger time chunk free at J
			c.add(slot);
			return "C";
		} else {
			j.add(slot);
			return "J";
		}
	}
	
	private int findDelta(TimeSlot slot, PriorityQueue<TimeSlot> c) {
		int delta = -1;
		if(0 == c.size()) {
			return 0;
		}
		Iterator<TimeSlot> it = c.iterator();
		while(it.hasNext()) {
			TimeSlot s = (TimeSlot)it.next();
			if(slot.start >= s.end) {
				delta = slot.start - s.end;
			} else if(slot.end <= s.start) {
				delta = s.start - slot.end;
			}
		}
		return delta;
	}

}