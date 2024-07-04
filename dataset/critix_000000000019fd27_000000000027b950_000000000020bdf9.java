
import java.util.*;
import java.io.*;

class Activity {
	final int start;
	final int end;

	Activity(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			List<Activity> activities = new ArrayList<>(n);

			for (int j = 0; j < n; j++)
				activities.add(new Activity(in.nextInt(), in.nextInt()));

			activities.sort(Comparator.comparingInt((Activity e) -> e.start).thenComparing((Activity e) -> e.end));

			StringBuilder sb = new StringBuilder(activities.size());

			int prevEndJ=-1;
			int prevEndC=-1;
			boolean poss = true;

			for(Activity a : activities){
				if(prevEndC<=a.start){
					sb.append('C');
					prevEndC=a.end;
				}else if(prevEndJ<=a.start){
					sb.append('J');
					prevEndJ=a.end;
				}else{
					poss=false;
					break;
				}
			}


			String answer = (poss) ? sb.toString() : "IMPOSSIBLE";
			System.out.println("Case #" + i + ": " + answer);
		}
	}
}
