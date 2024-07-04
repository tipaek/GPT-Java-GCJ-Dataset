import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

	static class Activity implements Comparable {
		int start;
		int end;
		String responsible;
		int id;
		public Activity(int start, int end,int id) {
			this.start = start;
			this.end = end;
			this.id = id;
		}
		@Override
		public int compareTo(Object arg0) {
			if(this.start <= ((Activity)arg0).start)
				return -1;
			else
				return 1;
		}
		@Override
		public String toString() {
			return "Activity [start=" + start + ", end=" + end + ", responsible=" + responsible + ", id=" + id + "]";
		}
		
	}

	static class Input{
		int n; // nb of activities
		ArrayList<Activity> activities;
		ArrayList<Activity> sortedActivities;
		public Input(int n, ArrayList<Activity> activities) {
			this.n = n;
			this.activities = activities;
			this.sortedActivities = (ArrayList<Activity>) activities.clone();
			Collections.sort(sortedActivities);
		}
		@Override
		public String toString() {
			return "Input [n=" + n + ", activities=" + activities + ", sortedActivities=" + sortedActivities + "]";
		}

	}


	public static void main(String args[]) throws FileNotFoundException {
		Scanner scan = new Scanner(System.in);
		//Scanner scan = new Scanner(new File("./data/data1.in"));
		
		int T = Integer.parseInt(scan.nextLine());
		for (int ks = 1; ks <= T; ks++) {
			Input in = readInput(scan);
			//System.err.println(in);
			String  sol = solve(in);
			//System.err.println(in);
			System.out.println("Case #"+ks+ ": "+sol);
		}
	}


	private static String solve(Input in) {
		
		int dC=0;
		int dJ=0;
		for(Activity ac: in.sortedActivities) {
			if(dC<=ac.start) {
				ac.responsible = "C";
				dC=ac.end;
			} else if(dJ<=ac.start) {
				ac.responsible = "J";
				dJ=ac.end;
			} else {
				return "IMPOSSIBLE";
			}
		}
		String sol = "";
		for(Activity a: in.activities) {
			sol+= a.responsible;
		}
		return sol;
	}


	private static Input readInput(Scanner scan) {
		int n = scan.nextInt();
		ArrayList<Activity> activities = new ArrayList<Activity>();
		for(int id=0;id<n;id++) {
			int start = scan.nextInt();
			int end = scan.nextInt();
			Activity ac = new Activity(start,end,id);
			activities.add(ac);
		}
		return new Input(n,activities);
	}




}