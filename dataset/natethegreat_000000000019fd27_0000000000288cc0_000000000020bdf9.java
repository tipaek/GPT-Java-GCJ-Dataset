import java.util.*;
import java.io.*;


public class Solution {
	public class Activity{
		public int index;
		public int startTime;
		public int endTime;
		public char partner;
		public Activity(int i, int s, int e) {
			index = i;
			startTime = s;
			endTime = e;
		}
	}
	public ArrayList<Activity> activities;
	public char part1 = 'C';
	public char part2 = 'J';
	public int p1free;
	public int p2free;
	public boolean possible = true;
	
	public void restart() {
		activities = new ArrayList<>();
		p1free = 0;
		p2free = 0;
		possible = true;
	}
	
	public void addActivity(int i, int s, int e) {
		for(Activity a: activities) {
			if(s <= a.startTime) {
				activities.add(activities.indexOf(a), new Activity(i, s, e));
				return;
			}
		}
		activities.add(new Activity(i, s, e));
	}
	
	public void solve() {
		for(Activity a: activities) {
			if(p1free <= a.startTime) {
				p1free = a.endTime;
				activities.get(activities.indexOf(a)).partner = part1;
			}else if(p2free <= a.startTime) {
				p2free = a.endTime;
				activities.get(activities.indexOf(a)).partner = part2;
			}else {
				possible = false;
				return;
			}
		}
	}
	
	public void printSol(int i) {
		if(possible) {
			char[] sol = new char[activities.size()];
			for(Activity a: activities) {
				sol[a.index] = a.partner;
			}
			String s = String.valueOf(sol);
			System.out.println("Case #" + i + " " + s);
		}else {
			System.out.println("Case #" + i + " IMPOSSIBLE");
		}
		
		
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int total = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        Solution s = new Solution();
        for(int i = 0; i < total; ++i) {
        	int a = in.nextInt();
        	s.restart();
        	for(int j = 0; j < a; j++) {
        		int start = in.nextInt();
        		int end = in.nextInt();
        		s.addActivity(j, start, end);
        	}
        	s.solve();
        	s.printSol(i+1);
        }
        in.close();
	}

}
