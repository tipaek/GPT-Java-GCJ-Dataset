import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		in.nextLine();
		for (int i = 1; i <= t; ++i) {

			// read input
			int n = in.nextInt();
			in.nextLine();
			
			List<Activity> activities = new LinkedList<>();
			for(int j = 0; j < n; j++) {
				int start = in.nextInt();
				int end = in.nextInt();
				in.nextLine();
				
				activities.add(new Activity(start, end));
			}
			
			String answer = schedule(activities);
			

			System.out.println("Case #" + i + ": " + answer);
		}
	}
	
	public static String schedule(List<Activity> activities) {
		
		Map<Activity, Set<Activity>> collisionMap = new HashMap<>();
		List<Activity> colliders = new LinkedList<>();
		
		for(Activity a : activities) {
			for(Activity b : activities) {
				if( (a != b) && a.collides(b) ) {
					colliders.add(a);
					Set<Activity> collided = collisionMap.get(a);
					if(collided == null) {
						collided = new HashSet<>();
						collisionMap.put(a, collided);
					}
					collided.add(b);
					if(Activity.anyCollide(collided)) {
						return "IMPOSSIBLE";
					}
				}
			}
		}
		
		int entriesCount = colliders.size();
		int i = 0;
		
		while( Activity.anyCollide(colliders) ) {
			Activity activity = colliders.get(i);
			fixCollided(activity, collisionMap.get(activity));
			i = (i + 1) % entriesCount;
		}
		
		StringBuilder answer = new StringBuilder();
		for(Activity a : activities) {
			answer.append(a.assigned);
		}
		return answer.toString();
	}
	
	private static boolean fixCollided(Activity key, Set<Activity> collided) {
		
		char keyAssigned = key.assigned;
		boolean changedAny = false;
		
		Set<Character> collidedAssign = new HashSet<>();
		for(Activity a : collided) {
			if(a.assigned == keyAssigned) {
				a.assigned = keyAssigned == 'J' ? 'C' : 'J';
				changedAny = true;
			}
		}
		
		return changedAny;
	}
	
	
	
	static class Activity{
		int start;
		int end;
		
		char assigned;
		
		public Activity(int start, int end) {
			this.start = start;
			this.end = end;
			this.assigned = 'C';
		}
		
		public boolean collides(Activity other) {
			return 
					(this.assigned == other.assigned) // assigned to same person
					&& // overlaps in time
					(
						(
							this.start >= other.start && this.start < other.end
						) 
						||
						(
							this.end > other.start && this.end < other.end
						)
					);
		}
		
		public char swap() {
			this.assigned = this.assigned == 'C' ? 'J' : 'C';
			return this.assigned;
		}
		
		public static boolean anyCollide(Collection<Activity> activities) {
			for(Activity a : activities) {
				for(Activity b : activities) {
					if( (a != b) && a.collides(b) ) {
						return true;
					}
				}
			}
			
			return false;
		}
	}

}