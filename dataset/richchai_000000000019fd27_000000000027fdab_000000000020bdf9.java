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
			activity a = new activity(in.nextInt(), in.nextInt(), i);
			
			if(cameron.canAdd(a)) {
				cameron.add(a);
				order.add(a);
			} else if(jamie.canAdd(a)) {
				jamie.add(a);
				order.add(a);
			} else {
				return "IMPOSSIBLE";
			}
		}
		
		String s = "";
		
		for(activity a : order) {
			s += a.getPerson();
		}
		
		return s;
	}
	
	
}

class activity {
	private int start;
	private int end;
	private int num;
	private String person;
	
	public activity(int s, int e, int n) {
		start = s;
		end = e;
		num = n;
	}
	
	public int getStart() {
		return start;
	}
	
	public int getEnd() {
		return end;
	}
	
	public int getNum() {
		return num;
	}
	
	public void setPerson(String s) {
		person = s;
	}
	
	public String getPerson() {
		return person;
	}
}

class schedule {
	
	ArrayList<activity> arr;
	String name;
	
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
			}
		}
		return true;
	}
	
	public void add(activity a) {
		arr.add(a);
		a.setPerson(name);
	}
	
	
	
	
}
