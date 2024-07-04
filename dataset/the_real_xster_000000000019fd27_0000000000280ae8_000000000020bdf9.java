import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;


class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int testCases = Integer.parseInt(br.readLine());
			
			for(int i=0;i<testCases;i++) {
				
				int numActivities = Integer.parseInt(br.readLine());
				
				HashMap<Integer, Integer> startEndTimes = new HashMap<>();
				int[] startTimes = new int[numActivities];
				
				for(int j=0;j<numActivities;j++) {
					String[] timeStrings = br.readLine().split(" ");
					int start = Integer.parseInt(timeStrings[0]);
					int end = Integer.parseInt(timeStrings[1]);
					
					startEndTimes.put(start, end);
					startTimes[j] = start;
				}
				
				Arrays.sort(startTimes);
				
				int CEnd = 0;
				int JEnd = 0;
				
				String ans = "";
				
				for(int j=0;j<numActivities;j++) {
					
					int current = startTimes[j];
					if(CEnd <= current) {
						CEnd = startEndTimes.get(current);
						ans += "C";
					}
					else if(JEnd <= current) {
						JEnd = startEndTimes.get(current);
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
