import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
		Set<Activity> set1=new HashSet<Activity>();
		Set<Activity> set2=new HashSet<Activity>();
		set1.add(activities.get(0));
		for (int i = 1; i < activities.size(); i++) {
			int j = i - 1;
			while (j >= 0) {
				//non overlapping
				if (activities.get(i).getStartTime() >= activities
						.get(j).getEndTime()) {
					if(set1.contains(activities
						.get(j))){
						set1.add(activities
						.get(i));
					}
					else{
						set2.add(activities
								.get(i));
					}
					break;
				}
				else{
					if(set1.contains(activities
							.get(j))){
							set2.add(activities
							.get(i));
						}
						else{
							set1.add(activities
									.get(i));
						}
				}
				j--;
			}
		}
		List<Activity> list1=new ArrayList<Activity>(set1);
		Collections.sort(list1, new Comparator<Activity>() {

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
		List<Activity> list2=new ArrayList<Activity>(set2);
		Collections.sort(list2, new Comparator<Activity>() {

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
		StringBuilder result=null;
		
		if(set1.size()+set2.size()>activities.size()){
			result= new StringBuilder("Case #"+testCAse+": IMPOSSIBLE");
		}
		else{
			result=new StringBuilder("Case #"+testCAse+": ");
			int i=0,j=0;
			for(int k=0;(k<activities.size() && i<list1.size() && j<list2.size());k++){
				if(list1.get(i).getIndex()<list2.get(j).getIndex()){
					result.append("C");
					i++;
				}
				else{
					result.append("J");
					j++;
				}
			}
			if(i<list1.size()){
				for(int k=i;k<list1.size();k++){
					
					result.append("C");
				}
			}
			else if(j<list2.size()){
				for(int k=j;k<list2.size();k++){
					
					result.append("J");
				}	
			}
		}
		return result.toString();
	}

}

class Activity implements Comparable<Activity> {
	private int index;
	private char parent;
	private boolean released;
	public boolean isReleased() {
		return released;
	}

	public void setReleased(boolean released) {
		this.released = released;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + endTime;
		result = prime * result + startTime;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Activity other = (Activity) obj;
		if (endTime != other.endTime)
			return false;
		if (startTime != other.startTime)
			return false;
		return true;
	}

}
