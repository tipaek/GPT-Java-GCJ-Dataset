/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.Scanner;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int x = 0; x < t; x++) {

			int n = sc.nextInt();

			boolean debug = false;
			
			Activity[] activities = new Activity[n];
			
			int[] s = new int[n];
			int[] e = new int[n];
			
			for(int i=0; i < n; i++) {
				activities[i] = new Activity(sc.nextInt(), sc.nextInt(), i);
			}

			if (debug) {
				System.out.println("Initial");

				for (int i = 0; i < n; i++) {
					System.out.println(activities[i].start + " : " + activities[i].end);
				}
			}
			Arrays.sort(activities, (a, b) -> a.start - b.start);

			if (debug) {
				System.out.println("After start time sort");

				for (int i = 0; i < n; i++) {
					System.out.println(activities[i].start + " : " + activities[i].end);
				}
			}
			int[] cam = new int[1441];
			int[] jam = new int[1441];
			
			for(int i=0; i < 1441; i++) {
				cam[i] = 0;
				jam[i] = 0;
			}

			boolean impossible = false;

			for(int i=0; i < n; i++) {
				Activity current = activities[i];
				boolean isCamOccupied = false;
				boolean isJamOccupied = false;
				for(int j = current.start; j < current.end; j++) {
					if (cam[j] == 1) isCamOccupied = true;
					if (jam[j] == 1) isJamOccupied = true;
				}

				if (isCamOccupied && isJamOccupied) {
					impossible = true;
					break;
				}
				if (!isCamOccupied) {
					for(int k=current.start; k < current.end; k++) {
						cam[k] = 1;
					}
					current.assignee = "C";
				} else {
					for(int k=current.start; k < current.end; k++) {
						jam[k] = 1;
					}
					current.assignee = "J";
				}
			}

			Arrays.sort(activities, (a, b) -> a.index - b.index);

			if (debug) {
				System.out.println("Sort by Index");

				for (int i = 0; i < n; i++) {
					System.out.println(activities[i].start + " : " + activities[i].end);
				}
			}

			StringBuilder sb = new StringBuilder();

			String sOut = sb.toString();
			
			if (impossible) {
				sOut = "IMPOSSIBLE";
			} else {
				for(int i=0; i < n; i++) {
					sb.append(activities[i].assignee);
				}
				sOut = sb.toString();
			}
			
			System.out.println("Case #" + (x+1) + ": " + sOut);
		}
	}
	
	public static final class Activity {
		
		public final int start;
		public final int end;
		public final int index;
		public String assignee;

		public Activity(int start, int end, int index) {
			this.start = start;
			this.end = end;
			this.index = index;
			this.assignee = "";
		}
		
	}
	
}
