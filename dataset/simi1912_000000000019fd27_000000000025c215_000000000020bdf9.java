
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
	
	static int numCases;
	static List<List<Activity>> cases = new ArrayList<>();
	static Scanner scanner;
	
	public static void main(String[] args) {

		scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		numCases = scanner.nextInt();
		
		int numActivities;
		Activity activity;
		int start;
		int end;
		List<Activity> activities;
		
		for(int i=0; i<numCases; i++) {
			
			activities = new ArrayList<>();
			numActivities = scanner.nextInt();
			for(int j=0; j<numActivities; j++) {
				
				start = scanner.nextInt();
				end = scanner.nextInt();
				
				activity = new Activity(start, end);
				activities.add(activity);
			}
			cases.add(activities);
		}
		print();
	}
	
	public static void print() {
		
		Scheduler scheduler;
		String caseSolution;
		int caseNr = 0;
		for(List<Activity> activities: cases) {
			
			caseNr++;
			
			scheduler = new Scheduler(activities);
			caseSolution = scheduler.getSchedule();
			System.out.println("Case #"+caseNr+": "+caseSolution);
		}
	}
}

class Activity implements Comparable<Activity>{
	
	private int start;
	private int end;
	private boolean available = true;
	private String efector;
	
	public Activity(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	public int getStart() {return start;}
	
	public int getEnd() {return end;}

	public boolean isAvailable() {return available;}
	
	public void setAvailable(boolean used) {this.available = used;}
	
	public void setEfector(String efector) {this.efector = efector;}
	
	public String getEfector() {return efector;}
	
	@Override
	public int compareTo(Activity o) {
		return start-o.start;
	}
}

class Scheduler{
	
	List<Activity> activitiesUnsorted;
	List<Activity> activities;
	String solution = "";
	Activity previousActivityC;
	Activity previousActivityJ;
	
	public Scheduler(List<Activity> activities) {
		this.activities = activities;
		copyToUnsortedList(activities);
		activities.sort(null);
	}
	
	private void copyToUnsortedList(List<Activity> activities) {
		
		activitiesUnsorted = new ArrayList<>();
		for(Activity activity: activities) {
			activitiesUnsorted.add(activity);
		}
	}

	public String getSchedule() {
		
		Activity firstActivity = activities.get(0);
		addNextAactivity("C", firstActivity);
		
		Activity nextActivity = null;
		for(int i=1; i<activities.size(); i++) {
			
			nextActivity = activities.get(i);
			
			if( nextActivity.getStart() >= previousActivityC.getEnd() ) {
				addNextAactivity("C", nextActivity);
			}
			if( previousActivityJ == null ) { 
				addNextAactivity("J", nextActivity);
			} else if( nextActivity.getStart() >= previousActivityJ.getEnd()) {
				addNextAactivity("J", nextActivity);
			}
		}
		
		return getSolution();
	}
	
	private String getSolution() {
		StringBuilder solution = new StringBuilder("");
		
		for(Activity activity: activitiesUnsorted) {
			
			solution.append(activity.getEfector());
		}
		
		if(solution.toString().contains("null")) {
			return "IMPOSSIBLE";
		}
		
		return solution.toString();
	}

	public void addNextAactivity(String efector, Activity activity) {
		
		activity.setEfector(efector);
		
		if(efector.equals("C")) {
			previousActivityC = activity;
		} else {
			previousActivityJ = activity;
		}
		activity.setAvailable(false);
	}
}


