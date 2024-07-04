import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs,
								// strings, chars, etc.

		for (int tc = 1; tc <= t; ++tc) {
			in.nextLine();
			int activitiesCount = in.nextInt();
			
			ArrayList<Activity> activities = new ArrayList<Activity>();
			ArrayList<Intersection> intersections = new ArrayList<Intersection>();
			
			String result = null;
			
			TEST_CASE : for (int a = 0; a < activitiesCount; a++) {
				in.nextLine();
				Activity activity = new Activity();
				activity.start = in.nextInt();
				activity.end = in.nextInt();
				for (int j = 0; j < activities.size(); j++) {
					Intersection i = activities.get(j).overlaps(activity, j, activities.size());
					if (i != null) {
						for (int k = 0; k < intersections.size(); k++) {
							if (intersections.get(k).overlaps(i)) {
								// impossible distribution found, 2 periods intersections overlaps --> needs 3 persons.
								result = "IMPOSSIBLE";
								break TEST_CASE;
							}
						}
						intersections.add(i);
						activities.get(j).addIntersection(i);
						activity.addIntersection(i);
					}
				}
				activities.add(activity);
			}

			if (result == null) { // Not impossible
				result = "";
				// generate result
				for (int a = 0; a < activities.size(); a++) {
					Activity activity = activities.get(a);
					char assignee = 'N';
					if (activity.hasIntersections()) {
						for (int i = 0; i < activity.intersections.size(); i++) {
							if (activity.intersections.get(i).a2Index == a) {
								// we are second activity, first activity already assigned.
								char otherAssignee = activities.get(activity.intersections.get(i).a1Index).assignedTo;
								if (otherAssignee == 'C') {
									assignee = 'J';
								} else {
									assignee = 'C';
								}
							}
						}
					}
					if (assignee == 'N') {
						assignee = 'C';
					}
					activity.assignedTo = assignee;
					result += assignee;
				}
				
			}

			
			System.out.println("Case #" + tc + ": " + result);
		}
	}
	
	static class Activity {
		int start;
		int end;
		char assignedTo = 'N'; // none
		ArrayList<Intersection> intersections = new ArrayList<Intersection>();
		
		Intersection overlaps(Activity o, int a1Index, int a2Index) {
			boolean intersects = false;
			if (o.start > start && o.start < end) {
				intersects = true;
			}
			if (o.end > start && o.end < end) {
				intersects = true;
			}
			if (o.start < start && o.end > end) {
				intersects = true;
			}
			Intersection i = null;
			if (intersects) {
				i = new Intersection();
				i.start = Math.max(start, o.start);
				i.end = Math.min(end, o.end);
				i.a1Index = a1Index;
				i.a2Index = a2Index;
			}
			return i;
		}

		void addIntersection(Intersection i) {
			intersections.add(i);
		}
		
		boolean hasIntersections() {
			return !intersections.isEmpty();
		}
	}
	
	static class Intersection {
		int start;
		int end;
		int a1Index;
		int a2Index;
		boolean overlaps(Intersection o) {
			if (o.start > start && o.start < end) {
				return true;
			}
			if (o.end > start && o.end < end) {
				return true;
			}
			if (o.start < start && o.end > end) {
				return true;
			}

			return false;			
		}
	}
}
