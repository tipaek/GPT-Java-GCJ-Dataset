import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();
		for( int x = 0; x < T; x++ ) {
			int n = input.nextInt();
			
			List<Activity> activities = new ArrayList<>( n );
			for( int i = 0; i < n; i++ ) {
				activities.add( new Activity( input.nextInt(), input.nextInt() ) );
			}
			
			System.out.println("Case #" + ( x + 1 ) + ": " + getSchedule( activities ));
		}
		
		input.close();
	}

	private static String getSchedule(List<Activity> activities) {
		Collections.sort( activities );

		StringBuilder schedule = new StringBuilder("CJ");

		Activity cActivity = activities.get( 0 );
		Activity jActivity = activities.get( 1 );
		
		for( int i = 2; i < activities.size(); i++ ) {
			Activity nextActivity = activities.get( i );

			if( parentCanDoIt( cActivity, nextActivity ) ) {
				cActivity = nextActivity;
				schedule.append("C");
			} else if( parentCanDoIt( jActivity, nextActivity ) ) {
				jActivity = nextActivity;
				schedule.append("J");
			} else {
				return "IMPOSSIBLE";
			}
		}

		return schedule.toString();
	}

	private static boolean parentCanDoIt(Activity lastActivity, Activity nextActivity) {
		return nextActivity.start >= lastActivity.end;
	}

}

class Activity implements Comparable<Activity> {
	public Integer start;
	public Integer end;

	public Activity(int s, int e) {
		this.start = s;
		this.end = e;
	}

	@Override
	public int compareTo(Activity a) {
		return this.start.compareTo( a.start );
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(start).append(" ").append(end);
		return builder.toString();
	}

}
