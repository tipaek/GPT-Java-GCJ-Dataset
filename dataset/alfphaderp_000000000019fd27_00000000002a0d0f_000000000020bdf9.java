
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static class Activity {
		public int startTime, endTime;
		public String assignment;
		
		public String toString() {
			return "[" + startTime + ", " + endTime + ", " + assignment + "]";
		}
	}
	
	static Scanner in;
	static int T;
	
	static int N;
	static List<Activity> activities;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		T = in.nextInt();
		
		for(int c = 1; c <= T; c++) {
			readInput();
						
			System.out.print("Case #" + c + ": ");
			if(assignAll()) {
				for(Activity a : activities)
					System.out.print(a.assignment);
			} else {
				System.out.print("IMPOSSIBLE");
			}
			
			System.out.println();
		}
		
		in.close();
	}
	
	public static void readInput() {
		N = in.nextInt();
		activities = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			Activity a = new Activity();
			a.startTime = in.nextInt();
			a.endTime = in.nextInt();
			activities.add(a);
		}
	}
	
	public static boolean assignAll() {
		List<Activity> startList = new ArrayList<>(activities);
		List<Activity> endList = new ArrayList<>(activities);
		
		startList.sort((a1, a2) -> a1.startTime - a2.startTime);
		endList.sort((a1, a2) -> a1.endTime - a2.endTime);
		
		int startPtr = 0, endPtr = 0;
		boolean j = true, c = true;
		while(startPtr < startList.size() || endPtr < endList.size()) {
			
			Activity start, end;
			if(startPtr == startList.size()) {
				Activity a = new Activity();
				a.startTime = Integer.MAX_VALUE;
				a.endTime = Integer.MAX_VALUE;
				start = a;
			} else {
				start = startList.get(startPtr);
			}
			
			
			if(endPtr == endList.size()) {
				Activity a = new Activity();
				a.startTime = Integer.MAX_VALUE;
				a.endTime = Integer.MAX_VALUE;
				end = a;
			} else {
				end = endList.get(endPtr);
			}
			
//			System.out.println(startPtr + "\t" + endPtr + "\t" + j + "\t" + c);
			
			if(start.startTime < end.endTime) {
				if(j) {
					start.assignment = "J";
					j = false;
				} else if(c) {
					start.assignment = "C";
					c = false;
				} else {
					return false;
				}
				
				startPtr++;
			} else {
				if(end.assignment.equals("J"))
					j = true;
				else if(end.assignment.equals("C"))
					c = true;
				else
					throw new IllegalStateException();
				
				endPtr++;
			}
		}
		return true;
	}
}
