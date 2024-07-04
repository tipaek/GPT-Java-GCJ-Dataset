import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

 class ScheduleTask {
	
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int tcNbr =  in.nextInt(); 
		
		for(int c =1 ; c<=tcNbr; c++) {
			
			int nbrSchedule = in.nextInt(); 
			
			Map<Integer, Integer> taskMap = new HashMap<>();
			List<Integer> startTimeLst = new ArrayList<>();
			List<Integer> startTimeImmut = new ArrayList<>();
			
			for(int schNbr=1; schNbr<=nbrSchedule;schNbr++) {
				int startTime = in.nextInt();
				taskMap.put(startTime, in.nextInt());
				startTimeLst.add(startTime);
				startTimeImmut.add(startTime);
			}
			
			//StringBuilder taskSeq = new StringBuilder();
			
			Map<Integer, String> taskPerson = new HashMap<>();
			
			Collections.sort(startTimeLst);
			
			int cEndTime = -1;
			int jEndTime = -1;
			
			int cntCTask = 0;
			int cntJTask = 0;
			
			boolean isImpossible = false;
			
			for(int startTime : startTimeLst) {
				boolean isAssigned = false;
				if(startTime==cEndTime) {
					//taskSeq.append("C");
					taskPerson.put(startTime, "C");
					cEndTime = taskMap.get(startTime);
					cntCTask++;
					isAssigned=true;
					continue;
				}
				
				if(startTime==jEndTime) {
					//taskSeq.append("J");
					taskPerson.put(startTime, "J");
					jEndTime = taskMap.get(startTime);
					cntJTask++;
					isAssigned=true;
					continue;
				}
				
				if(cntCTask<=cntJTask) {
					if(cEndTime < startTime) {
						//taskSeq.append("C");
						taskPerson.put(startTime, "C");
						cEndTime = taskMap.get(startTime);
						cntCTask++;
						isAssigned=true;
						continue;
					}
				}else {
					if(jEndTime < startTime) {
						//taskSeq.append("J");
						taskPerson.put(startTime, "J");
						jEndTime = taskMap.get(startTime);
						cntJTask++;
						isAssigned=true;
						continue;
						
					}
					
				}
				
				if(cEndTime < startTime) {
					//taskSeq.append("C");
					taskPerson.put(startTime, "C");
					cEndTime = taskMap.get(startTime);
					cntCTask++;
					isAssigned=true;
					continue;
				}
				
				if(jEndTime < startTime) {
					//taskSeq.append("J");
					taskPerson.put(startTime, "J");
					jEndTime = taskMap.get(startTime);
					cntJTask++;
					isAssigned=true;
					continue;
					
				}
				
				if(!isAssigned) {
					isImpossible = true;
					break;
				}
				
				
			}
			
			StringBuilder taskSeq = new StringBuilder();
			
			if(isImpossible) {
				taskSeq.append("IMPOSSIBLE");
			}else {
				for(int i : startTimeImmut) {
					taskSeq.append(taskPerson.get(i));
					
				}
				
				
			}
			
			
			System.out.println("Case #"+tcNbr+": "+taskSeq.toString());
			
			
			
			
			
		}
		in.close();
	}
	

}
