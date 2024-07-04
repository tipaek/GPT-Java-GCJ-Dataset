import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Activity {
	int id;
	int start;
	int end;
	char assignedTo;
	
	Activity(int id, int start, int end, char assignedTo) {
		this.id = id;
		this.start = start;
		this.end = end;
		this.assignedTo = assignedTo;
	}
	
	boolean OverlapsWith(Activity activity) {
		if((activity.start >= this.start && activity.start < this.end)
			|| (activity.end > this.start && activity.end <= this.end))
		{
			return true;
		}
		return false;
	}
}

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
	
			
		for (int x = 0; x < T; x++) {
			String y = "";
			int N = sc.nextInt();
			ArrayList<Activity> activities = new ArrayList<Activity>();
			boolean breaked = false;
			/*
			int[] time = new int[24*60 + 1];
			int[] setime = new int[24*60 + 1]; //start end time
			*/
			
			for (int i = 0 ; i < N; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				Activity activity = new Activity(i, start, end, 'C');
				activities.add(activity);
				/*
				for (int j = start; j <= end; j++) {
					time[j] += 1;
				}
				setime[start] += 1;
				setime[end] += 1;
				*/
			}
			/*
			for (int j = 0; j < N; j++) {
				if(time[j] > 2 && time[j] - setime[j] >= 2) {
					y = "IMPOSSIBLE";
					breaked  = true;
					break;
				}
			}
			*/
			/*
			1 2 2 2 3 2 2 3 3 3 2 1 2 1 1 --time
			1 1 0 0 2 0 0 1 0 1 1 0 2 0 1 --setime
			
			1 1 1 1 1 1 1 1 1 1 1 1 1
			  1 1 1 1 
			        1 1 1 1 1 1
			              1 1 1 1
                                    1 1 1
            */
			
			
			//if (!breaked) {
				activities.sort(new Comparator<Activity>() {
					@Override
					public int compare(Activity a1, Activity a2) {
						if(a1.start < a2.start || a1.start > a2.start) {
							return a1.start - a2.start;
						}
						
						return a1.end - a2.end;
					}
				});
				
				Activity prevActivity = null;
				char[] result = new char[N];
				int cEndTime = 0;
				int jEndTime = 0;
			
				for(Activity activity: activities) {
					if (null == prevActivity) {
						activity.assignedTo = 'C';
						cEndTime = activity.end;
					} else if (prevActivity.OverlapsWith(activity)) {
						if('C' == prevActivity.assignedTo) {
							if (activity.start < jEndTime) {
								y = "IMPOSSIBLE";
								breaked = true;
								break;
							}						
							
							activity.assignedTo = 'J';
							jEndTime = activity.end;
						} else {
							if (activity.start < cEndTime) {
								y = "IMPOSSIBLE";
								breaked = true;
								break;
							}
							
							activity.assignedTo = 'C';
							cEndTime = activity.end;
						}
					} else {
						activity.assignedTo = prevActivity.assignedTo;
						if ('C' == activity.assignedTo) cEndTime = activity.end;
						else jEndTime = activity.end;
					}
					
					result[activity.id] = activity.assignedTo;
					prevActivity = activity;
				}
			
				if (!breaked) y = new String(result);
			//}
									
			System.out.format("Case #%d: %s\n", (x + 1), y);			
		}
		
		sc.close();
	}
}
