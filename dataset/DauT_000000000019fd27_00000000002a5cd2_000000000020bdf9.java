import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Scanner;

public class Solution {

	public static class Task{
		int startTime;
		public int getStartTime() {
			return startTime;
		}
		public void setStartTime(int startTime) {
			this.startTime = startTime;
		}
		public int getEndTime() {
			return endTime;
		}
		public void setEndTime(int endTime) {
			this.endTime = endTime;
		}
		int endTime;
		public Task(int startTime , int endTime) {
			this.startTime= startTime;
			this.endTime = endTime;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for(int k =0;k<t;k++) {
			int n = in.nextInt();
			List<Task> taskList = new ArrayList();
			for(int i = 0;i<n;i++) {
				int startTime = in.nextInt();
				int endTime = in.nextInt();
				Task task = new Task(startTime,endTime);
				taskList.add(task);
			}
			String sol = findSol(taskList, k+1);
			System.out.println(sol);
		 }
	}

	
	
	static String findSol(List<Task> taskList, int caseNo) {
		String sol= "";
		String sol1="";
		
		Map<Integer, Integer> cSchedule =new HashMap();
		Map<Integer, Integer> jSchedule = new HashMap();
		String s =  getTaskString(taskList,  sol, cSchedule, jSchedule, 0);
		if(s.equals("")) {
			sol1 = "Case #"+caseNo+": " +"IMPOSSIBLE";
			return sol1;
		}else {
			sol1 = "Case #"+caseNo+": " +s;
			return sol1;
		}

	}



	private static String getTaskString(List<Task> taskList, String sol, Map<Integer, Integer> cSchedule,
			Map<Integer, Integer> jSchedule, int index) {
		String sol1;
		if(index >= taskList.size()) {
			return sol;
		}
		String solJ ="";
		String solC ="";
		Task t = taskList.get(index);
			int startTime = t.getStartTime();
			int endTime = t.getEndTime();
			boolean clashing = false;
			
			clashing = false;
			for(Map.Entry<Integer, Integer> e : jSchedule.entrySet()) {
				if(e.getKey() <= startTime) {
					if(e.getValue()> startTime) {
						clashing = true;
						break;
					}
				}else if(e.getKey()>= startTime && e.getKey() < endTime) {
					clashing = true;
					break;
				}
			}
			if(!clashing) {
				jSchedule.put(startTime, endTime);
//				sol+="J";
				solJ = getTaskString(taskList, sol + "J", cSchedule,jSchedule, index +1);
			}
			clashing = false;
			for(Map.Entry<Integer, Integer> e : cSchedule.entrySet()) {
				if(e.getKey() <= startTime) {
					if(e.getValue()> startTime) {
						clashing = true;
						break;
					}
				}else if(e.getKey()>= startTime && e.getKey() < endTime) {
					clashing = true;
					break;
				}
			}
			if(!clashing) {
				cSchedule.put(startTime, endTime);
//				sol+="C";
				solC = getTaskString(taskList, sol + "C", cSchedule,jSchedule, index +1);
				
			}
			if(!solC.equals("") && !solC.isEmpty()){
				return solC;
			}else return solJ;
	}
}
