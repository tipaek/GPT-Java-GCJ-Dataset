import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
				activities.add( new Activity( i, input.nextInt(), input.nextInt() ) );
			}
			
			System.out.println("Case #" + ( x + 1 ) + ": " + getSchedule( activities ));
		}
		
		input.close();
	}

	private static String getSchedule(List<Activity> activities) {
		Collections.sort( activities );

		Activity cActivity = activities.get( 0 );
		cActivity.parent = "C";
		Activity jActivity = activities.get( 1 );
		jActivity.parent = "J";
		
		for( int i = 2; i < activities.size(); i++ ) {
			Activity nextActivity = activities.get( i );

			if( parentCanDoIt( cActivity, nextActivity ) ) {
				cActivity = nextActivity;
				nextActivity.parent = "C";
			} else if( parentCanDoIt( jActivity, nextActivity ) ) {
				jActivity = nextActivity;
				nextActivity.parent = "J";
			} else {
				return "IMPOSSIBLE";
			}
		}
		
		Collections.sort( activities, new Comparator<Activity>() {
			@Override
			public int compare(Activity a1, Activity a2) {
				return a1.i.compareTo( a2.i );
			}
		} );
		
		StringBuilder schedule = new StringBuilder();
		
		for( Activity a : activities ) {
			schedule.append( a.parent );
		}

		return schedule.toString();
	}

	private static boolean parentCanDoIt(Activity lastActivity, Activity nextActivity) {
		return nextActivity.start >= lastActivity.end;
	}

}

class Activity implements Comparable<Activity> {
	public Integer i;

	public Integer start;
	public Integer end;

	public String parent;

	public Activity(int i, int s, int e) {
		this.i = i;
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
