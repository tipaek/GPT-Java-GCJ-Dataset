import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		

		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for(int i = 1; i <= t; i++) {
			int n = in.nextInt();
			
			
			System.out.print("Case #" + i + ": " + getSchedule(n, in) + "\n");
			
			
		}
		
	}
	
	public static String getSchedule(int n, Scanner in) {
		schedule cameron = new schedule("C");
		schedule jamie = new schedule("J");
		
		ArrayList<activity> order = new ArrayList<>();
		
		
		for(int i = 0; i < n; i++) {
			activity a = new activity(in.nextInt(), in.nextInt());
			order.add(a);
		}
		
		
		ArrayList<activity> sortedArr = (ArrayList<activity>) order.clone();
		Collections.sort(sortedArr);
		
		for(activity a : sortedArr) {
			if(cameron.canAdd(a)) {
				cameron.add(a);
			}
		}
		
		for(activity a : sortedArr) {
			if(a.haveadded() == false) {
				if(jamie.canAdd(a)) {
					jamie.add(a);
				}
			}
		}
		
		String s = "";
		
		for(activity a : order) {
			if(a.haveadded() == false) {
				return "IMPOSSIBLE";
			} else {
				s += a.getPerson();
			}
		}
		
		return s;
		
	}
	
	
	
	
	
}

class activity implements Comparable<activity> {
	private int start;
	private int end;
	private String person;
	private boolean added;
	
	public activity(int s, int e) {
		start = s;
		end = e;
		added = false;
	}
	
	public int getStart() {
		return start;
	}
	
	public int getEnd() {
		return end;
	}
	
	public void setPerson(String s) {
		person = s;
	}
	
	public String getPerson() {
		return person;
	}
	
	public void added() {
		added = true;
	}
	
	public boolean haveadded() {
		return added;
	}

	@Override
	public int compareTo(activity other) {
		if(start < other.getStart()) {
			return -1;
		} else if(start > other.getStart()) {
			return 1;
		} else {
			return 0;
		}
	}
	
	
}


class schedule {
	
	private ArrayList<activity> arr;
	private String name;
	
	public schedule(String n) {
		arr = new ArrayList<>();
		name = n;
	}
	
	public boolean canAdd(activity a) {
		for(activity b : arr) {
			if(a.getStart() > b.getStart() && a.getStart() < b.getEnd()) {
				return false;
			} else if(a.getEnd() > b.getStart() && a.getEnd() < b.getEnd()) {
				return false;
			} else if (b.getStart() > a.getStart() && b.getStart() < a.getEnd()){
				return false;
			} else if (b.getEnd() > a.getStart() && b.getEnd() < a.getEnd()){
			    return false;	
			} else if(a.getEnd() == b.getEnd() && a.getStart() == b.getStart()) {
				return false;
			}
		}
		return true;
	}
	
	public int minStartDist(activity a) {
		int mindist = 1440;
		for(activity b : arr) {
			if(b.getEnd() <= a.getStart()) {
				int i = a.getStart() - b.getEnd();
				if (i < mindist) {
					mindist = i;
				}
			}
		}
		
		return mindist;
	}
	
	public int minEndDist(activity a) {
		int mindist = 1440;
		for(activity b : arr) {
			if(b.getStart() >= a.getEnd()) {
				int i = b.getStart() - a.getEnd();
				if(i < mindist) {
					mindist = i;
				}
			}
		}
		return mindist;
	}
	
	
	public void add(activity a) {
		arr.add(a);
		a.setPerson(name);
		a.added();
	}
	
	
	
	
}

