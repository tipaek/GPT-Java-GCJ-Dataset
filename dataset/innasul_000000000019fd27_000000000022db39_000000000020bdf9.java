import java.util.*;
import java.io.*;

public class Solution {
	
	public static void main(String[] args) {
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));) {
			int numberOfTests = in.nextInt();
			List<String> schedules=new ArrayList<>();
			for (int t = 0; t < numberOfTests; t++) {
			int numberofSchedules = in.nextInt();
			List<List<Integer>> scheduleList=new ArrayList<>();
			Map<String,List<Integer>> activity=new LinkedHashMap<>();
			activity.put("B1", new ArrayList<Integer>());
			activity.put("B2", new ArrayList<Integer>());
			for(int i=0;i<numberofSchedules;i++){
				List<Integer> schedule=new ArrayList<>();
				schedule.add(in.nextInt());
				schedule.add(in.nextInt());
				scheduleList.add(schedule);				
			}
			if(isNonConflictTimeSlot(scheduleList.get(0),scheduleList.get(1))){
				activity.get("B1").add(0);
				activity.get("B1").add(1);
			}else{
				activity.get("B1").add(0);
				activity.get("B2").add(1);
			}
			String finalSchedule="";
			for(int i=2;i<scheduleList.size();i++){
				if(isSameBucket(activity.get("B1"),i,scheduleList)){
					activity.get("B1").add(i);
				}else if(isSameBucket(activity.get("B2"),i,scheduleList)){
					activity.get("B2").add(i);
				}else{
					finalSchedule="impossible".toUpperCase();
					break;
				}
			}
			if(finalSchedule.trim().isEmpty()){
			List<Integer> bucket1=activity.get("B1");
			for(int i=0;i<numberofSchedules;i++){
				if(bucket1.contains(i)){
					finalSchedule+="C";
				}else{
					finalSchedule+="J";
				}
			}
			}
			schedules.add(finalSchedule);
		}
			for (int i = 0; i < numberOfTests; i++) {
				System.out.println("Case #" + (i + 1) + ": " + schedules.get(i));
			}
		}	
	}
	
	private static Boolean isSameBucket(List<Integer> bucket,int i,List<List<Integer>> scheduleList){
		Boolean nonConflict=true;
		for(int j=0;j<bucket.size();j++){
			if(!isNonConflictTimeSlot(scheduleList.get(bucket.get(j)),scheduleList.get(i))){
				nonConflict=false;
				break;
			}
		}
		return nonConflict;
	}
	
	private static Boolean isNonConflictTimeSlot(List<Integer> schedule0, List<Integer> schedule1){
		Integer schedule0StartTime=schedule0.get(0);
		Integer schedule0EndTime=schedule0.get(1);
		Integer schedule1StartTime=schedule1.get(0);
		Integer schedule1EndTime=schedule1.get(1);
		if(schedule0EndTime<=schedule1StartTime|| schedule1EndTime<=schedule0StartTime){
			return true;
		}else{
			return false;
		}
	}
}
