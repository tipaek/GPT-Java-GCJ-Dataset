import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {

		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader bufferReader = new BufferedReader(reader);

		try {
			int activityCount = 0;
			Integer testCases = Integer.parseInt(bufferReader.readLine());
			for (int i = 1; i <= testCases; i++) {
				List<Activity> activities = new ArrayList<Activity>();
				activityCount = Integer.parseInt(bufferReader.readLine());
				for (int j = 1; j <= activityCount; j++) {
					String[] temp = bufferReader.readLine().split(" ");
					Activity activity = new Activity();
					activity.setIndex(j);
					activity.setStartTime(Integer.parseInt(temp[0]));
					activity.setEndTime(Integer.parseInt(temp[1]));
					activities.add(activity);
				}
				
				System.out.println(calculate(activities, i));

			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String calculate(List<Activity> activities,int testCAse) {
		Collections.sort(activities);
		Map<Character, Integer> pool = new HashMap<Character, Integer>();
		pool.put('C', 0);
		activities.get(0).setParent('C');
		pool.put('J', null);
		if (activities.get(1).getStartTime() < activities.get(0)
				.getEndTime()) {
			pool.put('J', 1);
			activities.get(1).setParent('J');
		} else {
			pool.put('C', 1);
			activities.get(1).setParent('C');
		}
		for (int i = 2; i < activities.size(); i++) {
			int j = i - 1;
			while (j >= 0) {
				// overlapping
				if (activities.get(i).getStartTime() > activities
						.get(j).getEndTime()) {
					releaseParent(pool, activities.get(j).getParent());
				}
				j--;
			}
			if (assignParent(pool, activities.get(i), i) == -1) {
				return "Case #"+testCAse+": IMPOSSIBLE";
			}
		}
		
		Collections.sort(activities, new Comparator<Activity>() {

			@Override
			public int compare(Activity o1, Activity o2) {
				// TODO Auto-generated method stub
				if(o1.getIndex()<o2.getIndex()){
					return -1;
				}
				else if(o1.getIndex()>o2.getIndex()){
					return 1;
				}
				else{
					return 0;
				}
			}
			
		});
		StringBuilder result=new StringBuilder("Case #"+testCAse+": ");
		for (Activity ac: activities){
			result.append(ac.getParent());
		}
		return result.toString();
	}

	public static int assignParent(Map<Character, Integer> pool, Activity act1,
			int index) {
		if (pool.get('C') == null) {
			pool.put('C', index);
			act1.setParent('C');
			return 1;

		} else if (pool.get('J') == null) {
			pool.put('J', index);
			act1.setParent('J');
			return 1;
		} else {
			return -1;
		}
	}

	public static void releaseParent(Map<Character, Integer> pool,
			Character parent) {
		pool.put(parent, null);
	}

}

class Activity implements Comparable<Activity> {
	private int index;
	private char parent;

	public char getParent() {
		return parent;
	}

	public void setParent(char parent) {
		this.parent = parent;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	private int startTime;
	private int endTime;

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	@Override
	public String toString() {
		return "Activity [index=" + index + ", parent=" + parent
				+ ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	@Override
	public int compareTo(Activity o) {
		// TODO Auto-generated method stub
		if (this.endTime < o.endTime)
			return -1;
		else if (this.endTime > o.endTime)
			return 1;
		else
			return 0;
	}

}
