
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

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
		Stack<Map<String, Integer>> cJob = new Stack<>();
		Stack<Map<String, Integer>> jJob = new Stack<>();
		
		Map<String,Stack<Map<String, Integer>>> patnerMap = new HashMap<String, Stack<Map<String,Integer>>>();
		patnerMap.put("C", cJob);
		patnerMap.put("J", jJob);
		
		String res = "IMPOSSIBLE";
		if(assignJob(timings, 0, totalJob, patnerMap, sb)){
			res = sb.toString();
		}
		
		return res;
	}
	
	static boolean assignJob(int[][] timing, int index, int totalJobs, Map<String,Stack<Map<String, Integer>>> patnerMap, StringBuilder sb){
		if(totalJobs <= index ){
			return true;
		}
		
		
		String[] pateners = {"C","J"};
		for(String p : pateners){
			if(isAvailable(patnerMap, p, timing[index][0], timing[index][1])){
				Map<String, Integer> timeMap = new HashMap<>();
				timeMap.put("startTime", timing[index][0]);
				timeMap.put("endTime", timing[index][1]);
				patnerMap.get(p).push(timeMap);
				sb.append(p);
				if(assignJob(timing, index + 1, totalJobs, patnerMap, sb)){
					return true;
				}else{
					patnerMap.get(p).pop();
					sb.deleteCharAt(sb.length()-1);
				}
			}
		}
		
		return false;
	}
	
	
	static boolean isAvailable(Map<String,Stack<Map<String, Integer>>> patnerMap, String key, int startTime, int endTime){
		
		Stack<Map<String,Integer>> assignedJobs = patnerMap.get(key);
		for(Map<String,Integer> jobTime : assignedJobs){
			int jobStartTime = jobTime.get("startTime");
			int jobEndTime = jobTime.get("endTime");
			if(((startTime > jobStartTime && startTime < jobEndTime)
				|| (endTime > jobStartTime && endTime < jobEndTime))
					|| (startTime <= jobStartTime && jobEndTime <= endTime)){
				return false;	
			}
		}
		return true;
	}
}
