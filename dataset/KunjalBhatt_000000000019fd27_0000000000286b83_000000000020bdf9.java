
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	
	public static void main(String args[]){
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	     int t = in.nextInt(); 
	     for (int i = 1; i <= t; ++i) {
	          int totalJob = in.nextInt();
	          int timings[][] = new int[totalJob][2];
	          for(int j=0; j < totalJob; j++){
	        	  timings[j][0] = in.nextInt();
	        	  timings[j][1] = in.nextInt();
	          }
	          System.out.println("Case #" + i + ": " + getAssignedJob(timings,totalJob));
	       }
	     in.close();
	}
	static String getAssignedJob(int[][] timings,int totalJob){
		
		StringBuilder sb = new StringBuilder();
		
		Map<String,Integer[]> patnerMap = new HashMap<String, Integer[]>();
		Integer[] c = new Integer[1441];
		Integer[] j = new Integer[1441];
		Integer[] k = new Integer[1441];
		Arrays.fill(c, 0);
		Arrays.fill(j, 0);
		patnerMap.put("C", c);
		patnerMap.put("J", j);
		Arrays.fill(k, 0);
		patnerMap.put("K", k);
		
		int overLapCount = 0;
		for(int index=0; index < totalJob; index++){
			if(!isAvailable(patnerMap, "K", timings[index][0], timings[index][1])){
				overLapCount++;
			}
			if(overLapCount > 2){
				return "IMPOSSIBLE";
			}
			Integer[] assignedJobs = patnerMap.get("K");
			for(int i=timings[index][0]; i < timings[index][1]; i++){
				assignedJobs[i] = 1;
			}
		}
		
		String res = "IMPOSSIBLE";
		if(assignJob(timings, 0, totalJob, patnerMap, sb)){
			res = sb.toString();
		}
		
		return res;
	}
	
	static boolean assignJob(int[][] timing, int index, int totalJobs, Map<String,Integer[]> patnerMap, StringBuilder sb){
		if(totalJobs <= index ){
			return true;
		}
		
		String[] pateners = {"C","J"};
		for(String p : pateners){
			if(isAvailable(patnerMap, p, timing[index][0], timing[index][1])){
				Integer[] assignedJobs = patnerMap.get(p);
				for(int i=timing[index][0]; i < timing[index][1]; i++){
					assignedJobs[i] = 1;
				}
				
				sb.append(p);
				if(assignJob(timing, index + 1, totalJobs, patnerMap, sb)){
					return true;
				}else{
					for(int i=timing[index][0]; i < timing[index][1]; i++){
						assignedJobs[i] = 0;
					}
					sb.deleteCharAt(sb.length()-1);
				}
			}
		}
		
		return false;
	}
	
	
	static boolean isAvailable(Map<String,Integer[]> patnerMap, String key, int startTime, int endTime){
		
		Integer[] assignedJobs = patnerMap.get(key);
		
		for(int i=startTime; i < endTime; i++){
			if(assignedJobs[i] > 0){
				return false;
			}
		}
		return true;
	}
}
