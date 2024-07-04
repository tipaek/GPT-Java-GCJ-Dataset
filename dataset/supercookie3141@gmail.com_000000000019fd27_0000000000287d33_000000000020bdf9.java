import java.util.Scanner;
import java.util.ArrayList;

class Schedule {
	int startTime;
	int endTime;
	String person;
	
	Schedule(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public String toString() {
		return "" + startTime + " " + endTime;
	}
}

public class Solution {
	public static boolean checkAvailability(int[] arr, int start, int end) {
		for(int i = start; i <= end; i += 1) {
			if(i == start) {
				if(arr[i] != 0 && arr[i + 1] != 0) {
					return false;
				}
			}
			else if(arr[i] != 0) {
				return false;
			}
		}
		return true;
	}
	
	public static int[] addActivity(int[] arr, int start, int end) {
		for(int i = start; i <= end; i += 1) {
			arr[i] = 1;
		}
		return arr;
	}
	
	public static ArrayList<Schedule> sort(ArrayList<Schedule> arr) {
		for(int i = 0; i < arr.size(); i += 1) {
			int index = i;
			for(int j = i; j < arr.size(); j += 1) {
				if(arr.get(index).startTime > arr.get(j).startTime) {
					index = j;
				}
			}
			Schedule temp = arr.get(index);
			arr.set(index, arr.get(i));
			arr.set(i, temp);
		}
		return arr;
	}
	
	public static void main(String[]args) {
		Scanner kboard = new Scanner(System.in);
		int t = kboard.nextInt();
		for(int i = 1; i <= t; i += 1) {
			int n = kboard.nextInt();
			int[] cameron = new int[1441];
			int[] jamie = new int[1441];
			for(int j = 0; j <= 1440; j += 1) {
				cameron[j] = 0;
				jamie[j] = 0;
			}
			ArrayList<Schedule> activities = new ArrayList<Schedule>();
			ArrayList<Schedule> sortedActivities = new ArrayList<Schedule>();
			
			String answer = "";
			for(int j = 0; j < n; j += 1) {
				answer += "a";
			}
			boolean impossible = false;
			for(int j = 0; j < n; j += 1) {
				Schedule temp = new Schedule(kboard.nextInt(), kboard.nextInt());
				activities.add(temp);
				sortedActivities.add(temp);
			}
			sortedActivities = sort(sortedActivities);
			for(int j = 0; j < activities.size(); j += 1) {
				if(!impossible) {
					int start = sortedActivities.get(j).startTime;
					int end = sortedActivities.get(j).endTime;
					boolean checkCameron = checkAvailability(cameron, start, end);
					boolean checkJamie = false;
					if(!checkCameron) {
						checkJamie = checkAvailability(jamie, start, end);
					}
					
					if(!checkCameron && !checkJamie) {
						impossible = true;
					}
					else if(checkCameron) {
						cameron = addActivity(cameron, start, end);
						int index = activities.indexOf(sortedActivities.get(j));
						if(index == activities.size() - 1) {
							answer = answer.substring(0, index) + "C";
						}
						else {
							answer = answer.substring(0, index) + "C" + answer.substring(index + 1);
						}
					}
					else {
						jamie = addActivity(jamie, start, end);
						int index = activities.indexOf(sortedActivities.get(j));
						if(index == activities.size() - 1) {
							answer = answer.substring(0, index) + "J";
						}
						else {
							answer = answer.substring(0, index) + "J" + answer.substring(index + 1);
						}
					}
				}
			}
			if(impossible) {
				answer = "IMPOSSIBLE";
			}
			System.out.println("Case #" + i + ": " + answer);
		}
	}
}