import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();

		for(int x = 1; x <= t; ++x) {
			int n = in.nextInt();

			Parent c = new Parent("C");
			Parent j = new Parent("J");

			String[] output = new String[n];
			ArrayList<Activity> activities = new ArrayList<Activity>();
			for(int i=0; i<n; i++) {
				activities.add(new Activity(in.nextInt(), in.nextInt(), i));
			}
			Collections.sort(activities);
			
			for(int i=0; i<activities.size(); i++){
				if(c.isAvailable(activities.get(i))){
					output[activities.get(i).getI()] = c.toString();
					c.addActivity(activities.get(i));
				} else if(j.isAvailable(activities.get(i))){
					output[activities.get(i).getI()] = j.toString();
					j.addActivity(activities.get(i));
				} else {
					output = new String("IMPOSSIBLE").split("");
					break;
				}
			}

			System.out.print("Case #"+x+": ");
			printWord(output);
		}
		
		in.close();
	}

	public static void printWord(String[] output){
		for(String letter: output){
			System.out.print(letter);
		}
		System.out.println();
	}
}
class Activity implements Comparable<Activity> {
	private int start;
	private int end;
	private int i;

	public Activity(int start, int end, int i){
		this.start = start;
		this.end = end;
		this.i = i;
	}

	public int getStart(){
		return start;
	}

	public int getEnd(){
		return end;
	}

	public int getI(){
		return i;
	}

	public boolean intersects(Activity other){
		return !(this.getEnd()<=other.getStart() || other.getEnd()<=this.getStart());
	}

	public int compareTo(Activity other){
		if(getStart() == other.getStart()){
			return this.getEnd() - other.getEnd();
		}
		return this.getStart() - other.getStart();
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