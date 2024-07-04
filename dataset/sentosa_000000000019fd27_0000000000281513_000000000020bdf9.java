import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		
		for ( int test = 1; test <= t ; test++ ) {
			int n = in.nextInt();
			Activity[] act= new Activity[n];
			
			for ( int i=0; i<n; i++) {
				int startTime = in.nextInt();
				int endTime = in.nextInt();
				act[i] = new Activity(startTime, endTime, i);
			}
			
			Arrays.parallelSort(act, (Activity a, Activity b)-> a.startTime-b.startTime);
			StringBuffer res = new StringBuffer("");
			
			int cst = -1, cet=-1, jst=-1, jet=-1;
			for ( Activity a: act) {
				if ( cet <= a.startTime ) {
					cst = a.startTime;
					cet = a.endTime;
					a.parent='C';
				}
				else if (jet <= a.startTime) {
					jst = a.startTime;
					jet = a.endTime;
					a.parent='J';
				}
				else {
					res.append("IMPOSSIBLE");
					break;
				}
			}
			
			if ( res.toString().equals("IMPOSSIBLE")) {
				
				System.out.println("Case #"+test+": "+ res.toString());
			}
			else {
			Arrays.parallelSort(act, (a,b)-> a.index-b.index);
			for ( Activity a: act) {
				res.append(a.parent);
			}
			System.out.println("Case #"+test+": "+ res.toString());
			}
		}
	}
	
	static class Activity{
		int startTime;
		int endTime;
		int index;
		char parent = 'P';
		
		public Activity(int startTime, int endTime, int index) {
			this.startTime = startTime;
			this.endTime = endTime;
			this.index = index;
		}
	}

}
