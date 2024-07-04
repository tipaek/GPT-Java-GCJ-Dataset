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
				act[i] = new Activity(startTime, endTime);
			}
			
			Arrays.parallelSort(act, (Activity a, Activity b)-> a.startTime-b.startTime);
			String res ="";
			
			int cst = -1, cet=-1, jst=-1, jet=-1;
			for ( Activity a: act) {
				if ( cet <= a.startTime ) {
					cst = a.startTime;
					cet = a.endTime;
					res += "C";
				}
				else if (jet <= a.startTime) {
					jst = a.startTime;
					jet = a.endTime;
					res += "J";
				}
				else {
					res = "IMPOSSIBLE";
					break;
				}
			}
			
			System.out.println("Case #"+test+": "+ res);
		}
	}
	
	static class Activity{
		int startTime;
		int endTime;
		
		public Activity(int startTime, int endTime ) {
			this.startTime = startTime;
			this.endTime = endTime;
		}
	}

}
