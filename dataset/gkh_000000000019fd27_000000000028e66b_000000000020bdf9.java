import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();

		for(int x = 1; x <= t; ++x) {
			int n = in.nextInt();

			Parent c = new Parent("C", 0);
			Parent j = new Parent("J", 0);

			String output = new String("");
			ArrayList<Activity> activities = new ArrayList<Activity>();
			for(int i=0; i<n; i++) {
				activities.add(new Activity(in.nextInt(), in.nextInt()));
			}
			Collections.sort(activities);

			for(int i=0; i<activities.size(); i++){
				if(c.isAvailable(activities.get(i))){
					output += c;
					c.setNextAvailable(activities.get(i).getEnd());
				} else if(j.isAvailable(activities.get(i))){
					output += j;
					j.setNextAvailable(activities.get(i).getEnd());
				} else {
					output = "IMPOSSIBLE";
					break;
				}
			}
			System.out.println("Case #"+x+": "+output);
		}
		
		in.close();
	}
}
class Activity implements Comparable<Activity>{
	private int start;
	private int end;

	public Activity(int start, int end){
		this.start = start;
		this.end = end;
	}

	public int compareTo(Activity other){
		if(getStart() == other.getStart()){
			return this.getEnd() - other.getEnd();
		}
		return this.getStart() - other.getStart();
	}

	public int getStart(){
		return start;
	}

	public int getEnd(){
		return end;
	}

	public String toString(){
		return getStart()+":"+getEnd();
	}
}
class Parent {
	private String name;
	private int nextAvailable;

	public Parent(String name, int nextAvailable){
		this.name = name;
		this.nextAvailable = nextAvailable;
	}

	public boolean isAvailable(Activity activity){
		return activity.getStart()>=nextAvailable;
	}

	public void setNextAvailable(int nextAvailable){
		this.nextAvailable = nextAvailable;
	}

	public String toString(){
		return name;
	}
}