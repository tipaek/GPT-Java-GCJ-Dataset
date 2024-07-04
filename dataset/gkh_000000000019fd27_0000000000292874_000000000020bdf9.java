import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();

		for(int x = 0; x < t; x++) {
			int n = in.nextInt();

			Parent c = new Parent("C");
			Parent j = new Parent("J");

			String output = new String("");
			ArrayList<Activity> activities = new ArrayList<Activity>();
			for(int i=0; i<n; i++) {
				activities.add(new Activity(in.nextInt(), in.nextInt()));
			}
			for(int i=0; i<activities.size(); i++){
				if(c.isAvailable(activities.get(i))){
					output += c;
					c.addActivity(activities.get(i));
				} else if(j.isAvailable(activities.get(i))){
					output += j;
					j.addActivity(activities.get(i));
				} else {
					output = "IMPOSSIBLE";
					break;
				}
			}

			System.out.println("Case #"+(x+1)+": "+output);
		}
		
		in.close();
	}
}
class Activity {
	private int start;
	private int end;

	public Activity(int start, int end){
		this.start = start;
		this.end = end;
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

	public boolean intersects(Activity other){
		return !(this.getEnd()<=other.getStart() || other.getEnd()<=this.getStart());
	}
}
class Parent {
	private String name;
	private ArrayList<Activity> activities;

	public Parent(String name){
		this.name = name;
		activities = new ArrayList<Activity>();
	}

	public boolean isAvailable(Activity activity){
		for(int i=0; i<activities.size(); i++){
			if(activities.get(i).intersects(activity)){
				return false;
			}
		}
		return true;
	}

	public void addActivity(Activity activity){
		activities.add(activity);
	}

	public String toString(){
		return name;
	}
}