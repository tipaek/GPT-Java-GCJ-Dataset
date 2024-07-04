import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int count = 1;

		while (t-- > 0) {
			int numActivities = sc.nextInt();
			boolean impossible = false;
			char[] schedule = new char[numActivities];
			boolean[] cameron = new boolean[1500];
			boolean[] jamie = new boolean[1500];

			int[] begins = new int[numActivities];
			int[] ends = new int[numActivities];
			
			boolean[] scheduled = new boolean[numActivities];
			
			for (int i = 0; i < numActivities; i++) {
				begins[i] = sc.nextInt();
				ends[i] = sc.nextInt();
			}
			
			
			while(findFirstStart(scheduled, begins) != -1 && !impossible){
				int nextTask = findFirstStart(scheduled, begins);
				int begin = begins[nextTask];
				int end = ends[nextTask];
				
//				System.out.println("Begin: " + begin + " End: " + end);
				
				if(checkAvailable(cameron, begin, end)) {
					for (int j = begin; j < end; j++) {
						cameron[j] = true;
					}
					scheduled[nextTask] = true;
					schedule[nextTask] = 'C';
				} else if(checkAvailable(jamie, begin, end)) {
					for (int j = begin; j < end; j++) {
						jamie[j] = true;
					}
					scheduled[nextTask] = true;
					schedule[nextTask] = 'J';
				} else {
					impossible = true;
				}
			}
			
			if(impossible) {
				System.out.println("Case #" + count + ": IMPOSSIBLE");
			} else {
				System.out.println("Case #" + count + ": " + new String(schedule));
			}
			
			count++;
		}
	}
	
	public static boolean checkAvailable(boolean[] person, int begin, int end) {
		for(int i = begin; i <= end; i++) {
			if(person[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static int findFirstStart(boolean[] scheduled, int[] begins){
		int loc = -1;
		int begin = 9999;
		
		for (int i = 0; i < scheduled.length; i++) {
			if(!scheduled[i] && begins[i]<begin) {
				begin = begins[i];
				loc = i;
			}
			
		}
		return loc;
	}
}
