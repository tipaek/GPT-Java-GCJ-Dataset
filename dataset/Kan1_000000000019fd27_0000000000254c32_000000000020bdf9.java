import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {


	static Solution sol = new Solution();
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);  // Create a Scanner object
		int T = scann.nextInt();

		Comparator<Activity> compareById = (Activity o1, Activity o2) -> 
        o1.id.compareTo( o2.id );
        
        Comparator<Activity> compareByStart = (Activity o1, Activity o2) -> 
        o1.start.compareTo( o2.start );
        
		for(int usease = 0; usease< T;usease++) {

			int N = scann.nextInt(); //Number of activities

			Parent cameron = new Parent('C');
			Parent jamy = new Parent('J');
			StringBuilder sb = new StringBuilder();
			List<Activity> activities = new ArrayList<>();
			
			for(int i = 0; i< N;i++) {
				
				int start = scann.nextInt();
				int end = scann.nextInt();
				activities.add(new Activity(i,start, end));			
				
			}

			Collections.sort(activities);
			
			for(Activity act : activities) {
				if(cameron.isAvailable(act.start)) {
					cameron.setActivity(act.start, act.end);
					act.affectTo(cameron.name);
					
				}else if(jamy.isAvailable(act.start)) {
					jamy.setActivity(act.start, act.end);
					act.affectTo(jamy.name);

				}
				else {
					sb.append("IMPOSSIBLE");
					break;
					
				}
			}
			
			if(sb.toString().isEmpty()) {
				Collections.sort(activities,compareById);
				for(Activity act : activities) {
					sb.append(act.doneBy);
				}
			}
			
			
			System.out.println(String.format("Case #%s: %s",usease+1,sb.toString()));			

		}

		
	}
	

	


	
	

}
class Parent {
	int start;
	int end;
	char name;
	public Parent(char name) {
		this.name = name;
		this.start=0;
		this.end=0;
	}
	
	public void setActivity(int start,int end) {
		this.start =start;
		this.end = end;
		
	}
	
	public boolean isAvailable(int time) {
		if(time >= start && time < end) return false;
		return true;
	}
	
}

class Activity implements Comparable<Activity>{
	Integer start;
	Integer end;
	Integer id;
	char doneBy;
	public Activity(int id, int start,int end) {
		this.id = id;
		this.start = start;
		this.end = end;
	}
	public void affectTo(char c) {
		this.doneBy = c;
	}
	
	@Override
	public int compareTo(Activity o) {
		
		return this.start.compareTo(o.start);
	}
	
	
}

