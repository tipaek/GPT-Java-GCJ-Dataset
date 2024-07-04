import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int testCases = Integer.parseInt(br.readLine());
			
			for(int i=0;i<testCases;i++) {
				
				int numActivities = Integer.parseInt(br.readLine());
				
				Activity[] startTimes = new Activity[numActivities];
				
				for(int j=0;j<numActivities;j++) {
					String[] timeStrings = br.readLine().split(" ");
					int start = Integer.parseInt(timeStrings[0]);
					int end = Integer.parseInt(timeStrings[1]);
					Activity activity = new Activity(start, end);
					
					startTimes[j] = activity;
				}
				
				Arrays.sort(startTimes);
				
				int CEnd = -1;
				int JEnd = -1;
				
				String ans = "";
				
				for(int j=0;j<numActivities;j++) {
					
					int currentStart = startTimes[j].startTime;
					int currentEnd = startTimes[j].endTime;
					
					if(CEnd <= currentStart) {
						CEnd = currentEnd;
						ans += "C";
					}
					else if(JEnd <= currentStart) {
						JEnd = currentEnd;
						ans += "J";
					}
					else {
						ans = "IMPOSSIBLE";
						break;
					}
				}
				
				String outputString = "Case #" + (i+1) + ": " + ans;
				System.out.println(outputString);
			}
		} 
		
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

class Activity implements Comparable<Activity>{
	
	int startTime;
	int endTime;
	
	public Activity(int startTime, int endTime) {
		this.endTime = endTime;
		this.startTime = startTime;
	}
	
	@Override
	public int compareTo(Activity a) {
		// TODO Auto-generated method stub
		if(this.startTime < a.startTime) {
			return -1;
		}
		else if(this.startTime > a.startTime) {
			return +1;
		}
		else {
			return 0;
		}
	}

}

	