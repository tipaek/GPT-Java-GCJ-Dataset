import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t = 1; t<=T; t++){
			System.out.print("Case #" + t + ": ");
			int n = in.nextInt();
			Activity[] activites = new Activity[n+1];
			activites[0] = new Activity(-1, 0, 0);
			for(int i = 0; i < n; i++){
				activites[i+1] = new Activity(i, in.nextInt(), in.nextInt());
			}
			
			Arrays.sort(activites);
			
			String str = next("", activites, 1, 0, 0);
			if(str == null)
				System.out.println("IMPOSSIBLE");
			else{
				StringBuilder solution = new StringBuilder(str);
				for(int a = 1; a < activites.length; a++){
					solution.setCharAt(activites[a].id, str.charAt(a-1));
				}
				System.out.println(solution);
			}
		}
		in.close();
	}	
	
	static String next(String state, Activity[] activities, int current, int lastC, int lastJ){
		if(current == activities.length)
			return state;
		
		if(activities[lastC].to <= activities[current].from)
			return next(state + "C", activities, current+1, current, lastJ);
		
		if(activities[lastJ].to <= activities[current].from)
			return next(state + "J", activities, current+1, lastC, current);
		
		return null;
	}
	
	static class Activity implements Comparable<Activity>{
		int id;
		int from, to;
		public Activity(int id, int from, int to){
			this.id = id;
			this.from = from;
			this.to = to;
		}
		@Override
		public int compareTo(Activity other) {
			if(from < other.from){
				return -1;
			}else if(from > other.from){
				return 1;
			}
			return 0;
		}
	}

}
