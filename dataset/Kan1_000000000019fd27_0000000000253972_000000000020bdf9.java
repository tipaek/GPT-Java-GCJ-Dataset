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

		for(int usease = 0; usease< T;usease++) {

			int N = scann.nextInt(); //Number of activities

			Parent cameron = new Parent('C');
			Parent jamy = new Parent('J');
			StringBuilder sb = new StringBuilder();
			List<Activity> activities = new ArrayList<>();
			
			for(int i = 0; i< N;i++) {
				
				int start = scann.nextInt();
				int end = scann.nextInt();
				activities.add(new Activity(start, end));			
				
			}

			Collections.sort(activities);
			
			for(Activity act : activities) {
				if(cameron.isAvailable(act.start)) {
					cameron.setActivity(act.start, act.end);
					sb.append(cameron.name);
				}else if(jamy.isAvailable(act.start)) {
					jamy.setActivity(act.start, act.end);
					sb.append(jamy.name);
				}
				else {
					sb = new StringBuilder();
					sb.append("IMPOSSIBLE");
					break;
					
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
	public Activity(int start,int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Activity o) {
		
		return this.start.compareTo(o.start);
	}
	
	
}

